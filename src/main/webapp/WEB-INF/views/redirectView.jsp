<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	리다이렉트되었음 
	<c:forEach var="items" items="${list}">
		<li>${items.bno}, ${items.title}</li>
	</c:forEach>
</body>
</html>