<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>

<!doctype html>
<html lang=''>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<head>
<meta charset='utf-8' />
<title>${title}</title>
</head>
<body>
	<jsp:include page="menu.jsp" />

	<h2>Admin Page</h2>


	<h3>Welcome : ${pageContext.request.userPrincipal.name}</h3>

	<b>This is protected page!</b>
</body>
</html>