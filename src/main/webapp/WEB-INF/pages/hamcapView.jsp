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
				<th>Mã Hầm cáp</th>
				<th>Tên Hầm cáp</th>
				<th>Trạng thái</th>
				<th>Mã vị trí</th>
				<th>thay đổi</th>
				<th>Xóa</th>
			</tr>
			<c:forEach var="hamcap" items="${hamcapData}" varStatus="status">
				<tr>
					<td>${hamcap.getHam_cap_id()}</td>
					<td>${hamcap.getTen_ham_cap()}</td>
					<td>${hamcap.getTreo_ngam()}</td>
					<td>${hamcap.getVi_tri_id()}</td>
					<td><input type="submit" class="close"
						onclick="gotoHam_capEditPage('${hamcap.getHam_cap_id()}')"
						data-dismiss="alert"> sửa đổi </input></td>
					<td><input type="submit" class="close"
						onclick="Ham_capyesNoBox('${hamcap.getHam_cap_id()}')"
						data-dismiss="alert"> Xóa </input></td>
				</tr>
			</c:forEach>

			<tr>
				<td><a
					href=${pageContext.request.contextPath}/thietbi_cauhinh?subPageParam=addHamcap>Thêm</a></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
		</table>
	</div>
	<script>
		function gotoHam_capEditPage() {
			var link = "${pageContext.request.contextPath}/thietbi_cauhinh?subPageParam=editHamcap "
					+ "?hamcap_id=" + arguments[0] + "";
			location.href = link;
		}
		function Ham_capyesNoBox() {
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