<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Create new account</h2>
	<form action="CreateAccount">
		<div>
			<label path="email">Email Address</label> <input type="email"
				name="email" required="required">
		</div>
		<div>
			<label path="username">User name</label> <input type="text"
				name="username" required="required">
		</div>
		<div>
			<label path="password">Password</label> <input type="password"
				name="password" required="required">
		</div>
		<input type="submit" value="Create" formmethod="post">
	</form>

</body>
</html>