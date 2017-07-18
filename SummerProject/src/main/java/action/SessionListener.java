package action;
import javax.servlet.http.HttpSessionEvent;  
import javax.servlet.http.HttpSessionListener;  
  
import org.apache.log4j.Logger;  
  
import model.User;  
import service.AppService;
public class SessionListener extends BaseAction implements HttpSessionListener {  
  
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(this.getClass());  
    private AppService appService;
    
    private User user = new User();
    public User getUser(){
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
    public void setAppService(AppService appService) {
		this.appService = appService;
		System.out.println("sessionListen start2!!!");
	}
    @Override  
    public void sessionCreated(HttpSessionEvent event) {  
    	System.out.println("sessionListen start3!!!");
    }  
  
    @Override  
    public void sessionDestroyed(HttpSessionEvent event) {  
    	System.out.println("sessionListen start12!!!");
    	String username = (String)event.getSession().getAttribute("username");
    	System.out.println(username+"??");
    	User user=appService.getUserByUsername(username);
    	System.out.println("sessionListen start111!!!");
		if(user.getRole().equals("admin_online")){
        	user.setRole("admin");
        }
		else if(user.getRole().equals("customer_online")){
        	user.setRole("customer");
        }
        appService.updateUser(user);
    }
	public Logger getLogger() {
		return logger;
	}
	public void setLogger(Logger logger) {
		this.logger = logger;
	}  
  
}  