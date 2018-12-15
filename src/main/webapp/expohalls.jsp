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
<title>Expo Halls</title>
</head>
<body>
	<fmt:message key="expohalls.title" var="title" />
	<h3>${title}</h3>
	<h1>${message}</h1>
	<form name="AddExpoForm" method="post" action="Controller">
		<input type="hidden" name="command" value ="addExpo"/>
		<fmt:message key="expohalls.label.names" var="names" />${names}<input type="text" placeholder="eg. A1, B2" name="names"><br>
		<fmt:message key="expohalls.label.exhibName" var="exhibName" />${exhibName}<input type="text" name=exhibName><br> 
		<fmt:message key="add.button.submit" var="buttonValue" />
		<input type="submit" value="${buttonValue}">
	</form>
	<br> 
	<fmt:message key="exhibitions.link" var="link" />
	<a href="adminPanel.jsp">${link}</a>
</body>
</html>