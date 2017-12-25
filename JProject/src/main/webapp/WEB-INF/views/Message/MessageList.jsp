<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form"  uri="http://www.springframework.org/tags/form"%>

<!doctype html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Document</title>
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script type="text/javascript">
		$(function(){
			$(".meview").on('click', function(){
				var value = $(this).attr('data-1');
				console.log(value);
				var url = "../Message/MessageView.park?meno="+value;
				var name = "message"
				var style = "left=10, top=10, width=500, height=500";
				window.open(url, name, style);
			});
			
			$("#mBtn").on('click', function(){
				var frm = $(this).parents('form');
				frm.attr('method', 'post');
				frm.attr('action', '../Message/AddMessage.park').submit(); 
			})
		})
		
		var msg = '${MSG}';
		if(msg.length != 0){
			alert(msg);
		}
	</script>
</head>
<body>
<%--
	private int meno;
	private String meSender;
	private String meReceiver;
	private String meText;
	private Date meSendDate;
	private Date meReadDate;
	private String meIsShow;
 --%>
<form>
	<table border="1" align="center" width="600">
		<tr>
			<td>받는 사람</td> 
			<td colspan=2><input type="text" name="mereceiver" /></td>
		</tr>
		<tr>
			<td>내용</td>
			<td  colspan=2><textarea  name="metext"></textarea></td>
		</tr>
		<tr>
			<td colspan=3>
				<input type=button id="mBtn" name="mBtn">전송
			</td>
		</tr>
	</table>
</form>

<br><br>

<c:if test="${not empty MessageVO}">
	<table border="1" align="center" width="600">
		<tr>
			<th>번호</th>
			<th>보낸사람</th>
			<th>보낸내용</th>
			<th>보낸시간</th>
		</tr>
	<c:forEach var="vo" items="${MessageVO}" varStatus="status">
		<tr>
			<td>${status.count}</td>
			<td>${vo.mesender}</td>
			<td><a href="#" class='meview' data-1='${vo.meno}'>${vo.metext}</a>
			</td>
			<td>
				<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${vo.mesenddate}"/>
			</td>
		</tr>
	</c:forEach>
	</table>
</c:if>

<c:if test="${empty MessageVO}">
	<table border="1" align="center" width="600">
		<tr>
			<th>메세지가 없습니다</th>
		</tr>
	</table>	
</c:if>  
</body>
</html>