package action;

import java.util.ArrayList;
import java.util.List;

import model.GameData;
import service.AppService;
import model.Item;

public class GetItems extends BaseAction{

	private static final long serialVersionUID = 1L;
	
	private AppService appService;
	
	public void setAppService(AppService appService) {
		this.appService = appService;
	}
	
	@SuppressWarnings("null")
	public String execute(){
		
		GameData gamedata = (GameData)session().getAttribute("gamedata");
		int id = gamedata.getId();
		
		/*Item item1 = appService.getItemById(1);
		Item item2 = appService.getItemById(2);
		
		request().setAttribute("item1", item1);
		request().setAttribute("item2", item2);
		*/
		List<Integer> have_items = new ArrayList<Integer>();
		if(gamedata.getItem1()!=0) have_items.add(1);
		else have_items.add(0);
		if(gamedata.getItem2()!=0) have_items.add(1);
		else have_items.add(0);
		if(gamedata.getItem3()!=0) have_items.add(1);
		else have_items.add(0);
		if(gamedata.getItem4()!=0) have_items.add(1);
		else have_items.add(0);
		if(gamedata.getItem5()!=0) have_items.add(1);
		else have_items.add(0);
		if(gamedata.getItem6()!=0) have_items.add(1);
		else have_items.add(0);
		if(gamedata.getItem7()!=0) have_items.add(1);
		else have_items.add(0);
		
		List<Item> characteritems = appService.getAllCharacterItems();
		List<Item> objectitems = appService.getAllObjectItems();
		
		
		request().setAttribute("characteritems", characteritems);
		request().setAttribute("objectitems", objectitems);
		request().setAttribute("have_items", have_items);
		
		
		return SUCCESS;
	}
}
