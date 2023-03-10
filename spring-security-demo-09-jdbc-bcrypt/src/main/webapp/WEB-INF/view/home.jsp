<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>


<html>

<head>
	<title>luv2code Company Home Page</title>
</head>

<body>
	<h2>luv2code Company Home Page</h2>
	<hr>
	
	<p>
	Welcome to the luv2code company home page!
	</p>
	
	<hr>
	<!-- display user name and role -->
	<p>
		User:<security:authentication property="principal.username"/>
		<br><br>
		Role(s):<security:authentication property="principal.authorities"/>	
	</p>
	<hr>
	<!-- add a link to point to leaders -->
	<p>
	
	<a href="${pageContext.request.contextPath}/leaders">LeaderShip Meeting</a>
		
	</p>
	
	<!-- add a link to point systems only for admins -->
	
	<p>
	
	<a href="${pageContext.request.contextPath}/systems">IT System Meeting</a>
		
	</p>
	
	<hr>
	
	
	<!-- add a logout button -->
	<form:form action="${pageContext.request.contextPath}/logout" method="POST">
	
		<input type="submit" value="Logout" />
	</form:form>	
</body>

</html>