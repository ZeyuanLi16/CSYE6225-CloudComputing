package StudentInfoSys.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "announcement")
public class Announcement {
	private int announcementId;
	private String announcement;
	private int courseId;
	
	public Announcement() {
		super();
	}
	@DynamoDBHashKey
	public int getAnnouncementId() {
		return announcementId;
	}
	public void setAnnouncementId(int announcementId) {
		this.announcementId = announcementId;
	}
	@DynamoDBAttribute
	public String getAnnouncement() {
		return announcement;
	}
	public void setAnnouncement(String announcement) {
		this.announcement = announcement;
	}
	@DynamoDBAttribute
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	
	
}
