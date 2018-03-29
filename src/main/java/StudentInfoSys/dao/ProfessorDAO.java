package StudentInfoSys.dao;

import java.util.List;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;

import StudentInfoSys.entity.Professor;

public class ProfessorDAO {
	static  AmazonDynamoDB dynamoDBClient = AmazonDynamoDBClientBuilder
			.standard()
//			.withCredentials(new ProfileCredentialsProvider("lzyzz50"))
			.withRegion("us-west-2") 
			.build();
	static DynamoDB dynamoDB = new DynamoDB(dynamoDBClient);
	static DynamoDBMapper mapper = new DynamoDBMapper(dynamoDBClient);
	static String tableName = "professor";
	static Table table = dynamoDB.getTable(tableName);
	
	
	public  void createUpdateProfessor(Professor professor){
	mapper.save(professor);          
	}
	
	public  boolean containProfessor(int id){
	Professor professor = mapper.load(Professor.class, id);
	return professor != null;
	}
	
	public Professor getProfessorById(int id){
	Professor professor = mapper.load(Professor.class, id);
	return professor;
	}
	
	public List<Professor> getAllProfessor(){
	List professors = mapper.scan(Professor.class, new DynamoDBScanExpression());
	return professors;
	}
	
	public void deleteProfessorById(int id) {
	mapper.delete(this.getProfessorById(id));
	}


}
