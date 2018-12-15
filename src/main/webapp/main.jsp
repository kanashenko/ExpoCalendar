<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="mytag" uri="WEB-INF/mytaglib.tld"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="language"
	value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}"
	scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="MyBundle" />
<%@ include file="logout.jsp"%>
<!DOCTYPE html>
<html lang="${language}">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="main.css">
<title>Exhibition Calendar</title>
</head>
<body>
	<h3>
		<mytag:hello visitorName="${user.getName()}" />
	</h3>
	<fmt:message key="main.title" var="title" />
	<h1 align="center">${title}</h1>

	<table>
		<tr>
			<td>
				<table border="1" class="floatedTable">
					<thead>
						<tr>
							<fmt:message key="main.table.date" var="Date" />
							<th>${Date}</th>
							<fmt:message key="main.table.name" var="Name" />
							<th>${Name}</th>
							<fmt:message key="main.table.price" var="Price" />
							<th>${Price}</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${exhibitions}" var="item">
							<tr>
								<td>${item.exhibStart.getMonth()}
									${item.exhibStart.getDayOfMonth()} -
									${item.exhibEnd.getMonth()} ${item.exhibEnd.getDayOfMonth()}
									${item.exhibEnd.getYear()}</td>
								<td>${item.exhibitionName}</td>
								<td>${item.price}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</td>
			<td>
				<table border="1" class="floatedTable">
					<thead>
						<tr>
							<fmt:message key="main.table.expohalls" var="Expo" />
							<th>${Expo}</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${expohalls}" var="item">
							<tr>
								<td><c:forEach items="${item}" var="i">			
						${i.expoHallName}
					</c:forEach></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</td>
			<td>
				<table border="1" class="floatedTable">
					<thead>
						<tr>
							<fmt:message key="main.table.tickets" var="Tickets" />
							<th>${Tickets}</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${maxTicketsList}" var="item">
							<tr>
								<td align="center">${item}<br></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</td>
			<td>
				<table border="1" >
					<tr>
						<td>
							<form name="CheckoutForm" method="post" action="Controller">
								<input type="hidden" name="command" value="checkout" />
								<table border="1" class="amountTable">
									<thead>
										<tr>
											<fmt:message key="main.table.ticketsBuy" var="TicketsBuy" />
											<th>${TicketsBuy}</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${exhibitions}" var="item"
											varStatus="theCount">
											<tr>
												<td align="center"><input type="number" value="0"
													style="text-align: center;" min="0"
													max="${maxTicketsArray[theCount.index]}" id="amount"
													name="${item.exhibitionName}" placeholder="0" step="1" /><br></td>
											<tr>
										</c:forEach>
										<tr>
											<td><fmt:message key="main.button.checkout"
													var="buttonValue" /> <input type="submit"
												value="${buttonValue}"></td>
										</tr>
									</tbody>
								</table>
							</form>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>

</body>
</html>