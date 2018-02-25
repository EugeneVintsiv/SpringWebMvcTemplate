<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List Test Entities</title>
</head>
<body>
	<div id="header">
		<h2>Test Entities</h2>
	</div>
	<div id="container">
		<input type="button" value="Add Test Entity"
			onclick="window.location.href='showFormForAdd'; return false;"
		/>
		<table>
			<tr>
				<th>Name</th>
				<th>Content</th>
				<th>Number</th>
			</tr>
			
			<c:forEach var="testEntity" items="${testEntities}">
				<c:url var="updateLink" value="/testentityhibernate/showFormForUpdate">
					<c:param name="testEntityId" value="${testEntity.id}"/>
				</c:url>
				<c:url var="deleteLink" value="/testentityhibernate/delete">
					<c:param name="deleteTestEntity" value="${testEntity.id}"/>
				</c:url>
				<tr>
					<td>${testEntity.testEntityName}</td>
					<td>${testEntity.testEntityContent}</td>
					<td>${testEntity.testEntityNumber}</td>
					<td><a href="${updateLink}">Update</a></td>
					<td><a href="${deleteLink}"
						onclick="if(!(confirm('Are you sure you want to delete this customer?'))) 
							return false">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>