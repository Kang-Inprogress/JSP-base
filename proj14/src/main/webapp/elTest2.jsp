<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여러 가지 비교연산자</title>
</head>
<body>
<h2>여러 가지 비교연산자</h2>
<h3>
	<!-- equals -->
	\${10 == 10 } : ${10 == 10 }<br>
	\${10 eq 10 } : ${10 eq 10 }<br><br>
	\${"hello" == "hello" } : ${"hello" == "hello" }<br>
	\${"hello" eq "hello" } : ${"hello" eq "hello" }<br><br>
	
	<!-- not equals -->
	\${10 != 20 } : ${10 != 20 }<br>
	\${10 ne 20 } : ${10 ne 20 }<br><br>
	\${"hello" == "hi" } : ${"hello" == "hi" }<br>
	\${"hello" ne "hi" } : ${"hello" ne "hi" }<br><br> 
	
	<!-- less than -->
	\${10 < 20 } : ${10 < 20 }<br>
	\${10 lt 20 } : ${10 lt 20 }<br><br>
	
	<!-- greater than -->
	\${100 > 20 } : ${100 > 20 }<br>
	\${100 gt 20 } : ${100 gt 20 }<br><br>
	
	<!-- less than equals-->
	\${10 <= 20 } : ${10 <= 20 }<br>
	\${10 le 20 } : ${10 le 20 }<br><br>
	
	<!-- greater than -->
	\${100 >= 20 } : ${100 >= 20 }<br>
	\${100 ge 20 } : ${100 ge 20 }<br><br>
</h3>
</body>
</html>