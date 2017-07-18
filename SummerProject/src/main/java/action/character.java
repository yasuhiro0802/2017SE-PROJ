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
	
	public String execute() throws IOException{
		String character=(String)session().getAttribute("character");
		int difficulty=(int)session().getAttribute("difficulty");
		Item item = appService.getItemByCharacterId(Integer.parseInt(character));
		
		double speed = (double)item.getSpeed();
		double blood = (double)item.getBlood();
		double attack = (double)item.getAttack();
		
		
		GameData gamedata = (GameData)session().getAttribute("gamedata");
		if(gamedata.getItem5()!=0){
			speed *= 1.3;
			attack *= 1.63;
			blood *= 1.33;
		}
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
