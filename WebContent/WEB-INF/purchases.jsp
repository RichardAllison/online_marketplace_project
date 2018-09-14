<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Your Sales</title>
</head>
<body>
	<h3>All Sales</h3>
	<table>
		<tr>
			<th>Seller</th>
			<th>Item</th>
			<th>Quantity</th>
			<th>Price</th>
			<th>Total Price</th>
		</tr>

		<c:forEach items="${purchaseList}" var="purchase">
			<tr>
				<c:forEach items="purchase" var="purchaseItem">
					<td><c:out value="${purchaseItem.seller}"/></td>
					<td><c:out value="${purchaseItem.name}" /></td>
					<td><c:out value="${purchaseItem.quantity}" /></td>
					<td>£<c:out value="${purchaseItem.price}" /></td>
				</c:forEach>
				<td><c:out value="${purchase.price}"/>
			</tr>
		</c:forEach>
		
	</table>
</body>
</html>