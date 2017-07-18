package action;

import model.Room;

public class set_rank_setting extends BaseAction{

	private static final long serialVersionUID = 1L;
	private RoomAction roomAction = new RoomAction();
	
	private int character;
	
	private int roomId;

	public int getCharacter() {
		return character;
	}

	public void setCharacter(int character) {
		this.character = character;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	
	public String execute(){
		int player = roomAction.addRoom(roomId);
		Room room = roomAction.getRoomList().get(roomId);
		session().setAttribute("roomId", roomId);
		session().setAttribute("mode", "rank");
		if(player == 1){
			room.setUserid_1(room.getUserid_1()*10+character);
			System.out.println(roomId+"RoomUserid_1:"+room.getUserid_1());
		}
			
		else{
			room.setUserid_2(room.getUserid_2()*10+character);
			System.out.println(roomId+"RoomUserid_2:"+room.getUserid_2());
		}
		return SUCCESS;
	}

}
