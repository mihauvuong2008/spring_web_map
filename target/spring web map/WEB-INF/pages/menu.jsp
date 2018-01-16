<!doctype html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>
<title>Hạ tầng truyền dẫn</title>
<link rel="stylesheet" type="text/css"
	href=${pageContext.request.contextPath}/css/menu_style.css />
</head>

<body>
	<ul id='menuLinks'>
		<li id='link1'><a href=${pageContext.request.contextPath}/main>Bản
				đồ</a></li>
		<li id='link2'><a
			href=${pageContext.request.contextPath}/thietbi_cauhinh>Thiết bị
				- Hạ tầng</a></li>
		<li id='link4'><a href=${pageContext.request.contextPath}/lienhe>Liên
				hệ</a></li>
		<li id='link5'><a
			href=${pageContext.request.contextPath}/userInfo>Tài khoản</a></li>
		<li style="float: right"><a
			href=${pageContext.request.contextPath}/logout>Đăng xuất</a></li>
	</ul>
</body>
</html>
