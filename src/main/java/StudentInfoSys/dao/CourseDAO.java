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

import StudentInfoSys.entity.Course;

public class CourseDAO {
	static  AmazonDynamoDB dynamoDBClient = AmazonDynamoDBClientBuilder
			.standard()
//			.withCredentials(new ProfileCredentialsProvider("lzyzz50"))
			.withRegion("us-west-2") 
			.build();
	static DynamoDB dynamoDB = new DynamoDB(dynamoDBClient);
	static DynamoDBMapper mapper = new DynamoDBMapper(dynamoDBClient);
	static String tableName = "course";
	static Table table = dynamoDB.getTable(tableName);
	
	
	public  void createUpdateCourse(Course course){
	mapper.save(course);          
	}
	
	public  boolean containCourse(int id){
	Course course = mapper.load(Course.class, id);
	return course != null;
	}
	
	public Course getCourseById(int id){
	Course course = mapper.load(Course.class, id);
	return course;
	}
	
	public List<Course> getAllCourse(){
	List courses = mapper.scan(Course.class, new DynamoDBScanExpression());
	return courses;
	}
	
	public void deleteCourseById(int id) {
	mapper.delete(this.getCourseById(id));
	}

	public List<Course> getCourseByProgramID(String programId) {
        Map<String, AttributeValue> eav = new HashMap<String, AttributeValue>();
        eav.put(":val1", new AttributeValue().withN(programId));

        DynamoDBScanExpression scanExpression = new DynamoDBScanExpression()
            .withFilterExpression("programId = :val1").withExpressionAttributeValues(eav);

        List courses = mapper.scan(Course.class, scanExpression);
        return courses;
	}


}
