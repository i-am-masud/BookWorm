<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Book Details Form</title>
<link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css'
	rel='stylesheet'>
<link rel="stylesheet"
	href="<c:url value='/resources/css/addbooks.css'/>">


</head>
<body>

	<header>
		<div id="navbar">
			<a href="/"> <i class="bx bx-book"></i> <span>BookWorm</span>
			</a>

			<div id="actionbtn">
				<c:if test="${adminLoggedIn != null}">
					<a href="/admindashboard">Admin Dashboard</a>
				</c:if>
			</div>
		</div>
	</header>


	<main>

		<div class="wrapper">

			<form:form action="" method="post" modelAttribute="bookdetails">
				<h1>Add book details</h1>

				<div class="input-box">
					<form:input type="text" placeholder="Enter book name"
						path="bookName" />
					<form:errors path="bookName" />
				</div>
				<div class="input-box">
					<form:input type="text" placeholder="Enter author name"
						path="authorName" />
					<form:errors path="authorName" />
				</div>
				<div class="input-box">
					<form:input type="text" placeholder="Enter publisher name"
						path="publisherName" />
					<form:errors path="publisherName" />
				</div>
				<div class="input-box" id="address">
					<form:input placeholder="Enter price" path="price" />
					<form:errors path="price" />
				</div>
				<div class="input-box">
					<form:input type="text" placeholder="Enter book image" path="image" />
					<form:errors path="image" />
				</div>
				<div class="input-box">
					<form:input type="text" placeholder="Enter book description"
						path="bookDescription" />
					<form:errors path="bookDescription" />
				</div>
				<div class="input-box">
					<form:input type="text" placeholder="Enter book genre"
						path="bookGenre" />
					<form:errors path="bookGenre" />
				</div>


				<div id="addbookbutton">
					<a href="/addbooks"><button type="submit" class="btn">Add
							Book</button></a>
				</div>
		</div>
		</form:form>

	</main>
</body>
</html>