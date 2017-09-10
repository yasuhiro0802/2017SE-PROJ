package action;


import model.Room;
public class RoomPrepare extends BaseAction{

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
		System.out.println("RoomPrepare success:"+roomId);
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
		int player = (int)session().getAttribute("player");
		if(player == 1){
			room.setUserid_1(-room.getUserid_1());
		}
		else{
			room.setUserid_2(-room.getUserid_2());
		}
		if(room.getUserid_1()>0 && room.getUserid_2()>0){
			room.setStatus("start");
		}		
		session().setAttribute("roomInfo", room);
		return SUCCESS;
	}

}
