<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
<!doctype html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Document</title>
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script type="text/javascript">
		$(function(){
			$("#login").on('click', function(){
				$(location).attr('href', './User/LoginForm.park');
				
			})
			$("#join").on('click', function(){
				$(location).attr('href', './User/JoinForm.park');
			});
		})
		
	</script>
</head>
<body>

<a href="./Board/BoardList.park">게시판</a>
<c:if test="${empty sessionScope.USER}">
	<a href="#" id="login">로그인</a><br>
	<a href="#" id="join">회원가입</a>
</c:if>
<c:if test="${not empty sessionScope.USER}">
	<a href="./User/Logout.park">로그아웃</a><br>
	<a href="./Message/MessageList.park">메시지</a>
</c:if>
<br>
	<!-- <a href="./HwpEx.jsp">a</a> -->
	<a href="./Report/List.park">보고서</a>
</body>
</html>
