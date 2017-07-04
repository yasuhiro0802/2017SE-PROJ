package action;


import model.User;
import service.AppService;

public class Register extends BaseAction{

	private static final long serialVersionUID = 1L;
	
    private User user = new User();
	private AppService appService;
	private String repassword;
	public User getUser(){
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	public void setAppService(AppService appService) {
		this.appService = appService;
	}
	
	public void setRepassword(String repassword){
		this.repassword=repassword;
	}
	
	public String execute() throws Exception {
		if(!volidate()){
			return INPUT;
		}
		user.setRole("customer");
        int result = appService.register(user);
        if(result == 0){
        	addFieldError("username","username repeat");
            return INPUT;
        }
        
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
		
		if(!(getUser().getPassword().equals(repassword))){
			addFieldError("password","2 password are not same");
			check=false;
		}
		
		return check;
		
	}
}