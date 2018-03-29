package StudentInfoSys.service;

import java.util.ArrayList;
import java.util.List;

import StudentInfoSys.dao.CourseDAO;
import StudentInfoSys.dao.ProfessorDAO;
import StudentInfoSys.entity.Course;
import StudentInfoSys.entity.Professor;

public class ProfessorService {
	public static String SUCCESS = "Success";
	public static String FAILURE = "Failure";
	public static ProfessorDAO professorDAO = new ProfessorDAO();
	public static CourseDAO courseDAO = new CourseDAO();
	
	//return list of professors
	public  List<Professor> getAllProfessor(){
	    return professorDAO.getAllProfessor();
	}
	
	//return professor object by its id
	public  Professor getProfessorById(String professorId){
	    return professorDAO.getProfessorById(Integer.parseInt(professorId));
	}
	
	//add one professor to system
	public  String createProfessor(Professor professor) {
		if(!professorDAO.containProfessor(professor.getProfessorId())){
			professorDAO.createUpdateProfessor(professor);
			return SUCCESS;
		}else{
			return FAILURE;
		}
	}
	
	//update professor info
	public  String updateProfessor(Professor professor) {
		if(professorDAO.containProfessor(professor.getProfessorId())){
			professorDAO.createUpdateProfessor(professor);
			return SUCCESS;
		}else{
			return FAILURE;
		}	
	}
	//delete professor by its id
	public String deleteProfessorById(String professorId) {
		if(professorDAO.containProfessor(Integer.parseInt(professorId))){
			professorDAO.deleteProfessorById(Integer.parseInt(professorId));
			return SUCCESS;
		}else{
			return FAILURE;
		}
	}

	public List<Course> getCourseByProfessorId(String professorId) {
		List<Course> courses = courseDAO.getAllCourse();
		List<Course> result = new ArrayList<Course>();
		for(Course course : courses){
				if(course.getProfessorId() == Integer.parseInt(professorId)){
					result.add(course);
				}
		}
		return result;
	}

	
	
}
