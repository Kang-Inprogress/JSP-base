<%@ page language="java" contentType="text/html; charset=UTF-8"
	    pageEncoding="UTF-8"
	    session="true"
	    info="(Page Directive Tag)"
	    import="java.util.*, java.io.*"
	    buffer="8kb"
	    autoFlush="true"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>페이지 디렉티브 태그</title>
</head>
<body>
	<h2>Page Directive Tag</h2>
	language=언어<br> 
	contentType=페이지 출력 형식<br>
    pageEncoding=인코딩 형식<br>
    session=HttpSession 쓸 건지<br>
    info=페이지를 설명해 주는 문자열 지정<br>
    import=다른 패키지의 클래스를 임포트할 때 지정<br>
    buffer=페이지 출력 시 사용할 버퍼 크기<br>
    autoFlush=JSP 페이지의 내용이 출력되기 전 버퍼가 다 채워질 경우 동작을 지정<br>
    <h3>대소문자를 구분하기 때문에 옵션을 작성할 때는 주의하기</h3>
</body>
</html>