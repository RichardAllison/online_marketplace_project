<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Your Products</title>
</head>
<body>
	<h3 style="text-align: center;">All Products</h3>
	<a href=#>Add Product</a>
	<table style="width: 90%; margin-left:auto;margin-right:auto;">
		<tr>
			<th>Item</th>
			<th>Quantity</th>
			<th>Available</th>
			<th>Price</th>
		</tr>

		<c:forEach products="${productList}" var="product">
			<tr>
				<td><c:out value="${product.item.name}" /></td>
				<td><c:out value="${product.quantity}" /></td>
				<td><c:out value="${product.quantityavailable}" /></td>
				<td>£</td>
				<td><a href="#">Edit</a></td>
			</tr>
		</c:forEach>
		
	</table>
</body>
</html>