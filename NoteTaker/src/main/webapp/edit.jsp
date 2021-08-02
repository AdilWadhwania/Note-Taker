<%@page import="com.notes.NotesManagement"%>
<%@page import="com.entities.Notes"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update</title>
<%@include file="all_links.jsp"%>
</head>
<body>
	<div class="container-fluid ">
		<%@include file="navbar.jsp"%>
		<br>
		<h2>Edit Your Notes here</h2>
	</div>
	<%
		int id=Integer.parseInt(request.getParameter("nodeId"));
	 Notes note=new Notes();
	try{
		 note= new NotesManagement().editNotes(id); 
	}catch(Exception e){
		System.out.print(e);
		response.sendRedirect("error.jsp");
	}
		
   %>
	
		<form action="UpdateNote" method="post" style="margin: 1%;">
		  <input name="id"  type="hidden" value="<%= note.getId()%>">
			<div class="form-group" >
				<label for="title">Note title</label> <input required type="text"
					name="title" class="form-control" id="title"
					aria-describedby="emailHelp" placeholder="Enter title" value="<%= note.getTitle()%>">

			</div>
			<div class="form-group">
				<label for="content">Note Content</label>
				<textarea required id="content" name="content"
					placeholder="Enter your notes here" class="form-control"
					style="height: 300px;"><%= note.getContent() %></textarea>
			</div>

			<div class="container text-center">

				<button type="submit" class="btn btn-success">Update Notes</button>

			</div>


		</form>


	
</body>
</html>