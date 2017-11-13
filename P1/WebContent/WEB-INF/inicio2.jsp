<%@ page language="java" contentType="text/html; charset=ISO-8859-1"    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="/WEB-INF/bootstrap/css/bootstrap.css">
<script src="/WEB-INF/bootstrap/js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Hola <%request.getAttribute("datos"); %></h1>
<h1><c:out value="${datos}" /></h1>
<p> directamente con request</p>
<h1>${requestScope.datos}</h1>
<p> con set y var</p>
<c:set var="message" value='${requestScope["datos"]}' />
<c:out value="${message}"/>
</body>
</html>