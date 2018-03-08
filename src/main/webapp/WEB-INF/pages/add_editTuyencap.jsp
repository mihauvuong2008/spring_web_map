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

	<p class="intro">${formTitle}</p>
	<hr>

	<div class="content">
		<div class="container-contact100 container">
			<form action="saveTuyencapInfo" method="POST"
				modelAttribute="tuyencapInfo">

				<div class="row">
					<div class="col-25">
						<label class="label-input100" class="col-25">Mã tuyến cáp
							*</label>
					</div>
					<div class="col-75">
						<input id="Matuyencap" class="input100" type="text"
							name="Matuyencap" placeholder="Mã tuyến cáp">
					</div>
				</div>

				<div class="row">
					<div class="col-25">
						<label class="label-input100">Tên tuyến cáp *</label>
					</div>
					<div class="col-75">
						<input id="Tentuyencap" class="input100" type="text"
							name="Tentuyencap" placeholder="Tên Tuyến cáp">
					</div>
				</div>

				<div class="row">
					<div class="col-25">
						<label class="label-input100">Chiều dài *</label>
					</div>
					<div class="col-75">
						<input id="Chieudai" class="input100" type="text" name="Chieudai"
							placeholder="Chiều dài">
					</div>
				</div>

				<div class="row">
					<div class="col-25">
						<label class="label-input100">Số core</label>
					</div>
					<div class="col-75">
						<input id="Socore" class="input100" type="text" name="Socore"
							placeholder="Số core">
					</div>
				</div>

				<div class="row">
					<div class="col-25">
						<label class="label-input100">ID Vị trí điểm đầu *</label>
					</div>
					<div class="col-75">
						<input id="Diemdau" class="input100" type="text" name="Diemdau"
							placeholder="ID Vị trí điểm đầu..."></input>
					</div>
				</div>
				<div class="row">
					<div class="col-25">
						<label class="label-input100">ID Vị trí điểm cuối *</label>
					</div>
					<div class="col-75">
						<input id="" Diemcuoi"" class="input100" type="text"
							name="Diemcuoi" placeholder="ID Vị trí điểm cuối"></input>
					</div>
				</div>
				<div class="row">
					<div class="col-25">
						<label class="label-input100">Mô tả tuyến cáp *</label>
					</div>
					<div class="col-75">
						<textarea id="message" class="input100" name="Gioithieu"
							placeholder="Mô tả tuyến cáp..."></textarea>
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