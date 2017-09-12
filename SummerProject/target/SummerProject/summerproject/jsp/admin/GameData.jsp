<%@ page import="java.util.ArrayList"%>
<%@ page import="model.GameData"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<title>Admin Page</title>

<%
	String path = request.getContextPath();
%>
<link href="<%=path%>/summerproject/css/admin/bootstrap.min.css" rel="stylesheet">
<link href="<%=path%>/summerproject/css/admin/dataTables.bootstrap.css"
	rel="stylesheet">
<link href="<%=path%>/summerproject/css/admin/dataTables.responsive.css"
	rel="stylesheet">
<link href="<%=path%>/summerproject/css/admin/bookstore.css" rel="stylesheet">
<link href="<%=path%>/summerproject/css/admin/font-awesome.min.css"
	rel="stylesheet" type="text/css">
</head>

<body>
	<%
		ArrayList<GameData> userList = new ArrayList<GameData>();
			if (request.getAttribute("datas") != null) {
		userList = (ArrayList<GameData>) request.getAttribute("datas");
			}
	%>
	<div id="wrapper">
		<!-- Navigation -->
		<nav class="navbar navbar-default navbar-static-top" role="navigation"
			style="margin-bottom: 0">

		<div class="navbar-header">
			<a class="navbar-brand" href="#">Admin Page</a>
		</div>

		<div class="navbar-default sidebar" role="navigation">
			<div class="sidebar-nav navbar-collapse">
				<ul class="nav" id="side-menu">
					<li><a href="allUserPro"><i
							class="fa fa-user fa-fw"></i>Manage  Users</a></li>
					<li><a href="allDataPro"><i class="fa fa-book fa-fw"></i>
							Manage GameData</a></li>
					<li><a href="allTaskPro"><i class="fa fa-reorder fa-fw"></i>
							Manage Questions</a></li>
					<li><a href="allItemPro"><i class="fa fa-table fa-fw"></i> 
							Manage Items</a></li>
					<!--<li><a href="allItemsPro"><i class="fa fa-table fa-fw"></i> 
							Question Pool</a></li>  -->
							
				</ul>
			</div>
			<!-- /.sidebar-collapse -->
		</div>
		<!-- /.navbar-static-side --> </nav>

		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">Gamedatas</h1>
				</div>
			</div>
			<!-- /.row -->
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">

						<!-- /.panel-heading -->
						<div class="panel-body">
							<div class="dataTable_wrapper">
								<table class="table table-striped table-bordered table-hover"
									id="dataTables">
									<thead>
										<tr>
										    <th>ID</th>
											<th>rankpoint</th>
											<th>coin</th>
											<th>singlegame</th>
											<th>singlewin</th>
											<th>rankgame</th>
											<th>rankwin</th>
											<th>teamgame</th>
											<th>teamwin</th>
											<th>item1</th>
											<th>item2</th>
											<th>item3</th>
											<th>item4</th>
											<th>item5</th>
											<th>item6</th>
											<th>item7</th>
										</tr>
									</thead>
									<tbody>
										<%
											for (int i = 0; i < userList.size(); i++) {
												GameData user = userList.get(i);
										%>
										<tr>
										    <td><%=user.getId()%></td>
											<td><%=user.getRankpoint()%></td>
											<td><%=user.getCoin()%></td>
											<td><%=user.getSinglegame()%></td>
											<td><%=user.getSinglewin()%></td>
											<td><%=user.getRankgame()%></td>
											<td><%=user.getRankwin()%></td>
											<td><%=user.getTeamgame()%></td>
											<td><%=user.getTeamwin()%></td>
											<td><%=user.getItem1()%></td>
											<td><%=user.getItem2()%></td>
											<td><%=user.getItem3()%></td>
											<td><%=user.getItem4()%></td>
											<td><%=user.getItem5()%></td>
											<td><%=user.getItem6()%></td>
											<td><%=user.getItem7()%></td>
										</tr>
										<%
											}
										%>
									</tbody>
								</table>
							</div>
						</div>
						<!-- /.panel-body -->
					</div>
					<!-- /.panel -->
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
		</div>
		<!-- /#page-wrapper -->
	</div>
	<!-- /#wrapper -->

	<div class="modal fade" id="modal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title" id="modalTitle"></h4>
				</div>
				<div class="modal-body">
					<div class="row">
						<div class="col-lg-12">
							<form role="form">
								<div class="form-group">
									<label>Username</label> <input class="form-control" name="username">
								</div>
								<div class="form-group">
									<label>Email</label> <input class="form-control" name="email">
								</div>
								<div class="form-group">
									<label>Password</label> <input class="form-control" name="password">
								</div>
								<div class="form-group">
									<label>Role</label> <input class="form-control" name="role">
								</div>
							</form>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					<button type="button" class="btn btn-primary" id="save">Save</button>
				</div>
			</div>
		</div>
	</div>
	
<div class="modal fade" id="eg2" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title" id="checkitout"></h4>
				</div>
				<div class="modal-body">
					<div class="row">
						<div class="col-lg-12">
							<form role="form">
								<div class="form-group">
									<h2 style="color:#00F">option</h2> <h3  id="showTitle"></h3>
								</div>
								<div class="form-group">
									<h2 style="color:#00F">option</h2> <h3  id="showAuthor"></h3>
								</div>
								<div class="form-group">
									<h2 style="color:#00F">option</h2> <h3  id="showPic"></h3>
								</div>
								<div class="form-group">
									<h2 style="color:#00F">option</h2> <h3  id="showD"></h3>
								</div>
								


							</form>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>
	<script src="<%=path%>/summerproject/js/admin/jquery.min.js"></script>
	<script src="<%=path%>/summerproject/js/admin/bootstrap.min.js"></script>
	<script src="<%=path%>/summerproject/js/admin/jquery.dataTables.min.js"></script>
	<script src="<%=path%>/summerproject/js/admin/dataTables.bootstrap.min.js"></script>
	<script src="<%=path%>/summerproject/js/admin/bookstore.js"></script>
	<script src="<%=path%>/summerproject/js/admin/bootbox.min.js"></script>

	<script src="<%=path%>/summerproject/js/admin/gamedata.js"></script>

	<script>
		$(document).ready(function() {
			$('#dataTables').DataTable({
				responsive : true
			});
		});
	</script>

</body>

</html>
