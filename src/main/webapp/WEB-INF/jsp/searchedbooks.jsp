<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>


<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css'
	rel='stylesheet'>
<link rel="stylesheet"
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
<link rel="stylesheet" href="<c:url value='/resources/css/genre.css'/>">
<title>Searched results</title>
</head>

<body>
	<header>

		<div id="navbar">
			<a href="/"> <i class="bx bx-book"></i> <span>BookWorm</span>
			</a>

			<form action="searchbooks" method="get">
				<div id="searchdiv">
					<input type="text" placeholder="Search Books. . ." required
						name="searchbooks">
					<button type="submit">
						<i class="bx bx-search-alt"></i>
					</button>
				</div>
			</form>


			<div id="actionbtn">
				<c:if test="${userLoggedIn != null}">
					<a href="/cart">Cart</a>
					<a href="/profile">Profile</a>
					<a href="/logout">Log Out</a>
				</c:if>

				<c:if test="${userLoggedIn==null}">
					<a href="/login">Login</a>
					<a href="/adminlogin">Admin Login</a>
				</c:if>
			</div>
		</div>



		<div id="snavbar">
			<a href="/genre/Mystery">Mystery</a> 
			<a href="/genre/Sci-fiction">Sci-fiction</a>
			<a href="/genre/Biography">Biography</a> 
			<a href="/genre/Novel">Novel</a>
			<a href="/genre/Comics">Comics</a>
		</div>
	</header>
	<main>

		<br>
		<div id="bookgallery">

			<c:forEach items="${searchedBookName}" var="book">
				<div>
					<div class="bookimg">
						<a href="/details/${book.bookId}"> 
						<img src="<c:url value='/resources/images/${book.bookGenre}/${book.image}'/>">
						</a>
					</div>
					<h3>
						${book.bookName} <br> <i class="fa fa-inr"></i>
						${book.price}0
					</h3>
				</div>
			</c:forEach>
		</div>

		<c:if test="${bookNotFound}">
			<h1>Book not found !</h1>
		</c:if>
	</main>

</body>

</html>