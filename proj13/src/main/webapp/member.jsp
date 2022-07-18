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
<% 	
	if(memberList != null) { 
		for(int i=0; i<memberList.size(); i++) {
			MemberBean dm = memberList.get(i);
%>
		<tr>
			<td>아이디: <%=dm.getId() %></td>
			<td>비밀번호: <%=dm.getPwd() %></td>
			<td>이메일: <%=dm.getEmail() %></td>
			<td>이름: <%=dm.getName() %></td>
			<td>가입일자: <%=dm.getJoinDate() %></td>
		</tr>	
<%
		}
	}
%>
</table>
</body>
</html>