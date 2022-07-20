<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    isELIgnored="false" 
    import="sec01.ex01.MemberBean"
%>

<% // Encoding Only
	request.setCharacterEncoding("utf-8");
%>

<jsp:useBean id="mBean2" class="sec01.ex01.MemberBean" />
<jsp:setProperty name="mBean2" property="*"/>
<jsp:useBean id="memberList" class="java.util.ArrayList" />

<%
	MemberBean mBean1 = new MemberBean("son", "41312", "손흥민", "son@test.ac.kr");
	
	// 리스트에 두 명의 회원 추가, jsp usebean으로 memberList를 만들어졌기 때문에
	// 여기서 불러서 사용이 가능한 것
	memberList.add(mBean1);
	memberList.add(mBean2);
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
<%--JSP로 받은 파라미터를 받는 여러가지 방법 --%>
	<tr>
		<th>아이디</th>
		<th>비밀번호</th>
		<th>이름</th>
		<th>이메일</th>	
	</tr>
	<tr>
		<th><jsp:getProperty name="mBean2" property="id"/></th>
		<th><jsp:getProperty name="mBean2" property="pwd"/></th>
		<th><jsp:getProperty name="mBean2" property="name"/></th>
		<th><jsp:getProperty name="mBean2" property="email"/></th>
	</tr>
	<tr>
		<th>${memberList[0].id }</th>
		<th>${memberList[0].pwd }</th>
		<th>${memberList[0].name }</th>
		<th>${memberList[0].email }</th>
	</tr>
	<tr>
		<th>${memberList[1].id }</th>
		<th>${memberList[1].pwd }</th>
		<th>${memberList[1].name }</th>
		<th>${memberList[1].email }</th>
	</tr>
	<tr>
		<th><%=mBean2.getId() %></th>
		<th><%=mBean2.getPwd() %></th>
		<th><%=mBean2.getName() %></th>
		<th><%=mBean2.getEmail() %></th>
	</tr>
</table>
</body>
</html>