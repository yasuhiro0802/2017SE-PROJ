package action;

import model.GameData;
import service.AppService;

public class Buy extends BaseAction{

	private static final long serialVersionUID = 1L;

	private int item;
	private AppService appService;
	
	public void setAppService(AppService appService) {
		this.appService = appService;
	}
	
	public void setItem(int item){
		this.item=item;
	}
	
	public String execute(){
		
		GameData gamedata = (GameData)session().getAttribute("gamedata");

		switch(item){
		case 1:
			int item_coin = appService.getItemById(1).getCoin();
			if(gamedata.getItem1()!=0){
				addFieldError("shopresult","购买失败，你已拥有该物品");
				return ERROR;
			}
			else{
				if (gamedata.getCoin()<=item_coin){
					addFieldError("shopresult","购买失败，金币不足");
					return ERROR;
				}
				else{
					gamedata.setCoin(gamedata.getCoin()-item_coin);
					gamedata.setItem1(1);
					addFieldError("shopresult","购买成功");
					appService.updateGamedata(gamedata);
					return SUCCESS;
				}
			}
		case 2:
			item_coin = appService.getItemById(2).getCoin();
			if(gamedata.getItem2()!=0){
				addFieldError("shopresult","购买失败，你已拥有该物品");
				return ERROR;
			}
			else{
				if (gamedata.getCoin()<=item_coin){
					addFieldError("shopresult","购买失败，金币不足");
					return ERROR;
				}
				else{
					gamedata.setCoin(gamedata.getCoin()-item_coin);
					gamedata.setItem2(1);
					addFieldError("shopresult","购买成功");
					appService.updateGamedata(gamedata);
					return SUCCESS;
				}
			}
		case 3:
			item_coin = appService.getItemById(3).getCoin();
			if(gamedata.getItem3()!=0){
				addFieldError("shopresult","购买失败，你已拥有该物品");
				return ERROR;
			}
			else{
				if (gamedata.getCoin()<=item_coin){
					addFieldError("shopresult","购买失败，金币不足");
					return ERROR;
				}
				else{
					gamedata.setCoin(gamedata.getCoin()-item_coin);
					gamedata.setItem3(1);
					addFieldError("shopresult","购买成功");
					appService.updateGamedata(gamedata);
					return SUCCESS;
				}
			}
		
		case 4:
			item_coin = appService.getItemById(4).getCoin();
			if(gamedata.getItem4()!=0){
				addFieldError("shopresult","购买失败，你已拥有该物品");
				return ERROR;
			}
			else{
				if (gamedata.getCoin()<=item_coin){
					addFieldError("shopresult","购买失败，金币不足");
					return ERROR;
				}
				else{
					gamedata.setCoin(gamedata.getCoin()-item_coin);
					gamedata.setItem4(1);
					addFieldError("shopresult","购买成功");
					appService.updateGamedata(gamedata);
					return SUCCESS;
				}
			}
		}
		
		
		return SUCCESS;
	}
}
