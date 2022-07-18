<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>include1.jsp(부모 페이지)</title>
</head>
<body>
	<h2>부모 페이지 시작</h2>
	<%--액션 태그를 이용하여 jsp 파일을 포함, 동적으로 포함하기 위한 파라미터 전달 --%>
		<jsp:include page="duke_image.jsp">
			<jsp:param name="name" value="duke" />
			<jsp:param name="imgName" value="Mylady.jpeg" />
		</jsp:include>
	<h2>부모 페이지 끝</h2>
</body>
</html>