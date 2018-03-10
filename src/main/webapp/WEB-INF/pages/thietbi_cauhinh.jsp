<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<head>
<title>Hạ tầng truyền dẫn</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" type="text/css"
	href=${pageContext.request.contextPath}/css/ThietbiHatangStyle.css />
<script type="text/javascript"
	src=${pageContext.request.contextPath}/js/common.js></script>
<script type="text/javascript"
	src=${pageContext.request.contextPath}/js/jquery.min.js></script>
</head>
</head>


<body
	onload="
			// Load on first time
			var link ='${pageContext.request.contextPath}/${subPageParam}';
			var x = '${subPageParam2}'.localeCompare('null');
			if(x!=0){
				link = link.concat('${subPageParam2}');
			};
			 $('.loaded_content').load(link); 
			 ">
	<jsp:include page="menu.jsp" />

	<script>
		// hightlight menu ÄÃ£ chá»n
		setActiveLink("link2");

		$(document).ready(function() {
			// your on click function here
			$('.label-for-check').click(function(event) {
				$('.loaded_content').load($(this).attr('href'));
				document.getElementById("checkbox").checked = true;
				return false;
			});
		});
	</script>
	<div id="contentWrapper">

		<div id="contentleft">
			<nav class="nav" role="navigation">
				<ul class="nav__list">

					<li><input id="group-1" class="check-with-label" type="radio"
						name="radio" hidden=true /> <label class="label-for-check"
						href=${pageContext.request.contextPath}/addTuyencap for="group-1">
							<span class="fa fa-angle-right"></span> Thêm Tuyến cáp
					</label></li>
					<li><input id="group-3" class="check-with-label" type="radio"
						name="radio" hidden=true /> <label class="label-for-check"
						href=${pageContext.request.contextPath}/tuyencapView for="group-3">
							<span class="fa fa-angle-right"></span> Danh sách Tuyến cáp
					</label></li>
					<li><input id="group-2" class="check-with-label" type="radio"
						name="radio" hidden=true /> <label class="label-for-check"
						href=${pageContext.request.contextPath}/vitriCuaham for="group-2">
							<span class="fa fa-angle-right"></span> Vị trí Cửa hầm
					</label></li>
					<li><input id="group-4" class="check-with-label" type="radio"
						name="radio" hidden=true /> <label class="label-for-check"
						href="#" for="group-4"> <span class="fa fa-angle-right"></span>
							Quản lý Tuyến cáp
					</label></li>

				</ul>
			</nav>
		</div>

		<div class='loaded_content' id="contentRight"></div>

	</div>

</body>

</html>
