<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="language"
	value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}"
	scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="MyBundle" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login page</title>
</head>
<body>
	<form>
		<select id="language" name="language" onchange="submit()">		
			<option value="ru" ${language == 'ru' ? 'selected' : ''}>Русский</option>
			<option value="en" ${language == 'en' ? 'selected' : ''}>English</option>						
		</select>
	</form>
	<fmt:message key="login.title" var="title" />
	<h3>${title}</h3>
	<h3>
		<c:out value="${message}" />
	</h3>

	<form name="loginForm" method="post" action="Controller">
		<input type="hidden" name="command" value="login" /> 
		<label for="login"><fmt:message key="login.label.username" />:</label>
		<input type="text" name="login">
		<br>  
		<label for="password"><fmt:message key="login.label.password" />:</label>
		<input type="password" name="password">
		<br>
		<fmt:message key="login.button.submit" var="buttonValue" />
		<input type="submit" value="${buttonValue}">
	</form>
	<br>
	<fmt:message key="login.register.visitor" var="regUser" />
	<a href="register.jsp">${regUser}</a>
	<br>
	<fmt:message key="login.register.admin" var="regAdmin" />
	<a href="adminRegister.jsp">${regAdmin}</a>
</body>
</html>