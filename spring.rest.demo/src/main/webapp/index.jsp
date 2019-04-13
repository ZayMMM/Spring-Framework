<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome pages</title>
</head>
<body>

	<h1>Welcome Page !</h1>

	<hr />

	<a href="${pageContext.request.contextPath}/test/hello"> Hello Page
	</a>

	<hr />

	<a href="${pageContext.request.contextPath}/api/students"> All
		Student List </a>

</body>
</html>