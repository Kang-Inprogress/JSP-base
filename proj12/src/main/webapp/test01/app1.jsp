<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	session.setAttribute("name", "홍길동");
	application.setAttribute("address", "서울시 강남구");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Binding Only</title>
</head>
<body>
	내장 객체 영역 확인<br>
	바인딩 처리<br>
	이름 -> 세션<br>
	주소 -> 어플리케이션(context)<br>
	<a href="app2.jsp">이동</a>
</body>
</html>