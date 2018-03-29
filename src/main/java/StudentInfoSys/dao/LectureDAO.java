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

import StudentInfoSys.entity.Lecture;

public class LectureDAO {
	static  AmazonDynamoDB dynamoDBClient = AmazonDynamoDBClientBuilder
			.standard()
//			.withCredentials(new ProfileCredentialsProvider("lzyzz50"))
			.withRegion("us-west-2") 
			.build();
	static DynamoDB dynamoDB = new DynamoDB(dynamoDBClient);
	static DynamoDBMapper mapper = new DynamoDBMapper(dynamoDBClient);
	static String tableName = "lecture";
	static Table table = dynamoDB.getTable(tableName);
	
	
	public  void createUpdateLecture(Lecture lecture){
	mapper.save(lecture);          
	}
	
	public  boolean containLecture(int id){
	Lecture lecture = mapper.load(Lecture.class, id);
	return lecture != null;
	}
	
	public Lecture getLectureById(int id){
	Lecture lecture = mapper.load(Lecture.class, id);
	return lecture;
	}
	
	public List<Lecture> getAllLecture(){
	List lectures = mapper.scan(Lecture.class, new DynamoDBScanExpression());
	return lectures;
	}
	
	public void deleteLectureById(int id) {
	mapper.delete(this.getLectureById(id));
	}

	public List<Lecture> getLecturesByCourseID(String courseId) {
        Map<String, AttributeValue> eav = new HashMap<String, AttributeValue>();
        eav.put(":val1", new AttributeValue().withN(courseId));

        DynamoDBScanExpression scanExpression = new DynamoDBScanExpression()
            .withFilterExpression("courseId = :val1").withExpressionAttributeValues(eav);

        List results = mapper.scan(Lecture.class, scanExpression);
        return results;
	}
}
