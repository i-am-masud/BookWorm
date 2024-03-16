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
	href="<c:url value='/resources/css/confirmdelete.css'/>">
<title>Confirm Delete</title>
</head>
<body>
	<div class="success-card">
		<div class="checkmark">
			<img src="<c:url value='/resources/images/exclamation.jpg'/>">
		</div>
		<h3 class="success-message">Are you sure ?</h3>
		<span id="delete">
			<a href="/deletebooks/${bookId}" id="deleteBtn">Delete</a>
		</span>
		<span id="return">
			<a href="/viewbooks" id="returnBtn">Return</a>
		</span>
	</div>
</body>
</html>