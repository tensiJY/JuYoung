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
			var msg = '${MSG}';
			if(msg=='RSUCCESS1'){
				alert('댓글을 작성하였습니다');
			}else if(msg=='RSUCCESS2'){
				alert('정상적으로 수정하였습니다.');	
			}else if(msg=='RSUCCESS3'){
				alert('댓글을 삭제하였습니다.')
			}
			
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
			
			$("#rBtn").on('click', function(){
				var writer = $("#rreplyer").val();
				writer = $.trim(writer);
				
				if(writer.length == 0 || writer == null){
					return $("#rreplyer").focus();
				}
				
				var rreplytext = $("#rreplytext").val();
				rreplytext = $.trim(rreplytext);
				if(rreplytext.length == 0 ){
					return $("#rreplytext").focus();
				}
				
				$("#rFrm").attr('method', 'post');
			 	$("#rFrm").attr('action', '../Board/ReplyProc.do').submit(); 
			});
			
			//	수정하기
			$(".rmBtn").on('click', function(){
				/* var abcd= $(this).parents().find('.aa').attr(); */
				
				$(this).parents().next().children().slideToggle();			
				
			})
			
			$(".rmBtn2").on('click', function(){
				var frm = $(this).parents('form');
				frm.attr('method', 'post');
				frm.attr('action', '../Board/ReplyModify.do').submit();
				
			})
			
			// 삭제하기
			$(".rrBtn").on('click', function(){
				var rrno = $(this).attr('data-1');
				var bno = $("#bno").val();
				var nowPage = $("#nowPage").val();
				$(location).attr('href', '../Board/RemoveReply.do?rrno='+rrno+'&bno='+bno+'&nowPage='+nowPage);
			})
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
				<td><input type="text" id="rreplyer" name="rreplyer"></td>
				<td><textarea id="rreplytext" name="rreplytext" cols="60"></textarea></td>
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
<c:if test="${empty RLIST}">
	<table border=1 align="center" width="700">
		<tr>
			<td> 댓글이 없습니다. </td>
		</tr>
	</table>	
</c:if>
<c:if test="${not empty RLIST}">
	<c:forEach var="data" items="${RLIST}" varStatus="status">
		<table border=1 align="center" width="700">
			<tr>
				<td>${data.rreplyer}</td>
				<td><fmt:formatDate pattern="yyyy.MM.dd HH:mm"   value="${data.rrupdatedate}"/></td>
			</tr>
			<tr>
				<td colspan="3"><textarea cols="90" readonly class='aa'>${data.rreplytext}</textarea></td>
			</tr>
			<tr>
				<td colspan="3">
					<input type="button" class="rmBtn" name="rmBtn" value="수정하기"> 
					<input type="button" class="rrBtn" name="rrBtn" value="삭제하기" data-1='${data.rrno}'>
				</td>
			</tr>
		</table>
		
		<form>
			<input type="hidden" id="rrno" name="rrno" value="${data.rrno}">
			<input type="hidden" value='${BoardVO.bno}' id="bno" name="bno">
		<input type="hidden" value='${nowPage}' id="nowPage" name="nowPage">
			<table style="display: none; border-color: red;" align="center" border="1" width='700' >
				<tr>
					<td width="200">작성자</td>
					<td width="500">내용</td>
				</tr>
				<tr>
					<td><input type="text" id="rreplyer" name="rreplyer" value="${data.rreplyer}"readonly></td>
					<td><textarea id="rreplytext" name="rreplytext" cols="60">${data.rreplytext}</textarea></td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="button" class="rmBtn2" name="rmBtn2" value='수정하기'>
					</td>
				</tr>
			</table>
		</form>
	</c:forEach>
</c:if>

</body>
</html>
