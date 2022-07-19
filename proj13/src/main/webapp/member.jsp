<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="sec01.ex01.MemberBean, sec01.ex01.MemberDAO, java.util.*"
    %>
<%
	request.setCharacterEncoding("utf-8"); 
	
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	String email = request.getParameter("email");
	String name = request.getParameter("name");
	
	MemberBean m = new MemberBean(id, pwd, email, name);
	MemberDAO dao = new MemberDAO();
	// 회원 추가 메서드 추가
	dao.addMembers(m);
	
	//등록한 회원의 정보를 조회하는 메서드 호출
	List<MemberBean> memberList = new ArrayList<MemberBean>();
	memberList = dao.listMembers();
	
>>>>>>> 51e62ce778f2db87d0bdd546859d7f9b1865d22f
%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
	
</style>
<meta charset="UTF-8">
<title>Members</title>
</head>
<body >
<h2 id="title" align="center">회원 정보</h2>
<table align="center" border="1">
<<<<<<< HEAD
		<tr text-align="center" bgcolor="yellow">
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이메일</th>
			<th>이름</th>
			<th>가입일자</th>
		</tr>
<% 	
	if(memberList.size() == 0) { 
%>
		<tr height="1" bgcolor="skyblue">
			<td colspan="5">현재 등록된 회원은 없습니다!</td>
		</tr>
<%
	} else {
=======
<% 	
	if(memberList != null) { 
>>>>>>> 51e62ce778f2db87d0bdd546859d7f9b1865d22f
		for(int i=0; i<memberList.size(); i++) {
			MemberBean dm = memberList.get(i);
%>
		<tr>
<<<<<<< HEAD
			<td><%=dm.getId() %></td>
			<td><%=dm.getPwd() %></td>
			<td><%=dm.getEmail() %></td>
			<td><%=dm.getName() %></td>
			<td><%=dm.getJoinDate() %></td>
=======
			<td>아이디: <%=dm.getId() %></td>
			<td>비밀번호: <%=dm.getPwd() %></td>
			<td>이메일: <%=dm.getEmail() %></td>
			<td>이름: <%=dm.getName() %></td>
			<td>가입일자: <%=dm.getJoinDate() %></td>
>>>>>>> 51e62ce778f2db87d0bdd546859d7f9b1865d22f
		</tr>	
<%
		}
	}
%>
</table>
</body>
</html>
