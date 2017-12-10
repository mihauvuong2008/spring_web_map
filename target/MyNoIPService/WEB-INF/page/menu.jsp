<!doctype html>
<html lang=''>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<head>
<meta charset='utf-8' />
<title>Web server - MyNoIPService</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" type="text/css"
	href=${pageContext.request.contextPath}/css/styles.css />
<script type="text/javascript"
	src=${pageContext.request.contextPath}/js/common.js></script>
</head>

</head>

<body>
	<div id='cssmenu'>
		<img id="logo"
			src=${pageContext.request.contextPath}/img/LogoSample_ByTailorBrands.jpg>
		<div id="useraccount">
			<a id="linkUseraccount"
				href=${pageContext.request.contextPath}/userInfo target="_blank">${pageContext.request.userPrincipal.name}</a>
		</div>
		<ul id='menuLinks'>
			<li id='link1' onClick="setActiveLink(this.id)"><a
				href=${pageContext.request.contextPath}/main>Trang chủ</a></li>
			<li id='link2' onClick="setActiveLink(this.id)"><a
				href=${pageContext.request.contextPath}/thietbi_cauhinh>Thiết bị
					và cấu hình</a></li>
			<li id='link3' onClick="setActiveLink(this.id)"><a
				href=${pageContext.request.contextPath}/tainguyen>Tài nguyên</a></li>
			<li id='link4' onClick="setActiveLink(this.id)"><a
				href=${pageContext.request.contextPath}/lienhe>Liên hệ</a></li>
			<li id='link5' onClick="setActiveLink(this.id)"><a
				href=${pageContext.request.contextPath}/userInfo>Tài khoản -
					Đăng nhập</a></li>
		</ul>
	</div>
</body>
</html>
