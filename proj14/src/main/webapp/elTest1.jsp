<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL TEST</title>
</head>
<body>
	<h2>표현 언어에 사용되는 데이터</h2>
	<h3>
		\${100} : ${100} <br>
		\${"안녕하세요" } : ${"안녕하세요" } <br>
		\${100 + 10 * 2043 } : ${100 + 10 * 2043} <br>
	</h3>
	<h2>여러가지 산술 연산자</h2>
	<h3>
		\${100/9} : ${100/9} <br>
		\${100 div 9} : ${100 div 9} <br>
		\${100%9} : ${100%9} <br>
		\${100 mod 9} : ${100 mod 9} <br>
	</h3>
</body>
</html>