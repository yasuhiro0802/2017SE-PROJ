<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="action.RoomAction" %>
<%@ page import="model.Room" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
	Room room = (Room)session.getAttribute("roomInfo");
	Integer player=(Integer)session.getAttribute("player");
	if(room.getStatus().equals("start"))
		response.sendRedirect("roomtest?character="+String.valueOf(player)+"&mode=rank");
%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="refresh" content="3">
<title>Insert title here</title>
</head>
<body>
<p><%=room.getUserid_1() %>&<%=room.getUserid_2() %>&<%=room.getStatus() %></p>
<a href="quitRoom"><button>QUIT</button></a>
<%if(room.getStatus().equals("busy")){ %><a href="start"><button>START</button></a><%} %>

</body>
</html>