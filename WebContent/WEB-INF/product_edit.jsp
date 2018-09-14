<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Product</title>
</head>
<body>
	<h2>Edit Product</h2>
	<form action="${pageContext.request.contextPath}/User/Product/${product.id}/Edit">
		${message}
		<table>
			<tr>
				<td><label path="name">Name</label></td>
				<td><input type="text" name="name" required="required" value="${product.name}"/></td>
			</tr>
			<tr>
				<td><label path="description">Description</label></td>
				<td><input type="text" name="description" value="${product.description}"/></td>
			</tr>
			<tr>
				<td><label path="price">price</label></td>
				<td><input type="number" name="price" min="0.00" max="10000.00" step="0.01" value="${product.price}"/></td>
			</tr>
			<tr>
				<td><label path="quantity">quantity</label></td>
				<td><input type="number" name="quantity" min="0" value="${product.quantity}"/></td>
			</tr>
		</table>

		<input type="submit" value="Update" formmethod="post">
	</form>
	<a href="${pageContext.request.contextPath}/Home">Home</a>
	<a href="${pageContext.request.contextPath}/User">Account</a>
</body>
</html>