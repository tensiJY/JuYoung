<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
<!doctype html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Document</title>
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script type="text/javascript">
		$(function(){
			$("#mBtn").on('click', function(){
				var frm = $(this).parents('form');
				frm.attr('method', 'post');
				frm.attr('action', '../User/LoginProc.park').submit();
			});
		})
	</script>
</head>
<body>
<form>
	<table>
		<tr>
			<td> id : </td>
			<td> <input type="text" id="mid" name="mid"> </td>
		</tr>
		<tr>
			<td> pw : </td>
			<td> <input type="password" id="mpw" name="mpw"> </td>
		</tr>
		<tr>
			<td colspan="2"><input type="button" id=mBtn name="mBtn"> </td>
		</tr>
	</table>
</form> 
</body>
</html>