<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.GameData"%>
<!DOCTYPE HTML>
<html>
<head>
<%
	String path = request.getContextPath();
	GameData gamedata = (GameData)session.getAttribute("gamedata");
	
	if(gamedata == null){
		response.sendRedirect("login_again");
	}
	
	String result = (String)session.getAttribute("result");
	Integer correct = (Integer)session.getAttribute("correct");
	Integer wrong = (Integer)session.getAttribute("wrong");
	Integer coin = (Integer)session.getAttribute("coin");
	Integer rankpoint = (Integer)session.getAttribute("rankpoint");
	session.removeAttribute("coin");
	session.removeAttribute("correct");
	session.removeAttribute("wrong");
	session.removeAttribute("result");
	session.removeAttribute("rankpoint");
%>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>GameMain-Let's start your game</title>
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
  <div class="slidename">排位模式</div>
  <div class="container">
    <div class="row">
      
    
      <div class="span12">
        <div class="fancy-heading-big">
          <h3><%=result %></h3>
        </div>
        <div class="fun-facts">
          <div class="fun-fact">
            <div class="fun-fact-digit"><%=correct %></div>
            <div class="fun-fact-text">答对题目</div>
          </div>
          <div class="fun-fact">
            <div class="fun-fact-digit"><%=wrong %></div>
            <div class="fun-fact-text">答错题目</div>
          </div>
          <div class="fun-fact">
            <div class="fun-fact-digit">+<%=coin %></div>
            <div class="fun-fact-text">金币</div>
          </div>
          <div class="fun-fact">
            <div class="fun-fact-digit"><%if (rankpoint>=0){ %>+<%}%><%=rankpoint %></div>
            <div class="fun-fact-text">RankPoint</div>
          </div>
          <div class="fun-fact">
            <div class="fun-fact-digit"><%=((GameData)session.getAttribute("gamedata")).getRankpoint()%></div>
            <div class="fun-fact-text">当前RankPoint</div>
          </div>
        </div>
        <div class="fancy-heading-big">
          <h5><a href="returnhome" >返回主界面</a></h5>
        </div>
      </div>
    </div>
  </div>
</div>
<!--End Slide 5--> 



<!--Sripts--> 
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