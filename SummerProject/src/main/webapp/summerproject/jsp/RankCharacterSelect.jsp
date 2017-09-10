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
	List<Integer> have_items = (List<Integer>)request.getAttribute("have_items");
	List<Item> characteritems = (List<Item>)request.getAttribute("characteritems");

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

<body >



<!--Start slide6-->
<div class="scroll-slide" id="slide6" data-move="5" data-stellar-background-ratio="0.5">
  <div class="slide4-separator"></div>
  <div class="container">
    <div class="row">
      <div class="slidename">请选择角色</div>
      
      <div class="container">
    <div class="row">
      <div class="span12">
        <div class="dropcap">D</div>
        <p class="lead">请选择一个角色进行游戏 </p>
        
      </div>
     
      
      <%
      for(int x = 0;x < characteritems.size();x++){
    	  if(have_items.get(x)==1){
    	  %>
    	   <div class="span3">
          <div class="photographer">
             <div class="photo-frame-1">
             <img src="<%=path%>/summerproject/images/character/<%=(String)characteritems.get(x).getPath() %>" alt="Two" onclick="getInfo(<%=characteritems.get(x).getCharacterid()%>)"/></div>
          <h3><%=(String)characteritems.get(x).getDescription() %></h3>
          <div class="skill">速度</div>
            <div class="progress progress-danger progress-striped active">
              <div class="bar" data-percentage="<%=(int)(characteritems.get(x).getSpeed()/20)%>"></div>
            </div>
            <div class="skill">攻击力</div>
            <div class="progress progress-danger progress-striped active">
              <div class="bar" data-percentage="50"></div>
            </div>
        </div>
      </div>
    	  
    	  <%
    	  }
      }
      %>
      

      
    </div>
  </div>
       
       
      <div class="span12">
       <div class="fancy-heading-big">
          <h5><a href="returnhome" >返回主界面</a></h5>
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


<script>
	function getInfo(id){
		jsPost('set_rank_character',{'character' : id});
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