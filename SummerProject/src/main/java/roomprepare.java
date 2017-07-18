import action.*;
import model.Room;
public class roomprepare extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int roomId;

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	
	public String execute(){
		RoomAction roomAction = new RoomAction();
		session().setAttribute("roomId", roomId);
		roomAction.addRoom(roomId);
		return SUCCESS;
	}
	
	public String refresh(){
		roomId = (int)session().getAttribute("roomId");
		RoomAction roomAction = new RoomAction();
		session().setAttribute("roomInfo", roomAction.getRoomList().get(roomId));
		return SUCCESS;
	}
	
	public String start(){
		roomId = (int)session().getAttribute("roomId");
		RoomAction roomAction = new RoomAction();
		Room room = roomAction.getRoomList().get(roomId);
		room.setStatus("start");		
		session().setAttribute("roomInfo", room);
		return SUCCESS;
	}

}
