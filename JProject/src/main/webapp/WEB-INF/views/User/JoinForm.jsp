<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- <%@ taglib prefix="form"  uri="http://www.springframework.org/tags/form"%> --%>
	
<!doctype html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Document</title>
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script type="text/javascript">
		$(function(){
			$('input[name=jBtn]').on('click', function(){
				var form = $(this).parents('form');
				/* var mid = $("#mid").val();
				alert(mid); */
				form.attr('method', 'post');
				form.attr('action', '../User/JoinProc.park').submit();
			})
		})
	</script>
</head>
<body>
<%--
	private String mno;
	private String mid;
	private String mpw;
	private String mname;
	private int mpoint;
	private String msession;
	private Date msessionlimit;
 --%>
<form>
	<table border="1" witdh="600" align="center">
		<tr>
			<td>아이디</td>
			<td><input type="text" id="mid" name="mid"></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" id="mpw" name="mpw"></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><input type="text" id="mname" name="mname"></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="button" id="jBtn" name="jBtn" value="가입">
			</td>
		</tr>
	</table>
</form>

<!-- 
<form:form modelAttribute="uvo" id='jFrm'>
	<div>
	<form:label path="mid">id</form:label>
	<form:input path="mid"/> <form:errors path="mid"/> <br>
	</div>
	<div>
	<form:label path="mpw">pw</form:label>
	<form:password path="mpw"/> <form:errors path="mpw"/> <br>
	</div>
	<div>
	<form:label path="mname">name</form:label>
	<form:input path="mname"/> <form:errors path="mname"/> <br>
	</div>
	<input type="button" name="jBtn" value="가입하기">
</form:form>   -->
</body>
</html>