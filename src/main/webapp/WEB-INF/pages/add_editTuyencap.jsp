<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div>Thông tin tuyến cáp</div>
	<div id="tuyencaplist">
		<table id="tuyencaplist">
			<tr>
				<td>${tuyencapInfo.getTuyen_cap_id()}</td>
				<td>${tuyencapInfo.getTen_tuyen_cap()}</td>
				<td>${tuyencapInfo.getChieu_dai_tuyen_cap()}</td>
				<td>${tuyencapInfo.getSo_core()}</td>
				<td>${tuyencapInfo.getVi_tri_diem_dau_id()}</td>
				<td>${tuyencapInfo.getVi_tri_diem_cuoi()}</td>
				<td>${tuyencapInfo.getMo_ta_tuyen_cap()}</td>
			</tr>
		</table>


		<div class="container-contact100 container">
			<form action="saveUserInfo" method="POST" modelAttribute="userInfo">

				<div class="row">
					<div class="col-25">
						<label class="label-input100" class="col-25" for="first-name">Mã
							tuyến cáp *</label>
					</div>
					<div class="col-75">
						<input id="Username" class="input100" type="text" name="UserName"
							placeholder="Tên tài khoản">
					</div>
				</div>

				<div class="row">
					<div class="col-25">
						<label class="label-input100" for="first-name">Tên tuyến
							cáp *</label>
					</div>
					<div class="col-75">
						<input id="Hoten" class="input100" type="text" name="Hoten"
							placeholder="Họ và tên">
					</div>
				</div>

				<div class="row">
					<div class="col-25">
						<label class="label-input100" for="first-name">Chiều dài *</label>
					</div>
					<div class="col-75">
						<input id="Ngaysinh" class="input100" type="date" name="Ngaysinh"
							placeholder="Ngày sinh">
					</div>
				</div>

				<div class="row">
					<div class="col-25">
						<label class="label-input100" for="phone">Số core</label>
					</div>
					<div class="col-75">
						<input id="lienhe" class="input100" type="text" name="Lienhe"
							placeholder="090xxxxxxxx, example@email.com">
					</div>
				</div>

				<div class="row">
					<div class="col-25">
						<label class="label-input100" for="message">Vị trí điểm
							đầu *</label>
					</div>
					<div class="col-75">
						<textarea id="message" class="input100" name="Gioithieu"
							placeholder="Mô tả tài khoản người dùng..."></textarea>
					</div>
				</div>
				<div class="row">
					<div class="col-25">
						<label class="label-input100" for="message">Vị trí điểm
							cuối *</label>
					</div>
					<div class="col-75">
						<textarea id="message" class="input100" name="Gioithieu"
							placeholder="Mô tả tài khoản người dùng..."></textarea>
					</div>
				</div>
				<div class="row">
					<div class="col-25">
						<label class="label-input100" for="message">Mô tả tuyến cáp *</label>
					</div>
					<div class="col-75">
						<textarea id="message" class="input100" name="Gioithieu"
							placeholder="Mô tả tài khoản người dùng..."></textarea>
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