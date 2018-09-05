<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>All Products</h3>
	<table>
		<c:forEach products="${productList}" var="product">
			<tr>
				<td>Item:</td>
				<td><c:out value="${product.item.name}" /></td>
			</tr>
			<tr>
				<td>Quantity:</td>
				<td><c:out value="${product.quantity}" /></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>