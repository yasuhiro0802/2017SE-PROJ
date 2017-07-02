<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%
	String path = request.getContextPath();
%>

<link href="<%=path%>/summerproject/css/bootstrap.min.css" rel="stylesheet">
<link href="<%=path%>/summerproject/css/dataTables.bootstrap.css"
	rel="stylesheet">
<link href="<%=path%>/summerproject/css/dataTables.responsive.css"
	rel="stylesheet">
<link href="<%=path%>/summerproject/css/bookstore.css" rel="stylesheet">
<link href="<%=path%>/summerproject/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">


    <style type="text/css">
    body {background-image:url(BBPlayer.jpg);}
    
    img{
    	margin-left:500px;
    }
    
    div{float:left}
    button{
        width:200px;
        height:60px;
        background-color:pink;
        border:1px silver;
        margin-left:200px;
    }
    
	h1{
		margin-left:100px;
        color:white;
	}
    
    

</style>

</head>
<body>
<br>
<br>
<br>
<br>
<br>

    <img  src="timg.gif" style="border:5px solid black" height="450" width="500"/> <br>

<form class="form-horizontal" action="Gameover"  method="POST">
	<i class="fa fa-home fa-fw"></i>
    <button class="btn btn-success"> login out<tton>
</form>
<h1 class="vintage">Let's Start The Game</h1>
<div>

    <button type="button" class="btn btn-primary btn-lg"  onclick="{location.href='/SummerProject/summerproject/game/index.html'}" type="redirect">Single Player</button> 
	 
	
</div>

<div>
<button type="button button2" class="btn btn-success btn-lg">Rank Mode</button>
</div>

<div>
<button type="button button3" class="btn btn-info btn-lg">Team Mode</button>
</div>

</body>
</html>