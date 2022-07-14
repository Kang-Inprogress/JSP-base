<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	request.setAttribute("name", "홍길동");
	request.setAttribute("address", "서울시 강남구");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Binding Only</title>
</head>
<body>
	request로 이름과 주소 정보를 바인딩 합니다
	<%
	// 결과: 새로운 연결로써 넘어가기 때문에 요청 페이지와 응답 페이지가 다른 경우 request 객체에 바인딩은 의미가 없어짐
		/* response.sendRedirect("application1.jsp"); */
	// 그래서 RequestDispatcher를 사용하면 속성 값을 얻어 포워딩을 하고, URL이 즉각적으로 변경되지않는다(보안에 유리)
		RequestDispatcher dis = request.getRequestDispatcher("application1.jsp");
	// 바인딩을 위 라인에서 미리 해놓았고, forward를 하여 결과적으로 URL로 정보를 노출 시키지 않고 이동할 수 있다
		dis.forward(request, response);
		
	%>
</body>
</html>