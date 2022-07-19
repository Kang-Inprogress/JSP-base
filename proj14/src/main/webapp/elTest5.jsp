<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>

<%
	
%>
<jsp:useBean id="m1" class="sec01.ex01.MemberBean" />
<jsp:setProperty name="m1" property="name" value="kang" />

<jsp:useBean id="list" class="java.util.ArrayList" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>empty</title>
</head>
<body>
	<h2>
		\${empty m1} : ${empty m1}<br>
		\${not empty m1} : ${not empty m1}<br><br>
		
		\${empty "hi"} : ${empty "hi"}<br>
		\${not empty "hi"} : ${not empty "hi"}<br><br>
		
		\${empty null} : ${empty null}<br>
		\${empty ""} : ${empty ""}<br>
	</h2>
</body>
</html>