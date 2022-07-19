<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*, sec01.ex01.*"
    %>
 <jsp:useBean id="m" class="sec01.ex01.MemberBean" scope="page"/>
 <%-- <jsp:setProperty name="m" property="id" param="id"/>
 <jsp:setProperty name="m" property="pwd" param="pwd"/>
 <jsp:setProperty name="m" property="email" param="email"/>
 <jsp:setProperty name="m" property="name" param="name"/> 
 아래 코드 처럼 변경--%>
 <jsp:setProperty name="m" property="id"/>
 <jsp:setProperty name="m" property="pwd"/>
 <jsp:setProperty name="m" property="email"/>
 <jsp:setProperty name="m" property="name"/>
<%
	request.setCharacterEncoding("utf-8");
	
	MemberDAO dao = new MemberDAO();
	List<MemberBean> memberList = new ArrayList<MemberBean>();
	
	if(m.getId() != null && m.getPwd() != null && m.getEmail() != null && m.getName() != null) {
		/* MemberBean m = new MemberBean(id, pwd, email, name); */
		/* m.setId(id); m.setPwd(pwd); m.setEmail(email); m.setName(name); */
		
		// 회원 추가 메서드 추가
		dao.addMembers(m);
		
		//등록한 회원의 정보를 조회하는 메서드 호출
		memberList = dao.listMembers();
	} else {
		memberList = dao.listMembers();
	}
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
	if(memberList.size() == 0) { 
%>
		<tr height="1" bgcolor="skyblue">
			<td colspan="5">현재 등록된 회원은 없습니다!</td>
		</tr>
<%
	} else {
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