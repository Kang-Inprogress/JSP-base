<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%! // 선언문(static)
	String admin_name = "admin";
	String admin_pwd = "I'm admin";
%>
<% // Java 코드(지역 변수)
	String id = request.getParameter("user_id"); // GET, POST 모두 인자로 받을 수 있다
	String pwd = request.getParameter("user_pwd");
	// System.out.println(id);
	// System.out.println(pwd);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Scriptlet</title>
</head>
<body>
	<%	if((id == null || id.length() == 0) || (pwd == null || pwd.length() == 0)) { %>
		<script type="text/javascript">
			/* 잘못된 로그인 정보일 경우 경고를 알람을 발생시키고 이전 페이지로 이동 */
			alert("잘못된 로그인 정보");
			history.back(); // 또는 history.go(-1);
		</script>
		<!-- <h4>잘못된 로그인 정보</h4> -->
		<!-- <a href="login.html" >로그인 창으로 되돌아 가기</a> -->
	<% } else { %>
	<%		if(id.equals(admin_name) && pwd.equals(admin_pwd)) { %>
				<script type="text/javascript">
					window.location.href="administration.html";
				</script>
	<% 		} else { %>
				<h2>Welcome!</h2>
				<h3>ID: <%= id%></h3>
				<h3>PWD: <%=pwd %></h3>
	<% 		}
	  } 
	%>
	<%-- 이것은 JSP 주석문 입니다 --%>
	<!-- 이것은 HTML 주석문 입니다 -->
</body>
</html>