<%@ page 
	language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    isELIgnored="false" 
    import="sec01.ex01.MemberBean, java.util.*"%>

<%
	request.setCharacterEncoding("utf-8");
	
	List<MemberBean> memberList = (List<MemberBean>) request.getAttribute("memberList");
	
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
			<th>${memberList[0].getId() }</th>
			<th>${memberList[0].getPwd() }</th>
			<th>${memberList[0].getName() }</th>
			<th>${memberList[0].getEmail() }</th>
		</tr>
		<tr>
			<th>${memberList[1].getId() }</th>
			<th>${memberList[1].getPwd() }</th>
			<th>${memberList[1].getName() }</th>
			<th>${memberList[1].getEmail() }</th>
		</tr>
	</table>
</body>
</html>