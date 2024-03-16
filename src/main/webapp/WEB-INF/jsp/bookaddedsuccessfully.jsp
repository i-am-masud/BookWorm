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
	href="<c:url value='/resources/css/bookaddedsuccessfully.css'/>">
<title>Registered successfully</title>
</head>
<body>
	<div class="success-card">
		<div class="checkmark">
			<img src="<c:url value='/resources/images/greentick.jpg'/>">
		</div>
		<h3 class="success-message">Book added successfully</h3>
		<div id="continue">
			<a href="/admindashboard" id="contBtn">Continue</a>
		</div>
	</div>
</body>
</html>