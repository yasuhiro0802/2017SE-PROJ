import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;
 
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
 

@ServerEndpoint("/websocket")
public class MyWebSocket {

    private static int onlineCount = 0;
     

    private static CopyOnWriteArraySet<MyWebSocket> webSocketSet = new CopyOnWriteArraySet<MyWebSocket>();
     

    private Session session;
     

    @OnOpen
    public void onOpen(Session session){
        this.session = session;
        webSocketSet.add(this);     
        addOnlineCount();           
        System.out.println("member :" + getOnlineCount());
    }
     
    
    @OnClose
    public void onClose(){
        webSocketSet.remove(this);  
        subOnlineCount();            
        System.out.println("member :" + getOnlineCount());
    }
     
   
    @OnMessage
    public void onMessage(String message, Session session) {
        System.out.println("message :" + message);
         
        for(MyWebSocket item: webSocketSet){             
            try {
                item.sendMessage(message);
            } catch (IOException e) {
                e.printStackTrace();
                continue;
            }
        }
    }
     

    @OnError
    public void onError(Session session, Throwable error){
        System.out.println("error occur");
        error.printStackTrace();
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