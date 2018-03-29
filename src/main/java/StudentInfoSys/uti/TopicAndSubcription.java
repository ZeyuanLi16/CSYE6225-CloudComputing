package StudentInfoSys.uti;

import java.util.List;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;
import com.amazonaws.services.sns.model.CreateTopicRequest;
import com.amazonaws.services.sns.model.DeleteTopicRequest;
import com.amazonaws.services.sns.model.ListSubscriptionsByTopicRequest;
import com.amazonaws.services.sns.model.ListSubscriptionsByTopicResult;
import com.amazonaws.services.sns.model.SubscribeRequest;
import com.amazonaws.services.sns.model.Subscription;
import com.amazonaws.services.sns.model.UnsubscribeRequest;


public class TopicAndSubcription {
	public static String arnPre = "arn:aws:sns:us-west-2:369714707443:courseId";
	public static AmazonSNS SNSClient = AmazonSNSClientBuilder
										.standard()
//										.withCredentials(new ProfileCredentialsProvider("lzyzz50"))
										.withRegion(Regions.US_WEST_2)
										.build();

	
	public void subscribeTopic(String courseId, String email) {
		String arn = arnPre + courseId;
		SubscribeRequest subscribeRequest = new SubscribeRequest(arn, "email", email);
		SNSClient.subscribe(subscribeRequest);
	} 
	
	public void unsubscribeTopic(String courseId, String email) {
		String arn = arnPre + courseId;
		ListSubscriptionsByTopicRequest lRequest = new ListSubscriptionsByTopicRequest(arn);
		ListSubscriptionsByTopicResult lResult = SNSClient.listSubscriptionsByTopic(lRequest);
		List<Subscription> subscriptions = lResult.getSubscriptions();
		for(Subscription s : subscriptions) {
			if(s.getEndpoint().equals(email)) {
				UnsubscribeRequest unsubscribeRequest = new UnsubscribeRequest(s.getSubscriptionArn());
				SNSClient.unsubscribe(unsubscribeRequest);
			}
		}
	}
	public void createSNSTopic(int courseId) {
	
		CreateTopicRequest createTopicRequest = new CreateTopicRequest("courseId" + courseId);
		SNSClient.createTopic(createTopicRequest);
	} 
	
	public void removeSNSTopic(String courseId) {
		
		DeleteTopicRequest deleteTopicRequest = new DeleteTopicRequest(arnPre + courseId);
		SNSClient.deleteTopic(deleteTopicRequest);
	}
}
