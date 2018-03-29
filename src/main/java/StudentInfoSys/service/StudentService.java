package StudentInfoSys.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import StudentInfoSys.dao.CourseDAO;
import StudentInfoSys.dao.ProgramDAO;
import StudentInfoSys.dao.StudentDAO;
import StudentInfoSys.entity.Student;
import StudentInfoSys.uti.TopicAndSubcription;


public class StudentService {

	public static String SUCCESS = "Success";
	public static String FAILURE = "Failure";
	public static StudentDAO studentDAO = new StudentDAO();
	public static ProgramDAO programDAO = new ProgramDAO();
	public static CourseDAO courseDAO = new CourseDAO();
	public static TopicAndSubcription TS = new TopicAndSubcription();
	//return list of students
	public  List<Student> getAllStudent(){
	    return studentDAO.getAllStudent();
	}
	
	//return student object by its id
	public  Student getStudentById(String studentId){
	    return studentDAO.getStudentById(Integer.parseInt(studentId));
	}
	
	//add one student to system
	public  String createStudent(Student student) {
		if(!studentDAO.containStudent(student.getStudentId())
				&& programDAO.containProgram(student.getProgramId())){
			studentDAO.createUpdateStudent(student);
			return SUCCESS;
		}else{
			return FAILURE;
		}
	}
	
	//update student info
	public  String updateStudent(Student student) {
		if(studentDAO.containStudent(student.getStudentId())
				&& programDAO.containProgram(student.getProgramId())){
			studentDAO.createUpdateStudent(student);
			return SUCCESS;
		}else{
			return FAILURE;
		}	
	}
	//delete student by its id
	public String deleteStudentById(String studentId) {
		if(studentDAO.containStudent(Integer.parseInt(studentId))){
			studentDAO.deleteStudentById(Integer.parseInt(studentId));
			return SUCCESS;
		}else{
			return FAILURE;
		}
		//return studentDAO.deleteStudentById(Integer.parseInt(studentId));
	}

	public List<Student> RosterOfCourse(String courseId) {
		List<Student> students = studentDAO.getAllStudent();
		List<Student> result = new ArrayList<Student>();
		for(Student student : students){
			for(String course : student.getCourseList()){
				if(course.equals(courseId)){
					result.add(student);
				}
			}
		}
		return result;
	}

	public String registerCourse(String studentId, String courseId) {
		if(!courseDAO.containCourse(Integer.parseInt(courseId))){
			return FAILURE;
		}
		Student student = studentDAO.getStudentById(Integer.parseInt(studentId));
		Set<String> courseList = student.getCourseList();
		for(String course : courseList){
			if(course.equals(courseId)){
				return "You have already register this course.";
			}
		}
		courseList.add(courseId);
		student.setCourseList(courseList);
		studentDAO.createUpdateStudent(student);
		TS.subscribeTopic(courseId, student.getEmail());
		return SUCCESS;
	}

	public String unregisterCourse(String studentId, String courseId) {
		if(!courseDAO.containCourse(Integer.parseInt(courseId))){
			return FAILURE;
		}
		Student student = studentDAO.getStudentById(Integer.parseInt(studentId));
		Set<String> courseList = student.getCourseList();
		courseList.remove(courseId);
		student.setCourseList(courseList);
		studentDAO.createUpdateStudent(student);
		TS.unsubscribeTopic(courseId, student.getEmail());
		return SUCCESS;
	}
	
}
