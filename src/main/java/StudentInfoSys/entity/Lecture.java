package StudentInfoSys.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "lecture")
public class Lecture {
	private int lectureId;
	private String lectureNnumber;
	private String lectureTime;
	private int courseId;
	public Lecture(int lectureId, String lectureNnumber, String lectureTime, int courseId) {
		super();
		this.lectureId = lectureId;
		this.lectureNnumber = lectureNnumber;
		this.lectureTime = lectureTime;
		this.courseId = courseId;
	}
	
	public Lecture() {
		super();
		// TODO Auto-generated constructor stub
	}
	@DynamoDBHashKey
	public int getLectureId() {
		return lectureId;
	}
	public void setLectureId(int lectureId) {
		this.lectureId = lectureId;
	}
	@DynamoDBAttribute
	public String getLectureNnumber() {
		return lectureNnumber;
	}
	public void setLectureNnumber(String lectureNnumber) {
		this.lectureNnumber = lectureNnumber;
	}
	@DynamoDBAttribute
	public String getLectureTime() {
		return lectureTime;
	}
	public void setLectureTime(String lectureTime) {
		this.lectureTime = lectureTime;
	}
	@DynamoDBAttribute
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	
}
