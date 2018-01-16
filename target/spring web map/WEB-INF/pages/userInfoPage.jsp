<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>
<title>User Info</title>
<script type="text/javascript"
	src=${pageContext.request.contextPath}/js/common.js></script>
</head>

<body>
	<jsp:include page="menu.jsp" />

	<script>
		// hightlight menu ÄÃ£ chá»n
		setActiveLink("link5");
	</script>

	<a>xin chao : ${pageContext.request.userPrincipal.name}</a>
	<a id="linkUseraccount" href=${pageContext.request.contextPath}/logout
		target="_blank">Log out</a>
</body>
</html>