<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("utf-8");
	// 내장되어 있어서 세션 객체를 얻을 필요가 없다
	String name = (String) session.getAttribute("name");
	session.setAttribute("address", "서울시 강남구");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내장 객체 세션</title>
</head>
<body>
	넘겨 받은 값: <%=name %><br>
	<a href="session2.jsp">다음 페이지로</a>
</body>
</html>