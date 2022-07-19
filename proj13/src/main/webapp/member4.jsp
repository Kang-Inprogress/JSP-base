<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*, sec01.ex01.*"
    %>
 <jsp:useBean id="m" class="sec01.ex01.MemberBean" scope="page"/>
 <jsp:setProperty name="m" property="*"/>
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
	td {
		width: 350px;
	}
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

		<tr>
			<td><jsp:getProperty name="m" property="id" /></td>
			<td><jsp:getProperty name="m" property="pwd"/></td>
			<td><jsp:getProperty name="m" property="email" /></td>
			<td><jsp:getProperty name="m" property="name"/></td>
		</tr>	

</table>
</body>
</html>