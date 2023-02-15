<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
	<title>Custome Login Page</title>
	
	<style>
		.failed{
		color:red;
		}
	</style>
</head>

<body>
<h3>

My Customer Login Page
	<form:form action="${pageContext.request.contextPath}/authenticateTheUser"
				method="POST">
				
	<!-- Check for login error -->
	
	<c:if test="${param.error !=null}">
		<i class="failed">Sorry! You entered invalid username/password.</i>
	</c:if>
	
	<P>
		User name:<input type="text" name="username"/>
	</P>
	
	<P>
		Password:<input type="password" name="password"/>
	</P>	
	
	<input type="submit" value="Login" />
	
	</form:form>
</h3>
</body>

</html>