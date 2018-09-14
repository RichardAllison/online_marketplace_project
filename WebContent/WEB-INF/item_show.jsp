<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
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
<p>${item.quantityAvailable} available</p>
<form>
	<input type="submit" value="Add to basket"/>
</form>

</body>
</html>