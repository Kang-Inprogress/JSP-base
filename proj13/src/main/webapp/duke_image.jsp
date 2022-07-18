<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	request.setCharacterEncoding("utf-8");
	String name = request.getParameter("name");
	String imgName = request.getParameter("imgName");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공통 페이지</title>
</head>
<body>
	<h4>이미지가 포함된 페이지 시작 입니다</h4>
		<h3>이름은 <%= name %></h3>
		<img src="/proj13/images/<%= imgName%>"/>
	<h4>이미지가 포함된 페이지 끝 입니다</h4>
</body>
</html>