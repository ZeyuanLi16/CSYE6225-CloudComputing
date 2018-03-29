package StudentInfoSys.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "program")
public class Program {
	private int programId;
	private String programName;
	private int capacity;
	public Program(int programId, String programName, int capacity) {
		super();
		this.programId = programId;
		this.programName = programName;
		this.capacity = capacity;
	}
	public Program() {
		super();
		// TODO Auto-generated constructor stub
	}
	@DynamoDBHashKey
	public int getProgramId() {
		return programId;
	}
	public void setProgramId(int programId) {
		this.programId = programId;
	}
	@DynamoDBAttribute
	public String getProgramName() {
		return programName;
	}
	public void setProgramName(String programName) {
		this.programName = programName;
	}
	@DynamoDBAttribute
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
}
