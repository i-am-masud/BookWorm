<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Profile Bookworm</title>
<link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
<link rel="stylesheet"
	href="<c:url value='/resources/css/profile.css'/>">
</head>

<body>

	<header>
		<div id="navbar">
			<a href="/"> <i class="bx bx-book"></i> <span>BookWorm</span>
			</a>

			<div id="actionbtn">
				<c:if test="${userLoggedIn != null}">
					<a href="/">Home</a>
					<a href="/cart">Cart</a>
					<a href="/logout">Log Out</a>
				</c:if>
			</div>
		</div>
	</header>
	<main>

		<div class="container">
			<div class="main">
				<div class="row enclips">
					<div class="col-md-4-mt-1">
						<div class="cardtext-center sidebar">
							<div class="card-body">
								<img src="<c:url value='/resources/images/user.jpg'/>"
									class="rounded-circle" width="150">
								<div class="mt-3">
									<h3>${user.fullName }</h3>
									<br>
									<br>
									<hr>
									<a href="/cart">My Cart</a>
									<hr>
									<a href="/orders">My Orders</a> 
									<hr>
									<a href="/">Home</a>
									<hr>
									<a href="/logout">Logout</a>
								</div>
							</div>
						</div>
					</div>
					<div class="col-md-8-mt-1">
						<div class="card mb-3 content">
							<h1 class="m-3 pt-3">About</h1>
							<div class="card-body">
								<div class=" row">
									<div class="col-md-3">
										<h5>User Name</h5>
									</div>
									
									<div class="col-md-9-text-secondary">${user.username}</div>
								</div>
								<hr>
								<div class=" row">
									<div class="col-md-3">
										<h5>Full Name</h5>
									</div>
									<div class="col-md-9-text-secondary">${user.fullName}</div>
								</div>
								<hr>
								<div class="row">
									<div class="col-md-3">
										<h5>Email</h5>
									</div>
									<div class="col-md-9-text-secondary">${user.email}</div>
								</div>
								<hr>
								<div class="row">
									<div class="col-md-3">
										<h5>Phone</h5>
									</div>
									<div class="col-md-9-text-secondary">${user.phno}</div>
								</div>
								<hr>
								<div class="row">
									<div class="col-md-3">
										<h5>Address</h5>
									</div>
									<div class="col-md-9-text-secondary">${user.address}</div>
								</div>
								<hr>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</main>
</body>

</html>
