<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 결과 창</title>
</head>
<body>
<%
	String user_id = request.getParameter("user_id");
	String msg = "유효하지 않은 값이 입력 되었습니다";
	if(user_id == null || user_id.length() == 0) {
%>
		<jsp:forward page="login2.jsp">
			<jsp:param value="<%=msg %>" name="msg"/>
		</jsp:forward>
<%		/* 위 코드가 아래의 코드의 동작(forward)을 대신할 수 있다
		RequestDispatcher dis = request.getRequestDispatcher("login.jsp");
		dis.forward(request, response); 
		*/
	}
%>
<h2>안녕하세요 <%=user_id %>회원님</h2>
</body>
</html>