<!doctype html>
<html lang=''>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<head>
<meta charset='utf-8' />
<title>Hạ tầng truyền dẫn</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" type="text/css"
	href=${pageContext.request.contextPath}/css/ol.css />
<link rel="stylesheet" type="text/css"
	href=${pageContext.request.contextPath}/css/main_style.css />
<link rel="stylesheet" type="text/css"
	href=${pageContext.request.contextPath}/css/main_tool_style.css />
<script type="text/javascript"
	src=${pageContext.request.contextPath}/js/common.js></script>
<script type="text/javascript"
	src=${pageContext.request.contextPath}/js/ol.js></script>
</head>

<body>
	<jsp:include page="menu.jsp" />
	<script>
		// hightlight menu ÄÃ£ chá»n
		setActiveLink("link1");
	</script>

	<!-- 	<a class="skiplink" href="#map">Go to map</a> -->

	<div id="container">

		<div id="map" class="map" tabindex="0"></div>

		<div id="tool"></div>
	</div>
	<script>
		var extent4269 = [ 11510897, 909947, 12211990, 1647390 ];

		var projection4269 = new ol.proj.Projection({
			code : 'EPSG:3857',
			extent : extent4269,
			units : 'm'
		});

		var linelayer = new ol.layer.Tile({
			extent : extent4269,
			source : new ol.source.TileWMS({
				url : 'http://localhost:8080/geoserver/wms',
				params : {
					'LAYERS' : 'spring_web_map:planet_osm_line',
				},
				serverType : 'geoserver'
			})
		});

		var osm_polygonlayer = new ol.layer.Tile({
			extent : extent4269,
			source : new ol.source.TileWMS({
				url : 'http://localhost:8080/geoserver/wms',
				params : {
					'LAYERS' : 'spring_web_map:planet_osm_polygon',
				},
				serverType : 'geoserver'
			})
		});

		osm_polygonlayer.setOpacity(0.6);
		var mousePositionControl = new ol.control.MousePosition({
			coordinateFormat : ol.coordinate.createStringXY(4),
			undefinedHTML : '&nbsp;'
		});

		var scaleLineControl = new ol.control.ScaleLine();

		var zoomslider = new ol.control.ZoomSlider();

		var map = new ol.Map({
			controls : ol.control.defaults().extend(
					[ mousePositionControl, scaleLineControl, zoomslider ]),
			layers : [ osm_polygonlayer, linelayer ],
			target : 'map',
			pixelRatio : 1,
			view : new ol.View({
				projection : projection4269,
				center : [ 11876769.5, 1206878.5 ],
				zoom : 7,
				maxZoom : 12
			})
		});

		
		// 		map.addLayer(linelayer);
		// 		map.addLayer(roadslayer);
		window.onresize = function() {
			setTimeout(function() {
				map.updateSize();
			}, 200);
		}
		// an hien panel

		var acc = document.getElementsByClassName("accordion");
		var i;

		for (i = 0; i < acc.length; i++) {
			acc[i].addEventListener("click", function() {
				this.classList.toggle("active");
				var panel = this.nextElementSibling;
				if (panel.style.display === "block") {
					panel.style.display = "none";
				} else {
					panel.style.display = "block";
				}
			});
		}
	</script>
</body>


</html>
