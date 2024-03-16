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
<link rel="stylesheet" href="<c:url value='/resources/css/cart.css'/>">

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
	<h1>Your cart</h1>
	<div>
		<table>
			<thead>
				<tr>
					<th>Item Image</th>
					<th>Item Name</th>
					<th>Item Price</th>
					<th>Item Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${booksCart}" var="book">
					<tr>
						<td><img
							src="<c:url value='/resources/images/${book.bookGenre}/${book.image}'/>"
							class="item-photo"></td>
						<td>${book.bookName}</td>
						<td>Rs.${book.price}</td>
						<td><a href="/deleteItem/${book.bookId}"><button class = deletebutton>Delete</button></a></td>
					</tr>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="2" style="text-align: right;"></td>
					<td id="grandTotal">Rs.${totalcost}</td>
				</tr>
			</tfoot>
		</table>
		<div class="placeorder">
			<a href="/orderedsuccessfully"><button>Place Order</button></a>
		</div>
	</div>
</body>
</html>