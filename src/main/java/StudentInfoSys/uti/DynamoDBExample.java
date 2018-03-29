package StudentInfoSys.uti;

import java.util.HashMap;
import java.util.Map;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.model.AttributeDefinition;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.KeySchemaElement;
import com.amazonaws.services.dynamodbv2.model.KeyType;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazonaws.services.dynamodbv2.model.PutItemRequest;
import com.amazonaws.services.dynamodbv2.model.PutItemResult;
import com.amazonaws.services.dynamodbv2.model.ScalarAttributeType;
import com.amazonaws.services.dynamodbv2.util.TableUtils;

public class DynamoDBExample {
	static  AmazonDynamoDB dynamoDB;
	/*
	 * 
	 * Method cr
	 * 
	 * 
	 * */
	private static void init() throws Exception{
		
		//define CredentialsProvider
		ProfileCredentialsProvider credentialsProvider = new ProfileCredentialsProvider("lzyzz50");
		credentialsProvider.getCredentials();
		dynamoDB = AmazonDynamoDBClientBuilder
					.standard()
					.withCredentials(credentialsProvider)
					.withRegion("us-west-2")   //passed all the parameter
					.build();
		
		
	}
	
	public static void main(String[] args) throws Exception{
		init();//remember to create your own exception
		String tableName = "restaurant-test-table";
		//we will create the table first and add item in it 
		
		CreateTableRequest createTableRequest = new CreateTableRequest()
						.withTableName(tableName)
						.withKeySchema(   // can have a lot of KeySchema
								new KeySchemaElement()
								.withAttributeName("name")
								.withKeyType(KeyType.HASH)
								)
						.withAttributeDefinitions(
								new AttributeDefinition()
								.withAttributeName("name")
								.withAttributeType(ScalarAttributeType.S)
//								new AttributeDefinition()
//								.withAttributeName("phone")
//								.withAttributeType(ScalarAttributeType.S)
								)
						.withProvisionedThroughput(
								new ProvisionedThroughput()
								.withReadCapacityUnits(3L)
								.withWriteCapacityUnits(3L)
								);
		TableUtils.createTableIfNotExists(dynamoDB, createTableRequest);
		TableUtils.waitUntilActive(dynamoDB, tableName);
		
		Map<String, AttributeValue> item = 
				new HashMap<String, AttributeValue>();
		
		item.put("name", new AttributeValue().withS("chipotle"));
		item.put("address", new AttributeValue().withS("some add"));
		
		PutItemRequest putItemRequest = new PutItemRequest(
				tableName, item);
		System.out.println("putItemRequest = " + putItemRequest);
		PutItemResult putItemResult = dynamoDB.putItem(putItemRequest);
		System.out.println("putItemResult = " + putItemResult);
				
						
	}
}
