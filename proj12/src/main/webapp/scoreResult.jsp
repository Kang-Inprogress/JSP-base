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
	if(!(score == null | score.length() == 0)) {
		int iscore = Integer.parseInt(score);
		System.out.println(iscore);
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
<%	} else { %>
		<script type="text/javascript">
			alert("잘못된 입력 값");
			history.go(-1);
		</script>
<%	} %>
</p>
<a href="score.jsp">점수 입력창으로 되돌아가기</a>
</body>
</html>