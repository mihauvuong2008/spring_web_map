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
			<form:form action="savePointInfo" method="POST"
				modelAttribute="pointInfo">
				<div class="row">
					<div class="col-25">
						<label class="label-input100" class="col-25">Mã Vị trí *</label>
					</div>
					<div class="col-75">
						<!-- 			path là trường khai báo trong userInfo -->
						<form:input id="Point_id" class="input100" type="text"
							name="Point_id" placeholder="Mã Vị trí" path="point_id" />
					</div>
				</div>

				<div class="row">
					<div class="col-25">
						<label class="label-input100" for="first-name">Tọa độ X *</label>
					</div>
					<div class="col-75">
						<form:input id="x_data" class="input100" type="text" name="x_data"
							placeholder=" Tọa độ X" path="x_data" />
					</div>
				</div>

				<div class="row">
					<div class="col-25">
						<label class="label-input100" for="first-name">Tọa độ Y *</label>
					</div>
					<div class="col-75">
						<form:input id="y_data" class="input100" type="text" name="y_data"
							placeholder="Tọa độ Y" path="y_data" />
					</div>
				</div>

				<div class="row">
					<input type="submit" value="Submit" /> 
					<a  href=${pageContext.request.contextPath}/thietbi_cauhinh?subPageParam=pointView >cancel</a>
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>