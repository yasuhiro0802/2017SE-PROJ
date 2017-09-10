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
	
%>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Introduction-Let's start your game</title>
<link href="<%=path%>/summerproject/css/GameMain/bootstrap.css" rel="stylesheet" type="text/css">
<link href="<%=path%>/summerproject/css/GameMain/bootstrap-responsive.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="<%=path%>/summerproject/css/GameMain/style.css">

<link href="<%=path%>/summerproject/css/GameMain/font-awesome.min.css" rel="stylesheet" type="text/css">
<link href="<%=path%>/summerproject/css/GameMain/prettyPhoto.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="<%=path%>/summerproject/js/GameMain/modernizr.custom.js"></script>

</head>

<body >


<!--Start Slide 5-->

<div class="scroll-slide" id="slide5" data-move="4" data-stellar-background-ratio="0">
  <div class="slide1-separator"></div>
  <div class="slidename">玩法介绍</div>
  <div class="container">
    <div class="row">
      <div class="span12">
        <div class="dropcap">作</div>
        <p class="lead">为一款趣味性答题对战游戏，玩家在答题的同时要进行以虚拟地图为背景的趣味性的游戏活动，
        场上存在玩家控制的角色和敌对势力控制的角色，双方均已通过攻击的方式来消灭对方为目标，在玩家题目回答正确之后，玩家
        可以根据角色发动技能，同时躲避敌人的技能以保证生存；若答题错误，则无法发动技能，所以，在锻炼自己的敏捷度的同时，
        提升自己答题正确率吧!</p>
      </div>
      <div class="span3">
        <div class="photographer">
           <!-- <div class="photo-frame-1"><img src="<%=path%>/summerproject/images/character/1.png" alt="One" /></div> -->
          <h3>单人模式</h3>
          	<p>在单人模式中，与玩家相对抗的敌对势力将由电脑AI控制</p>

         
        </div>
      </div>
      <div class="span3">
        <div class="photographer">
          <!-- <div class="photo-frame-1"><img src="<%=path%>/summerproject/images/character/1.png" alt="Two" /></div> -->
          <h3>排位模式</h3>
          <p>在排位模式中，与玩家相对抗的敌对势力将由其他玩家控制，玩家将与其他玩家进行对战</p>

          
        </div>
      </div>
      
      <div class="span3">
        <div class="photographer">
          <!-- <div class="photo-frame-1"><img src="<%=path%>/summerproject/images/character/1.png" alt="Two" /></div> -->
          <h3>题目</h3>
          <p>题目的种类包罗万象，涵盖了文科和理科以及特定的考试，玩家可以通过选择游戏难度来决定题目难度</p>

          
        </div>
      </div>
      
      <div class="span3">
        <div class="photographer">
          <!-- <div class="photo-frame-1"><img src="<%=path%>/summerproject/images/character/1.png" alt="Two" /></div> -->
          <h3>游戏角色</h3>
          <p>玩家一开始只拥有一个游戏角色，可以在商城中购买新的游戏角色，不同的角色拥有不同的技能，可以带给使用者不同的
          游戏体验</p>

          
        </div>
      </div>

      <div class="span3">
        <div class="photographer">
          <!-- <div class="photo-frame-1"><img src="<%=path%>/summerproject/images/character/1.png" alt="Two" /></div> -->
          <h3>道具</h3>
          <p>为了游戏趣味性而生，玩家可以在商城中购买道具，来提升自己角色的战斗能力</p>

          
        </div>
      </div>
      
      <br>
      <br>
      <br>
      <br>
      <br>
      <br>
      <div class="span12">
       <div class="fancy-heading-big">
          <h5><a href="returnhome" >返回主页面</a></h5>
       </div>
      </div>   
    </div>
  </div>
</div>
<!--End Slide 5--> 


<!--Start slide6-->


  <img class="visible-desktop hidden-phone hidden-tablet" id="slide4-img1" src="<%=path%>/summerproject/images/slide4/1.png" data-stellar-ratio="1.4" data-stellar-vertical-offset="-102" alt=""> <img class="visible-desktop hidden-phone hidden-tablet" id="slide4-img2" src="<%=path%>/summerproject/images/slide4/2.png" data-stellar-ratio="1.5" data-stellar-vertical-offset="-53" alt=""> <img class="visible-desktop hidden-phone hidden-tablet" id="slide4-img3" src="<%=path%>/summerproject/images/slide4/3.png" data-stellar-ratio="2.5" data-stellar-vertical-offset="-200" alt=""> <img class="visible-desktop hidden-phone hidden-tablet" id="slide4-img4" src="<%=path%>/summerproject/images/slide4/1.png" data-stellar-ratio="2.3" data-stellar-vertical-offset="-200" alt=""> <img class="visible-desktop hidden-phone hidden-tablet" id="slide4-img5" src="<%=path%>/summerproject/images/slide4/2.png" data-stellar-ratio="1.7" data-stellar-vertical-offset="-200" alt=""> </div>

<!--End Slide 6--> 

<!-- Footer -->
<div class="scroll-slide" id="slide4" data-move="6" data-stellar-background-ratio="0.5">
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
  </div>
</footer>
</div>

<!-- Footer Ends --> 

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