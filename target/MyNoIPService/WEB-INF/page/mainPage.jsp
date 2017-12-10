<!doctype html>
<html lang=''>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<head>
<meta charset='utf-8' />
<title>Web server - MyNoIPService</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" type="text/css"
	href=${pageContext.request.contextPath}/css/styles.css />
<script type="text/javascript"
	src=${pageContext.request.contextPath}/js/common.js>
	
</script>
</head>

<body>
	<jsp:include page="menu.jsp" />

	<div class="container">
		<article>
			<h1>private IP</h1>
			<p>
				<%
					out.print(request.getRemoteAddr() + "|" + request.getRemoteHost());
				%>
			</p>
			<hr>
			<h2>public IP</h2>
			<section>
				<div class="thirds">
					<p>
						<%
							out.print(request.getHeader("x-forwarded-for"));
						%>
					</p>
				</div>
			</section>
			<hr>
		</article>
		<footer>
			liên hệ: <a href="/MyNoIPService/lienhe" title="liên hệ"> link </a>
		</footer>
	</div>

	<script>
		// hightlight menu đã chọn
		setActiveLink("link1");
	</script>
</body>

</html>
