import action.BaseAction;
public class room extends BaseAction{

	private static final long serialVersionUID = 1L;
	
	private int roomId;
	
	public void setRoomId(int roomId){
		this.roomId = roomId;
	}
	
	public String execute(){
		System.out.println(roomId);
		System.out.println("room action");
		session().setAttribute("roomId", roomId);
		return SUCCESS;
	}
}
/*import action.BaseAction;
import model.Item;
import service.AppService;

public class test extends BaseAction{
	private static final long serialVersionUID = 1L;
	private AppService appService;
	public void setAppService(AppService appService){
		this.appService= appService;
	}
	public String execute(){
		Item i = appService.getItemById(1);
		System.out.println(i.getCategory()+"!!!");
		return SUCCESS;
	}
}*/