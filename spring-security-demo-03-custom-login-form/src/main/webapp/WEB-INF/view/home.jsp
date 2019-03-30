<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<!doctype html>
<html lang="en">
<head>
<title>Next Company Home Page</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Reference Bootstrap files -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body>

	<div class="container">
		<h2>Next Company Home Page</h2>
		<hr>

		<p>Welcome to the Next company home page!</p>

		<P>
			<security:authorize access="isAuthenticated()">
		User : <security:authentication property="principal.username" />
				<br />
		Role : <security:authentication property="principal.authorities" />
			</security:authorize>
		</P>

		<hr />

		<security:authorize access="hasRole('MANAGER')">
			<P>
				<a href="${pageContext.request.contextPath}/leaders"> LeaderShip
					Meeting (Only for Manager peeps) </a>
			</P>
		</security:authorize>
		<hr />

		<security:authorize access="hasRole('ADMIN')">
			<P>
				<a href="${pageContext.request.contextPath}/system"> IT System
					Meeting (Only for Admin peeps) </a>
			</P>
		</security:authorize>

		<form:form action="${pageContext.request.contextPath}/logout"
			method="POST">
			<button type="submit" class="btn btn-danger">Logout</button>
		</form:form>
	</div>

</body>

</html>