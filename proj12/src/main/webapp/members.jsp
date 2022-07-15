<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    import = "sec01.ex01.MemberVO, sec01.ex01.MemberDAO, java.util.List"
    %>
    
<%
	request.setCharacterEncoding("utf-8");
	String name = request.getParameter("name");
	
	MemberVO memberVO = new MemberVO();
	memberVO.setId(name);
	
	MemberDAO dao = new MemberDAO();
	List<MemberVO> list = dao.listMembersByid(memberVO);
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 조회</title>
</head>
<body>
	받아온 이름: <%=name %>
<table border="1">
	<tr bgcolor="lightyellow" align="center">
		<td>아이디</td>
		<td>비밀번호</td>
		<td>이름</td>
		<td>이메일</td>
		<td>가입일자</td>
	</tr>
<%
	for(int i=0; i<list.size(); i++) {
		memberVO = list.get(i);
%>
		<tr align="center">
			<%-- <%=memberVO %><br> --%>
			<td>ID: <%=memberVO.getId() %></td>
			<td>PWD: <%=memberVO.getPwd() %></td>
			<td>NAME: <%=memberVO.getName() %></td>
			<td>E-MAIL: <%=memberVO.getEmail() %></td>
			<td>joinDate: <%=memberVO.getJoinDate()%></td>
		</tr>
<%
	}
%>
</table>
</body>
</html>