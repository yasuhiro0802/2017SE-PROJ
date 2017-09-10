package action;
import service.AppService;

import java.util.ArrayList;
import java.util.List;
import model.Room;
import model.GameData;

public class RoomAction extends BaseAction{

	private static final long serialVersionUID = 1L;
	
	private AppService appService;
	private static List<Room> roomList = new ArrayList<Room>();
	private int roomSize = 10;
	
	public void setAppService(AppService appService){
		this.appService = appService;
	}
	
	public RoomAction(){
		
	}
	
	public RoomAction(AppService appService){
		this.appService = appService;
	}
	
	public String quit(){
		int roomId = (int)session().getAttribute("roomId");
		int player = (int)session().getAttribute("player");
		if(player == 1)
			roomList.get(roomId).setUserid_1(0);
		else
			roomList.get(roomId).setUserid_2(0);
		if(roomList.get(roomId).getStatus().equals("wait"))
			roomList.get(roomId).setStatus("empty");
		else
			roomList.get(roomId).setStatus("wait");
		return SUCCESS;
	}
	
	//需要修改
	public int addRoom(int roomId){                                   //进入房间
		
		if(roomList.size() == 0){
			for(int i = 0;i<roomSize;i++){		
				Room tempRoom = new Room();
				tempRoom.setStatus("empty");
				tempRoom.setUserid_1(0);
				tempRoom.setUserid_2(0);
				tempRoom.setId(i);
				roomList.add(tempRoom);
			}
			System.out.println("Initial roomList success");
		}
		GameData user = (GameData)session().getAttribute("gamedata");
		System.out.println("get gamedata");
		String character = (String)session().getAttribute("character");
		int characterid = Integer.parseInt(character);
		System.out.println("get character");
		if(roomList.get(roomId).getStatus().equals("empty")){
			roomList.get(roomId).setUserid_1(-user.getId()*10-characterid);
			roomList.get(roomId).setStatus("wait");
			session().setAttribute("player", 1);
			return 1;
		}
		if(roomList.get(roomId).getStatus().equals("wait")){
			if(roomList.get(roomId).getUserid_1() == 0){
				roomList.get(roomId).setUserid_1(-user.getId()*10-characterid);
				session().setAttribute("player", 1);
				roomList.get(roomId).setStatus("busy");
				return 1;
			}
			else{
				roomList.get(roomId).setUserid_2(-user.getId()*10-characterid);
				session().setAttribute("player", 2);
				roomList.get(roomId).setStatus("busy");
				return 2;
			}
		}
		session().setAttribute("player", 1);
		return 1;
	}
	
	
public String addRank(){                                   //进入排位
		
		if(roomList.size() == 0){
			for(int i = 0;i<roomSize;i++){		
				Room tempRoom = new Room();
				tempRoom.setStatus("empty");
				tempRoom.setUserid_1(0);
				tempRoom.setUserid_2(0);
				tempRoom.setId(i);
				roomList.add(tempRoom);
			}
			System.out.println("Initial Rank roomList success");
		}
		GameData user = (GameData)session().getAttribute("gamedata");
		System.out.println("get rank gamedata");
		String character = (String)session().getAttribute("character");
		int characterid = Integer.parseInt(character);
		System.out.println("get rank character");
		
		for(int j = 0; j < roomSize; j++){
			if(roomList.get(j).getStatus().equals("waitrank")){
				roomList.get(j).setUserid_2(user.getId()*10+characterid);
				roomList.get(j).setStatus("start");
				session().setAttribute("roomId", j);
				session().setAttribute("player", 2);
				System.out.println("Get Rank Success:"+j);
				return SUCCESS;
			}
		}
		
		int roomId = getEmptyRoom();
		Room room = roomList.get(roomId);
		roomList.get(roomId).setUserid_1(user.getId()*10+characterid);
		roomList.get(roomId).setStatus("waitrank");
		session().setAttribute("player", 1);
		session().setAttribute("roomId", roomId);
		session().setAttribute("roomInfo", room);
		System.out.println("Get Rank Wait Success"+roomId);
		return "wait";
}
		
		
	

	public String room(){
		GameData user = (GameData)session().getAttribute("gamedata");
		if(roomList.size() == 0){
			for(int i = 0;i<roomSize;i++){
				Room temp = new Room();
				temp.setId(i);
				roomList.add(temp);
			}
		}
		String character = (String)session().getAttribute("character");
		int characterid = Integer.parseInt(character);
		for(int i = 0;i<roomSize;i++){
			if(roomList.get(i).getStatus().equals("empty")){
				roomList.get(i).setUserid_1(user.getId()*10+characterid);
				roomList.get(i).setStatus("wait");
				session().setAttribute("roomId", roomList.get(i).getId());
				session().setAttribute("player", 1);
				return SUCCESS;
			}
			if(roomList.get(i).getStatus().equals("wait")){
				if(roomList.get(i).getUserid_1() == 0){
					roomList.get(i).setUserid_1(user.getId()*10+characterid);
					session().setAttribute("player", 1);
				}
				else{
					roomList.get(i).setUserid_2(user.getId()*10+characterid);
					session().setAttribute("player", 2);
				}
				roomList.get(i).setStatus("busy");
				session().setAttribute("roomId", roomList.get(i).getId());
				return "start";
			}
		}
		
		return INPUT;
	}
	
	public void ClearRoom(int roomId){
		roomList.get(roomId).setStatus("empty");
		roomList.get(roomId).setUserid_1(0);
		roomList.get(roomId).setUserid_2(0);
	}

	
	public List<Room> getRoomList(){
		return roomList;
	}
	
	public int getEmptyRoom(){
		if(roomList.size() == 0){
			for(int i = 0;i<roomSize;i++){		
				Room tempRoom = new Room();
				tempRoom.setStatus("empty");
				tempRoom.setUserid_1(0);
				tempRoom.setUserid_2(0);
				tempRoom.setId(i);
				roomList.add(tempRoom);
			}
		}
		System.out.println("New roomlist！");
		for (int z = 0; z < roomList.size(); z++){
			if (roomList.get(z).getStatus().equals("empty")){
				System.out.println("Empty Room:"+z);
				return z;
			}
		}
		return -1;
	}
}
