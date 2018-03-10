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
	href=${pageContext.request.contextPath}/css/userView.css />
<link rel="stylesheet" type="text/css"
	href=${pageContext.request.contextPath}/css/ApplicationStyle.css />
</head>
<body>
	<p class="intro">Danh sách tài khoản</p>
	<hr>
	<div class="content">
		<table id="tableData">
			<tr>
				<th>Tên tài khoản</th>
				<th>Họ và tên</th>
				<th>Ngày sinh</th>
				<th>Liên hệ</th>
				<th>Giới thiệu</th>
				<th>Ngày cập nhật</th>
				<th>Thay đổi</th>
				<th>Xóa</th>
			</tr>
			<c:forEach var="user" items="${userData}" varStatus="status">
				<tr>
					<td>${user.getUserName()}</td>
					<td>${user.getHoten()}</td>
					<td>${user.getNgaysinh()}</td>
					<td>${user.getLienhe()}</td>
					<td>${user.getGioithieu()}</td>
					<td>${user.getLast_modify()}</td>
					<td><input type="submit" class="close"
						onclick="gotoEditPage('${user.getUserName()}')"
						data-dismiss="alert"> sửa đổi </input></td>
					<td><input type="submit" class="close"
						onclick="yesNoBox('${user.getUserName()}')" data-dismiss="alert">
						Xóa </input></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<script>
		function gotoEditPage() {
			var link = "${pageContext.request.contextPath}/userManager?subPageParam=editUser "
					+ arguments[0];
			location.href = link;
		}
		function yesNoBox() {
			var link = "${pageContext.request.contextPath}/deleteUser?username="
					+ arguments[0];
			var answer = confirm("Xóa tài khoản: " + link + "?");
			if (answer) {
				location.href = link;
			} else {
				//some code
			}
		}
	</script>
</body>
</html>