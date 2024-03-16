<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="<c:url value='/resources/css/booknotfound.css'/>">
<title>Book not found</title>
</head>
<body>
	<div class="success-card">
		<div class="checkmark">
			<img src="<c:url value='/resources/images/exclamation.jpg'/>">
		</div>
		<h1 class="success-message">Something went wrong !</h1>
		<h4 class="success-message">The page you are looking for is temporary unavailable.</h4>
		<br>
		<br>
		<div id="continue">
			<a href="/" id="contBtn">Home</a>
		</div>
	</div>
</body>
</html>