<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여러 가지 논리 연산자</title>
</head>
<body>
<h2>여러 가지 논리 연산자</h2>
<h3>
	\${(10 == 10) && (10 != 10) } : ${(10 == 10) && (10 != 10) }<br>
	\${(10 == 10) and (10 != 10) } : ${(10 == 10) and (10 != 10) }<br><br>
	
	\${(10 == 20) || (10 != 20) } : ${(10 == 20) || (10 != 20) }<br>
	\${(10 == 20) or (10 != 20) } : ${(10 == 20) or (10 != 20) }<br><br>
</h3>
</body>
</html>