<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
<link rel="stylesheet"
	href="<c:url value='/resources/css/registration.css'/>">
<title>Register Bookworm</title>
</head>
<body>

	<header>
		<div id="navbar">
			<a href="/"> <i class="bx bx-book"></i> <span>BookWorm</span>
			</a>

			<div id="actionbtn">
				<a href="/">Home</a>

			</div>
		</div>
	</header>

	<main>
		<div class="wrapper">

			<form:form action="registration" method="post" modelAttribute="registeruser">
				<h1>Register Now</h1>

				<div class="input-box">
					<form:input type="text" placeholder="Full Name" path="fullName" />
					<form:errors path="fullName" />
				</div>
				<div class="input-box">
					<form:input type="text" placeholder="Mobile Number" path="phno" />
					<form:errors path="phno" />
				</div>
				<div class="input-box">
					<form:input type="email" placeholder="Email" path="email" />
					<form:errors path="email" />
					<p>${emailError}</p>
				</div>

				<div class="input-box" id="address">
					<form:input placeholder="Address" path="address" />
					<form:errors path="address" />
				</div>
				<div class="input-box">
					<form:input type="text" placeholder="Username" path="username" />
					<form:errors path="username" />
					<p>${usernameError}</p>

				</div>
				<div class="input-box">
					<form:input type="password" placeholder="Password" path="password" />
					<form:errors path="password" />
				</div>

				<button type="submit" class="btn">Register</button>

				<div class="register-link">
					<p>
						Already have an account! <a href="/login"> Login</a>
					</p>
				</div>
			</form:form>
		</div>
	</main>
</body>
</html>