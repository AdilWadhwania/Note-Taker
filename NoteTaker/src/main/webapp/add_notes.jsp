<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="all_links.jsp" %>
<title>Add Notes</title>
</head>
<body>

	<div class="container-fluid ">
     <%@include file="navbar.jsp" %>
    <br>
    <h2>Please add the Notes </h2>
    <br>
   
   <!--This is form to add the the notes  -->
		<form action="SaveNote" method="post">
			<div class="form-group" class="p-0 m-0">
				<label for="title">Note title</label> <input required type="text"
					name="title" class="form-control" id="title"
					aria-describedby="emailHelp" placeholder="Enter title">

			</div>
			<div class="form-group">
				<label for="content">Note Content</label>
				<textarea required id="content" name="content"
					placeholder="Enter your notes here" class="form-control"
					style="height: 300px;"></textarea>
			</div>

			<div class="container text-center">

				<button type="submit" class="btn btn-primary">Add</button>

			</div>


		</form>


	</div>

</body>
</html>