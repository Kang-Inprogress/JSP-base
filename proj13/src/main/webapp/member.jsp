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
		<tr text-align="center" bgcolor="yellow">
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이메일</th>
			<th>이름</th>
			<th>가입일자</th>
		</tr>
		<% 	
	if(memberList != null) { 
		for(int i=0; i<memberList.size(); i++) {
			MemberBean dm = memberList.get(i);
%>
		<tr>
			<td><%=dm.getId() %></td>
			<td><%=dm.getPwd() %></td>
			<td><%=dm.getEmail() %></td>
			<td><%=dm.getName() %></td>
			<td><%=dm.getJoinDate() %></td>
		</tr>	
<%
		}
	}
%>
</table>
</body>
</html>