package action;

import model.GameData;
import service.AppService;
import action.RoomAction;
public class UpdateGamedata extends BaseAction{

	private static final long serialVersionUID = 1L;
	
	private String result;
	private int num;
	private int wrong;
	
	private AppService appService;
	
	public void setAppService(AppService appService) {
		this.appService = appService;
	}
	
	public void setResult(String result){
		this.result=result;
	}
	
	public void setNum(int num){
		this.num=num;
	}
	
	public void setWrong(int wrong){
		this.wrong=wrong;
	}
	
	public String execute(){
		
		GameData gamedata = (GameData)session().getAttribute("gamedata");
		int id = gamedata.getId();
		int coin = num-wrong*2>0?num-wrong*2:0;
		
		session().setAttribute("gameresult", result);

		gamedata.setSinglegame(gamedata.getSinglegame()+1);
		
		if (result.equals("win")){
			coin*=5;
			gamedata.setCoin(coin+gamedata.getCoin());
			gamedata.setSinglewin(gamedata.getSinglewin()+1);
		}
		else
		{
			gamedata.setCoin(coin+gamedata.getCoin());
		}
		appService.updateGamedata(gamedata);
		session().setAttribute("gamedate", gamedata);
		session().setAttribute("result", result);
		session().setAttribute("correct",num-wrong);
		session().setAttribute("wrong", wrong);
		session().setAttribute("coin", coin);
		return SUCCESS;
	}
	
public String UpdateRank(){
		RoomAction roomAction = new RoomAction(appService);
		GameData gamedata = (GameData)session().getAttribute("gamedata");
		int id = gamedata.getId();
		int coin = num-wrong*2>0?num-wrong*2:0;
		
		System.out.println("start!!!");
		String mode = (String)session().getAttribute("mode");
		System.out.println(mode);
		if(mode.equals("rank")){                //排位模式
			int rankpoint = roomAction.RankPoint(num-wrong,wrong,result);
			gamedata.setRankgame(gamedata.getRankgame()+1);
			
			if(gamedata.getRankpoint()+rankpoint<=0){
				gamedata.setRankpoint(0);
			}
			else{
				gamedata.setRankpoint(gamedata.getRankpoint()+rankpoint);
			}
			
			if (result.equals("win")){
				coin*=5;
				gamedata.setCoin(coin+gamedata.getCoin());
				gamedata.setRankwin(gamedata.getRankwin()+1);
			}
			else
			{
				gamedata.setCoin(coin+gamedata.getCoin());
			}
			appService.updateGamedata(gamedata);
			session().setAttribute("gamedate", gamedata);
			session().setAttribute("result", result);
			session().setAttribute("correct",num-wrong);
			session().setAttribute("wrong", wrong);
			session().setAttribute("coin", coin);
			session().setAttribute("rankpoint", rankpoint);
			return SUCCESS;
		}
		else{                                                                   //一般模式

			roomAction.ClearRoom((int)session().getAttribute("roomId"));
			
			gamedata.setTeamgame(gamedata.getTeamgame()+1);
			System.out.println(result);
			if (result.equals("win")){
				coin*=5;
				gamedata.setCoin(coin+gamedata.getCoin());
				gamedata.setTeamwin(gamedata.getTeamwin()+1);
			}
			else
			{
				gamedata.setCoin(coin+gamedata.getCoin());
			}
			
			appService.updateGamedata(gamedata);
			session().setAttribute("gamedate", gamedata);
			session().setAttribute("result", result);
			session().setAttribute("correct",num-wrong);
			session().setAttribute("wrong", wrong);
			session().setAttribute("coin", coin);
			System.out.println("over");
			return SUCCESS;
		}
	}

	/*public String GetMode(){
		if(((String)session().getAttribute("mode")).equals("rank")){
			return "rank";
		}
		else 
			return SUCCESS;
		
	}*/
}
