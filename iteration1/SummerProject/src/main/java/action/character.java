package action;

import java.io.IOException;

public class character extends BaseAction{

	private static final long serialVersionUID = 1L;
	
	private String character;
	
	public void setCharacter(String character){
		this.character=character;
	}	
	public String set_choice(){
		session().setAttribute("character", character);

		return SUCCESS;
	}
	
	public String execute() throws IOException{
		character=(String)session().getAttribute("character");
		String speed="850";
		
		if(character.equals("2"))
			speed="1350";
		else if(character.equals("1"))
			speed="850";
		
		response().getWriter().write(character+'|'+speed+'|'+"20|10|");
		response().flushBuffer();
		return SUCCESS;
	}

}