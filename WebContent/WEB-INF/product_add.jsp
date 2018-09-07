<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Product</title>
</head>
<body>
	<h2>Add Product</h2>
	<form action="ProductCreate">
		${message}
		<table>
			<tr>
				<td><label path="name">Name</label></td>
				<td><input type="text" name="name" required="required"/></td>
			</tr>
			<tr>
				<td><label path="description">Description</label></td>
				<td><input type="text" name="description"/></td>
			</tr>
			<tr>
				<td><label path="price">price</label></td>
				<td><input type="number" name="price" min="0.00" max="10000.00" step="0.01"/></td>
			</tr>
			<tr>
				<td><label path="quantity">quantity</label></td>
				<td><input type="number" name="price" min="0"/></td>
			</tr>
		</table>

		<input type="submit" value="Add" formmethod="post">
	</form>
	<a href="${pageContext.request.contextPath}/Home">Home</a>
	<a href="${pageContext.request.contextPath}/User/AccountHome">Account</a>
</body>
</html>