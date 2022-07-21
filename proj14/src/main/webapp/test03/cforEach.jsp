<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	List<String> dataList = new ArrayList<String>();
	dataList.add("JSTL 라이브러리");
	dataList.add("JSTL core");
	dataList.add("forEach test");
%>

<!DOCTYPE html>
<html>
<link href="formal.css" type="text/css" rel="stylesheet"/>
<head>
<meta charset="UTF-8">
<title>C:forEach</title>
</head>
<body>
<c:forEach var="data" items="${dataList }">
	${data }<br>
</c:forEach>
</body>
</html>