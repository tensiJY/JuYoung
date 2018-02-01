<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>document</title>
	<!-- 합쳐지고 최소화된 최신 CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<!-- 부가적인 테마 -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
	<script type="text/javascript">
		$(function(){
			// 글쓰기 폼
			$('input[name=wBtn]').on('click', function(){
				$(location).attr('href', '../FileBoard/Form.park?nowPage=${MAP.nowPage}'); 
			});
			
		});
	</script>
</head>
<body>
<%-- 검색 --%>  

<%-- 리스트 --%>

<table class="table">

</table>
<%-- 페이징 --%>

<%-- 파일쓰기 --%>
<table class="table">
	<tbody>
		<tr>
			<td>
				<input type="button" id="wBtn" name="wBtn" value="파일폼" class="btn btn-primary">
			</td>
		</tr>
	</tbody>
</table>
</body>
</html>