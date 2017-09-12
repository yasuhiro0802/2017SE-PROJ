package action;

import java.util.List;

import model.Item;
import service.AppService;

public class AllItemAction extends BaseAction {

	private static final long serialVersionUID = 1L;

	private AppService appService;

	public void setAppService(AppService appService) {
		this.appService = appService;
	}

	@Override
	public String execute() throws Exception {

		List<Item> users = appService.getAllItems();
		request().setAttribute("items", users);

		return SUCCESS;
	}
}
