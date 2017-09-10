package action;

import java.io.IOException;
import action.BaseAction;
import model.GameData;
import model.Room;
import model.Item;
import service.AppService;


public class get_rank_setting extends BaseAction{

	private static final long serialVersionUID = 1L;
	private AppService appService;
	private RoomAction roomAction = new RoomAction();
	
	public AppService getAppService() {
		return appService;
	}
	public void setAppService(AppService appService) {
		this.appService = appService;
	}
	
	public String execute() throws IOException{
		System.out.println("get_setting");
		GameData playerdata =((GameData)session().getAttribute("gamedata"));
		int roomId = (int)session().getAttribute("roomId");
		Room room = roomAction.getRoomList().get(roomId);
		
		System.out.println("setting!!!!");
		//自己位置X|Y|对手位置X|Y|自己速度|自己血量|敌人血量|攻击加成|type(空)|自己动画|敌人动画|
		int player = (int)session().getAttribute("player");
		
		
		if ( player == 1 )
		{
			Item item = appService.getItemByCharacterId(room.getUserid_1()%10);
			double blood = item.getBlood()*(playerdata.getItem5()/10.0+1);
			double speed = item.getSpeed()*(playerdata.getItem6()/10.0+1);;
			double attack = item.getAttack()*(playerdata.getItem7()/10.0+1);;
			int opponentCharacter = room.getUserid_2()%10;
			int opponentId = room.getUserid_2()/10;
			GameData opponentdata = appService.getGamedataById(opponentId);
			double oppoBlood = appService.getItemByCharacterId(opponentCharacter).getBlood()*(opponentdata.getItem5()/10.0+1);

			session().setAttribute("blood", blood);
			response().getWriter().write("500|1225|3500|1225|"+String.valueOf(speed)+"|"+String.valueOf(blood)+"|"+String.valueOf(oppoBlood)
			+"|"+String.valueOf(attack)+"|"+String.valueOf(player)+"|"+String.valueOf(room.getUserid_1()%10)+"|"+String.valueOf(room.getUserid_2()%10)+"|");
		}
		else{
			Item item = appService.getItemByCharacterId(room.getUserid_2()%10);
			double blood = item.getBlood()*(playerdata.getItem5()/10.0+1);
			double speed = item.getSpeed()*(playerdata.getItem6()/10.0+1);
			double attack = item.getAttack()*(playerdata.getItem7()/10.0+1);
			int opponentCharacter = room.getUserid_1()%10;
			int opponentId = room.getUserid_1()/10;
			GameData opponentdata = appService.getGamedataById(opponentId);
			double oppoBlood = appService.getItemByCharacterId(opponentCharacter).getBlood()*(opponentdata.getItem5()/10.0+1);
			session().setAttribute("blood", blood);
			response().getWriter().write("3500|1225|500|1225|"+String.valueOf(speed)+"|"+String.valueOf(blood)+"|"+String.valueOf(oppoBlood)
			+"|"+String.valueOf(attack)+"|"+String.valueOf(player)+"|"+String.valueOf(room.getUserid_2()%10)+"|"+String.valueOf(room.getUserid_1()%10)+"|");
		}
			
		response().getWriter().flush();
		return SUCCESS;
	}
	

}
