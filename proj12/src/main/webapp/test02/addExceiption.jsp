<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예외 처리 페이지</title>
</head>
<body>
	발생한 예외를 문자열로 출력
	<p>
		------------------toString()-------------------------<br>
		<h2><%=exception.toString() %></h2>
		
	</p>
	<p>
		------------------getMessage()-------------------------<br>
		<h2><%=exception.getMessage() %></h2>
		
	</p>
	<%--콘솔에서 확인가능 --%>
	<%exception.printStackTrace(); %>
	<h3>숫자만 입력 가능합니다. 다시 정확하게 입력해 주세요!</h3>
	<a href="add.html">돌아가기</a>
</body>
</html>