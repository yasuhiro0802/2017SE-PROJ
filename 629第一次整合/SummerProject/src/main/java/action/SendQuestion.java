package action;

import java.io.IOException;

import model.Question;
import service.AppService;

public class SendQuestion extends BaseAction{
	private static final long serialVersionUID = 1L;
	private AppService appService;
	
	public void setAppService(AppService appService) {
		this.appService = appService;
	}
	
	private String skill;
	
	public void setSkill(String skill){
		this.skill = skill;
	}
	
	public String getSkill(){
		return skill;
	}
	
	public String execute() throws IOException{
		System.out.println(skill);
		Question question = appService.getRandomQuestion();
		String message = String.valueOf(question.getId())+'|'+question.getQuestion()+'|'+question.getAnswerA()+'|'+
					question.getAnswerB()+'|'+question.getAnswerC()+'|'+question.getAnswerD()+'|'+question.getAnswer()+'|';
		response().getWriter().write(message);
		response().flushBuffer();
		return SUCCESS;
	}
}
