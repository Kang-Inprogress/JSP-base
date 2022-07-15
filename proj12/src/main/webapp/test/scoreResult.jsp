<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학점 변환 결과창</title>
</head>
<body>
<p>
<%
	String score = request.getParameter("score");
	// System.out.println(iscore);
	if ((score == null | score.length() == 0)){ %>
		<script type="text/javascript">
			alert("잘못된 입력 값");
			history.go(-1);
		</script>
<%	} else if (Integer.parseInt(score) < 0) { %>
		<script type="text/javascript">
			alert("0 이상의 큰 값을 입력하십시오");
			history.go(-1);
		</script>
<%	} else if (Integer.parseInt(score) > 100) { %>
		<script type="text/javascript">
			alert("100 이하의 값을 입력하십시오");
			history.go(-1);
		</script>
<% 	} else if(!(score == null | score.length() == 0)) {
	int iscore = Integer.parseInt(score);
%>
	<h2>시험 점수: <%=iscore %>점</h2>
	<%if(iscore >= 90) { %>
		<h2>A학점</h2>
	<%} else if (iscore >= 80) { %>
		<h2>B학점</h2>
	<%} else if (iscore >= 70) { %>
		<h2>C학점</h2>
	<%} else if (iscore >= 60) { %>
		<h2>D학점</h2>
	<%} else { %>
		<h2>F학점</h2>
	<%} %>
<% } %>
<%-- <%	} else if ((score == null | score.length() == 0)){ %>
		<script type="text/javascript">
			alert("잘못된 입력 값");
			history.go(-1);
		</script>
<%	} else if (iscore < 0) { %>
		<script type="text/javascript">
			alert("0 이상의 큰 값을 입력하십시오");
			history.go(-1);
		</script>
<%	} else if (iscore > 100) { %>
		<script type="text/javascript">
			alert("100 이하의 값을 입력하십시오");
			history.go(-1);
		</script>
<% 	} %> --%>
</p>
<a href="score.jsp">점수 입력창으로 되돌아가기</a>
</body>
</html>