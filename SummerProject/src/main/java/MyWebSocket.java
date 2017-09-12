import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.servlet.http.HttpSession;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import model.GameData;
import action.RoomAction;
import model.Room;

@ServerEndpoint(value="/websocket",configurator=GetHttpSessionConfigurator.class)
public class MyWebSocket{

    private static int onlineCount = 0;
    
    private int roomId;
    private double blood;
    private static int roomSize = 10;
    private MyWebSocket opponent;
    //private CopyOnWriteArraySet<MyWebSocket> webSocketSet = new CopyOnWriteArraySet<MyWebSocket>();
    private static List<CopyOnWriteArraySet<MyWebSocket>> roomList =new ArrayList<CopyOnWriteArraySet<MyWebSocket>>();
    private int userId;
    private Session session;
    private HttpSession webSession;
    @OnOpen
    public void onOpen(Session session,EndpointConfig config){
        this.session = session;
        HttpSession httpSession= (HttpSession) config.getUserProperties().get(HttpSession.class.getName());
        webSession = httpSession;
        roomId = (int)httpSession.getAttribute("roomId");
        userId = ((GameData)httpSession.getAttribute("gamedata")).getId();
        if (roomList.size() < roomSize){
        	for(int i = roomList.size() ; i < roomSize ; i++){
        		roomList.add(new CopyOnWriteArraySet<MyWebSocket>());
        	}
        }
        
        blood = (double)httpSession.getAttribute("blood");
        System.out.println("Open_room:"+roomId);
        //if(roomList.size()<roomId+1)     
        	//roomList.add(webSocketSet);
        roomList.get(roomId).add(this);   
      //webSocketSet.add(this);  
        addOnlineCount();           
        System.out.println("member :" + getOnlineCount()+"roomMember:"+roomList.get(roomId).size());
    }
     
    
    @OnClose
    public void onClose(){
    	roomList.get(roomId).remove(this);
        //webSocketSet.remove(this);  
        subOnlineCount();            
        System.out.println("member :" + getOnlineCount());
    }
     
   
    @OnMessage
    public void onMessage(String message, Session session,EndpointConfig config) {
       /*for(MyWebSocket item: webSocketSet){             
            try {
                item.sendMessage(message);
                session.getBasicRemote().sendText(message);
            } catch (IOException e) {
                e.printStackTrace();
                continue;
            }
        }*/
    	String[] temp = message.split("\\|");
		if(opponent == null){
    		for(MyWebSocket item: roomList.get(roomId)){             
	            if(item != this){ 
	            	opponent = item;
	        		webSession.setAttribute("player2", opponent.userId);
	           		break;
	           	}
    		}
		}
		else{
	    	if (!(temp[0].equals("position") || temp[0].equals("attack")))
	    	{
	    		double attack = Double.parseDouble(temp[1]);
	    		
	    		if(temp[0].equals("increase")){
	    			blood++;
	    		}
	
	
	    		try {
	    			opponent.blood -=attack;
	        		message = "blood|"+String.valueOf(opponent.blood)+"|"+String.valueOf(this.blood)+"|";
	        		opponent.sendMessage(message);
	        		message = "blood|"+String.valueOf(this.blood)+"|"+String.valueOf(opponent.blood)+"|";
	        		this.sendMessage(message);
	        		
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	    				
	    	}
	    	else{
	    		try {
	        		opponent.sendMessage(message);
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	    	}
		}
    }
     

    @OnError
    public void onError(Session session, Throwable error){
        System.out.println("error occur");
        error.printStackTrace();
        RoomAction roomAction = new RoomAction();
    	List<Room> roomList = roomAction.getRoomList();
    	roomList.get(roomId).setStatus("empty");
    	roomList.get(roomId).setUserid_1(0);
    	roomList.get(roomId).setUserid_2(0);
    	
    }
     

    public void sendMessage(String message) throws IOException{ 		
    		this.session.getBasicRemote().sendText(message);
        //this.session.getAsyncRemote().sendText(message);
    }
 
    public static synchronized int getOnlineCount() {
        return onlineCount;
    }
 
    public static synchronized void addOnlineCount() {
        MyWebSocket.onlineCount++;
    }
     
    public static synchronized void subOnlineCount() {
        MyWebSocket.onlineCount--;
    }
}