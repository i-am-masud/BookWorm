<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Bookworm Cart</title>
<link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
<link rel="stylesheet" href="<c:url value='/resources/css/orders.css'/>">

</head>
<body>




	<div id="navbar">
		<a href="/"> <i class="bx bx-book"></i> <span>BookWorm</span>
		</a>

		<div id="actionbtn">
			<c:if test="${userLoggedIn != null}">
				<a href="/">Home</a>
			</c:if>

		</div>
	</div>
	<h1>Your orders</h1>
	<div>
		<table>
			<thead>
				<tr>
					<th>Order Id</th>
					<th>Order Items</th>
					<th>Order Date</th>
					<th>Total Price</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ordersList}" var="order">
					<tr>
						<td>${order.orderId}</td>
						<td><c:forEach items="${order.books}" var="book">
								<img
									src="<c:url value='/resources/images/${book.bookGenre}/${book.image}'/>"
									class="item-photo">
									
							<%-- <p>${book.bookName}</p> --%>
							</c:forEach></td>
						<td>${order.orderDate}</td>
						<td>${order.totalPrice}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>