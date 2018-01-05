<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
<!doctype html>
<html>
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>Document</title>
	<!-- 합쳐지고 최소화된 최신 CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<!-- 부가적인 테마 -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
	<style type="text/css">
		
	</style>
	
	<script type="text/javascript">
		var msg = '${MSG}'; 
	
		$(function(){
			$("#iBtn").on('click', function(){
				
			});// iBtn end
			
			$("#pBtn").on('click', function(){
				var rno = $("#rno").val();
				var nowPage = $("#nowPage").val();
				$(location).attr('href', '../Report/ReportPrint.park?rno='+rno+"&nowPage="+nowPage);
			})
			
			$("#eBtn").on('click', function(){
				var rno = $('input[name="rno"]').val();
				$(location).attr('href', '../Report/ExcelDown.park?type=view&rno='+rno);
			});
		})// document function end	
	</script>
</head>
<body>


<table  width="80%" align="center" class="table">
	<tr>
		<th>${ReportVO.rtitle}</th>
	</tr>
</table>

<br>
<%-- 사원 정보 --%>

	<table  width="80%" align="center" class="table">
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
	<table  width="80%" align="center" class="table">
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
	<table  width="80%" align="center" class="table">
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
	<table width="80%" align="center" class="table">
		<tr>
			<th>금일 업무결과 요약</th>
			<th>문제점/중요정보</th>
			
		</tr>
		<tr>
			<td>${ReportVO.rsumm}</td>
			<td>${ReportVO.rtrou}</td>
		</tr>
	</table>
	
	<table  width="80%" align="center" class="table">
		<tr>
			<td>
				<input type="button" id="iBtn" name="iBtn" value="수정하기" class="btn btn-xs btn-primary">
				<!-- <input type="button" id="pBtn" name="pBtn" value="워드출력하기" class="btn btn-xs btn-primary"> -->
				<input type="button" id="eBtn" name="eBtn" value="엑셀다운로드" class="btn btn-xs btn-primary">
			</td>
		</tr>
	</table>
</body>

<input type="hidden" id="nowPage" name="nowPage" value="${nowPage}">
<input type="hidden" id="rno" name="rno" value="${ReportVO.rno }">
</html>
