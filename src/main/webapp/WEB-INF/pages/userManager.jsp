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
							<li><a href="#">Thêm tài khoản</a></li>
							<li><a href="#">Danh sách tài khoản</a></li>
							<input id="sub-group-2" type="checkbox" hidden=true />
						</ul></li>
					<li><input id="group-3" type="checkbox" hidden=true /> <label
						for="group-3"><span class="fa fa-angle-right"></span> Quản
							lý phân quyền</label>
						<ul class="group-list">
							<li><a href="#">Thêm quyền</a></li>
							<li><a href="#">Danh sách quyền</a></li>
							<input id="sub-group-3" type="checkbox" hidden=true />
						</ul></li>

					<li><input id="group-4" type="checkbox" hidden=true /> <label
						for="group-4"><span class="fa fa-angle-right"></span> Phân
							quyền</label></li>
				</ul>
			</nav>
		</div>

		<div id="contentRight">

			<div class="row">
				<div class="col-md-6">
					<strong>Information</strong><br>
					<div class="table-responsive">
						<table
							class="table table-condensed table-responsive table-user-information">
							<tbody>
								<tr>
									<td><strong> <span
											class="glyphicon glyphicon-asterisk text-primary"></span> Mã
											định danh
									</strong></td>
									<td class="text-primary">123456789</td>
								</tr>
								<tr>
									<td><strong> <span
											class="glyphicon glyphicon-user  text-primary"></span> Họ tên
									</strong></td>
									<td class="text-primary">Nguyễn văn a</td>
								</tr>
								<tr>
									<td><strong> <span
											class="glyphicon glyphicon-cloud text-primary"></span> Ngày
											sinh
									</strong></td>
									<td class="text-primary">30/2/1990</td>
								</tr>
								<tr>
									<td><strong> <span
											class="glyphicon glyphicon-bookmark text-primary"></span>
											Username
									</strong></td>
									<td class="text-primary">nguyenvana</td>
								</tr>
								<tr>
									<td><strong> <span
											class="glyphicon glyphicon-eye-open text-primary"></span>
											Role
									</strong></td>
									<td class="text-primary">Admin</td>
								</tr>
								<tr>
									<td><strong> <span
											class="glyphicon glyphicon-envelope text-primary"></span>
											liên hệ
									</strong></td>
									<td class="text-primary">noreply@email.com</td>
								</tr>
								<tr>
									<td><strong> <span
											class="glyphicon glyphicon-calendar text-primary"></span>
											giới thiệu
									</strong></td>
									<td class="text-primary">cán bộ tổ công nghệ</td>
								</tr>
								<tr>
									<td><strong> <span
											class="glyphicon glyphicon-calendar text-primary"></span> cập
											nhật ngày
									</strong></td>
									<td class="text-primary">20 jul 20014 20:00:00</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>

	</div>


</body>
</html>