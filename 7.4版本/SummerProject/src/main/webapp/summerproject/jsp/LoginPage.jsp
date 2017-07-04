<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<meta charset="utf-8">
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Login - Welocome to Knowledge Contest</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="Free HTML5 Template by FreeHTML5.co" />
	<meta name="keywords" content="free html5, free template, free bootstrap, html5, css3, mobile first, responsive" />
	
<%
	String path = request.getContextPath();
%>
  

  	<!-- Facebook and Twitter integration -->
	<meta property="og:title" content=""/>
	<meta property="og:image" content=""/>
	<meta property="og:url" content=""/>
	<meta property="og:site_name" content=""/>
	<meta property="og:description" content=""/>
	<meta name="twitter:title" content="" />
	<meta name="twitter:image" content="" />
	<meta name="twitter:url" content="" />
	<meta name="twitter:card" content="" />

	<!-- Place favicon.ico and apple-touch-icon.png in the root directory -->
	<link rel="shortcut icon" href="<%=path%>/summerproject/favicon.ico">

	<link href='https://fonts.googleapis.com/css?family=Open+Sans:400,700,300' rel='stylesheet' type='text/css'>
	
	<link rel="stylesheet" href="<%=path%>/summerproject/css/login/bootstrap.min.css">
	<link rel="stylesheet" href="<%=path%>/summerproject/css/login/animate.css">
	<link rel="stylesheet" href="<%=path%>/summerproject/css/login/style.css">


	<!-- Modernizr JS -->
	<script src="<%=path%>/summerproject/js/login/modernizr-2.6.2.min.js"></script>


	</head>
	
	
	<body>

		<div class="container">
			
           
			<div class="row">
				<div class="col-md-4 col-md-offset-4">
					

					<!-- Start Sign In Form -->
					<form action="homepage" class="fh5co-form animate-box" data-animate-effect="fadeIn" method="post">
						<h2>Sign In</h2>
						<div class="form-group">
							<label for="username" class="sr-only">Username</label>
							<input type="text" class="form-control" name="user.username" placeholder="Username" autocomplete="off">
							<s:fielderror cssStyle="color:red" fieldName="username"></s:fielderror>
						</div>
						<div class="form-group">
							<label for="password" class="sr-only">Password</label>
							<input type="password" class="form-control" name="user.password" placeholder="Password" autocomplete="off">
							<s:fielderror cssStyle="color:red" fieldName="password"></s:fielderror>
						</div>
						
						<div class="form-group">
							<p>Not registered? <a href="signuppage">Sign Up</a> | <a href="forgotpage">Forgot Password?</a></p>
						</div>
						<div class="form-group">
							<input type="submit" value="Sign In" class="btn btn-primary">
						</div>
					</form>
					<!-- END Sign In Form -->
					<!--<s:form action="login" class="fh5co-form animate-box" data-animate-effect="fadeIn" theme="simple">
						<div class="form-group">
							<label for="username" class="sr-only">Username</label>
							<s:textfield type="text" class="form-control" name="user.username" placeholder="Username" autocomplete="off"></s:textfield>
						</div>
						<div class="form-group">
							<label for="password" class="sr-only">Password</label>
							<s:password type="password" class="form-control" name="user.password" placeholder="Password" autocomplete="off"></s:password>
						</div>
						<input type="submit"/>
					</s:form>-->
				</div>
			</div>
			
		</div>
	
	<!-- jQuery -->
	<script src="<%=path%>/summerproject/js/login/jquery.min.js"></script>
	<!-- Bootstrap -->
	<script src="<%=path%>/summerproject/js/login/bootstrap.min.js"></script>
	<!-- Placeholder -->
	<script src="<%=path%>/summerproject/js/login/jquery.placeholder.min.js"></script>
	<!-- Waypoints -->
	<script src="<%=path%>/summerproject/js/login/jquery.waypoints.min.js"></script>
	<!-- Main JS -->
	<script src="<%=path%>/summerproject/js/login/main.js"></script>


	</body>
	
	



</html>