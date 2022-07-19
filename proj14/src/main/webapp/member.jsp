<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	String email = request.getParameter("email");
	String name = request.getParameter("name");
%>
<jsp:useBean id="member" class="sec01.ex01.MemberBean"/>
<jsp:setProperty name="member" property="*" /><!-- value와 scope는 생략되었다 -->
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
	table {
		width: 800px;
		margin-left: auto;
		margin-right: auto;
		text-align: center;
	}
	th {
		width: 25%;
	}
</style>
<meta charset="UTF-8">
<title>회원 정보 출력</title>
</head>
<body>
<table align="center" border="1">
	<tr>
		<th>아이디</th>
		<th>비밀번호</th>
		<th>이름</th>
		<th>이메일</th>		
	</tr>
	<tr colspan="2">
		<!-- <td colspan="4">dididi</td> -->
		<th><jsp:getProperty name="member" property="id"/></th>
		<th><jsp:getProperty name="member" property="pwd"/></th>
		<th><jsp:getProperty name="member" property="name"/></th>
		<th><jsp:getProperty name="member" property="email"/></th>		
	</tr>
	<tr>
		<th>${param.id }</th>
		<th>${param.pwd }</th>
		<th>${param.name }</th>
		<th>${param.email }</th>	
	</tr>
</table>
</body>
</html>