package StudentInfoSys.dao;

import java.util.List;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;

import StudentInfoSys.entity.Student;

public class StudentDAO {
	ProfileCredentialsProvider credentialsProvider = new ProfileCredentialsProvider();
	
	static  AmazonDynamoDB dynamoDBClient = AmazonDynamoDBClientBuilder
											.standard()
//											.withCredentials(new ProfileCredentialsProvider("lzyzz50"))
											.withRegion("us-west-2") 
											.build();
    static DynamoDB dynamoDB = new DynamoDB(dynamoDBClient);
    static DynamoDBMapper mapper = new DynamoDBMapper(dynamoDBClient);
    static String tableName = "student";
    static Table table = dynamoDB.getTable(tableName);
		

    public  void createUpdateStudent(Student student){
    		mapper.save(student);          
	}
    
    public  boolean containStudent(int id){
    		Student student = mapper.load(Student.class, id);
    		return student != null;
    }
    
    public Student getStudentById(int id){
		Student student = mapper.load(Student.class, id);
		return student;
    }

    public List<Student> getAllStudent(){
		List students = mapper.scan(Student.class, new DynamoDBScanExpression());
		return students;
    }

	public void deleteStudentById(int id) {
		mapper.delete(this.getStudentById(id));
	}


}
