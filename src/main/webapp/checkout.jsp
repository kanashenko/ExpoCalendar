<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="MyBundle" />
<!DOCTYPE html>
<html lang="${language}">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="main.css">
<title>Checkout</title>
</head>
<body>
<%@ include file="logout.jsp"%>
<br>
<%@ include file="goToMain.jsp"%>
<br>			
	<fmt:message key="checkout.title" var="order" /><h3>${order}</h3>
	<table>
		<tr>
			<td>
				<table border="1" class="floatedTable">
					<thead>
						<tr>
							<fmt:message key="main.table.name" var="Name" /><th>${Name}</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${choosenexhibs}" var="item">
							<tr>
								<td>${item.exhibitionName}<br></td>
							<tr>
						</c:forEach>
					</tbody>
				</table>
			</td>
			<td>
				<table border="1" class="floatedTable">
					<thead>
						<tr>
							<fmt:message key="main.table.tickets" var="Tickets"/><th>${Tickets}</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${choosenTickets}" var="value">
							<tr>
								<td>${value}<br></td>
							<tr>
						</c:forEach>
					</tbody>
				</table>
			</td>
			<td>
				<table border="1" class="floatedTable">
					<thead>
						<tr>
							<fmt:message key="main.table.price" var="Price" /><th>${Price}</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${prices}" var="value">
							<tr>
								<td>${value}<br></td>
							<tr>
						</c:forEach>
					</tbody>
				</table>
			</td>
		</tr>
	</table>
	<fmt:message key="checkout.total" var="total" /><h3>${total}</h3>
	<c:out value="${totalPrice}" />

	<form name="buyForm" method="post" action="Controller">
		<input type="hidden" name="command" value="buy" />
		<fmt:message key="checkout.button.submit" var="buttonValue" />
		<input type="submit" value="${buttonValue}">
	</form>
</body>
</html>