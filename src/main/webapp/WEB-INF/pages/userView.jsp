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
</head>
<body>
	<div>
		Danh sách tài khoản
	</div>
	<div id="userlist">
		<table id="userlist">
			<tr>
				<th>Tên tài khoản</th>
				<th>Họ và tên</th>
				<th>Ngày sinh</th>
				<th>Liên hệ</th>
				<th>Giới thiệu</th>
				<th>Ngày cập nhật</th>
			</tr>
			<c:forEach var="user" items="${userData}" varStatus="status">
				<tr>
					<td>${user.getUserName()}</td>
					<td>${user.getHoten()}</td>
					<td>${user.getNgaysinh()}</td>
					<td>${user.getLienhe()}</td>
					<td>${user.getGioithieu()}</td>
					<td>${user.getLast_modify()}</td>
				</tr>
			</c:forEach>
		</table>
	</div>

</body>
</html>