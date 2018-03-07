<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<head>
<title>Hạ tầng truyền dẫn</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<script type="text/javascript"
	src=${pageContext.request.contextPath}/js/common.js></script>
</head>


<body>
	<jsp:include page="menu.jsp" />
	<script>
		// hightlight menu đã chọn
		setActiveLink("link2");
	</script>
	<a href=${pageContext.request.contextPath}/addTuyencap>add tuyen
		cap</a>
</body>
</html>
