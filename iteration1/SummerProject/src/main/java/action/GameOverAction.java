package action;

import java.io.IOException;

import model.Question;
import service.AppService;

public class GameOverAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	private AppService appService;
	
	public void setAppService(AppService appService) {
		this.appService = appService;
	}
	
	private String skill;
	private Integer coin;
	
	public void setSkill(String skill){
		this.skill = skill;
	}
	
	public String getSkill(){
		return skill;
	}
	
	public void setCoin(Integer coin){
		this.coin = coin;
	}
	
	public Integer getCoin(){
		return coin;
	}
	
	public String execute() throws IOException{
		System.out.println("game_over_action2");
		return SUCCESS;
	}
}
