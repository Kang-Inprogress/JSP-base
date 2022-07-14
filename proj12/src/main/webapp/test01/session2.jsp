<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("utf-8");
	// 내장되어 있어서 세션 객체를 얻을 필요가 없다
	String name = (String) session.getAttribute("name");
	String address = (String) session.getAttribute("address");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내장 객체 세션</title>
</head>
<body>
	名前: <%=name %><br>
	住所: <%=address %><br>
</body>
</html>