<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Marketplace Login</title>
</head>
<body>
	<nav>
		<a href="Home" style="text-align: center">Home</a>
	</nav>
	<h2 style="text-align: center;">Marketplace Login</h2>
	<form action="LoginSubmit">
		${message}
		<table style="margin-left:auto; margin-right:auto;">
			<tr>
				<td><label path="username">Username</label></td>
				<td><input type="text" name="username" required="required"></td>
			</tr>
			<tr>
				<td><label path="password">Password</label></td>
				<td><input type="password" name="password" required="required"></td>
			</tr>
			<tr>
			<td><input type="submit" value="Login" formmethod="post"></td>
			<td></td>
			</tr>
		</table>
		
	</form>
</body>
</html>
