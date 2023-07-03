<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<header>
	<c:if test="${id ne null}">
		<h3><span>${id }님 접속중</span>&nbsp;&nbsp;<span><a href="logout">로그아웃</a></span></h3>
	</c:if>
	<c:if test="${id eq null}">
		<h3><span>gest님 접속중</span>&nbsp;&nbsp;<span><a href="login">로그인</a></span></h3>
	</c:if>
</header>
	<h1>Main page</h1>
	<hr>
</body>
</html>