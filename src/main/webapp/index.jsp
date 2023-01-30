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
<h2>mybatis 활용하여 로그인 구현</h2>
<hr>
	
	<c:if test="${user == null }">  <!-- user 애트리뷰트는 NewMember타입 객체 -->
	<a href="login.hrd">로그인</a>
	</c:if>
	<c:if test="${user != null }">
	${user.name } 님 환영합니다.<br>
	<a href="logout.hrd">로그아웃</a>
	</c:if>
<hr>
</body>
</html>