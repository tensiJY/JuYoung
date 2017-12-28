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
			$("#wBtn").on('click', function(){
				$(location).attr('href', '../Report/Form.park');
			})
		})
	</script>
</head>
<body>

<%-- 검색 --%>

<%-- 리스트 --%>
<table border="1" width="80%" align="center">
	<tr>
		<th>일련번호</th>
		<th>사원이름</th>
		<th>보고서</th>
		<th>작성일</th>
	</tr>
	<%-- 없을 경우 --%>
	<c:if test="${empty ReportVO}">
	<tr>
		<td colspan="4"></td>
	</tr>
	<tr>
		<td colspan="4" align="center"> 보고서가 없습니다.</td>
	</tr>
	</c:if>
	<%-- 있을 경우 --%>
	<c:if test="${not empty ReportVO}">
		<c:forEach var="VO" items="${ReportVO}">
	<tr>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
	</tr>
		</c:forEach>
	</c:if>
</table>
<br>
<%-- 쓰기 --%>
<table border="1" width="80%" align="center">
	<tr>
		<td><input type="button" id="wBtn" name="wBtn" value="업무보고서"></td>
	</tr>
</table>
<br>
<%-- 페이징 --%>

  
</body>
</html>
