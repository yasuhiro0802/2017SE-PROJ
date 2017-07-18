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
		}
		GameData user = (GameData)session().getAttribute("gamedata");
		if(roomList.get(roomId).getStatus().equals("empty")){
			roomList.get(roomId).setUserid_1(user.getId());
			roomList.get(roomId).setStatus("wait");
			session().setAttribute("player", 1);
			return 1;
		}
		if(roomList.get(roomId).getStatus().equals("wait")){
			if(roomList.get(roomId).getUserid_1() == 0){
				roomList.get(roomId).setUserid_1(user.getId());
				session().setAttribute("player", 1);
				roomList.get(roomId).setStatus("busy");
				return 1;
			}
			else{
				roomList.get(roomId).setUserid_2(user.getId());
				session().setAttribute("player", 2);
				roomList.get(roomId).setStatus("busy");
				return 2;
			}
		}
		session().setAttribute("player", 1);
		return 1;
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
		
		for(int i = 0;i<roomSize;i++){
			if(roomList.get(i).getStatus().equals("empty")){
				roomList.get(i).setUserid_1(user.getId());
				roomList.get(i).setStatus("wait");
				session().setAttribute("roomId", roomList.get(i).getId());
				session().setAttribute("player", 1);
				return SUCCESS;
			}
			if(roomList.get(i).getStatus().equals("wait")){
				if(roomList.get(i).getUserid_1() == 0){
					roomList.get(i).setUserid_1(user.getId());
					session().setAttribute("player", 1);
				}
				else{
					roomList.get(i).setUserid_2(user.getId());
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
	
	public int RankPoint(int correct,int wrong,String result){
		int roomId = (int)session().getAttribute("roomId");
		GameData player = (GameData)session().getAttribute("gamedata");
		int id2 = (int)session().getAttribute("player2");
		ClearRoom(roomId);

		GameData player2 = appService.getGamedataById(id2); 

		double diff = player.getRankpoint() - player2.getRankpoint();

		double point = Math.sqrt(Math.abs(diff));

		if(result.equals("win")){
			if(diff>0)
				point = diff*(correct*point-wrong);
			else
				point = -1*diff*(correct*point*point-wrong);
			if (point>0)
				return (int)point;
			return 0;
		}
		if(diff>0)
			point = diff*(correct*point*point-wrong+1)/point;
		else
			point = -1*diff*(correct*point-wrong+1)/point;
		if (point>0)
			return (int)point*-1;
		return (int)(point*point);
		
	}
	
	public List<Room> getRoomList(){
		return roomList;
	}
}
