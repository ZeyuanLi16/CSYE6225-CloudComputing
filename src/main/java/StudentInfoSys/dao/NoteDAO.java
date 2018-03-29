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

import StudentInfoSys.entity.Note;

public class NoteDAO {
	static  AmazonDynamoDB dynamoDBClient = AmazonDynamoDBClientBuilder
			.standard()
//			.withCredentials(new ProfileCredentialsProvider("lzyzz50"))
			.withRegion("us-west-2") 
			.build();
	static DynamoDB dynamoDB = new DynamoDB(dynamoDBClient);
	static DynamoDBMapper mapper = new DynamoDBMapper(dynamoDBClient);
	static String tableName = "note";
	static Table table = dynamoDB.getTable(tableName);
	
	
	public  void createUpdateNote(Note note){
	mapper.save(note);          
	}
	
	public  boolean containNote(int id){
	Note note = mapper.load(Note.class, id);
	return note != null;
	}
	
	public Note getNoteById(int id){
	Note note = mapper.load(Note.class, id);
	return note;
	}
	
	public List<Note> getAllNote(){
	List notes = mapper.scan(Note.class, new DynamoDBScanExpression());
	return notes;
	}
	
	public void deleteNoteById(int id) {
	mapper.delete(this.getNoteById(id));
	}

	public List<Note> getNotesByLectureID(String lectureId) {
		Map<String, AttributeValue> eav = new HashMap<String, AttributeValue>();
        eav.put(":val1", new AttributeValue().withN(lectureId));

        DynamoDBScanExpression scanExpression = new DynamoDBScanExpression()
            .withFilterExpression("lectureId = :val1").withExpressionAttributeValues(eav);

        List results = mapper.scan(Note.class, scanExpression);
        return results;
	}


}
