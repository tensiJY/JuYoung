<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
<!doctype html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Document</title>
	<!-- 합쳐지고 최소화된 최신 CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<!-- 부가적인 테마 -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
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
			
			$("#chb1").on('click', function(){
				
				if($("#chb1").prop("checked")){
					$("input[name=chb2]").prop('checked', true);
				}else{
					$("input[name=chb2]").prop('checked', false);
				}
				
			});
			
			
			$("#lBtn").on('click', function(){
				var len = $("input[name=chb2]:checked").length;
								
				if(len==0){
					alert('리스트를 체크하지 않았습니다');
					return;
				}else {
					$("input[name=chb2]:checked").each(function(){
						var v = $(this).val();
						var a = "<input type='hidden' id='chb2' name='chb2' value='"+v+"'>";
						$("#target").append(a);
					});
					
					var type = "<input type=hidden id=type name=type value=list>";
					
					$("#target").append(type);
					$("#lfrm").attr('method', 'post').attr('action', '../Report/ExcelDown.park').submit(); 
				};
					
			});//lBtn end
			
			
			
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
<table align="center" class='table'>
	<tr>
		<th><input type="checkbox" id="chb1" name="chb1" value="전체선택"></th>
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
		<td><input type="checkbox" id="chb2" name="chb2" value='${VO.rno}'></td>
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
<table align="center" class='table'>
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
<table  align="center" class='table'>
	<tr>
		<td><input type="button" id="wBtn" name="wBtn" value="업무보고서" class="btn btn-xs btn-primary"></td>
		<td><input type="button" id="lBtn" name="lBtn" value="리스트출력" class="btn btn-xs btn-primary"></td>
	</tr>
</table>
<br>  

<form id="lfrm" name="lfrm">
	<span class='target' id=target></span>
</form>
</body>
</html>
