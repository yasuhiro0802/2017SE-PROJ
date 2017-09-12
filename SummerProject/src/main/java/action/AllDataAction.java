package action;

import java.util.List;

import model.GameData;
import service.AppService;

public class AllDataAction extends BaseAction {

	private static final long serialVersionUID = 1L;

	private AppService appService;

	public void setAppService(AppService appService) {
		this.appService = appService;
	}

	@Override
	public String execute() throws Exception {

		List<GameData> users = appService.getAllGameData();
		request().setAttribute("datas", users);

		return SUCCESS;
	}
}
