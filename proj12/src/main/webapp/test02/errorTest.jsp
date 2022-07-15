<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%!

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>error test</title>
</head>
<body>
	예외 발생시 처리 페이지로 넘어감<br>
	<!-- 같은 폴더에서의 404 에러에 대해서만 web.xml을 통해서 오류처리가 가능하다 -->
	<a href="errorro.jsp">404로 넘어가기</a><br>
	<button onClick="ae()">하지마!</button>
</body>
</html>