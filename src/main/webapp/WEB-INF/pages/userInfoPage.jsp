<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>
<title>User Info</title>
<link rel="stylesheet" type="text/css"
	href=${pageContext.request.contextPath}/css/userInfoPage.css />
<script type="text/javascript"
	src=${pageContext.request.contextPath}/js/common.js></script>
</head>

<body>
	<jsp:include page="menu.jsp" />
	<script>
		setActiveLink("link5");
	</script>

	<div id="contentWrapper">

		<div id="contentleft">
			<nav class="nav" role="navigation">
				<ul class="nav__list">
					<li><input id="group-1" type="checkbox" hidden=true /> <label
						for="group-1"><span class="fa fa-angle-right"></span> Tài
							khoản </label></li>
					<li><input id="group-2" type="checkbox" hidden=true /> <label
						for="group-2"> <span class="fa fa-angle-right"></span> Đổi
							thông tin
					</label></li>


					<li><input id="group-4" type="checkbox" hidden=true /> <label
						for="group-4"><span class="fa fa-angle-right"></span> Lịch sử hoạt động</label></li>
				</ul>
			</nav>
		</div>

		<div id="contentRight">

			<a>xin chao : ${pageContext.request.userPrincipal.name}</a> <a
				id="linkUseraccount" href=${pageContext.request.contextPath}/logout
				target="_blank">Log out</a>

			<jsp:include page="userView.jsp" />

		</div>

	</div>


</body>
</html>