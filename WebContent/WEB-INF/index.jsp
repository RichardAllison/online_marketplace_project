<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Marketplace Home</title>
</head>
<body>
	<h2>Marketplace</h2>
	<h3>Login</h3>
	<a href="Login">Log in</a>
	<a href="NewAccount">Create Account</a>
	<h3>Browse</h3>
			<c:forEach items="${itemList}" var="item">
			<div>
				<p><a href="Item/${item.id}"><c:out value="${item.name}" /></a></p>
				<p>£<c:out value="${item.price}" /></p>
			</div>
		</c:forEach>
</body>
</html>
