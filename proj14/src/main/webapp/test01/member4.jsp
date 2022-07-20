<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    isELIgnored="false" 
    import="sec01.ex01.MemberBean"
%>

<% // Encoding Only
	request.setCharacterEncoding("utf-8");
%>

<jsp:useBean id="member1" class="sec01.ex01.MemberBean" />
<jsp:setProperty name="member1" property="*"/>
<jsp:useBean id="memberList" class="java.util.ArrayList" />
<jsp:useBean id="memberMap" class="java.util.HashMap" />

<%
	MemberBean member2 = new MemberBean("son", "41312", "손흥민", "son@test.ac.kr");
	// 리스트에 두 명의 회원 추가, jsp usebean으로 memberList를 만들어졌기 때문에
	// 여기서 불러서 사용이 가능한 것
	memberList.add(member1);
	memberList.add(member2);
	
	memberMap.put("id", "park");
	memberMap.put("pwd", "1212");
	memberMap.put("name", "박세리");
	memberMap.put("email", "park@web.com");
	memberMap.put("memberList", memberList);
%>

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
		width: 20%;
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
	<tr>
		<td>${memberMap.memberList[0].getId() }</td>
		<td>${memberMap.memberList[0].pwd }</td>
		<td>${memberMap.memberList[0].getName() }</td>
		<td>${memberMap.memberList[0].email }</td>
	</tr>
	<tr>
		<td>${memberMap.memberList[1].id }</td>
		<td>${memberMap.memberList[1].pwd }</td>
		<td>${memberMap.memberList[1].name }</td>
		<td>${memberMap.memberList[1].email }</td>
	</tr>
	<tr>
		<td>${memberMap.get("id") }</td>
		<td>${memberMap.get("pwd") }</td>
		<td>${memberMap.get("name") }</td>
		<td>${memberMap.get("email") }</td>
	</tr>
</table>
</body>
</html>