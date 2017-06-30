package action;


import java.util.ArrayList;



import model.User;
import service.AppService;

public class login extends BaseAction{

	private static final long serialVersionUID = 1L;
	
    private User user = new User();
	private AppService appService;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	public void setAppService(AppService appService) {
		this.appService = appService;
	}
	

	@Override
	public String execute() throws Exception {
        int result = appService.login(user);
        if(result == 0){
            return INPUT;
        }
        return SUCCESS;
	}
}