
<%@page import="org.hibernate.Session"%>
<%@page import="com.entities.*"%>
<%@page import="java.util.*"%>
<%@page import="com.helper.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Notes</title>
<%@include file="all_links.jsp"%>
</head>
<body>
	<%

	%>

		<%@include file="navbar.jsp"%>
		<br>
		<div class="container text-center">
		<h3 >Notes To Refer !</h3>
	   </div>
		<div class="row">
			<div class="col-12">
				<%
				try {
					List<Notes> list = new GetAllRecords().getRecords();
					for (Notes note : list) {
				
				%>
			
				<div class="card mt-3" style="color: white; background-color: black;">
					<div class="card-body  px-5" >
						<h5 class="card-title"><%= note.getTitle() %></h5>
						<!-- <h6 class="card-subtitle  text-muted">Card subtitle</h6> -->
						<p class="card-text"><%= note.getContent() %></p>
						<p class="card-text"><%= note.getAddedDate() %></p>
						<div class="container text-center">
						  <a href="History?nodeId=<%=note.getId() %>" class="btn btn-danger">Delete</a>
						 <a href="edit.jsp?nodeId=<%=note.getId() %>" class="btn btn-primary">update</a>
					   </div>
				</div>

				<%
				}

				} catch (Exception e) {
					response.sendRedirect("error.jsp");
				}
				%>
			</div>


		</div>



	</div>

</body>
</html>