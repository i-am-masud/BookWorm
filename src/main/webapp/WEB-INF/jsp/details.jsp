<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="details.css">
<link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">

<title>Book Details</title>
<link rel="stylesheet"
	href="<c:url value='/resources/css/details.css'/>">

<style>
</style>
</head>
<body>

	<header>
	<div id="navbar">
			<a href="/">
				<i class="bx bx-book"></i>
				<span>BookWorm</span>
			</a>
			
			<div id="actionbtn">
			<c:if test="${userLoggedIn != null}">
				<a href="/">Home</a>
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
	<section id="book_container">
		<div class="book_container">
			<div class="img_div">
				<div class="image">		
					<img src="<c:url value='/resources/images/${book.bookGenre}/${book.image}'/>" alt="Book Cover" class="book-image">
				</div>
			</div>
			<div class="detail">
				<h1 class="book-title">${book.bookName}</h1>
				<h3><i>${book.authorName}</i></h3>
				<br>
				<p class="book-price"><i class="fa fa-inr"></i> ${book.price}0</p>
				
				<p class="book-description">
					${book.bookDescription}
				</p>
				<a href="/addtocart/${book.bookId}"><button class="add-to-cart">Add to Cart</button></a>
			</div>
		</div>
	</section>
	</main>
</body>
</html>

