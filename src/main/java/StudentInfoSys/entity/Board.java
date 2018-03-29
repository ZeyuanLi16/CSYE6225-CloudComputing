package StudentInfoSys.entity;

public class Board {
	private int boardId;
	private String board;
	private int courseId;
	
	public Board(int boardId, String board, int courseId) {
		super();
		this.boardId = boardId;
		this.board = board;
		this.courseId = courseId;
	}
	
	public Board() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getBoardId() {
		return boardId;
	}
	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}
	public String getBoard() {
		return board;
	}
	public void setBoard(String board) {
		this.board = board;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	
}
