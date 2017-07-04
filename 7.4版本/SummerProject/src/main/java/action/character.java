package action;

import java.io.IOException;

public class character extends BaseAction{

	private static final long serialVersionUID = 1L;
	
	private String character;
	
	public void setCharacter(String character){
		this.character=character;
		session().setAttribute("character", character);
		System.out.println("character is "+character+"???????????????????????");
	}
	
	public String set_choice(){
		session().setAttribute("character", character);
		System.out.println("character is "+character+"???????????????????????");
		return SUCCESS;
	}
	
	public String execute() throws IOException{
		character=(String)session().getAttribute("character");
		System.out.println("character is "+character+"!!!!!!!!!!!!!!");
		response().getWriter().write(character+'|');
		response().flushBuffer();
		return SUCCESS;
	}

}
