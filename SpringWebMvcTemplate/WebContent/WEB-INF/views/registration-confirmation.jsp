<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insert title here</title>
	<jsp:include page="/resources/includes/bootstrap-include.jsp" />
	<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/resources/css/master-template.css">	
</head>
<body>
	<jsp:include page="/resources/includes/main-header-include.jsp" />
	<div class="container">
		<div class="row">
			<div class="col-12-lg">
				
				<h2>User registered successfully!</h2>
				
				<hr>
				
				<a href="${pageContext.request.contextPath}/showMyLoginPage">Login with new user.</a>

			</div>
		</div>
	</div>
	<jsp:include page="/resources/includes/main-footer-include.jsp" />
</body>
</html>