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
			var search = '${BoardVO.search}';
			$("#search").val(search);
			
			var word = '${BoardVO.word}';
			$("#word").val(word);
		})
	</script>
</head>
<body>
<%-- 검색 처리 --%>
<table align="center">
	<tr>
		<td>
			<select id="search">
				<option value="title">제목</option>
				<option value="content">내용</option>
				<option value="writer">작성자</option>
			</select>
		</td>
		<td>
			<input type="text" id="word" name="word">
			<input type="button" id="sBtn" name="sBtn" value="검색하기">
		</td>
	</tr>
</table>

	<form id="frm" name="frm">

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
