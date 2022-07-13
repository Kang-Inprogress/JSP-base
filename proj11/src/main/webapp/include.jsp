<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이미지가 들어있는 jsp 파일을 포함하는 부모 jsp</title>
</head>
<body>
	<h2>인클루드 디렉티브 시작</h2>
	<!-- 인클루드 디렉티브 태그를 사용하면 변환 시, 단 하나의 java 파일로 생성 된다 -->
	<p><%@ include file="doge_image.jsp" %></p>
	<h2>인클루드 디렉티브 종료!</h2>
</body>
</html>