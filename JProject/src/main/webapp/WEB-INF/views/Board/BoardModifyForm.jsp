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
			$("#mBtn").on('click', function(){
				$("#mFrm").attr('method', 'post');
				$("#mFrm").attr('action', '../Board/ModifyProc.do').submit();
			})
		})
	</script>
</head>
<body>
	<form role='form' id='mFrm'>
		<input type="hidden" value="${nowPage}" id="nowPage" name="nowPage">
	<table border='1' align='center'>
		<tr>
			<td>작성자</td>
			<td><input type="text" id="bwriter" name="bwriter" value='${BoardVO.bwriter}' readOnly></td>
			<td>제목</td>
			<td><input type="text" id="btitle" name="btitle" value='${BoardVO.btitle}'></td>
		</tr>
		<tr>
			<td>내용</td>
			<td colspan=3> <textarea id="bcontent" name="bcontent">${BoardVO.bcontent}</textarea></td>
		</tr>
		<tr>
			<td colspan=4>
				<input type="button" id="mBtn" name="mBtn" value="수정하기">
			</td>
		</tr>
	</table>
</form>  
</body>
</html>