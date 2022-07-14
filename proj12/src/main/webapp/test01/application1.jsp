<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("utf-8");
	String name = (String)request.getAttribute("name");
	String address = (String)request.getAttribute("address");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Binding된 정보 확인(내장객체 out으로 출력)</title>
</head>
<body>
<%-- <h3>이름: <%=name %></h3>
<h3>住所: <%=address %></h3> --%>
<%
	if((name != null || name.length() != 0) && (address != null || address.length() != 0)) {
		out.print("<h3>이름: " + name + "</h3>"
				+ "<h3>주소: " + address + "</h3>");
	}
%>
</body>
</html>