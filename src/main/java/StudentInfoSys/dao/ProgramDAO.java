package StudentInfoSys.dao;

import java.util.List;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;

import StudentInfoSys.entity.Program;


public class ProgramDAO {
	static  AmazonDynamoDB dynamoDBClient = AmazonDynamoDBClientBuilder
											.standard()
//											.withCredentials(new ProfileCredentialsProvider("lzyzz50"))
											.withRegion("us-west-2") 
											.build();
    static DynamoDB dynamoDB = new DynamoDB(dynamoDBClient);
    static DynamoDBMapper mapper = new DynamoDBMapper(dynamoDBClient);
    static String tableName = "program";
    static Table table = dynamoDB.getTable(tableName);
		

    public  void createUpdateProgram(Program program){
    		mapper.save(program);          
	}
    
    public  boolean containProgram(int id){
    	Program program = mapper.load(Program.class, id);
    		return program != null;
    }
    
    public Program getProgramById(int id){
    	Program program = mapper.load(Program.class, id);
		return program;
    }

    public List<Program> getAllProgram(){
		List programs = mapper.scan(Program.class, new DynamoDBScanExpression());
		return programs;
    }

	public void deleteProgramIdById(int id) {
		mapper.delete(this.getProgramById(id));		
	}


}
