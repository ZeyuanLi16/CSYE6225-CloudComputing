package StudentInfoSys.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;

import StudentInfoSys.entity.Announcement;

public class AnnouncementDAO {
	static  AmazonDynamoDB dynamoDBClient = AmazonDynamoDBClientBuilder
			.standard()
//			.withCredentials(new ProfileCredentialsProvider("lzyzz50"))
			.withRegion("us-west-2") 
			.build();
	static DynamoDB dynamoDB = new DynamoDB(dynamoDBClient);
	static DynamoDBMapper mapper = new DynamoDBMapper(dynamoDBClient);
	static String tableName = "announcement";
	static Table table = dynamoDB.getTable(tableName);
	
	
	public  void createUpdateAnnouncement(Announcement announcement){
	mapper.save(announcement);          
	}
	
	public  boolean containAnnouncement(int id){
	Announcement announcement = mapper.load(Announcement.class, id);
	return announcement != null;
	}
	
	public Announcement getAnnouncementById(int id){
	Announcement announcement = mapper.load(Announcement.class, id);
	return announcement;
	}
	
	public List<Announcement> getAllAnnouncement(){
	List announcements = mapper.scan(Announcement.class, new DynamoDBScanExpression());
	return announcements;
	}
	
	public void deleteAnnouncementById(int id) {
	mapper.delete(this.getAnnouncementById(id));
	}

	public List<Announcement> getAnnouncementsByCourseID(String courseId) {
        Map<String, AttributeValue> eav = new HashMap<String, AttributeValue>();
        eav.put(":val1", new AttributeValue().withN(courseId));

        DynamoDBScanExpression scanExpression = new DynamoDBScanExpression()
            .withFilterExpression("courseId = :val1").withExpressionAttributeValues(eav);

        List results = mapper.scan(Announcement.class, scanExpression);
        return results;
	}
}
