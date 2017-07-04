    <%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
    <style type="text/css">
    body {background-image:url(book2.jpg);}
    tr
    {
        background-color:ghostwhite;
        color:black;
    }
    table
    {
        border:greenyellow;
        outline:#0000cc dashed;
    }
</style>
<title>Login</title>

<%
	String path = request.getContextPath();
%>
<link href="<%=path%>/bookstore/css/bootstrap.min.css" rel="stylesheet">
<link href="<%=path%>/bookstore/css/dataTables.bootstrap.css"
	rel="stylesheet">
<link href="<%=path%>/bookstore/css/dataTables.responsive.css"
	rel="stylesheet">
<link href="<%=path%>/bookstore/css/bookstore.css" rel="stylesheet">
<link href="<%=path%>/bookstore/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
</head>
<body>

<div class="jumbotron">
    <div class="container">
        <h1>Online Bookstore</h1>
        <p>Welcome to our online bookstore! Here you can browse books, create orders and do many other things you may want.
            Enjoy your shopping!</p>

    </div>
</div>

<div class="col-md-4 col-md-offset-4">
    <form class="form-horizontal"
          action="allLogin"
          method="POST">

        <div class="form-group">
            <label class="control-label">Username</label>
            <input type="text" name="user.username" class="form-control" placeholder="Username">
        </div>
        <div class="form-group">
            <label class="control-label">Password</label>
            <input type="password" name="user.password" class="form-control" placeholder="Password">
        </div>
        <div class="form-group">
            <a class="pull-right" style="padding-top: 8px;" href="<s:url action="register" />">
                Sign up an account</a>
            <table>
            </table>
            <button class="btn btn-primary">Sign in</button>
        </div>
    </form>
</div>
<h2></h2>
<h2></h2>
</body>
</html>