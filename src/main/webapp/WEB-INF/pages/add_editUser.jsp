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

	<div class="container-contact100 container">
		<form action="saveUserInfo" method="POST"  modelAttribute="userInfo">

    <div class="row">
      		<div class="col-25">
				<label class="label-input100" class="col-25" for="first-name">Tên tài khoản *</label> 
			</div>
			<div class="col-75">
				<input id="Username" class="input100" type="text" name="UserName" placeholder="Tên tài khoản"> 
			</div>
	</div>

    <div class="row">
      	<div class="col-25">
			<label class="label-input100" for="first-name">Họ và tên *</label> 
		</div>
		<div class="col-75">
			<input id="Hoten" class="input100" type="text" name="Hoten" placeholder="Họ và tên"> 
		</div>
	</div>

    <div class="row">
      	<div class="col-25">
			<label class="label-input100" for="first-name">Ngày sinh *</label> 
		</div>
		<div class="col-75">
			<input id="Ngaysinh" class="input100" type="date" name="Ngaysinh" placeholder="Ngày sinh"> 
		</div>
	</div>

    <div class="row">
      	<div class="col-25">
			<label class="label-input100" for="phone">Liên hệ</label>
		</div>
		<div class="col-75">
			<input id="lienhe" class="input100" type="text" name="Lienhe" placeholder="090xxxxxxxx, example@email.com"> 
		</div>
	</div>

    <div class="row">
      	<div class="col-25">
			<label class="label-input100" for="message">Giới thiệu *</label>
		</div>	
		<div class="col-75">
			<textarea id="message" class="input100" name="Gioithieu" placeholder="Mô tả tài khoản người dùng..."></textarea>
		</div>
	</div>

    <div class="row">
   			<input type="submit" value="Submit"/>
   			<input type="submit" href=${pageContext.request.contextPath}/userManager value="Cancel"/>
	</div>
		</form>
	</div>
</body>
</html>