    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
 <title>List organizations</title>
 <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
	table {
		border-collapse: collapse;
	}
	
	table, th, td {
		padding: 5px;
		margin: 10px;
		font-size: 20px;
		border: 1px solid black
	}
</style>
</head>
<body>
			<div align="center">
		<table>
			<tr>
				<th>Name</th>
				<th>Year</th>
				<th>Zip</th>
				<th>Emp Count</th>
				<th>Slogan</th>
			</tr>
			<c:forEach var="orgl" items="${orgList}">
				<tr>
				    <td>${orgl.companyName}</td>
					<td>${orgl.yearOfIncorporation}</td>
					<td>${orgl.postalCode}</td>
					<td>${orgl.employeeCount}</td>
					<td>${orgl.slogan}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>










