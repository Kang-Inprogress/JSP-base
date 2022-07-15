<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	String dan = request.getParameter("dan");
%>

<html>
<head>
<meta charset="UTF-8">
<title>gugu출력</title>
</head>
<body>
	<h2>구구단을 출력 합니다</h2>
	<form action="gugu.jsp" method="get" >
		출력할 단 입력: <input type="text" name="dan"/><br>
		<input type="submit" value="submit">
	</form>
<% 
	if(!(dan == null || dan.length() == 0)) {
		int idan = Integer.parseInt(dan);
%>		
		<table border="1" width="600" align="center">
		<tr><th colspan="1" bgcolor="yellow"><%=idan %> 단</th></tr>
<%
		for(int i=1; i<10; i++) {
			if(i % 2 == 0) {
%>
				<tr>
					<td align="center" bgcolor="red"> <%=dan %> * <%=i %> = <%=idan * i %> </td>
				</tr>
<%
				
			} else {
%>
				<tr>
					<td align="center" bgcolor="blue"> <%=dan %> * <%=i %> = <%=idan * i %> </td>
				</tr>
<%				
			}
%>
<%
		}
%>		
		</table>
<%
	}
%>
</body>
</html>