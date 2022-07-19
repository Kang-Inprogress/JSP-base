<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
	table, h2 {
		margin-left: auto;
		margin-right: auto;
		width: 600px;
	}
	th {
		width: 200px;
		text-align: right;
	}
</style>
<meta charset="UTF-8">
<title>Member Form</title>
</head>
<body>
	<form method="post" action="member.jsp">
	<h2 style="text-align:center;">회원 가입창</h2>
		<table>
			<tr>
				<th>아이디: </th>
				<td><input type="text" name="id"/></td>
			</tr>
			<tr>
				<th>비밀번호: </th>
				<td><input type="password" name="pwd"/></td>
			</tr>
			<tr>
				<th>이메일: </th>
				<td><input type="text" name="email"/></td>
			</tr>
			<tr>
				<th>이름: </th>
				<td><input type="text" name="name"/></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="submit"/><input type="reset" value="reset"/></td>
			</tr>
		</table>
	</form>
</body>
</html>