package StudentInfoSys.service;

import java.util.List;

import StudentInfoSys.dao.LectureDAO;
import StudentInfoSys.entity.Lecture;


public class LectureService {

	public static String SUCCESS = "Success";
	public static String FAILURE = "Failure";
	public static LectureDAO lectureDAO = new LectureDAO();


	//return list of lectures
	public  List<Lecture> getAllLecture(){
	    return lectureDAO.getAllLecture();
	}
	
	//return lecture object by its id
	public  Lecture getLectureById(String lectureId){
		return lectureDAO.getLectureById(Integer.parseInt(lectureId));
	}

	public  String createLecture(Lecture lecture) {
		if(!lectureDAO.containLecture(lecture.getLectureId())){
			lectureDAO.createUpdateLecture(lecture);
			return SUCCESS;
		}else{
			return FAILURE;
		}
	}

	public  String updateLecture(Lecture lecture) {
		if(lectureDAO.containLecture(lecture.getLectureId())){
			lectureDAO.createUpdateLecture(lecture);
			return SUCCESS;
		}else{
			return FAILURE;
		}
	}
	public String deleteLectureById(String lectureId) {
		if(lectureDAO.containLecture(Integer.parseInt(lectureId))){
			lectureDAO.deleteLectureById(Integer.parseInt(lectureId));
			return SUCCESS;
		}else{
			return FAILURE;
		}
	}

	public List<Lecture> getLecturesByCourseID(String CourseId) {
		return lectureDAO.getLecturesByCourseID(CourseId);
	}
	
	
}
