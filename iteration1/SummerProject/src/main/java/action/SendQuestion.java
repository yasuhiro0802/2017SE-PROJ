package action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
	
	public static List<Question> questionList = new ArrayList<>();
	public static int id = 0;
	public static int size = 0;
	public String execute() throws IOException{
		System.out.println(skill+"123123");
		response().setHeader("Content-type", "text/html;charset=gb2312");

		if(size==0)
		{
			System.out.println("getAllquestion");
			questionList = appService.getAllQuestion();
			size = questionList.size();
		}
		if (id ==0)
			id = size-1;
		Question question = questionList.get(id);
		id--;

		
		String message = String.valueOf(question.getId())+'|'+question.getQuestion()+'|'+question.getAnswerA()+'|'+
					question.getAnswerB()+'|'+question.getAnswerC()+'|'+question.getAnswerD()+'|'+question.getAnswer()+'|'+
					String.valueOf(question.getDifficulty())+'|';
		response().getWriter().write(message);
		response().flushBuffer();
		System.out.println(message);
		return SUCCESS;
	}
}
