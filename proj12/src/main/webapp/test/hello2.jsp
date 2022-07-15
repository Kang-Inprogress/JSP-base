<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%! // 선언문(static)
	String name = "이순신";
%>
<% // Java 코드(지역 변수)
	String age = request.getParameter("age"); // GET 처럼 URL을 통해서 전달 받을 수 있다
	String addr = request.getParameter("addr");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Scriptlet</title>
</head>
<body>
	<h2>Hello, <%=name %>!</h2>
	<%	if(age != null && addr != null) { %>
		<h3><%=age %>세 군요!</h3>
		<h3><%=addr %>에 거주하시는 군요!</h3>
	<% } %>
	
	<form action="hello2.jsp" method="get">
	 	나이: <input type="text" name="age" />
	 	거주지: <input type="text" name="addr" />
	 	<input type="submit" value="submit"/>
	</form>
</body>
</html>