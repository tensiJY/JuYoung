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
			})// wBtn end
			
			$(".titleView").on('click', function(){
				var rno = $(this).attr('data-1');
				var nowPage = $("#nowPage").val();
				$(location).attr('href', '../Report/View.park?rno='+rno+"&nowPage="+nowPage);
				
			});// .titleView end
		})// $(document).ready(function(){}) end
		
		var MSG = '${MSG}';
		if(MSG.length != 0){
			alert(MSG);
		}
	</script>
</head>
<body>
<input type="hidden" id="nowPage" name="nowPage" value="${nowPage}">
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
		<td>${VO.rno}</td>
		<td>${VO.rname}</td>
		<td><a href="#" class='titleView' data-1='${VO.rno}'>${VO.rtitle}</a></td>
		<td>${VO.rdate}</td>
	</tr>
		</c:forEach>
	</c:if>
</table>
<br>

<%-- 페이징 --%>
<table border="1" width="80%" align="center">
	<tr>
		<td align="center">
			<%--	[이전] --%>
			<c:if test="${PINFO.startPage eq 1}">
				[이전]
			</c:if>
			<c:if test="${PINFO.startPage ne 1}">
				<a href="../Report/List.park?nowPage=${PINFO.startPage - 1}">[이전]</a>
			</c:if>
			<%--	[1][2][3] --%>
			<c:forEach var="page" begin="${PINFO.startPage}" end="${PINFO.endPage}">
				<a href="../Report/List.park?nowPage=${page}">[${page}]</a>
			</c:forEach>
			<%--	[다음] --%>
			<c:if test="${PINFO.endPage eq PINFO.totalPage}">
				[다음]
			</c:if>
			<c:if test="${PINFO.endPage ne PINFO.totalPage}">
				<a href="../Report/List.park?nowPage=${PINFO.endPage + 1}">[다음]</a>
			</c:if>
		</td>
	</tr>
</table>
<br>
<%-- 쓰기 --%>
<table border="1" width="80%" align="center">
	<tr>
		<td><input type="button" id="wBtn" name="wBtn" value="업무보고서"></td>
	</tr>
</table>
<br>  
</body>
</html>
