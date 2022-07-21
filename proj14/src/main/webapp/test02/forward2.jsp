<%@ page language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    import="sec01.ex01.MemberBean"
%>
    
<%
	request.setCharacterEncoding("utf-8");

	MemberBean mb = new MemberBean("lee", "1234", "이승기", "lee@web.com");
	request.setAttribute("member", mb);
%>
<%-- <jsp:useBean id="mb" class="sec01.ex01.MemberBean" />
<jsp:setProperty name="mb" property="*" /> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>forward2 page</title>
</head>
<body>
	<jsp:forward page="member2.jsp" />
</body>
</html>