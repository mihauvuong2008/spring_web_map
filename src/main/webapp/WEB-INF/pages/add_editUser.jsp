<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>${formTitle}</title>
<link rel="stylesheet" type="text/css"
	href=${pageContext.request.contextPath}/css/add_editUser.css />
</head>
<body>

	<div class="container-contact100">
		<form action="saveUserInfo" method="POST"  modelAttribute="userInfo">

			<label class="label-input100" for="first-name">Tên tài khoản *</label> 
			<input id="Username" class="input100" type="text" name="UserName" placeholder="Tên tài khoản"> 

			<label class="label-input100" for="first-name">Họ và tên *</label> 
			<input id="Hoten" class="input100" type="text" name="Hoten" placeholder="Họ và tên"> 

			<label class="label-input100" for="first-name">Ngày sinh *</label> 
			<input id="Ngaysinh" class="input100" type="date" name="Ngaysinh" placeholder="Ngày sinh"> 

			<label class="label-input100" for="phone">Liên hệ</label>
			<input id="lienhe" class="input100" type="text" name="Lienhe" placeholder="090xxxxxxxx, example@email.com"> 

			<label class="label-input100" for="message">Giới thiệu *</label>
			<textarea id="message" class="input100" name="Gioithieu" placeholder="Mô tả tài khoản người dùng..."></textarea>

   			<input type="submit" value="Submit">
			<a href=${pageContext.request.contextPath}/userManager>Cancel</a>
		</form>
	</div>
</body>
</html>