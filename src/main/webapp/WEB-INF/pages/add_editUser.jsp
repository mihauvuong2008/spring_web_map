<%@page import="spring_web_map.model.UserInfo"%>
<%@page session="true"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>${formTitle}</title>
<link rel="stylesheet" type="text/css"
	href=${pageContext.request.contextPath}/css/add_editUser.css />
<link rel="stylesheet" type="text/css"
	href=${pageContext.request.contextPath}/css/ApplicationStyle.css />
</head>
<body>
	<p class="intro">${formTitle}</p>
	<hr>
	
	<div class="content">
		<div class="container  ">
			<form:form  action="saveUserInfo" method="POST"  modelAttribute="userInfo">
			<% UserInfo userInfo=((UserInfo)request.getAttribute("userInfo"));%>
		    <div class="row">
		      		<div class="col-25">
						<label class="label-input100" class="col-25" for="first-name">Tên tài khoản *</label> 
					</div>
					<div class="col-75">
		<!-- 			path là trường khai báo trong userInfo -->
						<form:input id="Username" class="input100" type="text" name="UserName" placeholder="Tên tài khoản"   path="userName"/>
					</div>
			</div>
		
		    <div class="row">
		      	<div class="col-25">
					<label class="label-input100" for="first-name">Họ và tên *</label> 
				</div>
				<div class="col-75">
					<form:input id="hoten" class="input100" type="text" name="hoten" placeholder="Họ và tên" path="hoten"/> 
				</div>
			</div>
		
		    <div class="row">
		      	<div class="col-25">
					<label class="label-input100" for="first-name">Ngày sinh *</label> 
				</div>
				<div class="col-75">
					<form:input id="Ngaysinh" class="input100" type="date" name="Ngaysinh" placeholder="Ngày sinh" path="ngaysinh"/> 
				</div>
			</div>
		
		    <div class="row">
		      	<div class="col-25">
					<label class="label-input100" for="phone">Liên hệ</label>
				</div>
				<div class="col-75">
					<form:input id="lienhe" class="input100" type="text" name="Lienhe" placeholder="090xxxxxxxx, example@email.com" path="lienhe"/> 
				</div>
			</div>
	
		    <div class="row">
		      	<div class="col-25">
					<label class="label-input100" for="message">Giới thiệu *</label>
				</div>	
				<div class="col-75">
					<form:textarea id="message" class="input100" name="Gioithieu" placeholder="Mô tả tài khoản người dùng..." path="gioithieu"/>
				</div>
			</div>
		
		    <div class="row">
		   			<input type="submit" value="Submit"/>
		   			<a type="submit" href=${pageContext.request.contextPath}/userManager?subPageParam=userView >Cancel</a>
			</div>
			</form:form >
		</div>
	</div>
</body>
</html>