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
						
			
			$("#chBtn").on('click', function(){
				var check = "../Board/Msearch.do?";
				var bwriter = $("#bwriter").val();
				var btitle = $("#btitle").val();
				var bcontent = $("#bcontent").val();
								
				$('input[name=chb]:checked').each(function(index, data) { 
			       var temp = $(data).val();
					if(temp == 1){
			    	   if(!(bwriter== "" || bwriter.length==0 || bwriter ==null)){
			    		   check += 'bwriter='+ bwriter + '&';
			    	   }
			    	   		  
			       }else if(temp == 2){
			    	   if(!(btitle == "" || btitle.length==0 || btitle ==null)){
			    		   check += 'btitle='+ btitle  + '&';   
			    	   }
			       }else if(temp == 3 ){
			    	   if(!(bcontent == "" || bcontent.length==0 || bcontent ==null)){
			    		   check += 'bcontent='+ bcontent  + '&';
			    	   }	
			       }
			   });
				
				var sdate = $("#sdate").val();
				if( !(sdate == "" || sdate.length == 0 || sdate ==null)){
					sdate=sdate.replace(/-/g, "");
					check += 'sdate=' + sdate + '&'; 	
				}
				
				var edate = $("#edate").val();
				if( !(edate == "" || edate.length == 0 || edate ==null)){
					edate=edate.replace(/-/g, "");
					check += 'edate=' + edate + '&';	
				}
				
				var cnt = check.lastIndexOf("&");
				check = check.substring(0,cnt);
				
				$(location).attr('href', check);
				
 			});//
 			
 			$("#dateReset").on('click', function(){
 				$("#sdate").val('');
 			})
		})// document end
		
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
<table align="center" >
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

<%-- 선택 조건 --%>

	<table  align="center" border="1" width=700>
		<tr>
			<td> 
				 <input type="checkbox" id="chb" name="chb" value='1'> 작성자
				 <input type="text" id="bwriter" name="bwriter"> 
			</td>
			<td> 
				 <input type="checkbox" id="chb" name="chb" value='2'> 제목
				 <input type="text" id="btitle" name="btitle"> 
			</td>
			<td> 
				 <input type="checkbox" id="chb" name="chb" value='3'> 내용
				 <input type="text" id="bcontent" name="bcontent"> 
			</td>
			
		</tr>
		<tr>
			<td colspan=3>
				 <input type="date" id="sdate" name="sdate"> ~ <input type="date" id="edate" name="edate">
				 <input type="button" id="dateReset" name="dateReset" value="날짜초기화">
			</td>
		</tr>
		<tr>
			<td colspan=4><input type="button" id="chBtn" name="chBtn" value="검색"></td>
		</tr>
	
	</table>


<%-- 리스트 처리 --%>
<table align="center" border="1" width=700>
	<tr>
		<td>작성자</td>
		<td>제목</td>
		<td>작성일</td>
		<td>조회수/댓글수</td>
	</tr>
	<c:forEach var="BoardVO" items="${BLIST}">
		<tr>
			<td>${BoardVO.bwriter}</td>
			<td><a href="../Board/BoardView.do?bno=${BoardVO.bno}&nowPage=${PINFO.nowPage}">${BoardVO.btitle}</a></td>
			<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${BoardVO.bregdate}"/></td>
			<td>[${BoardVO.bviewcnt}] [${BoardVO.rcnt}]</td>
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
