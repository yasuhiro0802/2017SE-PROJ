<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>select room</title>
</head>
<body>
<form action='socket' method='post'>
	<input name='roomId' value='0' type='hidden'/>
	<input type='submit' value='ROOM 0'/>
</form>
<form action='socket' method='post'>
	<input name='roomId' value='1' type='hidden'/>
	<input type='submit' value='ROOM 1'/>
</form>
<form action='socket' method='post'>
	<input name='roomId' value='2' type='hidden'/>
	<input type='submit' value='ROOM 2'/>
</form>
\

</body>
</html>