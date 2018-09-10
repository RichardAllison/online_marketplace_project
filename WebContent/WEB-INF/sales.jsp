<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<jsp:useBean id="date" class="java.util.Date" />
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Your Sales</title>
</head>
<body>
	<h3>All Sales</h3>
	<table
		style="width: 90%; height: auto; margin-left: auto; margin-right: auto">
		<thead>
			<tr>
				<th>Time</th>
				<th>Buyer</th>
				<th>Items</th>
				<th>Total Price</th>
			</tr>
		</thead>
		<tbody>

			<c:forEach items="${saleList}" var="sale">
				<tr>
					<td><fmt:formatDate value="${sale.time}" pattern="dd/MM/yyyy HH:mm:ss" /><!--<c:out value="${sale.time}" />--></td>
					<td><c:out value="${sale.buyer.username}" /></td>
					<td>
						<table
							style="width: 100%; height: auto; margin-left: auto; margin-right: auto">
							<thead>
								<tr>
									<th>Item</th>
									<th>Quantity</th>
									<th>Price</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${sale.saleItems}" var="saleItem">
									<tr>
										<td><c:out value="${saleItem.item.name}" /></td>
										<td><c:out value="${saleItem.quantity}" /></td>
										<td align="right"><c:out value="£${saleItem.price}" /></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</td>
					<td align="right"><c:out value="£${sale.price}" /></td>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>