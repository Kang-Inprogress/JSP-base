<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    isELIgnored="false" 
    import="sec01.ex01.MemberBean"
%>

<% // Encoding Only
	request.setCharacterEncoding("utf-8");
%>

<jsp:useBean id="mem" class="sec02.ex01.MemberBean" />
<jsp:setProperty name="mem" property = "*"/>

<jsp:useBean id="addr" class="sec02.ex01.Address" />
<jsp:setProperty name="addr" property="city" value="부산시" />
<jsp:setProperty name="addr" property="zipcode" value="48062" />

<jsp:setProperty name="mem" property="addr" value="<%=addr %>" />
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
		<th>도시</th>
		<th>우편번호</th>
	</tr>
	<tr>
		<th>${mem.id }</th>
		<th>${mem.pwd }</th>
		<th>${mem.name }</th>
		<th>${mem.email }</th>	
		<th>${mem.addr.city }</th>	
		<th>${mem.addr.zipcode }</th>	
	</tr>
	<tr>
		<th><%=mem.getId() %></th>
		<th><%=mem.getPwd() %></th>
		<th><%=mem.getName() %></th>
		<th><%=mem.getEmail() %></th>
		<th><%=mem.getAddr().getCity() %></th>
		<th><%=mem.getAddr().getZipcode() %></th>
	</tr>
</table>
</body>
</html>