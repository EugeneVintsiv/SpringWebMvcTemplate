<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Save Test Entity</title>
</head>
<body>
	<h3>Save Test Entity</h3>
	
	<form:form action="saveTestEntity" modelAttribute="testEntity" method="POST">
		<form:hidden path="id" />
		<table>
			<tbody>
				<tr>
					<td><label>Name:</label></td>
					<td><form:input path="testEntityName"/></td>
				</tr>
				<tr>
					<td><label>Content:</label></td>
					<td><form:input path="testEntityContent"/></td>
				</tr>
				<tr>
					<td><label>Number:</label></td>
					<td><form:input path="testEntityNumber"/></td>
				</tr>
				<tr>
                    <td><label></label></td>
                    <td><input type="submit" value="Save" class="save" /></td>
                </tr>
			</tbody>
		</table>
		
	</form:form>	
	<p>
		<a href="${pageContext.request.contextPath}/testentityhibernate/list">Back to list</a>
	</p>
</body>
</html>