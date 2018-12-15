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
<title>Error</title>
</head>
<body>
	<fmt:message key="error.title" var="title" /><h3>${title}</h3>
	<hr />	
	
	<h3>
		<c:out value="${error}" />
	</h3>
	 	
	Request that failed: ${pageContext.errorData.requestURI} 
    <br>
    Status code: ${pageContext.errorData.statusCode}
    <br>
    Exception: ${pageContext.errorData.throwable}
	<br>
	<fmt:message key="error.return" var="link" />
	<a href="Controller">${link}</a>

</body>
</html>