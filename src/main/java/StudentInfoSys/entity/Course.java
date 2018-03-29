package StudentInfoSys.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "course")
public class Course {
	private int courseId;
	private String courseName;
	private int professorId;
	private int programId;
	public Course(int courseId, String courseName, int professorId, int programId) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.professorId = professorId;
		this.programId = programId;
	}
	
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}
	@DynamoDBHashKey
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	@DynamoDBAttribute
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	@DynamoDBAttribute
	public int getProfessorId() {
		return professorId;
	}
	public void setProfessorId(int professorId) {
		this.professorId = professorId;
	}
	@DynamoDBAttribute
	public int getProgramId() {
		return programId;
	}
	public void setProgramId(int programId) {
		this.programId = programId;
	}
	
}
