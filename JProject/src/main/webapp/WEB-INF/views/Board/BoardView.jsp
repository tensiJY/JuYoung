<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
	
<!doctype html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Document</title>
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script type="text/javascript">
		$(function(){
			$("#listBtn").on('click', function(){
				var nowPage = $("#nowPage").val();
				$(location).attr('href', '../Board/BoardList.do?nowPage='+nowPage);
			});
			
			$('#modifyBtn').on('click', function(){
				var bno = $("#bno").val();
				var nowPage = $("#nowPage").val();
				$(location).attr('href', '../Board/ModifyForm.do?bno='+bno+"&nowPage="+nowPage);
			});
			
			$("#removeBtn").on('click', function(){
				$("#frm").attr('method', 'post');
				$("#frm").attr('action', '../Board/Remove.do').submit();
			});
			
			$("#rfBtn").on('click', function(){
				$("#rFrm").slideToggle();
			});
		})
	</script>
</head>
<body>
<%-- 상세보기 --%>
	<form id="frm" name="frm">
		<input type="hidden" value='${BoardVO.bno}' id="bno" name="bno">
		<input type="hidden" value='${nowPage}' id="nowPage" name="nowPage"> 
		<table align=center border="1" width=700>
			<tr>
				<td colspan="4">${BoardVO.bno}</td>
			</tr>
			<tr>
				<td> 작성자 </td>
				<td> ${BoardVO.bwriter} </td>
				<td> 작성일</td>
				<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${BoardVO.bregdate}"/></td>
			</tr>
			<tr>
				<td> 제목 </td>
				<td>${BoardVO.btitle}</td>
				<td> 조회수 </td>
				<td> ${BoardVO.bviewcnt}</td>	
			</tr>
			<tr>
				<td>내용</td>
				<td colspan="3"><textarea rows="" cols="" readonly="readonly">${BoardVO.bcontent}</textarea></td>
			</tr>
			<tr>
				<td colspan=4>
					<input type="button" value="수정하기" id="modifyBtn" name="modifyBtn">
					<input type="button" value="삭제하기" id="removeBtn" name="removeBtn">
					<input type="button" value="목록" id="listBtn" name="listBtn">
					<input type="button" value="댓글쓰기폼" id="rfBtn" name="rfBtn">
				</td>
			</tr>
		</table>
	</form>

<%-- 댓글 쓰기 --%>	
	<form id="rFrm" name="rFrm" style="display: none">
		<input type="hidden" value='${BoardVO.bno}' id="bno" name="bno">
		<input type="hidden" value='${nowPage}' id="nowPage" name="nowPage">
		<table border="1" align="center" width="700">
			<tr>
				<td width="200">작성자</td>
				<td width="500">내용</td>
			</tr>
			<tr>
				<td><input type="text"></td>
				<td><textarea></textarea></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="button" id="rBtn" name="rBtn" value='답글쓰기'>
				</td>
			</tr>
		</table>
	</form>

<br>

<%-- 댓글 목록 --%>	
</body>
</html>