<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="beans.User"%>
<%@page import="java.util.ArrayList"%>
<%@ include file="fragments/header.jsp"%>
<title>User Management System</title>
</head>
<body>
	<%@ include file="fragments/navbar.jsp"%>
	<div class="container text-center row mx-auto">
		<h1>Welcome to User Management System</h1>
		<%
		List<User> listUsers = (List<User>) request.getAttribute("listUsers");
		%>
		<div class="col-md-6 mx-auto mt-3">
			<table class="table table-bordered border-primary">
				<thead>
					<tr>
						<th>ID</th>
						<th>FirstName</th>
						<th>FirstName</th>
						<th>Login</th>
						<th colspan="2">Actions</th>
					</tr>
				</thead>
				<tbody>
					<%
				for (User user : listUsers) {
				%>
					<tr>
						<td><c:out value="<%= user.getId() %>" /></td>
						<td><c:out value="<%= user.getLastName() %>" /></td>
						<td><c:out value="<%= user.getFirstName() %>" /></td>
						<td><c:out value="<%= user.getLogin() %>" /></td>
						<td><a href="/user/update?id=<c:out value="<%= user.getId() %>" />" class="btn btn-outline-info"> Update </a></td>
						<td><a href="/user/delete?id=<c:out value="<%= user.getId() %>" />" class="btn btn-danger"> Delete </a></td>
					</tr>
					<%
				}
				%>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>