<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.GameData"%>
<html>
	<head>
		<title>RankStart</title>
		<%
		String path = request.getContextPath();
		GameData gamedata = (GameData)session.getAttribute("gamedata");
		
		if(gamedata == null){
			response.sendRedirect("login_again");
		}%>
	</head>
	<body>
	<body onload="getStart()">
		
		<p>匹配成功，即将开始游戏</p>
		
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

	</body>
</html>
