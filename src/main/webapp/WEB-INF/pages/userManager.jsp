<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>
<title>Quản lý tài khoản</title>
<link rel="stylesheet" type="text/css"
	href=${pageContext.request.contextPath}/css/userManagerStyle.css />
<script type="text/javascript"
	src=${pageContext.request.contextPath}/js/common.js></script>
</head>

<body>
	<jsp:include page="menu.jsp" />

	<script>
		// hightlight menu ÄÃ£ chá»n
		setActiveLink("link6");
	</script>

	<div id="contentWrapper">
		<div id="menuwrapper">
			<ul id="sidemenu">
				<li><a class="noflyout" href="#">Tài khoản</a></li>
				<li><a href="#">Quản lý tài khoản</a>
					<ul>
						<li>Thêm tài khoản</li>
						<li>Danh sách tài khoản</li>
					</ul></li>
				<li><a href="#">Quản lý phân
						quyền</a>
					<ul>
						<li>Thêm quyền</li>
						<li>Danh sách quyền</li>
					</ul></li>
				<li><a class="noflyout selected" href="#">Phân quyền</a></li>
			</ul>
		</div>
		<div id="contentRight">Your main content goes hereaaaaa</div>
	</div>


</body>
</html>