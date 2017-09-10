package action;

import java.util.ArrayList;
import java.util.List;

import model.Question;
import service.AppService;

public class AddQuesAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	
	private String website;
	private Integer difficulty;
	private String subject;
	private Integer number;
	
	private AppService appService;

	public void setWebsite(String website) {
		this.website = website;
	}
	
	public void setDifficulty(Integer difficulty) {
		this.difficulty = difficulty;
	}
	
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public void setNumber(Integer number) {
		this.number = number;
	}
	
	public void setAppService(AppService appService) {
		this.appService = appService;
	}

	@Override
	public String execute() throws Exception {
		String url = "";
		ArrayList<String> current = new ArrayList<String>();
		Question added;
		Integer page = number/10;
		System.out.println(subject);
		String parsed = subject;
		System.out.println(parsed);
		if(parsed.equals("0"))
			return SUCCESS;
		for (int i =40; i<40+page ;i++) {
			url = "http://tiku.21cnjy.com/tiku.php?mod=quest&channel=" + parsed +"&xd="+difficulty+"&type=1&page="+i;	
			current = appService.getParse(url);
			for(int j = 0; j < current.size();j++){
				System.out.println(current.get(j));
				
				added = appService.pachong(current.get(j),parsed,difficulty);
				if(added == null)
					continue;
				System.out.println(added.getQuestion());
				appService.addQuestion(added);

		}
		}
		return SUCCESS;

	}
	
}
