package action;

import model.GameData;
import service.AppService;

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
			coin=num-wrong;
		}
		appService.updateGamedata(gamedata);
		session().setAttribute("gamedate", gamedata);
		session().setAttribute("result", result);
		session().setAttribute("correct",num-wrong);
		session().setAttribute("wrong", wrong);
		session().setAttribute("coin", coin);
		return SUCCESS;
	}
}
