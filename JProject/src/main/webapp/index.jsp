<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
<!doctype html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Document</title>
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
<c:if test="${empty sessionScope.USER}"><a href="./User/LoginForm.park">로그인</a><br></c:if>
<c:if test="${not empty sessionScope.USER}"><a href="./User/Logout.park">로그아웃</a><br></c:if>
<a href="./Board/BoardList.park">게시판</a>
</body>
</html>
