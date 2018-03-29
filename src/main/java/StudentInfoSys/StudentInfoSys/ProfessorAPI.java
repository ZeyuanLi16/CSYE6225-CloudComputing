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
import StudentInfoSys.entity.Professor;
import StudentInfoSys.service.ProfessorService;

@Path("/professor")
public class ProfessorAPI {
	
	public static ProfessorService professorService = new ProfessorService();
	//get all professor
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllProfessor() {
	    GenericEntity< List< Professor > > entity = new GenericEntity<List<Professor>>(professorService.getAllProfessor()){};
	    return Response.ok( entity ).build();
	}
	
	//get professor by its id
	@GET
	@Path("/{professorId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProfessorByID(@PathParam("professorId") String professorId) {
	    GenericEntity<Professor> entity = new GenericEntity<Professor>(professorService.getProfessorById(professorId)){};
	    return Response.ok( entity ).build();
	}
	
	//get allcourse by professor
	@GET
	@Path("/{professorId}/course")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCourseByProfessorId(@PathParam("professorId") String professorId) {
	    GenericEntity<List< Course >> entity = new GenericEntity<List< Course >>(professorService.getCourseByProfessorId(professorId)){};
	    return Response.ok( entity ).build();
	}
	
	//add professor  
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String createProfessor(Professor professor) {
	    return professorService.createProfessor(professor);
	}
	  
	//update professor  
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateProfessor(Professor professor) {
	    return professorService.updateProfessor(professor);
	}
	//delete professor by its id
	@DELETE
	@Path("/{professorId}")
	@Produces(MediaType.APPLICATION_JSON)
	public String deleteProfessorByID(@PathParam("professorId") String professorId) {
	    return professorService.deleteProfessorById(professorId);
	}
}
