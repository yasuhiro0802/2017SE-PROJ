<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
	<head>
		<title>0702</title>
		<%
			//response.sendRedirect("loginpage"); 
		%>
	</head>
	<body>
		<h2>Hello World!</h2>
		<a href="socket">socket test</a>
		<p>Single_player_test</p>
		<form action="set_choice" method="POST">
			<input type="text" name="character"/>
			<input type="submit" />
		</form>
	</body>
</html>
