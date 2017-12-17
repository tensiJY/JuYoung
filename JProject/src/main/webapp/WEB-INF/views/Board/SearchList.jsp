<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
<!doctype html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Document</title>
	<style type="text/css">
	ul { list-style:none;}
	ul li {float:left; }
	</style>
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script type="text/javascript">
		$(function(){
			var search = '${BoardVO.search}';
			$("#search").val(search);
			
			var word = '${BoardVO.word}';
			$("#word").val(word);
			
			
			$("#sBtn").on('click', function(){
				var search = $("#search").val();
				
				var word = $("#word").val();
				
				word = $.trim(word);
				
				$(location).attr('href', '../Board/SearchList.park?search='+search+"&word="+word);
				
			});	
		});
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
		<td>글번호</td>
		<td>작성자</td>
		<td>제목</td>
		<td>작성일</td>
		<td>조회수</td>
	</tr>
	<c:if test="${not empty LIST}">
		<c:forEach var="data" items="${LIST}">
			<tr>
				<td>${data.bno}</td>
				<td>${data.bwriter}</td>
				<td><a href="../Board/SearchView.park?bno=${data.bno}&nowPage=${PINFO.nowPage}&search=${BoardVO.search}&word=${BoardVO.word}">${data.btitle}</a></td>
				<td>${data.bregdate}</td>
				<td>${data.bviewcnt}</td>
			</tr>
		</c:forEach>
	</c:if>
	<c:if test="${empty LIST}">
		<tr>
			<td colspan="5"> 찾으시는 정보가 없습니다.</td>
		</tr>
	</c:if>
</table>



<%-- 페이징 처리 --%>
<table border='1' align="center">
	<tr><td>
			<ul>
				<c:if test="${PINFO.startPage eq 1}">
					<li><a href="#">[이전]</a></li>
				</c:if>
				<c:if test="${PINFO.startPage ne 1}">
					<li><a href='../Board/SearchList.park?nowPage=${PINFO.startPage - 1}&search=${BoardVO.search}&word=${BoardVO.word}'>[이전]</a></li>
				</c:if> 
				<c:forEach var="page" begin="${PINFO.startPage}" end="${PINFO.endPage}">
					<li><a href="../Board/SearchList.park?nowPage=${page}&search=${BoardVO.search}&word=${BoardVO.word}">[${page}]</a></li>
				</c:forEach>
						
				<c:if test="${PINFO.endPage eq PINFO.totalPage}">
					<li><a href="#">[다음]</a></li>
				</c:if>
						
				<c:if test="${PINFO.endPage ne PINFO.totalPage}">
					<li><a href="../Board/SearchList.park?nowPage=${PINFO.endPage + 1}&search=${BoardVO.search}&word=${BoardVO.word}">[다음]</a></li>
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
