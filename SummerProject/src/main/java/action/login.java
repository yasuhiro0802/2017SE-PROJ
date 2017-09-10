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
        
        
        
        user=appService.getUserByUsername(user.getUsername());
        
       
        
        
        session().setAttribute("username", user.getUsername());
        if(user.getRole().equals("admin")){
        	appService.updateUser(user);
            GameData gamedata= appService.getGamedataById(user.getId());
            session().setAttribute("gamedata", gamedata);
            return LOGIN;
        }
        else if(user.getRole().equals("customer")){
        	user.setRole("customer");
        	appService.updateUser(user);
            GameData gamedata= appService.getGamedataById(user.getId());
            session().setAttribute("gamedata", gamedata);
            return SUCCESS;
        }
        return SUCCESS;
	}
	
	public String logout(){
		user=appService.getUserByUsername((String)session().getAttribute("username"));
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