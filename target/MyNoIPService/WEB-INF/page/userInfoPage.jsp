<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>

<html>
<head>
<title>User Info</title>
</head>
<body>
	<jsp:include page="menu.jsp" />

	<script>
		// hightlight menu đã chọn
		setActiveLink("link5");
	</script>

	<h2>User Info Page</h2>
	<h3>Welcome : ${pageContext.request.userPrincipal.name}</h3>
	<b>This is protected page!</b>
	<a id="linkUseraccount" href=${pageContext.request.contextPath}/logout
		target="_blank">Log out</a>
</body>
</html>