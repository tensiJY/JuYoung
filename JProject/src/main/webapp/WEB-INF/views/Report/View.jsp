<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
<!doctype html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Document</title>
	<style type="text/css">
		
	</style>
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script type="text/javascript">
		$(function(){
			$("#iBtn").on('click', function(){
				
			});// iBtn end
			
			$("#pBtn").on('click', function(){
				var rno = $("#rno").val();
				var nowPage = $("#nowPage").val();
				$(location).attr('href', '../Report/ReportPrint.park?rno='+rno+"&nowPage="+nowPage);
			})
		})// document function end	
	</script>
</head>
<body>


<table border="1" width="80%" align="center">
	<tr>
		<th>${ReportVO.rtitle}</th>
	</tr>
</table>

<br>
<%-- 사원 정보 --%>

	<table border="1" width="80%" align="center">
		<tr>
			<th>성명</th>
			<td>${ReportVO.rname}</td>
			<th>부서명</th>
			<td>${ReportVO.rdname}</td>	
		</tr>
		<tr>
			<th>직급</th>
			<td>${ReportVO.rdjob}</td>
			<th>작성일</th>
			<td>${ReportVO.rdate}</td>
		</tr>
	</table>

	<br>
	
	<%-- 금일 진행 사항 --%>
	<table border="1" width="80%" align="center">
		<tr>
			<th colspan=3>금일 진행 사항</th>
		</tr>
		<tr>
			<th width="15%">업무시간</th>
			<th width="75%">내용</th>
			<th width="10%">비고</th>
		</tr>
		<tr>
			<th>08:45</th>
			<td>${ReportVO.rtime1}</td>
			<td>${ReportVO.rtimea}</td>
		</tr>
		<tr>
			<th>09:00-09:30</th>
			<td>${ReportVO.rtime2}</td>
			<td>${ReportVO.rtimeb}</td>
		</tr>
		<tr>
			<th>09:30-12:00</th>
			<td>${ReportVO.rtime3}</td>
			<td>${ReportVO.rtimec}</td>
		</tr>
		<tr>
			<th>12:00-13:00</th>
			<td>${ReportVO.rtime4}</td>
			<td>${ReportVO.rtimed}</td>
		</tr>
		<tr>
			<th>13:00-16:00</th>
			<td>${ReportVO.rtime5}</td>
			<td>${ReportVO.rtimee}</td>
		</tr>
		<tr>
			<th>16:00-18:00</th>
			<td>${ReportVO.rtime6}</td>
			<td>${ReportVO.rtimef}</td>
		</tr>
	</table>
	
	<br>
	
	<%--차일 진행 예정사항 --%>
	<table border="1" width="80%" align="center">
		<tr>
			<th colspan=2>차일 진행예정사항</th>
		</tr>
		<tr>
			<th width="20%">교육 및 학습</th>
			<td>${ReportVO.reduc}</td>
		</tr>
		<tr>
			<th>업무보고서<br>프로그램</th>
			<td>${ReportVO.rprog}</td>
		</tr>
	</table>  
	
	<br>
	<%-- 금일 업무결과 요약 / 문제점 & 중요정보 --%>
	<table border="1" width="80%" align="center">
		<tr>
			<th>금일 업무결과 요약</th>
			<th>문제점/중요정보</th>
			
		</tr>
		<tr>
			<td>${ReportVO.rsumm}</td>
			<td>${ReportVO.rtrou}</td>
		</tr>
	</table>
	
	<table border="1" width="80%" align="center">
		<tr>
			<td>
				<input type="button" id="iBtn" name="iBtn" value="수정하기">
				<input type="button" id="pBtn" name="pBtn" value="출력하기">
			</td>
		</tr>
	</table>
</body>

<input type="hidden" id="nowPage" name="nowPage" value="${nowPage}">
<input type="hidden" id="rno" name="rno" value="${ReportVO.rno }">
</html>
