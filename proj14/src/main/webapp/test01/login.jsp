<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
<form action="result.jsp" method="post">
	아이디: <input type="text" name="id" />	
	비밀번호: <input type="password" name="pwd" />
	<input type="submit" value="submit" />
	<p>
		<a href="<%=request.getContextPath() %>/test01/memberForm.jsp">회원가입하기</a>
	</p>
</form>
</body>
</html>