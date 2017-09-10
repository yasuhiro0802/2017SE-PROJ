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
					<form action="addQuesPro" class="fh5co-form animate-box" data-animate-effect="fadeIn" method="post">
						<h2>Add Question Selection</h2>
						<div class="form-group">
							<h3>Website</h3>
							<select name="subject"  autocomplete="off"> 
								<option value="2">tiku.com</option> 
								<option value="3">21cnjy.com</option> 
								<option value="4">yitiku.cn</option> 

							</select> 
						</div>
						<div class="form-group">
							<h3>Subject</h3>
							<select name="subject"  autocomplete="off"> 
								<option value="2">Chinese</option> 
								<option value="3">Maths</option> 
								<option value="4">English</option> 
								<option value="6">Physics</option> 
								<option value="7">Chemistry</option> 
								<option value="8">History</option> 
								<option value="9">Politics</option> 
								<option value="10">Geography</option> 
								<option value="11">Biology</option> 
							</select> 
						</div>
						<div class="form-group">
							<h3>Difficulty</h3>
							<select name="difficulty"  autocomplete="off"> 
								<option value="2">Normal</option> 
								<option value="3">Hard</option> 

							</select> 
						</div>
						<div class="form-group">
							<h3>Number</h3>
							<input type="text" class="form-control" name="number"  autocomplete="off">
						</div>
						
						<div class="form-group">
							<input type="submit" value="Sign In" class="btn btn-primary">
						</div>
					</form>

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