package StudentInfoSys.service;

import java.util.List;

import StudentInfoSys.dao.NoteDAO;
import StudentInfoSys.entity.Note;


public class NoteService {
 
	public static String SUCCESS = "Success";
	public static String FAILURE = "Failure";
	public static NoteDAO noteDAO = new NoteDAO();


	//return list of notes
	public  List<Note> getAllNote(){
	    return noteDAO.getAllNote();
	}
	
	//return note object by its id
	public  Note getNoteById(String noteId){
		return noteDAO.getNoteById(Integer.parseInt(noteId));
	}
	
	public  String createNote(Note note) {
		if(!noteDAO.containNote(note.getNoteId())){
			noteDAO.createUpdateNote(note);
			return SUCCESS;
		}else{
			return FAILURE;
		}
	}
	
	public  String updateNote(Note note) {
		if(noteDAO.containNote(note.getNoteId())){
			noteDAO.createUpdateNote(note);
			return SUCCESS;
		}else{
			return FAILURE;
		}
	}
	public String deleteNoteById(String noteId) {
		if(noteDAO.containNote(Integer.parseInt(noteId))){
			noteDAO.deleteNoteById(Integer.parseInt(noteId));
			return SUCCESS;
		}else{
			return FAILURE;
		}
	}
	
	public List<Note> getNotesByLectureID(String CourseId) {
		return noteDAO.getNotesByLectureID(CourseId);
	}

}
