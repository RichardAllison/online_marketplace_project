<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${item.name}</title>
</head>
<body>
<h2>${item.name}</h2>
<p>${item.description}</p>
<p>£${item.price}</p>
<p>Sold by ${item.seller.username}</p>
<form>
	<input type="submit" value="Add to basket"/>
</form>

</body>
</html>