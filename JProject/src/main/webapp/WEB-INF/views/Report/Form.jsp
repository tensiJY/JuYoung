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
	<!-- 합쳐지고 최소화된 최신 CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<!-- 부가적인 테마 -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
	<script type="text/javascript">
		$(function(){
			$('#mm').on('click', function () {
						
				
				$(this).attr('data-toggle', 'modal');
				$(this).attr('data-target','#myModal');
			});
			
			$("#saveBtn").on('click', function(){
				var mTitle = $('#aaa').val();
				var mSend = $('#bbb').val();
								
				
				if(mTitle == null || mTitle.trim().length == 0){
					$('#aaa').focus()
					return;
				}
				
				if(mSend == null || mSend.trim().length == 0){
					$('#bbb').focus();
					return;
				}
				var regExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
				
				var check = mSend.match(regExp);
				
				if( !check ){
					$('#bbb').focus();
					return;
				}
				
				$(this).attr("data-dismiss", "modal");
				
				var tag = "<input type=hidden id=mtitle name=mtitle value=" + mTitle + ">";
				tag += "<input type=hidden id=msend name=msend value=" + mSend + ">";
				
				var frm = $(this).parents('div').prev('form');
				
				frm.append(tag);
				frm.attr('method', 'post').attr('action', '../Report/sendMail.park').submit();
				
			});
			
			$("#iBtn").on('click', function(){
				var frm = $(this).parents('form');
				console.log(frm);
				frm.attr('method', 'post');
				frm.attr('action', '../Report/ReportProc.park').submit(); 
			});
			
			
			
		})<%-- function end --%>
	</script>
</head>
<body>
<form>
	<table align="center" class='table'>
		<tr>
			<th><input type="text" id="rtitle" name="rtitle" value="일일 업무 보고서" readonly class="content1"></th>
		</tr>
	</table>

<br>
<%-- 사원 정보 --%>

	<table class='table' >
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
	<table class='table' >
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
	<table class='table' >
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
	<table class='table' >
		<tr>
			<th>금일 업무결과 요약</th>
			<th>문제점/중요정보</th>
			
		</tr>
		<tr>
			<td><textarea id="rsumm" name="rsumm" class="content3"></textarea></td>
			<td><textarea id="rtrou" name="rtrou" class="content3"></textarea></td>
		</tr>
	</table>
	
	<table class='table' >
		<tr>
			<td>
				<input type="button" id="iBtn" name="iBtn" value="저장하기" class="btn btn-xs btn-primary">
				<input type="button" id="mm" name="mm" class="btn btn-xs btn-primary" data-toggle="" data-target="" value="멜로보내기">
			</td>
		</tr>
	</table>
	
	

</form>


<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Modal title</h4>
      </div>
      <div class="modal-body">
       	<div class="input-group">
  			<span class="input-group-addon" id="basic-addon1">@</span>
  				<input type="text" id=aaa name=aaa class="form-control" placeholder="제목" aria-describedby="basic-addon1">
		</div>
		 <div class="input-group">
  			<span class="input-group-addon" id="basic-addon1">@</span>
  			<input type="email" id=bbb name=bbb class="form-control" placeholder="메일" aria-describedby="basic-addon1">
		</div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <input  type="button" id="saveBtn" class="btn btn-primary" value="저장하기" data-dismiss="">
      </div>
    </div>
  </div>
</div>

</body>
</html>
