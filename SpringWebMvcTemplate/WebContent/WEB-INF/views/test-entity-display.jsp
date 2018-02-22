<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Test Entity Display</title>
</head>
<body>

<div align="center">
	<table>
		<caption style="font-size: 40px; margin-bottom: 10px">
			Test Entities
		</caption>
		<tr>
			<th>Name</th>
			<th>Content</th>
			<th>Number</th>
		</tr>
		<c:forEach var="row" items="${testEntityList}">
			<tr>
				<td><c:out value="${row.testEntityName}"></c:out></td>
				<td><c:out value="${row.testEntityContent}"></c:out></td>
				<td><c:out value="${row.testEntityNumber}"></c:out></td>
			</tr>
		</c:forEach>
	</table>
</div>

</body>
</html>