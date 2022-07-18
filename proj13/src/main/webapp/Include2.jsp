<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>include2.jsp(부모 페이지)</title>
</head>
<body>
<%--액션 태그를 이용하여 jsp 파일을 포함, 동적으로 포함하기 위한 파라미터 전달 --%>
	<h2>부모 페이지 시작</h2>
		<jsp:include page="duke_image.jsp">
			
			<jsp:param name="name" value="duke2" />
			<jsp:param name="imgName" value="Mylady2.jpeg" />
		</jsp:include>
	<h2>부모 페이지 끝</h2>
</body>
</html>