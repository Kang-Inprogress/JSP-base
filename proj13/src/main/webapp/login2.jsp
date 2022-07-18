<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 결과 창</title>
</head>
<body>
<%
	String msg = request.getParameter("msg");
	if(msg != null) {
%>
		<h2><%=msg %></h2>
<%
	}
%>
	<form method="post" action="result2.jsp">
		아이디: <input type="text" name="user_id" /><br>
		비밀번호: <input type="password" name="user_name" /><br>
		<input type="submit" value="submit" />
		<input type="reset" value="reset" />
	</form>
</body>
</html>