import action.BaseAction;
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
}