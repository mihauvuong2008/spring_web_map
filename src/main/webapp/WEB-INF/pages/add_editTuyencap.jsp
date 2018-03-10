<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" type="text/css"
	href=${pageContext.request.contextPath}/css/add_editTuyencap.css />
<link rel="stylesheet" type="text/css"
	href=${pageContext.request.contextPath}/css/ApplicationStyle.css />
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<p class="intro">${formTitle}</p>
	<hr>

	<div class="content">
		<div class="container">
			<form:form action="saveTuyencapInfo" method="POST"
				modelAttribute="tuyencapInfo">

				<div class="row">
					<div class="col-25">
						<label class="label-input100" class="col-25">Mã tuyến cáp
							*</label>
					</div>
					<div class="col-75">
						<form:input id="Matuyencap" class="input100" type="text"
							name="Matuyencap" placeholder="Mã tuyến cáp" path="tuyen_cap_id" />
					</div>
				</div>

				<div class="row">
					<div class="col-25">
						<label class="label-input100">Tên tuyến cáp *</label>
					</div>
					<div class="col-75">
						<form:input id="Tentuyencap" class="input100" type="text"
							name="Tentuyencap" placeholder="Tên Tuyến cáp"
							path="ten_tuyen_cap" />
					</div>
				</div>

				<div class="row">
					<div class="col-25">
						<label class="label-input100">Chiều dài *</label>
					</div>
					<div class="col-75">
						<form:input id="Chieudai" class="input100" type="text"
							name="Chieudai" placeholder="Chiều dài"
							path="chieu_dai_tuyen_cap" />
					</div>
				</div>

				<div class="row">
					<div class="col-25">
						<label class="label-input100">Số core</label>
					</div>
					<div class="col-75">
						<form:input id="Socore" class="input100" type="text" name="Socore"
							placeholder="Số core" path="so_core" />
					</div>
				</div>

				<div class="row">
					<div class="col-25">
						<label class="label-input100">ID Vị trí điểm đầu *</label>
					</div>
					<div class="col-75">
						<form:input id="Diemdau" class="input100" type="text"
							name="Diemdau" placeholder="ID Vị trí điểm đầu..."
							path="vi_tri_diem_dau_id" />
					</div>
				</div>
				<div class="row">
					<div class="col-25">
						<label class="label-input100">ID Vị trí điểm cuối *</label>
					</div>
					<div class="col-75">
						<form:input id="Diemcuoi" class="input100" type="text"
							name="Diemcuoi" placeholder="ID Vị trí điểm cuối"
							path="vi_tri_diem_cuoi_id" />
					</div>
				</div>
				<div class="row">
					<div class="col-25">
						<label class="label-input100">Mô tả tuyến cáp *</label>
					</div>
					<div class="col-75">
						<form:textarea id="message" class="input100" name="Gioithieu"
							placeholder="Mô tả tuyến cáp..." path="mo_ta_tuyen_cap" />
					</div>
				</div>
				<div class="row">
					<input type="submit" value="Submit" /> <input type="reset"
						value="Reset" />
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>