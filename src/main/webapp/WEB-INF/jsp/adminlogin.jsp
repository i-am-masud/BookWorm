<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Admin Login Bookworm</title>
<link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
<link rel="stylesheet"
	href="<c:url value='/resources/css/adminlogin.css'/>">
</head>
<body>

	<header>
		<div id="navbar">
			<a href="/"> <i class="bx bx-book"></i> <span>BookWorm</span>
			</a>

			<div id="actionbtn">
				<%-- <c:if test="${adminLoggedIn != null}"> --%>
					<%-- <a href="/cart">Cart</a>
				<a href="/profile/${userLoggedIn.username}">Profile</a>
				<a href="/logout">Log Out</a> --%>
					<a href="/home">Home</a>
				<%-- </c:if> --%>

				<%-- <c:if test="${userLoggedIn==null}">
				<a href="/login">Login</a>
				<a href="/adminlogin">Admin Login</a>
			</c:if> --%>

			</div>
		</div>
	</header>

	<main>
		<div class="wrapper">
			<form action="adminlogin" method="post">
				<h1>Admin Login</h1>
				<div class="input-box">
					<input type="text" placeholder="Admin Username" required
						name="adminusername">
				</div>
				<div class="input-box">
					<input type="password" placeholder="Admin Password" required
						name="adminpassword">
				</div>

				<!-- <div class="remember-forgot">
				<label><input type="checkbox"> Remember me </label> <a
					href="#"> Forgot Password?</a>
			</div> -->

				<p>${Error}</p>
				<div id=loginbutton>
					<button type="submit" class="btn">Login</button>
				</div>


				<!--			<div class="register-link">
				<p>
					Don't have an account? <a href="/registration">Register</a>
				</p>
			</div> -->
			</form>
		</div>
	</main>

</body>
</html>