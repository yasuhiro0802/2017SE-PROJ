<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.GameData"%>
<%@ page import="model.Item"%>
<%@ page import="java.util.List"%>
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
	List<Item> characteritems = (List<Item>)request.getAttribute("characteritems");
	List<Item> objectitems = (List<Item>)request.getAttribute("objectitems");
	List<Integer> have_items = (List<Integer>)request.getAttribute("have_items");
	//Item item1 = (Item)request.getAttribute("item1");
	//Item item2 = (Item)request.getAttribute("item2");
	Integer coin = (Integer)gamedata.getCoin();
	
	Integer item5=5;
	Integer item6=6;
	Integer item7=7;
	
%>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Shop-Let's start your game</title>
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
      
      <!-- Everything you want hidden at 940px or less, place within here -->
      <div class="nav-collapse collapse">
        <div class="nav">
          <ul>
            <li data-move="1">角色购买</li>
            <li data-move="2">道具购买</li>
            <li data-move="3">返回主界面</li>
          </ul>
        </div>
      </div>
    </div>
  </div>
</div>


<!--Start slide1-->
<div class="scroll-slide" id="slide1" data-move="1" data-stellar-background-ratio="0.5">
<p>现有金币：<%=coin %></p>
  <div class="slide1-separator"></div>
  <div class="container">
    <div class="row">
      <div class="slidename">角色购买</div>

		<%
      for(int x = 1;x < characteritems.size();x++){
    	  
    	  %>
    	   <div class="span3">
        <div class="photographer">
           <div class="photo-frame-1"><img src="<%=path%>/summerproject/images/character/<%=(String)characteritems.get(x).getPath() %>" alt="One" /></div>
          <h3><%=(String)characteritems.get(x).getDescription() %></h3>
          <%
          if (have_items.get(x)==1){%>
        	<%="<h3>已拥有</h3>"%><%
          }
          %>
          <p>在所有模式中，你能够使用<%=(String)characteritems.get(x).getDescription() %>与电脑pk。</p>
          <p>适用于所有模式</p>
          <p>所需金币：<%=(Integer)characteritems.get(x).getCoin() %></p>
          <form action="buy" method="post">
          	<input name="item" value="<%=(Integer)characteritems.get(x).getId() %>" type="hidden"/>
          	<input type="submit" value="点击购买"/>
          </form>
        </div>
      </div>
    	  
    	  <%
      }
      %>
		

      
       
    </div>
  </div>
   </div>

<!--End Slide 1--> 


<!--Start slide2-->
<div class="scroll-slide" id="slide1" data-move="2" data-stellar-background-ratio="0.5">
  <div class="slide4-separator"></div>
  <div class="container">
    <div class="row">
      <div class="slidename">道具购买</div>
      
      <div class="span3">
        <div class="photographer">
           <div class="photo-frame-1"><img src="<%=path%>/summerproject/images/character/1.png" alt="One" /></div>
          <h3>血量加成10%</h3>
          <p>在所有模式中，你使用的角色血量会有10%加成</p>
          <p>适用于所有模式</p>
          <p>拥有数量：<%=gamedata.getItem5() %></p>
          <p>所需金币：1000</p>
          <form action="buy" method="post">
          	<input name="item" value="<%=item5%>" type="hidden"/>
          	<input type="submit" value="点击购买"/>
          </form>
        </div>
      </div>
      
      
      <div class="span3">
        <div class="photographer">
           <div class="photo-frame-1"><img src="<%=path%>/summerproject/images/character/1.png" alt="One" /></div>
          <h3>速度加成10%</h3>
          <p>在所有模式中，你使用的角色速度会有10%加成</p>
          <p>适用于所有模式</p>
          <p>拥有数量：<%=gamedata.getItem6() %></p>
          <p>所需金币：1000</p>
          <form action="buy" method="post">
          	<input name="item" value="<%=item6 %>" type="hidden"/>
          	<input type="submit" value="点击购买"/>
          </form>
        </div>
      </div>
      
      <div class="span3">
        <div class="photographer">
           <div class="photo-frame-1"><img src="<%=path%>/summerproject/images/character/1.png" alt="One" /></div>
          <h3>攻击加成10%</h3>
          <p>在所有模式中，你使用的角色攻击会有10%加成</p>
          <p>适用于所有模式</p>
          <p>拥有数量：<%=gamedata.getItem7() %></p>
          <p>所需金币：1000</p>
          <form action="buy" method="post">
          	<input name="item" value="<%=item7 %>" type="hidden"/>
          	<input type="submit" value="点击购买"/>
          </form>
        </div>
      </div>
      
      <br>
      <br>
      <br>
      <br>
      <div class="span12">
       <div class="fancy-heading-big">
          <h5><a href="returnhome" >返回主页面</a></h5>
       </div>
      </div>   
      <br>
      <br>
      <br>
      <br>
    </div>
  </div>
   </div>

<!--End Slide 2--> 


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