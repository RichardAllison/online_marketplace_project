<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Product</title>
</head>
<body>
	<h2>Add Product</h2>
	<form action="${pageContext.request.contextPath}/User/Products/Add">
		${message}
		<table>
			<tr>
				<td><label path="name">Name: </label></td>
				<td><input type="text" name="name" required="required" /></td>
			</tr>
			<tr>
				<td><label path="description">Description: </label></td>
				<td><input type="text" name="description" /></td>
			</tr>
			<tr>
				<td><label path="price">Price: </label></td>
				<td><input type="number" name="price" min="0.00" max="10000.00"
					step="0.01" /></td>
			</tr>
			<tr>
				<td><label>Category: </label></td>
				<td>
					<select name="category">
						<option selected disabled>-- Select a category --</option>
						<c:forEach items="${categories}" var="category">
							<option value="${category.id}">${category.name}</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td><label path="quantity">quantity</label></td>
				<td><input type="number" name="quantity" min="0" /></td>
			</tr>
		</table>

		<input type="submit" value="Add" formmethod="post">
	</form>
	<a href="${pageContext.request.contextPath}/Home">Home</a>
	<a href="${pageContext.request.contextPath}/User">Account</a>
</body>
</html>