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

import StudentInfoSys.entity.Course;
import StudentInfoSys.entity.Program;
import StudentInfoSys.service.CourseService;
import StudentInfoSys.service.ProgramService;


@Path("/program")
public class ProgramAPI {

	public static ProgramService programService = new ProgramService();
	public static CourseService courseService = CourseAPI.courseService;

	//get all Program
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllProgram() {
	    GenericEntity< List< Program > > entity = new GenericEntity<List<Program>>(programService.getAllProgram()){};
	    return Response.ok( entity ).build();
	}
	
	//get program by its id
	@GET
	@Path("/{programId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProgramByID(@PathParam("programId") String programId) {
	    GenericEntity<Program> entity = new GenericEntity<Program>(programService.getProgramById(programId)){};
	    System.out.println("GET request /program/{programId}");
	    return Response.ok( entity ).build();
	}
	//get all course under this program
	@GET
	@Path("/{programId}/course")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCourseByProgramID(@PathParam("programId") String programId) {
	    GenericEntity<List<Course>> entity = new GenericEntity<List<Course>>(courseService.getCourseByProgramID(programId)){};
	    System.out.println("GET request /program/{programId}/course");
	    return Response.ok( entity ).build();
	}
	
	//add program to hashmap
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String createProgram(Program program) {
	    System.out.println("POST request /program");
	    return programService.createProgram(program);
	}
	  
	//update program to hashmap
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateProgram(Program program) {
	    System.out.println("POST request /program");
	    return programService.updateProgram(program);
	}
	
	
	//delete student by its id
	@DELETE
	@Path("/{programId}")
	@Produces(MediaType.APPLICATION_JSON)
	public String deleteProgramIdByID(@PathParam("programId") String programId) {
	    return programService.deleteProgramIdById(programId);
	}


}
