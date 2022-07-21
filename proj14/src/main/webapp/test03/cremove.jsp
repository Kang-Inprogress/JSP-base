<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="id" value="hong" scope="page" />
<c:set var="pwd" value="1234" scope="page" />
<c:set var="name" value="${'홍길동' }" scope="page" />
<c:set var="age" value="25" scope="page" />
<c:set var="tall" value="${177 }" scope="page" />

<!-- 삭제하려는 변수와의 scope는 맞춰주어야 한다 --> 
<c:remove var="age" scope="page" />
<c:remove var="tall" scope='page'/>
<c:remove var="pwd" scope="request" />

<!DOCTYPE html>
<html>
<link href="formal.css" type="text/css" rel="stylesheet"/>
<head>
<meta charset="UTF-8">
<title>C tag library를 이용한 회원 정보 출력</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
			<th>나이</th>
			<th>키</th>
		</tr>
		<tr>
			<td>${id }</td>
			<td>${pwd }</td>
			<td>${name }</td>
			<td>${age }</td>
			<td>${tall }</td>
		</tr>
	</table>
</body>
</html>