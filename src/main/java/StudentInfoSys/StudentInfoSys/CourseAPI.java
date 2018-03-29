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

import StudentInfoSys.entity.Announcement;
import StudentInfoSys.entity.Course;
import StudentInfoSys.entity.Lecture;
import StudentInfoSys.entity.Note;
import StudentInfoSys.entity.Student;
import StudentInfoSys.service.AnnouncementService;
import StudentInfoSys.service.CourseService;
import StudentInfoSys.service.LectureService;
import StudentInfoSys.service.NoteService;
import StudentInfoSys.service.ProgramService;
import StudentInfoSys.service.StudentService;

@Path("/course")
public class CourseAPI {

	public static CourseService courseService = new CourseService();
	public static StudentService studentService = new StudentService();
	public static LectureService lectureService = new LectureService();
	public static AnnouncementService announcementService = new AnnouncementService();
	public static NoteService noteService = new NoteService();
	public static ProgramService programService = ProgramAPI.programService;
	public static String NOTEXIST = "Referance ID is not exist";

	//get all course
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllCourse() {
	    GenericEntity< List< Course > > entity = new GenericEntity<List<Course>>(courseService.getAllCourse()){};
	    System.out.println("GET request /course");
	    return Response.ok( entity ).build();
	}
	
	//get course by its id
	@GET
	@Path("/{courseId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCourseByID(@PathParam("courseId") String courseId) {
	    GenericEntity<Course> entity = new GenericEntity<Course>(courseService.getCourseById(courseId)){};
	    System.out.println("GET request /course/{courseId}");
	    return Response.ok( entity ).build();
	}
	
	//add course 
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String createCourse(Course course) {
	    System.out.println("POST request /course");
	    return courseService.createCourse(course);
	}
	  
	//update Course 
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateCourse(Course course) {
	    System.out.println("POST request /course");
	    return courseService.updateCourse(course);
	}
	//delete Course by its id
	@DELETE
	@Path("/{courseId}")
	@Produces(MediaType.APPLICATION_JSON)
	public String deleteCourseByID(@PathParam("courseId") String courseId) {
	    return courseService.deleteCourseById(courseId);
	}
	
	//get all RosterOfCourse
	@GET
	@Path("/{courseId}/roster")
	@Produces(MediaType.APPLICATION_JSON)
	public Response RosterOfCourse(@PathParam("courseId") String courseId) {
	    GenericEntity< List< Student > > entity = new GenericEntity<List<Student>>(studentService.RosterOfCourse(courseId)){};
	    System.out.println("GET request /course");
	    return Response.ok( entity ).build();
	}
	
	//lectures
	
	@GET
	@Path("/{courseId}/lecture")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getLecturesByCourseID(@PathParam("courseId") String courseId) {
	    GenericEntity< List< Lecture > > entity = new GenericEntity<List<Lecture>>(lectureService.getLecturesByCourseID(courseId)){};
	    System.out.println("GET request /{courseId}/lecture");
	    return Response.ok( entity ).build();
	}

	@GET
	@Path("/{courseId}/lecture/{lectureId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getLectureById(@PathParam("courseId") String courseId,
									@PathParam("lectureId") String lectureId) {
	    GenericEntity< Lecture > entity = new GenericEntity<Lecture>(lectureService.getLectureById(lectureId)){};
	    System.out.println("GET request /{courseId}/lecture/{lectureId}");
	    return Response.ok( entity ).build();
	}
	
	//add Lecture to 
	@POST
	@Path("/{courseId}/lecture")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String createLecture(@PathParam("courseId") String courseId,Lecture lecture) {
	    return lectureService.createLecture(lecture);
	}
	  
	//update Lecture 
	@PUT
	@Path("/{courseId}/lecture")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateLecture(@PathParam("courseId") String courseId,Lecture lecture) {
	    return lectureService.updateLecture(lecture);
	}
	
	//delete Lecture by its id
	@DELETE
	@Path("/{courseId}/lecture/{lectureId}")
	@Produces(MediaType.APPLICATION_JSON)
	public String deleteLectureByID(@PathParam("lectureId") String lectureId) {
	    return lectureService.deleteLectureById(lectureId);
	}
	
	//notes
	
	
	@GET
	@Path("/{courseId}/lecture/{lectureId}/note")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getNotesByLectureID(@PathParam("lectureId") String lectureId) {
	    GenericEntity< List< Note > > entity = new GenericEntity<List<Note>>(noteService.getNotesByLectureID(lectureId)){};
	    System.out.println("GET request /{courseId}/lecture/{lectureId}/note");
	    return Response.ok( entity ).build();
	}

	@GET
	@Path("/{courseId}/lecture/{lectureId}/note/{noteId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getNoteById(@PathParam("courseId") String courseId,
									@PathParam("lectureId") String lectureId) {
	    GenericEntity< Note > entity = new GenericEntity<Note>(noteService.getNoteById(lectureId)){};
	    System.out.println("GET request /{courseId}/lecture/{lectureId}/note/{noteId}");
	    return Response.ok( entity ).build();
	}
	
	//add Note  
	@POST
	@Path("/{courseId}/lecture/{lectureId}/note")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String createNote(@PathParam("lectureId") String lectureId,Note note) {
	    return noteService.createNote(note);
	}
	  
	//update Note  
	@PUT
	@Path("/{courseId}/lecture/{lectureId}/note")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateNote(@PathParam("lectureId") String lectureId,Note note) {
	    return noteService.updateNote(note);
	}
	
	//delete note by its id
	@DELETE
	@Path("/{courseId}/lecture/{lectureId}/note/{noteId}")
	@Produces(MediaType.APPLICATION_JSON)
	public String deleteNoteById(@PathParam("noteId") String noteId) {
	    return noteService.deleteNoteById(noteId);
	}
	
	
	//Announcement
	
	@GET
	@Path("/{courseId}/announcement")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAnnouncementsByCourseID(@PathParam("courseId") String courseId) {
	    GenericEntity< List< Announcement > > entity = new GenericEntity<List<Announcement>>(announcementService.getAnnouncementsByCourseID(courseId)){};
	    System.out.println("GET request /{courseId}/Announcement");
	    return Response.ok( entity ).build();
	}

	@GET
	@Path("/{courseId}/announcement/{AnnouncementId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAnnouncementById(@PathParam("courseId") String courseId,
									@PathParam("AnnouncementId") String AnnouncementId) {
	    GenericEntity< Announcement > entity = new GenericEntity<Announcement>(announcementService.getAnnouncementById(AnnouncementId)){};
	    System.out.println("GET request /{courseId}/Announcement/{AnnouncementId}");
	    return Response.ok( entity ).build();
	}
	
	//add Announcement to 
	@POST
	@Path("/{courseId}/announcement")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String createAnnouncement(@PathParam("courseId") String courseId,Announcement Announcement) {
	    return announcementService.createAnnouncement(Announcement);
	}
	  
	//update Announcement 
	@PUT
	@Path("/{courseId}/announcement")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateAnnouncement(@PathParam("courseId") String courseId,Announcement Announcement) {
	    return announcementService.updateAnnouncement(Announcement);
	}
	
	//delete Announcement by its id
	@DELETE
	@Path("/{courseId}/announcement/{AnnouncementId}")
	@Produces(MediaType.APPLICATION_JSON)
	public String deleteAnnouncementByID(@PathParam("AnnouncementId") String AnnouncementId) {
	    return announcementService.deleteAnnouncementById(AnnouncementId);
	}
	
	
	
}
