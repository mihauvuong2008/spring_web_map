<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" type="text/css"
	href=${pageContext.request.contextPath}/css/add_editTuyencap.css />
<link rel="stylesheet" type="text/css"
	href=${pageContext.request.contextPath}/css/ApplicationStyle.css />

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<p class="intro">Thông tin Vị trí - Cửa hầm. ${formTitle}</p>
	<hr>

	<div class="content">
		<div class="container-contact100 container">
			<form action="saveUserInfo" method="POST" modelAttribute="userInfo">

				<div class="row">
					<div class="col-25">
						<label class="label-input100" class="col-25" for="first-name">Mã
							Cửa hầm *</label>
					</div>
					<div class="col-75">
						<input id="Macuaham" class="input100" type="text"
							name="Macuaham" placeholder="Mã Cửa hầm">
					</div>
				</div>

				<div class="row">
					<div class="col-25">
						<label class="label-input100" for="first-name">ID Vị trí</label>
					</div>
					<div class="col-75">
						<input id="IDVitri" class="input100" type="text"
							name="IDVitri" placeholder="ID Vị trí">
					</div>
				</div>

				<div class="row">
					<div class="col-25">
						<label class="label-input100" for="message">Trạng thái tuyến cáp *</label>
					</div>
					<div class="col-75">
						<select class="w3-select" name="option">
							<option value="" disabled selected>Chọn Trạng thái tuyến cáp</option>
							<option value="1">Cáp chìm</option>
							<option value="2">Cáp nổi</option>
						</select>
					</div>
				</div>
				<div class="row">
					<input type="submit" value="Submit" /> <input type="submit"
						href=${pageContext.request.contextPath}/userManager value="Cancel" />
				</div>
			</form>
		</div>
	</div>
</body>
</html>