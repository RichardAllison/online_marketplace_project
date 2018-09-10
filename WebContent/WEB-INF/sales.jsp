<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Your Sales</title>
</head>
<body>
	<h3>All Sales</h3>
	<table>
		<tr>
			<th>Buyer</th>
			<th>Item</th>
			<th>Quantity</th>
			<th>Price</th>
			<th>Total Price</th>
		</tr>

		<c:forEach items="${saleList}" var="sale">
			<tr>
				<td><c:out value="${sale.buyer.username}"/></td>
				<c:forEach items="${sale.saleItems}" var="saleItem">
					<td><c:out value="${saleItem.item.name}" /></td>
					<td><c:out value="${saleItem.quantity}" /></td>
					<td>£<c:out value="${saleItem.price}" /></td>
				</c:forEach>
				<td><c:out value="${sale.price}"/>
			</tr>
		</c:forEach>
		
	</table>
</body>
</html>