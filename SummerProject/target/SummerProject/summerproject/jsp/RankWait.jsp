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
	
	Room room = (Room)session.getAttribute("roomInfo");
	Integer roomId = (Integer)session.getAttribute("roomId");
	Integer player=(Integer)session.getAttribute("player");
	if(room.getStatus().equals("start")){
	%>
		<body onload="getStart()">
<%
}
%>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta http-equiv="refresh" content="3">

<title>RoomWait-Let's start your game</title>
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
  <div class="slidename">正在匹配排位对手。。。请等待</div>
 
  <div class="container">
    <div class="row">
      <div class="span12">
        <p class="lead">请勿离开，匹配成功后将自动开始游戏 </p>
        
      </div>
      
     
      <br>
      <br>
      <br>
      <br>
      <br>
      <a href="quitRank">返回</a>
      <br>
      <br>
      <br>
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

<script>
	function getStart(){
		jsPost('roomtest',{ 'mode' : 'rank'});
	}
	var jsPost = function(action, values) {
		  var id = Math.random();
		  document.write('<form id="post' + id + '" name="post'+ id +'" action="' + action + '" method="post">');
		  for (var key in values) {
		    document.write('<input type="hidden" name="' + key + '" value="' + values[key] + '" />');
		  }
		  document.write('</form>');  
		  document.getElementById('post' + id).submit();
		}

</script>
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