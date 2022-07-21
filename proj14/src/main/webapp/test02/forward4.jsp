<%@ page language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    import="sec01.ex01.MemberBean, java.util.*"
%>
    
<%
	request.setCharacterEncoding("utf-8");

	MemberBean mb1 = new MemberBean("lee", "1234", "이승기", "lee@web.com");
	MemberBean mb2 = new MemberBean("son", "9876", "소농민", "son@web.com");
	
	List<MemberBean> memberList = new ArrayList<MemberBean>();
	memberList.add(mb1);
	memberList.add(mb2);
	
	request.setAttribute("memberList", memberList);
	request.setAttribute("address", "서울시 강남구");
	application.setAttribute("address", "부산시 해운대구");
%>
<%-- <jsp:useBean id="mb" class="sec01.ex01.MemberBean" />
<jsp:setProperty name="mb" property="*" /> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>forward4 page</title>
</head>
<body>
	<jsp:forward page="member4.jsp" />
</body>
</html>