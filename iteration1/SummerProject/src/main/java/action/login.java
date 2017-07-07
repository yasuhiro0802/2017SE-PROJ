package action;


import model.GameData;
import model.User;
import service.AppService;

public class login extends BaseAction{

	private static final long serialVersionUID = 1L;
	
    private User user = new User();
	private AppService appService;
	
	public User getUser(){
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	public void setAppService(AppService appService) {
		this.appService = appService;
	}
	
	public String execute() throws Exception {
		if(!volidate()){
			return INPUT;
		}
        int result = appService.login(user);
        if(result == -1){
        	addFieldError("password","Wrong Password");
            return INPUT;
        }
        if(result == 0){
        	addFieldError("username","No such user");
            return INPUT;
        }
        session().setAttribute("username", user.getUsername());
        user=appService.getUserByUsername(user.getUsername());
        GameData gamedata= appService.getGamedataById(user.getId());
        session().setAttribute("gamedata", gamedata);
       /* int coin = gamedata.getCoin();
		int rankpoint = gamedata.getRankpoint();
		int singlegame = gamedata.getSinglegame();
		int singlewin = gamedata.getSinglewin();
		int rankgame = gamedata.getRankgame();
		int rankwin = gamedata.getRankwin();
		int teamgame = gamedata.getTeamgame();
		int teamwin = gamedata.getTeamwin();
		session().setAttribute("coin", coin);
		session().setAttribute("rankpoint", rankpoint);
		session().setAttribute("singlegame", singlegame);
		session().setAttribute("singlewin", singlewin);
		session().setAttribute("rankgame", rankgame);
		session().setAttribute("rankwin", rankwin);
		session().setAttribute("teamgame", teamgame);
		session().setAttribute("teamwin", teamwin);*/
        return SUCCESS;
	}
	
	public String logout(){
		session().removeAttribute("username");
		session().removeAttribute("gamedata");
		return SUCCESS;
	}
	
	public boolean volidate(){
		boolean check=true;
		if ((getUser().getUsername()).length()<=2){
			addFieldError("username","username at least 3 characters");
			check=false;
		}
		
		if ((getUser().getPassword()).length()<=2){
			addFieldError("password","password at least 3 characters");
			check=false;
		}
		return check;
		
	}
}