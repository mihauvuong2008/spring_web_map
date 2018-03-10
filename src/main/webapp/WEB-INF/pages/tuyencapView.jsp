<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Xem danh sách tài khoản</title>
<link rel="stylesheet" type="text/css"
	href=${pageContext.request.contextPath}/css/ApplicationStyle.css />
</head>
<body>
	<p class="intro">Danh sách Hầm cáp</p>
	<hr>
	<div class="content">
		<table id="tableData">
			<tr>
				<th>Mã Tuyến cáp</th>
				<th>Tên Tuyến cáp</th>
				<th>Chiều dài</th>
				<th>Số core</th>
				<th>ID Vị trí điểm đầu</th>
				<th>ID Vị trí điểm cuối</th>
				<th>Mô tả</th>
				<th>thay đổi</th>
				<th>Xóa</th>
			</tr>

			<c:forEach var="tuyencap" items="${tuyencapData}" varStatus="status">
				<tr>
					<td>${tuyencap.getTuyen_cap_id()}</td>
					<td>${tuyencap.getTen_tuyen_cap()}</td>
					<td>${tuyencap.getChieu_dai_tuyen_cap()}</td>
					<td>${tuyencap.getSo_core()}</td>
					<td>${tuyencap.getVi_tri_diem_dau_id()}</td>
					<td>${tuyencap.getVi_tri_diem_cuoi_id()}</td>
					<td>${tuyencap.getMo_ta_tuyen_cap()}</td>
					<td><input type="submit" class="close"
						onclick="gotoEditPage('${hamcap.getHam_cap_id()}')"
						data-dismiss="alert"> sửa đổi </input></td>
					<td><input type="submit" class="close"
						onclick="yesNoBox('${hamcap.getHam_cap_id()}')"
						data-dismiss="alert"> Xóa </input></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<script>
		function gotoEditPage() {
			var link = "${pageContext.request.contextPath}/thietbi_cauhinh?subPageParam=editHamcap "
					+ "?hamcap_id=" + arguments[0] + "";
			location.href = link;
		}
		function yesNoBox() {
			var link = "${pageContext.request.contextPath}/deleteHamcap?hamcap_id="
					+ arguments[0];
			var answer = confirm("Xóa Vị trí: " + link + "?");
			if (answer) {
				location.href = link;
			} else {
				//some code
			}
		}
	</script>
</body>
</html>