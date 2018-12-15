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
<title>Guest register</title>
</head>
<body>
<fmt:message key="register.link.toLogin" var="backToLogin" />
	<a href="login.jsp">${backToLogin}</a>
<br>	
<fmt:message key="register.title" var="title" />
<h3>${title}</h3>
<h1>${message}</h1>
<form name="registerUserForm" action = "Controller" method = "post">
	<input type="hidden" name="command" value ="register"/>
	<label for="name"><fmt:message key="register.label.name" />:</label>
    <input type = "text" name = "name">
    <br>
	<label for="login"><fmt:message key="login.label.username" />:</label>
	<input type="text" name="login">
	<br>  
	<label for="password"><fmt:message key="login.label.password" />:</label>
	<input type="password" name="password">
	<br>
	<fmt:message key="register.button.submit" var="buttonValue" />
	<input type="submit" value="${buttonValue}">
</form>

</body>
</html>