package StudentInfoSys.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "note")
public class Note {
	
	private int noteId;
	private String noteName;
	private String note;
	private int lectureId;
	public Note(int noteId, String noteName, String note, int lectureId) {
		super();
		this.noteId = noteId;
		this.noteName = noteName;
		this.note = note;
		this.lectureId = lectureId;
	}
	
	public Note() {
		super();
		// TODO Auto-generated constructor stub
	}
	@DynamoDBHashKey
	public int getNoteId() {
		return noteId;
	}
	public void setNoteId(int noteId) {
		this.noteId = noteId;
	}
	@DynamoDBAttribute
	public String getNoteName() {
		return noteName;
	}
	public void setNoteName(String noteName) {
		this.noteName = noteName;
	}
	@DynamoDBAttribute
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	@DynamoDBAttribute
	public int getLectureId() {
		return lectureId;
	}
	public void setLectureId(int lectureId) {
		this.lectureId = lectureId;
	}


}
