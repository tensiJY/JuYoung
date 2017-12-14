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
		})
	</script>
</head>
<body>
	<form id="frm" name="frm">
		<input type="hidden" value='${BoardVO.bno}' id="bno" name="bno">
		<input type="hidden" value='${nowPage}' id="nowPage" name="nowPage"> 
		<table align=center border="1">
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
				</td>
			</tr>
		</table>
	</form>
</body>
</html>