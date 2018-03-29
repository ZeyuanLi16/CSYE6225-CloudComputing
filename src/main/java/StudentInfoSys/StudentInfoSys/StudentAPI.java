package StudentInfoSys.StudentInfoSys;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import StudentInfoSys.entity.Student;
import StudentInfoSys.service.StudentService;

@Path("/student")
public class StudentAPI {

	public static StudentService studentService = new StudentService();
	//get all student
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllStudent() {
	    GenericEntity< List< Student > > entity = new GenericEntity<List<Student>>(studentService.getAllStudent()){};
	    System.out.println("GET request /student");
	    return Response.ok( entity ).build();
	}
	
	//get student by its id
	@GET
	@Path("/{studentId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getStudentByID(@PathParam("studentId") String studentId) {
	    GenericEntity<Student> entity = new GenericEntity<Student>(studentService.getStudentById(studentId)){};
	    System.out.println("GET request /student/{studentId}");
	    return Response.ok( entity ).build();
	}
	
	//add student  
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String createStudent(Student student) {
	    System.out.println("POST request /student");
	    return studentService.createStudent(student);
	}
	  
	//update student  
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateStudent(Student student) {
	    System.out.println("PUT request /student");
	    return studentService.updateStudent(student);
	}
	//delete student by its id
	@DELETE
	@Path("/{studentId}")
	@Produces(MediaType.APPLICATION_JSON)
	public String deleteStudentByID(@PathParam("studentId") String studentId) {
	    return studentService.deleteStudentById(studentId);
	}
	
	//register student to a new course
	@PUT
	@Path("/{studentId}/course/{courseId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String registerCourse(@PathParam("studentId") String studentId,@PathParam("courseId") String courseId) {
	    return studentService.registerCourse(studentId,courseId);
	}
	
	//unregister student to a new course
	@DELETE
	@Path("/{studentId}/course/{courseId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String unregisterCourse(@PathParam("studentId") String studentId,@PathParam("courseId") String courseId) {
	    return studentService.unregisterCourse(studentId,courseId);
	}

}
