package StudentInfoSys.entity;

import java.util.Set;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverted;

import StudentInfoSys.uti.DynamoDBSetCoverter;


@DynamoDBTable(tableName = "student")

public class Student {

	private String name;
	private int studentId;
	private Set<String> courseList;
	private int programId;
	private String email;
	
	public Student() {
		super();
	}
	public Student(String name, int studentId, Set<String> courseList, int programId) {
		super();
		this.name = name;
		this.studentId = studentId;
		this.courseList = courseList;
		this.programId = programId;
	}
	
    @DynamoDBAttribute(attributeName = "name")

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
    @DynamoDBHashKey(attributeName = "studentId")
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
    @DynamoDBAttribute(attributeName = "courseList")
	@DynamoDBTypeConverted(converter = DynamoDBSetCoverter.class)
	public Set<String> getCourseList() {
		return courseList;
	}
	public void setCourseList(Set<String> courseList) {
		this.courseList = courseList;
	}
    @DynamoDBAttribute(attributeName = "programId")
	public int getProgramId() {
		return programId;
	}
	public void setProgramId(int programId) {
		this.programId = programId;
	}
    @DynamoDBAttribute(attributeName = "email")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	
	


	
}