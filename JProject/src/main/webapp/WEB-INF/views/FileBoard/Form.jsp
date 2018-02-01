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
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>	
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script type="text/javascript">
		var cnt = 1;
		
		$(function(){
						
			$("#iBtn").on('click', function(){
				cnt++ ;
				
				if(cnt >5){
					cnt = 5;
					return;
				}
				
				var copy = ''; 
				copy +=	'<tr>';
				copy += '<td>첨부파일'
				copy += '<input type="button" class="btn btn-primary" onClick=deleteFile(this) value="삭제하기">'
				copy += '</td>';
				copy += '<td>';
				copy += '<input type="file" id="files" name="files" value="파일선택">' ;
				copy += '<input type="button" id="att" name="att" class="att" value="파일첨부" onClick=fileAttach(this)>'
				copy += '</td></tr>';
				
				$(this).parents('tr').after(copy);
				
			}); // iBtn end
			
			$("#wBtn").on('click', function(){
				checkForm();	
				
				/* var frm = $(this).parents('form');
				frm.attr('method', 'post').attr('action', '../FileBoard/Proc.park').submit(); */
			});
			
		});
		
		function deleteFile(a){
			 $(a).parents('tr').remove();
			 cnt--;
		}
		
		function checkForm(){
			var frm = document.frm;
			/* console.log(frm); */
		 	
			/* if( frm.writer.value ==null || frm.writer.value.length == 0 || frm.writer.value.trim().length==0 || frm.writer.value == '') {
				$('#writerMsg').text('asdf');
				return frm.writer.focus();
			}   */
			
			
			
			var files2 = $('input[name=files]');
			
			files2.each(function(i, v){
				var a = $(v).val();
				if(a == null || a.length == 0 ){
					
					
					return false;
				}
				console.log(a);
			});
			
			return true;
		}
		
		function fileAttach(a){
			var file = $(a).prev().val();
			if(file.length == 0) return alert('파일이 없스요');
			var len = file.lastIndexOf('\\');
			file = file.substring(len+1);
			console.log(file);
			
			$("#target").append('<div>'+file+'</div>');
		}
	</script>
</head>
<body>
	<!-- 	글쓰기 폼을 만든다. 
			폼의 내용이 파일 첨부가 있을 경우에는 parameter 타입으로 전송하면 안되고
			반드시 스트림 방식으로 처리해야 한다.
			
			방법		enctype="multipart/form-data"		선언을 한다.
	-->
<form enctype="multipart/form-data" name='frm' id="frm">
	<table class="table">
		<tr>
			<td>글쓴이</td>
			<td>
				<input type="text" id="writer" name="writer">
				<div id="writerMsg"></div>
			</td>
		</tr>
		<tr>
			<td>제목</td>
			<td><input type="text" id="title" name="title"></td>
		</tr>
		<tr>
			<td>내용</td>
			<td><textarea id="body" name="body"></textarea></td>
		</tr>
		<tr>
			<td>첨부파일</td>
			<td>
				<input type="file" id="files" name="files" value="파일선택">
				<input type="button" id="att" name="att" class="att" value="파일첨부" onClick='fileAttach(this)'>
				<input type="button" id="iBtn" name="iBtn" class="btn btn-primary" value="추가하기">
			</td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" id="pw" name="pw"></td>
		</tr>		
		<tr>
			<td colspan="2">
				<input type="button" id="wBtn" name="wBtn" value='전송하기'>
			</td>
		</tr>				
	</table>
</form>  

<div id="target">

</div>
</body>
</html>
