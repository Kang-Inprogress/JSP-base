<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP 리스트 작성</title>
<style type="text/css">
.lst_type {
	overflow: hidden;
	width: 80%;
	padding: 0 10px 10px;
	margin: 0 auto
}

.lst_type li {
	overflow: hidden;
	clear: both;
	margin: 10px 0 0;
	color: #2d2c2d;
	font-family: '돋움', Dotum;
	font-size: 12px;
	line-height: 400px;
	list-style: none;
	border-bottom: 2px solid lightgray;
	position: relative;
}

.lst_type li img {
	display: inline;
	float: left;
	position: absolute;
}

.lst_type li a {
	color: #2d2c2d;
	text-decoration: none;
	margin-left: 50%;
}

.lst_type li a:hover {
	text-decoration: underline
}

.lst_type li span {
	color: blue;
	margin-left: 11%;
	font-family: '돋움', Dotum;
	font-size: 14px;
}
#inlineImg {
	margin-left: 40px;
}
</style>
</head>
<body>
<!-- 맨 위 헤더 -->
<ul class="lst_type">
	<li>
		<span>이미지</span>
		<span>이미지 이름</span>
		<span>이미지 선택하기</span>
	</li>
<%
	for(int i=1; i<10; i++) {
%>
	<li >
		<span id="inlineImg"><img src="./imgs/<%=i %>.jpg" height="380" ></span>
		<a>이미지 이름: MEME <%=i %></a>
		<input type="checkbox" name="chk<%=i %>"/>
	</li>
<%	
	}
%>
</ul>
</body>
</html>