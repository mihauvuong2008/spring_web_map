<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang=''>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<head>
<meta charset='utf-8' />

<title>Login</title>
<link rel="stylesheet" type="text/css"
	href=${pageContext.request.contextPath}/css/styles.css />
<link rel="stylesheet" type="text/css"
	href=${pageContext.request.contextPath}/css/login_form_style.css />
<script type="text/javascript"
	src=${pageContext.request.contextPath}/js/common.js></script>
</head>
<body>

	<div class="body"></div>
	<div class="grad"></div>
	<div class="header">
		<div>
			Site<span>Login</span>
		</div>
	</div>

	<!-- /login?error=true -->
	<c:if test="${param.error == 'true'}">
		<div style="color: red; margin: 10px 0px;">

			Login Failed!!!<br /> Reason :
			${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}

		</div>
	</c:if>

	<h3>Enter user name and password:</h3>

	<form class="login" name='f'
		action="${pageContext.request.contextPath}/j_spring_security_check"
		method='POST'>
		<table>
			<tr>
				<td>User:</td>
				<td><input type="text" placeholder="username" name="username"></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="password" placeholder="password"
					name="password"></td>
			</tr>
			<tr>
				<td></td>
				<td><input name="submit" type="submit" value="Login" /></td>
			</tr>
		</table>
	</form>
</body>
</html>