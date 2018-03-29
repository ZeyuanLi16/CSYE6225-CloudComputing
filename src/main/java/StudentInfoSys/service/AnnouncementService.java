package StudentInfoSys.service;

import java.util.List;

import StudentInfoSys.dao.AnnouncementDAO;
import StudentInfoSys.entity.Announcement;

public class AnnouncementService {
	public static String SUCCESS = "Success";
	public static String FAILURE = "Failure";
	public static AnnouncementDAO announcementDAO = new AnnouncementDAO();


	//return list of announcements
	public  List<Announcement> getAllAnnouncement(){
	    return announcementDAO.getAllAnnouncement();
	}
	
	//return announcement object by its id
	public  Announcement getAnnouncementById(String announcementId){
		return announcementDAO.getAnnouncementById(Integer.parseInt(announcementId));
	}

	public  String createAnnouncement(Announcement announcement) {
		if(!announcementDAO.containAnnouncement(announcement.getAnnouncementId())){
			announcementDAO.createUpdateAnnouncement(announcement);
			return SUCCESS;
		}else{
			return FAILURE;
		}
	}

	public  String updateAnnouncement(Announcement announcement) {
		if(announcementDAO.containAnnouncement(announcement.getAnnouncementId())){
			announcementDAO.createUpdateAnnouncement(announcement);
			return SUCCESS;
		}else{
			return FAILURE;
		}
	}
	public String deleteAnnouncementById(String announcementId) {
		if(announcementDAO.containAnnouncement(Integer.parseInt(announcementId))){
			announcementDAO.deleteAnnouncementById(Integer.parseInt(announcementId));
			return SUCCESS;
		}else{
			return FAILURE;
		}
	}

	public List<Announcement> getAnnouncementsByCourseID(String CourseId) {
		return announcementDAO.getAnnouncementsByCourseID(CourseId);
	}
	
}
