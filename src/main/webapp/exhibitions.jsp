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
<title>Exhibitions</title>
</head>
<body>
	<fmt:message key="exhibitions.title" var="title" />
	<h3>${title}</h3>
	<h1>${message}</h1>
	<form name="AddExhibForm" method="post" action="Controller">
		<input type="hidden" name="command" value ="addExhib"/>
		<fmt:message key="exhibitions.label.name" var="name" />${name}<input type="text" name="name"><br>
		<fmt:message key="exhibitions.label.price" var="price" />${price}<input type="text" pattern="\d{1,4}" name="price"><br> 
		<fmt:message key="exhibitions.label.startDate" var="startDate" />${startDate} <input type="text" placeholder="yyyy-mm-dd" name="startDate"> <br> 
		<fmt:message key="exhibitions.label.endDate" var="endDate" />${endDate}<input type="text" placeholder="yyyy-mm-dd" name="endDate"> <br> 
		<fmt:message key="add.button.submit" var="buttonValue" />
		<input type="submit" value="${buttonValue}">
	</form>
	<br> 
	<fmt:message key="exhibitions.link" var="link" />
	<a href="adminPanel.jsp">${link}</a>
</body>
</html>