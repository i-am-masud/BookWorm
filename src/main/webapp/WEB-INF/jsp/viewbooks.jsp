<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="<c:url value='/resources/css/viewbooks.css'/>">
<link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
	

<title>View Books</title>
</head>
<body>


<header>
	<div id="navbar">
		<a href="/"> <i class="bx bx-book"></i> <span>BookWorm</span> </a>
		
		<div id="actionbtn">
			<a href="/admindashboard">Admin Dashboard</a>
		</div>
	</div>
</header>


<main>
	<table>
		<thead>
			<tr>
				<th>Book Id</th>
				<th>Book Image</th>
				<th>Book Name</th>
				<th>Author Name</th>
				<th>Publisher Name</th>
				<th>Genre</th>
				<th>Book Price</th>
				<th>Action</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${allBookDetails}" var="book">
				<tr>
					<td>${book.bookId}</td>
					<td>
						<div id="bookimage">
							<img src="/resources/images/${book.bookGenre}/${book.image}">
						</div>
					</td>
					<td>${book.bookName}</td>
					<td>${book.authorName}</td>
					<td>${book.publisherName}</td>
					<td>${book.bookGenre}</td>
					<td>Rs. ${book.price}0</td>
					<td><a href="/updatebooks/${book.bookId}">
						<button class="updatebutton">Update</button> 
						</a></td>
					<td><a href="/confirmdelete/${book.bookId}">
						<button class="deletebutton">Delete</button>
						</a></td>

				</tr>
			</c:forEach>

		</tbody>
	</table>
</main>
</body>
</html>
