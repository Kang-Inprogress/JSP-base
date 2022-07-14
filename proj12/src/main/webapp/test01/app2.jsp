<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String name = (String)session.getAttribute("name");
	String address = (String)application.getAttribute("address");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Binding된 정보 확인</title>
</head>
<body>
<h3>이름: <%=name %></h3>
<h3>住所: <%=address %></h3>
</body>
</html>