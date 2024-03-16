<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Admin Dashboard Bookworm</title>
<link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
<link rel="stylesheet"
	href="<c:url value='/resources/css/admindashboard.css'/>">
</head>
<body>
	<header>
		<div id="navbar">
			<a href="/"> <i class="bx bx-book"></i> <span>BookWorm</span>
			</a>

			<div id="actionbtn">
				

			</div>
		</div>
	</header>
	<main>
		<div class="wrapper">
			<h1>Admin Dashboard</h1>

			<p>Welcome ${adminusername } !</p>
			<div id="button">
				<a href="/addbooks">
				<button type="submit" class="btn" id="addbooksbutton">Add Books</button> 
				</a> 
				<br> 
				<a href="/viewbooks">
				<button type="submit" class="btn" id="deletebooksbutton">View Books</button> 
				</a>
			</div>
			<br>
			<div id="adminlogout">
				<a href="/adminlogout">
					<button type="submit" class="btn" id="adminlogoutbutton">Admin Log Out</button>
				</a>
			</div>

		</div>
	</main>

</body>
</html>