<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	// request 객체에 address 이름으로 주소값을 바인딩
	request.setAttribute("address", "서울시 강남구");
	// System.out.println(request.getAttribute("address"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>포워드 페이지</title>
</head>
<body>
<%--액션 태그를 이용해서 memeber2.jsp로 포워딩 --%>
<jsp:forward page="member2.jsp" />
</body>
</html>