<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>

<head>
	<title>Home Page</title>
</head>

<body>
	<h2>Home Page</h2>
	<hr>
	<p>
	Welcome to the Spring Security Demo!
	</p>
	<p>  
	User: <security:authentication property="principal.username"/>
	<br><br>
	Role(s): <security:authentication property="principal.authorities"/> 
	</p>
	<hr>
	<p>
	<a href= "${pageContext.request.contextPath}/leaders">Leadership Meeting </a>
	(Only For Managers)
	</p>
	<p>
	<a href="${pageContext.request.contextPath}/systems">IT systems Meetings</a>
	(On;y For Admins)
	</p>
	<hr>
	<form:form action ="${pageContext.request.contextPath}/logout" method ="POST">
	<input type="submit" value ="Logout"> 
	</form:form>
	

</body>

</html>