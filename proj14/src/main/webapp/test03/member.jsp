<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="sec01.ex01.MemberBean"
    isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% request.setCharacterEncoding("utf-8");%>

<jsp:useBean id="memberList" class="java.util.ArrayList" />
<jsp:useBean id="memberHashmap" class="java.util.HashMap" />
<%
	MemberBean mb1 = new MemberBean("Hong", "9876", "홍두깨", "dudungTak@naver.com");
	MemberBean mb2 = new MemberBean("Kang", "1828", "강연우", "yeonu@gmail.com");
	
	memberHashmap.put("id", "Son");
	memberHashmap.put("pwd", "1234");
	memberHashmap.put("name", "소농민");
	memberHashmap.put("email", "Farmer119@naver.com");
	
	memberList.add(mb1);
	memberList.add(mb2);
	
	memberHashmap.put("memberList", memberList);
%>
<c:set var="memList" value="${memberHashmap.memberList }"/>
<!DOCTYPE html>
<html>
<head>
<link href="formal.css" rel="stylesheet" type="text/css" />
<meta charset="UTF-8">
<title>HashMap 회원정보 출력</title>
</head>
<body>

	<table border="1">
		<tr>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
			<th>이메일</th>
		</tr>
		<tr>
			<td>${memberHashmap.id }</td>
			<td>${memberHashmap.pwd }</td>
			<td>${memberHashmap.name }</td>
			<td>${memberHashmap.email }</td>
		</tr>
		<tr>
			<td>${memList[0].id }</td>
			<td>${memList[0].pwd }</td>
			<td>${memList[0].email }</td>
			<td>${memList[0].name }</td>
		</tr>
		<tr>
			<td>${memList[1].id }</td>
			<td>${memList[1].pwd }</td>
			<td>${memList[1].email }</td>
			<td>${memList[1].name }</td>
		</tr>
	</table>
	${memList }
</body>
</html>