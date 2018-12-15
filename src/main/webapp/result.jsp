<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="logout.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Result page</title>
</head>
<body>
	<h1>
		<c:out value="${message}" />
	</h1>
	<br>
	<%@ include file="goToMain.jsp"%>
</body>
</html>