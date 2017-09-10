package action;

import java.io.IOException;
import model.Item;
import model.GameData;
import service.AppService;

public class character extends BaseAction{

	private static final long serialVersionUID = 1L;
	
	private String character;
	private AppService appService;
	private int difficulty;
	public void setDifficulty(int difficulty){
		this.difficulty = difficulty;
	}
	
	public void setCharacter(String character){
		this.character = character;
	}	
	
	public void setAppService(AppService appService) {
		this.appService = appService;
	}
	
	public String set_choice(){
		session().setAttribute("character", character);
		session().setAttribute("difficulty", difficulty);
		return SUCCESS;
	}
	
	public String set_character(){
		session().setAttribute("character", character);
		System.out.println("set_character success:"+character);
		return SUCCESS;
	}
	
	public String execute() throws IOException{
		String character=(String)session().getAttribute("character");
		int difficulty=(int)session().getAttribute("difficulty");
		Item item = appService.getItemByCharacterId(Integer.parseInt(character));
		
		GameData gamedata = (GameData)session().getAttribute("gamedata");
		double blood = (double)item.getBlood()*(gamedata.getItem5()/10.0+1);
		double speed = (double)item.getSpeed()*(gamedata.getItem6()/10.0+1);
		double attack = (double)item.getAttack()*(gamedata.getItem7()/10.0+1);
		
		
		String speedS = String.valueOf(speed);
		String bloodS = String.valueOf(blood);
		String attackS = String.valueOf(attack);
		//角色|角色速度|血量|敌人血量|敌人攻击间隔时间（2）|敌人改变方向时间（0.4）|攻击力|敌人移动速度(350)|
		if (difficulty == 1){
			response().getWriter().write(character+'|'+speedS+'|'+bloodS+"|10|2|0.4|"+attackS+"|350|");
		}
		else if(difficulty == 2){
			response().getWriter().write(character+'|'+speedS+'|'+bloodS+"|15|1.5|0.4|"+attackS+"|400|");
		}
		else if(difficulty == 3){
			response().getWriter().write(character+'|'+speedS+'|'+bloodS+"|20|1.2|0.4|"+attackS+"|425|");
		}
		response().getWriter().flush();
		return SUCCESS;
	}

}
