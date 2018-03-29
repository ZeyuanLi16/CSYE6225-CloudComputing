package StudentInfoSys.uti;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.PutItemRequest;
import com.amazonaws.services.dynamodbv2.model.PutItemResult;

public class DynamoDBExample2 {
	static  AmazonDynamoDB dynamoDBClient = AmazonDynamoDBClientBuilder
											.standard()
											.withCredentials(new ProfileCredentialsProvider("lzyzz50"))
											.withRegion("us-west-2")   //passed all the parameter
											.build();
    static DynamoDB dynamoDB = new DynamoDB(dynamoDBClient);

    static String tableName = "student";
			

	private static void init() throws Exception{
		
		//define CredentialsProvider
		ProfileCredentialsProvider credentialsProvider = new ProfileCredentialsProvider("lzyzz50");
		credentialsProvider.getCredentials();
		dynamoDBClient = AmazonDynamoDBClientBuilder
					.standard()
					.withCredentials(credentialsProvider)
					.withRegion("us-west-2")   //passed all the parameter
					.build();
		
		
	}
	
	public static void main(String[] args) throws Exception{
		init();//remember to create your own exception
		//String tableName = "student-test";
		//we will create the table first and add item in it 
//        Table table = dynamoDB.getTable(tableName);
			
		Map<String, AttributeValue> item = 
				new HashMap<String, AttributeValue>();
		 
		ArrayList<String> course = new ArrayList<String>();
		course.add("0");
		course.add("1");
		
		item.put("name", new AttributeValue().withS("Zac4"));
		item.put("studentId", new AttributeValue().withN("0"));
		item.put("programId", new AttributeValue().withN("0"));
		item.put("courseList", new AttributeValue().withSS(course));

        			
            //table.putItem(item2);
//		private String name;
//		private int studentId;
//		private ArrayList<String> courseList;
//		private String programId;
		PutItemRequest putItemRequest = new PutItemRequest(
				tableName, item);
		System.out.println("putItemRequest = " + putItemRequest);
		PutItemResult putItemResult = dynamoDBClient.putItem(putItemRequest);
		System.out.println("putItemResult = " + putItemResult);
				
		
		
		
		
        //DynamoDB dynamoDB = new DynamoDB(dynamoDBClient);
//
//        Table table = dynamoDB.getTable(tableName);
//
//        String studentid = "0";
//
//        GetItemSpec spec = new GetItemSpec().withPrimaryKey("studentId", studentid);
//
//        try {
//            System.out.println("Attempting to read the item...");
//            Item outcome = table.getItem(spec);
//            System.out.println("GetItem succeeded: " + outcome);
//
//        }
//        catch (Exception e) {
//            System.err.println("Unable to read item: ");
//            System.err.println(e.getMessage());
//        }	
//        
//        
        
        


//        Map<String, Object> expressionAttributeValues = new HashMap<String, Object>();
//        expressionAttributeValues.put(":pr", "0");
//
//        ItemCollection<ScanOutcome> items = table.scan("studentId = :pr", // FilterExpression
//            "studentId, programId, courseList", // ProjectionExpression
//            null, // ExpressionAttributeNames - not used in this example
//            expressionAttributeValues);
//
//        System.out.println("Scan of " + tableName + " for items with a price less than 100.");
//        Iterator<Item> iterator = items.iterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next().toJSONPretty());
//        }
	}
}
