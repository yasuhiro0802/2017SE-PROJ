import java.io.IOException;
import action.BaseAction;
import model.GameData;


public class rank_setting extends BaseAction{

	private static final long serialVersionUID = 1L;
	
	public String execute() throws IOException{
		int id=((GameData)session().getAttribute("gamedata")).getId();
		if (id==1)
			id=2;
		else
			id=1;
		System.out.println("setting!!!!");
		//自己位置X|Y|对手位置X|Y|自己速度|自己血量|敌人血量|攻击加成|type(空)|自己动画|敌人动画|
		int player = (int)session().getAttribute("player");
		if ( player == 1 )
			response().getWriter().write("500|1225|3500|1225|800|10|10|1|"+String.valueOf(id)+"|2|2|");
		else
			response().getWriter().write("3500|1225|500|1225|800|10|10|1|"+String.valueOf(id)+"|2|2|");
		response().getWriter().flush();
		return SUCCESS;
	}

}
