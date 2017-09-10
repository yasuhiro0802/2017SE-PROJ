<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.GameData"%>
<%@ page import="model.Room"%>
<%@ page import="java.util.List"%>
<%@ page import="action.RoomAction"%>
<!DOCTYPE HTML>
<html>
<head>
<%
	String path = request.getContextPath();
	GameData gamedata = (GameData)session.getAttribute("gamedata");
	if(gamedata == null){
		response.sendRedirect("login_again");
	}
	
	
	String username = (String)session.getAttribute("username");
	RoomAction roomAction = new RoomAction();
	List<Room> roomList = roomAction.getRoomList();
	//List<Room> roomList = (List<Room>)request.getAttribute("roomList");
%>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta http-equiv="refresh" content="3">
<title>RoomList-Let's start your game</title>
<link href="<%=path%>/summerproject/css/GameMain/bootstrap.css" rel="stylesheet" type="text/css">
<link href="<%=path%>/summerproject/css/GameMain/bootstrap-responsive.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="<%=path%>/summerproject/css/GameMain/style.css">

<link href="<%=path%>/summerproject/css/GameMain/font-awesome.min.css" rel="stylesheet" type="text/css">
<link href="<%=path%>/summerproject/css/GameMain/prettyPhoto.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="<%=path%>/summerproject/js/GameMain/modernizr.custom.js"></script>
</head>

<body>


<!--Start Slide 5-->

<div class="scroll-slide" id="slide5" data-move="4" data-stellar-background-ratio="0">
  <div class="slide5-separator"></div>
  <div class="slidename">选择房间</div>
 
  <div class="container">
    <div class="row">
      <div class="span12">
        <div class="dropcap">D</div>
        <p class="lead">请选择一个房间进行游戏 </p>
        
      </div>
      
     <%
     for(int x = 0; x < roomList.size(); x++){
    	 if(!roomList.get(x).getStatus().equals("empty")){
     %>
      <div class="span3">
        <div class="photographer">
           <div class="photo-frame-1"><img href="prepare?roomId=<%=roomList.get(x).getId() %>" src="<%=path%>/summerproject/images/character/1.png" alt="One" /></div>
          <h3>房间<%=roomList.get(x).getId() %>:状态：<%=roomList.get(x).getStatus() %></h3>
          <%
          if(roomList.get(x).getStatus().equals("wait")){
          %>
          <a href="prepare?roomId=<%=roomList.get(x).getId() %>">进入房间</a>
          <%} %>
          <br>
          <br>
          <br>
          <br>
        </div>
      </div>
      <%
      }
     }
      %>
      
      <br>
      <br>
      <br>
      <br>
      <br>
      <a href="prepare?roomId=<%=roomAction.getEmptyRoom()%>">创建房间</a>
      <br>
      <br>
      <br>
      <a href="returnhome">返回主界面</a>
      <br>
      <br>
      <br>
    </div>
  </div>
</div>
<!--End Slide 5--> 


<!-- Footer -->
<div class="scroll-slide" id="slide4" data-move="5" data-stellar-background-ratio="0.5">
<footer class="footer">
  <div class="container">
  
    <div class="row"> 
      <!--Address and Company Name-->
      <div class="span4">
        <h4>Quick Info</h4>
        <p>Summer Project</p>
        <br/>
        <p>王雨乐</p>
        <br/>
        <p>彭浩伦</p>
        <br/>
        <p>高仓靖博</p>
      </div>
     </div>
     
     	<h5><a href="logout" >退出登录</a></h5>
    </div>
    </footer>
  </div>


<!-- Footer Ends --> 



<!--Scripts--> 
<script type="text/javascript" src="<%=path%>/summerproject/js/GameMain/jquery.js"></script> 
<script type="text/javascript" src="<%=path%>/summerproject/js/GameMain/jquery.cbpQTRotator.min.js"></script> 
<script type="text/javascript" src="<%=path%>/summerproject/js/GameMain/bootstrap.min.js"></script> 
<script type="text/javascript" src="<%=path%>/summerproject/js/GameMain/jquery.prettyPhoto.js"></script> 
<script type="text/javascript" src="<%=path%>/summerproject/js/GameMain/js.js"></script> 
<script type="text/javascript" src="<%=path%>/summerproject/js/GameMain/jquery.isotope.min.js"></script> 
<script type="text/javascript" src="<%=path%>/summerproject/js/GameMain/jquery.masonry.min.js"></script> 
<script type="text/javascript" src="<%=path%>/summerproject/js/GameMain/jquery.stellar.min.js"></script> 
<script type="text/javascript" src="<%=path%>/summerproject/js/GameMain/waypoints.min.js"></script> 
<script type="text/javascript" src="<%=path%>/summerproject/js/GameMain/jquery.easing.1.3.js"></script> 
<script type="text/javascript" src="<%=path%>/summerproject/js/GameMain/jquery.jigowatt.js"></script> 
<script type="text/javascript" src="<%=path%>/summerproject/js/GameMain/jquery.nicescroll.min.js"></script>
</body>
</html>