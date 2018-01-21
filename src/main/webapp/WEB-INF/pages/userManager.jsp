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
<script type="text/javascript"
	src=${pageContext.request.contextPath}/js/jquery.min.js></script>
</head>

<body>
	<jsp:include page="menu.jsp" />

	<script>
		// hightlight menu ÄÃ£ chá»n
		setActiveLink("link6");
		$(document).ready(function() {
			// your on click function here
			$('a').click(function(event) {
				event.preventDefault();
				$('.loaded_content').load($(this).attr('href'));
				return false;
			});
		});
	</script>
	<div id="contentWrapper">

		<div id="contentleft">
			<nav class="nav" role="navigation">
				<ul class="nav__list">
					<li><input id="group-1" type="checkbox" hidden=true /> <label
						for="group-1"><span class="fa fa-angle-right"></span> Tài
							khoản </label></li>
					<li><input id="group-2" type="checkbox" hidden=true /> <label
						for="group-2"> <span class="fa fa-angle-right"></span>
							Quản lý tài khoản
					</label>
						<ul class="group-list">
							<li><a href=${pageContext.request.contextPath}/addUser>Thêm
									tài khoản</a></li>
							<li><a href=${pageContext.request.contextPath}/userView>Danh
									sách tài khoản</a></li>
							<input id="sub-group-2" type="checkbox" hidden=true />
						</ul></li>
					<li><input id="group-3" type="checkbox" hidden=true /> <label
						for="group-3"><span class="fa fa-angle-right"></span> Quản
							lý phân quyền</label>
						<ul class="group-list">
							<li><a class="links" href="#">Thêm quyền</a></li>
							<li><a href="#">Danh sách quyền</a></li>
							<input id="sub-group-3" type="checkbox" hidden=true />
						</ul></li>

					<li><input id="group-4" type="checkbox" hidden=true /> <label
						for="group-4"><span class="fa fa-angle-right"></span> Phân
							quyền</label></li>
				</ul>
			</nav>
		</div>

		<div class='loaded_content' id="contentRight"></div>

	</div>

</body>
</html>