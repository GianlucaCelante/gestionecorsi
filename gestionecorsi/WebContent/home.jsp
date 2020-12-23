<%
	String admin = (String) session.getAttribute("admin");

	if (admin != null) {
%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
	<%@include file="../CDN.html"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>

<meta name="viewport" content="width = device-width, initial-scale = 1">
<link rel="stylesheet" href="css/style.css">

</head>
<body>

	<jsp:include page="../header.jsp"></jsp:include>


</body>
</html>

<%

	} else {
		
	
	}

%>


