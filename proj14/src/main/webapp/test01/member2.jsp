<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
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
		<th>주소</th>	
	</tr>
	<tr>
		<th>${param.id }</th>
		<th>${param.pwd }</th>
		<th>${param.name }</th>
		<th>${param.email }</th>	
		<th>${requestScope.address }</th>	
	</tr>
</table>
</body>
</html>