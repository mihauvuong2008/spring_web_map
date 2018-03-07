<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>

<head>
<title>Quản lý tài khoản</title>
<link rel="stylesheet" type="text/css"
	href=${pageContext.request.contextPath}/css/userManagerStyle.css />
<script type="text/javascript"
	src=${pageContext.request.contextPath}/js/common.js></script>
<script type="text/javascript"
	src=${pageContext.request.contextPath}/js/jquery.min.js></script>
</head>

<body onload="
			// Load on first time
			var link ='${pageContext.request.contextPath}/${subPageParam}';
			var x = '${subPageParam2}'.localeCompare('null');
			if(x!=0){
				link = link.concat('?username=${subPageParam2}');
			};
			 $('.loaded_content').load(link); ">
	<jsp:include page="menu.jsp" />

	<script>
		// hightlight menu ÄÃ£ chá»n
		setActiveLink("link6");

		$(document).ready(function() {
			// your on click function here
			$('.loadContent').click(function(event) {
				event.preventDefault();
				$('.loaded_content').load($(this).attr('href'));
				return false;
			});
		});
		document.getElementById('danhsach').focus();
	</script>
	<div id="contentWrapper">

		<div id="contentleft">
			<nav class="nav" role="navigation">
				<ul class="nav__list">
				
					<li>
						<input id="group-2" type="checkbox" hidden=true checked/> 
						<label for="group-2"> <span class="fa fa-angle-right" ></span>
							Quản lý tài khoản
						</label>
						<ul class="group-list">
							<li>
								<a class="loadContent" href=${pageContext.request.contextPath}/addUser>Tạo tài khoản mới</a>
							</li>
							<li>
								<a class="loadContent" id ="danhsach" href=${pageContext.request.contextPath}/userView>Danh sách tài khoản</a>
							</li>
							<li>
								<a class="loadContent" id ="danhsach" href=${pageContext.request.contextPath}/userView>Cài đặt chung</a>
							</li>
							<input id="sub-group-2" type="checkbox" hidden=true />
						</ul>
					</li>
					<li>
						<input id="group-3" type="checkbox" hidden=true checked/> 
							<label for="group-3"><span class="fa fa-angle-right"></span> Quản lý phân quyền</label>
						<ul class="group-list">
							<li><a class="loadContent" href="#">Thêm quyền</a></li>
							<li><a class="loadContent" href="#">Danh sách quyền</a></li>
							<li><a class="loadContent" href="#">Phân quyền</a></li>
							<input id="sub-group-3" type="checkbox" hidden=true />
						</ul>
					</li>
<!-- 					<li> -->
<!-- 						<input id="group-4" type="checkbox" hidden=true />  -->
<!-- 							<label class="loadContent" href="#" for="group-4"> -->
<!-- 								<span class="fa fa-angle-right"></span> Phân quyền -->
<!-- 							</label> -->
<!-- 					</li> -->
				</ul>
			</nav>
		</div>

		<div class='loaded_content' id="contentRight"></div>

	</div>

</body>
</html>