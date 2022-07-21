<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>

<%
	request.setCharacterEncoding("utf-8");
	
	String id = (String) request.getParameter("id");
	String pwd = (String) request.getParameter("pwd");
	String name = (String) request.getParameter("name");
	String email = (String) request.getParameter("email");
%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css" >
	table {
		margin-left: auto;
		margin-right: auto;
		border: 1px;
	}
	th {
		width : 25%;
		bgcolor: lightblue;
	}
</style>
<meta charset="UTF-8">
<title>회원 정보 출력</title>
</head>
<body>
	<table>
		<tr>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
			<th>이메일</th>
		</tr>
		<tr>
			<th><%=id %></th>
			<th><%=pwd %></th>
			<th><%=name %></th>
			<th><%=email %></th>
		</tr>
		<tr>
			<th>${id }</th>
			<th>${pwd }</th>
			<th>${name }</th>
			<th>${email }</th>
		</tr>
	</table>
</body>
</html>