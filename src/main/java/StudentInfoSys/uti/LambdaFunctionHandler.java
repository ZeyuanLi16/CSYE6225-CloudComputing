package StudentInfoSys.uti;

import java.util.Map;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.DynamodbEvent;
import com.amazonaws.services.lambda.runtime.events.DynamodbEvent.DynamodbStreamRecord;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;
import com.amazonaws.services.sns.model.PublishRequest;

public class LambdaFunctionHandler implements RequestHandler<DynamodbEvent, String> {
	
	private AmazonSNS SNSClient = AmazonSNSClientBuilder
			.standard()
			.withRegion(Regions.US_WEST_2)
			.build();
    
	private static String ARNPre = "arn:aws:sns:us-west-2:369714707443:courseId";
	
    public String handleRequest(DynamodbEvent input, Context context){
	    	
	    	String output = "";
	    	//read ddb records
	    	//read the stream
	    	for(DynamodbStreamRecord record : input.getRecords()){
		    	if(record == null || !record.getEventName().equals("INSERT")){
	    			continue;
	    		}
	        	//business logic to decide to send a notification
	    		Map<String, AttributeValue> map = record.getDynamodb().getNewImage();
	    		
	    		String courseId = map.get("courseId").getN();
	    		String announcement = map.get("announcement").getS();

	        	sendEmailNotification(courseId,announcement );
	    		
	    	}

    		return output;
    }
	private void sendEmailNotification(final String courseId, final String announcement) {
		//message object
		PublishRequest publicRequest = new PublishRequest(ARNPre+courseId,announcement,"New announcement for Course " + courseId);
		//call client.publishMessage
		SNSClient.publish(publicRequest);
	}
    
}

