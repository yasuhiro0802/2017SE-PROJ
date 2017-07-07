<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.GameData"%>
<!DOCTYPE HTML>
<html>
<head>
<%
	String path = request.getContextPath();
	GameData gamedata = (GameData)session.getAttribute("gamedata");
	String username = (String)session.getAttribute("username");
	
	Integer single_winrate=0;
	if(gamedata.getSinglegame()!=0)
		single_winrate = (Integer)(gamedata.getSinglewin()*100/gamedata.getSinglegame());
	Integer rank_winrate=0;
	if(gamedata.getRankgame()!=0)
		rank_winrate=(Integer)(gamedata.getRankwin()*100/gamedata.getRankgame());
	Integer team_winrate=0;
	if(gamedata.getTeamgame()!=0)
		team_winrate=(Integer)(gamedata.getTeamwin()*100/gamedata.getTeamgame());
	
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
<div class="navbar navbar-fixed-bottom">
  <div class="navbar-inner">
    <div class="navbar-decor"></div>
    <div class="container"> 
      
      <!-- .btn-navbar is used as the toggle for collapsed navbar content --> 
      <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse"> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </a> 
      <!-- Be sure to leave the brand out there if you want it shown -->
      <div class="brand hidden-desktop">Rococo</div>
      
      <!-- Everything you want hidden at 940px or less, place within here -->
      <div class="nav-collapse collapse">
        <div class="nav">
          <ul>
            <li data-move="1">Home</li>
            <li data-move="3">开始游戏</li>
            <li data-move="4">游戏介绍</li>
            <li data-move="5">游戏商城</li>
            <li data-move="6">退出登录</li>
          </ul>
        </div>
      </div>
    </div>
  </div>
</div>
<div class="scroll-slide" id="slide1" data-move="1" data-stellar-background-ratio="0.5">
  <div class="slide3-separator"></div>
  <div class="logotype">
    <h1>Hello  <%=username %></h1>
  </div>

  <div id="myCarousel" class="carousel slide">
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>
    <div class="carousel-inner">
      <div class="item item1 active">
        <div class="carousel-caption">
          <a href="single_player" ><h4>单人模式</h4></a>
        </div>
      </div>
      <div class="item item2">
        <div class="carousel-caption">
          <h4>排位模式</h4>
        </div>
      </div>
      <div class="item item3">
        <div class="carousel-caption">
          <h4>组队模式</h4>
        </div>
      </div>
    </div>
    <a class="left carousel-control" href="#myCarousel" data-slide="prev"><i class="icon-chevron-left"></i></a> <a class="right carousel-control" href="#myCarousel" data-slide="next"><i class="icon-chevron-right"></i></a></div>
</div>

<!--End Slide 1-->


<!--Start slide4-->
<div class="scroll-slide" id="slide4" data-move="3" data-stellar-background-ratio="0.5">
  <div class="slide4-separator"></div>
  <div class="container">
    <div class="slidename">请选择游戏模式</div>
    <div class="row"> 
      <!-- Row Starts -->
      <div class="span12">
        <div id="filtering">
          <ul>
            <li><a href="single_player" >单人模式</a></li>
            <li><a href="#" >排位模式</a></li>
            <li><a href="#" >组队模式</a></li>
          </ul>
        </div>
      </div>
    </div>
   </div>
   </div>

  <img class="visible-desktop hidden-phone hidden-tablet" id="slide4-img1" src="<%=path%>/summerproject/images/slide4/1.png" data-stellar-ratio="1.4" data-stellar-vertical-offset="-102" alt=""> <img class="visible-desktop hidden-phone hidden-tablet" id="slide4-img2" src="<%=path%>/summerproject/images/slide4/2.png" data-stellar-ratio="1.5" data-stellar-vertical-offset="-53" alt=""> <img class="visible-desktop hidden-phone hidden-tablet" id="slide4-img3" src="<%=path%>/summerproject/images/slide4/3.png" data-stellar-ratio="2.5" data-stellar-vertical-offset="-200" alt=""> <img class="visible-desktop hidden-phone hidden-tablet" id="slide4-img4" src="<%=path%>/summerproject/images/slide4/1.png" data-stellar-ratio="2.3" data-stellar-vertical-offset="-200" alt=""> <img class="visible-desktop hidden-phone hidden-tablet" id="slide4-img5" src="<%=path%>/summerproject/images/slide4/2.png" data-stellar-ratio="1.7" data-stellar-vertical-offset="-200" alt=""> </div>

<!--End Slide 4--> 

<!--Start Slide 5-->

<div class="scroll-slide" id="slide5" data-move="4" data-stellar-background-ratio="0">
  <div class="slide1-separator"></div>
  <div class="slidename">游戏介绍</div>
  <div class="container">
    <div class="row">
      <div class="span12">
        <div class="dropcap">D</div>
        <p class="lead">olor sit amet, consectetur adipiscing elit. Maecenas sed dui lorem. Mauris sit amet neque ut ligula laoreet consequat. Donec non tortor urna. Sed ultricies nunc enim, et lobortis ipsum hendrerit vitae. Ut ullamcorper vel enim non faucibus. Praesent blandit cursus diam, id vehicula ligula euismod ut. Nam tellus velit, tincidunt non facilisis vehicula, placerat vitae urna. Vivamus quis eros quis urna facilisis imperdiet. Vivamus laoreet nulla malesuada nulla cursus facilisis. Etiam rutrum vitae justo at sodales. </p>
      </div>
      <div class="span3">
        <div class="photographer">
           <div class="photo-frame-1"><img src="<%=path%>/summerproject/images/character/1.png" alt="One" /></div>
          <h3>单人模式</h3>
          <p>在单人模式中，你将与电脑pk。</p>
          <div class="skill">难度</div>
          <div class="progress progress-danger progress-striped active">
            <div class="bar" data-percentage="40"></div>
          </div>
          <div class="skill">娱乐性</div>
          <div class="progress progress-danger progress-striped active">
            <div class="bar" data-percentage="20"></div>
          </div>
         
        </div>
      </div>
      <div class="span3">
        <div class="photographer">
           <div class="photo-frame-1"><img src="<%=path%>/summerproject/images/character/1.png" alt="Two" /></div>
          <h3>排位模式</h3>
          <p>在排位模式中，</p>
          <div class="skill">难度</div>
          <div class="progress progress-danger progress-striped active">
            <div class="bar" data-percentage="80"></div>
          </div>
          <div class="skill">娱乐性</div>
          <div class="progress progress-danger progress-striped active">
            <div class="bar" data-percentage="95"></div>
          </div>
          
        </div>
      </div>
      <div class="span3">
        <div class="photographer">
           <div class="photo-frame-1"><img src="<%=path%>/summerproject/images/character/1.png" alt="Three" /></div>
          <h3>组队模式</h3>
          <p>在组队模式中，</p>
          <div class="skill">难度</div>
          <div class="progress progress-danger progress-striped active">
            <div class="bar" data-percentage="70"></div>
          </div>
          <div class="skill">娱乐性</div>
          <div class="progress progress-danger progress-striped active">
            <div class="bar" data-percentage="50"></div>
          </div>
          
        </div>
      </div>

      <div class="span12">
        <div class="fancy-heading-big">
          <h3>Fun Facts</h3>
        </div>
        <div class="fun-facts">
          <div class="fun-fact">
            <div class="fun-fact-digit"><%=gamedata.getSinglegame() %></div>
            <div class="fun-fact-text">单人模式场次</div>
          </div>
          <div class="fun-fact">
            <div class="fun-fact-digit"><%=single_winrate %>%</div>
            <div class="fun-fact-text">单人模式胜率</div>
          </div>
          <div class="fun-fact">
            <div class="fun-fact-digit"><%=gamedata.getRankgame() %></div>
            <div class="fun-fact-text">排位模式场次</div>
          </div>
          <div class="fun-fact">
            <div class="fun-fact-digit"><%=rank_winrate %>%</div>
            <div class="fun-fact-text">排位模式胜率</div>
          </div>
          <div class="fun-fact">
            <div class="fun-fact-digit"><%=gamedata.getTeamgame() %></div>
            <div class="fun-fact-text">组队模式场次</div>
          </div>
          <div class="fun-fact">
            <div class="fun-fact-digit"><%=team_winrate %>%</div>
            <div class="fun-fact-text">组队模式胜率</div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
<!--End Slide 5--> 


<!--Start slide6-->
<div class="scroll-slide" id="slide6" data-move="5" data-stellar-background-ratio="0.5">
  <div class="slide4-separator"></div>
  <div class="container">
    <div class="row">
      <div class="slidename">游戏商城</div>
      
      <div class="span3">
        <div class="photographer">
           <div class="photo-frame-1"><img src="<%=path%>/summerproject/images/character/1.png" alt="One" /></div>
          <h3>角色3</h3>
          <p>在单人模式中，你能够使用角色3与电脑pk。</p>
        </div>
      </div>
      
      
      <div class="span3">
        <div class="photographer">
           <div class="photo-frame-1"><img src="<%=path%>/summerproject/images/character/1.png" alt="One" /></div>
          <h3>角色4</h3>
          <p>在单人模式中，你能够使用角色4与电脑pk。</p>
        </div>
      </div>
      
      <div class="span3">
        <div class="photographer">
           <div class="photo-frame-1"><img src="<%=path%>/summerproject/images/character/1.png" alt="One" /></div>
          <h3>角色5</h3>
          <p>在单人模式中，你能够使用角色5与电脑pk。</p>
        </div>
       </div>
      <div class="span12">
       <div class="fancy-heading-big">
          <h5><a href="shop" >进入游戏商城</a></h5>
       </div>
      </div>   
    </div>
  </div>
   </div>

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