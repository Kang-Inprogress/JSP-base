<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage='addExceiption.jsp'%>
    
<%
	String value = request.getParameter("num");
	int sum = 0;
	int ivalue = Integer.parseInt(value);
	for(int i=0; i<ivalue; i++){
		sum += i;
	}
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>add</title>
</head>
<body>
	<h3>합계 결과</h3>
	<h3><%=sum %></h3>
	숫자 이외의 것을 입력하면 오류가 날 것이다.
</body>
</html>