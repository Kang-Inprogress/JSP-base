<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%!
 	// JSP 선언문 변수 선언
 	String name = "홍길동";
 	public String getName() {
 		return name;
 	}
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP 선언문</title>
</head>
<!-- JSP 파일은 저장 후 브라우저에서 새로 고침하면 즉시 반영 -->
<body>
	내 이름은 <%=name %> 이다! <br>
</body>
</html>