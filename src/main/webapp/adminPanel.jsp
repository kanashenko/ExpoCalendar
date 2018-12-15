<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="language"
	value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}"
	scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="MyBundle" />
<%@ include file = "logout.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin Panel</title>
</head>
<body>
	<fmt:message key="adminPanel.title" var="title" />
	<h3>${title}</h3>
	
	<form name="MenuAdminForm" method="post" action="Controller">
		<input type="hidden" name="command" value="menuAdmin" />
		<input type="radio" name="radios" value="Exhibitions" checked><fmt:message key="adminPanel.exhibitions" var="exhibitions" /> ${exhibitions}<br>
		<input type="radio" name="radios" value="ExpoHalls"><fmt:message key="adminPanel.expohalls" var="expohalls" />  ${expohalls}<br>
		<fmt:message key="adminPanel.button.submit" var="buttonValue" />
		<input type="submit" value="${buttonValue}">
	</form>
</body>
</html>