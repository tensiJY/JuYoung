<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
	
<!doctype html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Document</title>
	<style type="text/css">
	#wBtn:HOVER {cursor: pointer;}
	ul { list-style:none;}
	ul li {float:left; }
	
	</style>
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script type="text/javascript">
	
		$(function(){
			$("#wBtn").on('click', function(){
				var nowPage = $('#nowPage').val();
				$(location).attr('href', '../Board/BoardWriteForm.do?nowPage='+nowPage);
			});
			
			$("#sBtn").on('click', function(){
				var search = $("#search").val();
				var nowPage = $("#nowPage").val();
				var word = $("#word").val();
				
				word = $.trim(word);
				
				$(location).attr('href', '../Board/SearchList.do?search='+search+"&word="+word+'&nowPage='+nowPage);
				
			});	
		})
		
		var msg = '${MSG}';
		if(msg=='SUCCESS1'){
			alert('글을 성공적으로 등록하셨습니다');
		}else if(msg == 'SUCCESS2'){
			alert('글을 삭제했습니다.');
		}else if(msg == 'SUCCESS3'){
			alert('글을 성공적으로 수정하였습니다');
		}
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

<%-- 리스트 처리 --%>
<table align="center" border="1">
	<tr>
		<td>작성자</td>
		<td>제목</td>
		<td>작성일</td>
		<td>조회수</td>
	</tr>
	<c:forEach var="BoardVO" items="${BLIST}">
		<tr>
			<td>${BoardVO.bwriter}</td>
			<td><a href="../Board/BoardView.do?bno=${BoardVO.bno}&nowPage=${PINFO.nowPage}">${BoardVO.btitle}</a></td>
			<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${BoardVO.bregdate}"/></td>
			<td>${BoardVO.bviewcnt}</td>
		</tr>
	</c:forEach>
</table>
<input type="hidden" value="${PINFO.nowPage}" id="nowPage" name="nowPage">

<%-- 페이징 처리 --%>
<table align="center">
	<tr><td>
	<ul>
		<c:if test="${PINFO.startPage eq 1}">
			<li><a href="#">[이전]</a></li>
		</c:if>
		<c:if test="${PINFO.startPage ne 1}">
			<li><a href='../Board/BoardList.do?nowPage=${PINFO.startPage - 1}'>[이전]</a></li>
		</c:if> 
		<c:forEach var="page" begin="${PINFO.startPage}" end="${PINFO.endPage}">
			<li><a href="../Board/BoardList.do?nowPage=${page}">[${page}]</a></li>
		</c:forEach>
				
		<c:if test="${PINFO.endPage eq PINFO.totalPage}">
			<li><a href="#">[다음]</a></li>
		</c:if>
				
		<c:if test="${PINFO.endPage ne PINFO.totalPage}">
			<li><a href="../Board/BoardList.do?nowPage=${PINFO.endPage + 1}">[다음]</a></li>
		</c:if>
	</ul>
	</td></tr>
</table>
<%-- 글쓰기 폼 --%>
<table align="center" border=1>
	<tr>
		<td><span id="wBtn">글쓰기폼</span></td>
	</tr>
</table>
</body>
</html>
