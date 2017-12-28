<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
<!doctype html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Document</title>
	<style type="text/css">
		.content1{width: 98%}
		.content2{width: 98%; height:40px;}
		.content3{width: 98%; height:50px;}
	</style>
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script type="text/javascript">
	/* var today = new Date('yyyy-MM-dd');
	console.log(today);
	$('#rdate').val(today);
	 */
		$(function(){
			$("#iBtn").on('click', function(){
				$("#abc").attr('method', 'post');
				$("#abc").attr('action', '../Report/ReportProc.park').submit();
			});
		})
	</script>
</head>
<body>
<form id="abc">
<table border="1" width="80%" align="center">
	<tr>
		<th><input type="text" id="rtitle" name="rtitle" value="일일 업무 보고서" readonly class="content1"></th>
	</tr>
</table>

<br>
<%-- 사원 정보 --%>

	<table border="1" width="80%" align="center">
		<tr>
			<th>성명</th>
			<td><input type="text" id="rname" name="rname"></td>
			<th>부서명</th>
			<td>
				
				<select id="rdname" name="rdname">
					<option value='정보전략팀'>정보전략팀</option>
					<option value='회계'>회계</option>
					<option value='인사'>인사</option>
				</select>
			</td>	
		</tr>
		<tr>
			<th>직급</th>
			<td>
				
			 	<select id="rdjob" name="rdjob">
					<option value='사원'>사원</option>
					<option value='주임'>주임</option>
					<option value='대리'>대리</option>
				</select> 
			</td>
			<th>작성일</th>
			<td>
				<input type="date" id="rdate" name="rdate" >
			</td>
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
			<td><input type="text" id="rtime1" name="rtime1" value="출근" class="content1"></td>
			<td><input type="text" id="rtimea" name="rtimea" class="content1"></td>
		</tr>
		<tr>
			<th>09:00-09:30</th>
			<td><input type="text" id="rtime2" name="rtime2" class="content1"></td>
			<td><input type="text" id="rtimeb" name="rtimeb" class="content1"></td>
		</tr>
		<tr>
			<th>09:30-12:00</th>
			<td><input type="text" id="rtime3" name="rtime3" class="content1"></td>
			<td><input type="text" id="rtimec" name="rtimec" class="content1"></td>
		</tr>
		<tr>
			<th>12:00-13:00</th>
			<td><input type="text" id="rtime4" name="rtime4" value="점심시간" class="content1"></td>
			<td><input type="text" id="rtimed" name="rtimed" class="content1"></td>
		</tr>
		<tr>
			<th>13:00-16:00</th>
			<td><input type="text" id="rtime5" name="rtime5" class="content1"></td>
			<td><input type="text" id="rtimee" name="rtimee" class="content1"></td>
		</tr>
		<tr>
			<th>16:00-18:00</th>
			<td><input type="text" id="rtime6" name="rtime6" class="content1"></td>
			<td><input type="text" id="rtimef" name="rtimef" class="content1"></td>
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
			<td><textarea id="reduc" name="reduc" class="content2"></textarea></td>
		</tr>
		<tr>
			<th>업무보고서<br>프로그램</th>
			<td><textarea id="rprog" name="rprog" class="content2"></textarea></td>
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
			<td><textarea id="rsumm" name="rsumm" class="content3"></textarea></td>
			<td><textarea id="rtrou" name="rtrou" class="content3"></textarea></td>
		</tr>
	</table>
	
	<table border="1" width="80%" align="center">
		<tr>
			<td>
				<input type="button" id="iBtn" name="iBtn" value="저장하기">
			</td>
		</tr>
	</table>
</form>
</body>
</html>
