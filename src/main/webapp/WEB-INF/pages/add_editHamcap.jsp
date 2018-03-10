<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<link rel="stylesheet" type="text/css"
	href=${pageContext.request.contextPath}/css/add_editTuyencap.css />
<link rel="stylesheet" type="text/css"
	href=${pageContext.request.contextPath}/css/ApplicationStyle.css />

<script type="text/javascript"
	src=${pageContext.request.contextPath}/js/common.js></script>
<script type="text/javascript"
	src=${pageContext.request.contextPath}/js/jquery.min.js></script>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<p class="intro">${formTitle}</p>
	<hr>

	<div class="content">
		<div class="container"
			onload="var x = '${mode}'.localeCompare('edit');
			if(x==0){
				var element = document.getElementById('Macuaham');
				element.removeAttribute('disabled');  
				element.disabled = true;  }">
			<form:form action="saveHamcapInfo" method="POST"
				modelAttribute="hamcapInfo">
				<div class="row">
					<div class="col-25">
						<label class="label-input100" class="col-25" for="first-name">Mã
							Cửa hầm *</label>
					</div>
					<div class="col-75">
						<form:input id="Macuaham" class="input100" type="text"
							name="Macuaham" placeholder="Mã Cửa hầm" path="ham_cap_id" />
					</div>
				</div>

				<div class="row">
					<div class="col-25">
						<label class="label-input100" for="first-name">ID Vị trí</label>
					</div>
					<div class="col-75">
						<form:input id="IDVitri" class="input100" type="text"
							name="IDVitri" placeholder="ID Vị trí" path="vi_tri_id" />
					</div>
				</div>
				<div class="row">
					<div class="col-25">
						<label class="label-input100" for="first-name">Tên Hầm cáp</label>
					</div>
					<div class="col-75">
						<form:input id="ten_ham_cap" class="input100" type="text"
							name="ten_ham_cap" placeholder="Tên Hầm cáp" path="ten_ham_cap" />
					</div>
				</div>

				<div class="row">
					<div class="col-25">
						<label class="label-input100" for="message">Trạng thái
							tuyến cáp *</label>
					</div>
					<div class="col-75">
						<form:select class="w3-select" name="option" path="treo_ngam">
							<form:option value="1">Cáp chìm</form:option>
							<form:option value="2">Cáp treo</form:option>
						</form:select>
					</div>
				</div>
				<div class="row">
					<form:input type="submit" value="Submit" path="" />
					<a
						href=${pageContext.request.contextPath}/thietbi_cauhinh?subPageParam=hamcapView>cancel</a>
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>