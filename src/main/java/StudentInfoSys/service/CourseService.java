package StudentInfoSys.service;

import java.util.List;

import StudentInfoSys.dao.CourseDAO;
import StudentInfoSys.entity.Course;
import StudentInfoSys.uti.TopicAndSubcription;


public class CourseService {

	public static String SUCCESS = "Success";
	public static String FAILURE = "Failure";
	public static CourseDAO courseDAO = new CourseDAO();
	public static TopicAndSubcription TS = new TopicAndSubcription();
	//return list of courses
	public  List<Course> getAllCourse(){
	    return courseDAO.getAllCourse();
	}
	
	//return course object by its id
	public  Course getCourseById(String courseId){
		return courseDAO.getCourseById(Integer.parseInt(courseId));
	}

	public  String createCourse(Course course) {
		if(!courseDAO.containCourse(course.getCourseId())){
			courseDAO.createUpdateCourse(course);
			 TS.createSNSTopic(course.getCourseId());
			return SUCCESS;
		}else{
			return FAILURE;
		}
	}

	public  String updateCourse(Course course) {
		if(courseDAO.containCourse(course.getCourseId())){
			courseDAO.createUpdateCourse(course);
			return SUCCESS;
		}else{
			return FAILURE;
		}
	}
	public String deleteCourseById(String courseId) {
		if(courseDAO.containCourse(Integer.parseInt(courseId))){
			courseDAO.deleteCourseById(Integer.parseInt(courseId));
			TS.removeSNSTopic(courseId);
			return SUCCESS;
		}else{
			return FAILURE;
		}
	}

	public List<Course> getCourseByProgramID(String programId) {
		return courseDAO.getCourseByProgramID(programId);
	}
	


	
	
	
}
