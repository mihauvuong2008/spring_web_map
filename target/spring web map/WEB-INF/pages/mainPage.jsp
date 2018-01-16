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

		<div class="leaflet-top leaflet-right">
			<div class="leaflet-control-grid map-tooltip leaflet-control"
				style="display: none;">
				<a class="close" href="#" title="close">close</a>
				<div class="map-tooltip-content"></div>
			</div>
			<div
				class="leaflet-control-mapbox-geocoder leaflet-bar leaflet-control">
				<a
					style="background-image:
		url(${pageContext.request.contextPath}/img/iconsearch.png);"
					class="leaflet-control-mapbox-geocoder-toggle mapbox-icon mapbox-icon-geocoder"
					href="#">&nbsp;</a>
				<div class="leaflet-control-mapbox-geocoder-results"></div>
				<div class="leaflet-control-mapbox-geocoder-wrap">
					<form class="leaflet-control-mapbox-geocoder-form">
						<input class="" placeholder="Search" type="text">
					</form>
				</div>
			</div>
			<div class="leaflet-draw leaflet-control">
				<div class="leaflet-draw-section">
					<div
						class="leaflet-draw-toolbar leaflet-bar leaflet-draw-toolbar-top leaflet-draw-toolbar-nobottom">
						<a class="leaflet-draw-draw-polyline" href="#"
							title="Draw a polyline"></a><a class="leaflet-draw-draw-polygon"
							href="#" title="Draw a polygon"></a><a
							class="leaflet-draw-draw-rectangle" href="#"
							title="Draw a rectangle"></a><a
							class="leaflet-draw-draw-marker leaflet-draw-toolbar-button-enabled"
							href="#" title="Draw a marker"></a>
					</div>
					<ul class="leaflet-draw-actions leaflet-draw-actions-bottom"
						style="top: 78px; display: block;">
						<li class=""><a class="" href="#" title="Cancel drawing">Cancel</a></li>
					</ul>
				</div>
				<div class="leaflet-draw-section">
					<div class="leaflet-draw-toolbar leaflet-bar">
						<a class="leaflet-draw-edit-edit" href="#" title="Edit layers."></a><a
							class="leaflet-draw-edit-remove" href="#" title="Delete layers."></a>
					</div>
					<ul class="leaflet-draw-actions" style="top: 0px; display: none;">
						<li class=""><a class="" href="#" title="Save changes.">Save</a></li>
						<li class=""><a class="" href="#"
							title="Cancel editing, discards all changes.">Cancel</a></li>
					</ul>
				</div>
			</div>
		</div>
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
