package StudentInfoSys.service;

import java.util.List;

import StudentInfoSys.dao.ProgramDAO;
import StudentInfoSys.entity.Program;

public class ProgramService {

	public static String SUCCESS = "Success";
	public static String FAILURE = "Failure";
	public static ProgramDAO programDAO = new ProgramDAO();

	
	//return list of programs
	public  List<Program> getAllProgram(){
	    return programDAO.getAllProgram();
	}
	
	//return program object by its id
	public  Program getProgramById(String programId){
		return programDAO.getProgramById(Integer.parseInt(programId));
	}

	public  String createProgram(Program program) {
		if(!programDAO.containProgram(program.getProgramId())){
			programDAO.createUpdateProgram(program);
			return SUCCESS;
		}else{
			return FAILURE;
		}
	}

	public  String updateProgram(Program program) {
		if(programDAO.containProgram(program.getProgramId())){
			programDAO.createUpdateProgram(program);
			return SUCCESS;
		}else{
			return FAILURE;
		}
	}

	public String deleteProgramIdById(String programId) {
		if(programDAO.containProgram(Integer.parseInt(programId))){
			programDAO.deleteProgramIdById(Integer.parseInt(programId));
			return SUCCESS;
		}else{
			return FAILURE;
		}
	}
	
	
	
	
}
