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
	<p class="intro">Danh sách Vị trí</p>
	<hr>
	<div class="content">
		<table id="userlist">
			<tr>
				<th>Mã Vị trí</th>
				<th>Vĩ tuyến</th>
				<th>Kinh tuyến</th>
				<th>Thay đổi</th>
				<th>Xóa</th>
			</tr>
			<c:forEach var="point" items="${pointData}" varStatus="status">
				<tr>
					<td>${point.getPoint_id()}</td>
					<td>${point.getX_data()}</td>
					<td>${point.getY_data()}</td>
					<td><input type="submit" class="close"
						onclick="gotoEditPage('${point.getPoint_id()}')"
						data-dismiss="alert"> sửa đổi </input></td>
					<td><input type="submit" class="close"
						onclick="yesNoBox('${point.getPoint_id()}')" data-dismiss="alert">
						Xóa </input></td>
				</tr>
			</c:forEach>

			<tr>
				<td><a
					href=${pageContext.request.contextPath}/thietbi_cauhinh?subPageParam=addPoint>Thêm</a></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
		</table>
	</div>
	<script>
		function gotoEditPage() {
			var link = "${pageContext.request.contextPath}/thietbi_cauhinh?subPageParam=editPoint "
					+ arguments[0];
			location.href = link;
		}
		function yesNoBox() {
			var link = "${pageContext.request.contextPath}/deletePoint?point_id="
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