/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2018-01-17 11:35:53 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class mainPage_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<!doctype html>\r\n");
      out.write("<html lang=''>\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset='utf-8' />\r\n");
      out.write("<title>Hạ tầng truyền dẫn</title>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\" />\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\"\r\n");
      out.write("\thref=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/ol.css />\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\"\r\n");
      out.write("\thref=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/main_style.css />\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\"\r\n");
      out.write("\thref=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/main_tool_style.css />\r\n");
      out.write("<script type=\"text/javascript\"\r\n");
      out.write("\tsrc=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/common.js></script>\r\n");
      out.write("<script type=\"text/javascript\"\r\n");
      out.write("\tsrc=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/ol.js></script>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "menu.jsp", out, false);
      out.write("\r\n");
      out.write("\t<script>\r\n");
      out.write("\t\t// hightlight menu ÄÃ£ chá»n\r\n");
      out.write("\t\tsetActiveLink(\"link1\");\r\n");
      out.write("\t</script>\r\n");
      out.write("\r\n");
      out.write("\t<!-- \t<a class=\"skiplink\" href=\"#map\">Go to map</a> -->\r\n");
      out.write("\r\n");
      out.write("\t<div id=\"container\">\r\n");
      out.write("\r\n");
      out.write("\t\t<div id=\"map\" class=\"map\" tabindex=\"0\"></div>\r\n");
      out.write("\r\n");
      out.write("\t\t<div id=\"tool\"></div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<script>\r\n");
      out.write("\t\tvar extent4269 = [ 11510897, 909947, 12211990, 1647390 ];\r\n");
      out.write("\r\n");
      out.write("\t\tvar projection4269 = new ol.proj.Projection({\r\n");
      out.write("\t\t\tcode : 'EPSG:3857',\r\n");
      out.write("\t\t\textent : extent4269,\r\n");
      out.write("\t\t\tunits : 'm'\r\n");
      out.write("\t\t});\r\n");
      out.write("\r\n");
      out.write("\t\tvar linelayer = new ol.layer.Tile({\r\n");
      out.write("\t\t\textent : extent4269,\r\n");
      out.write("\t\t\tsource : new ol.source.TileWMS({\r\n");
      out.write("\t\t\t\turl : 'http://localhost:8080/geoserver/wms',\r\n");
      out.write("\t\t\t\tparams : {\r\n");
      out.write("\t\t\t\t\t'LAYERS' : 'spring_web_map:planet_osm_line',\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\tserverType : 'geoserver'\r\n");
      out.write("\t\t\t})\r\n");
      out.write("\t\t});\r\n");
      out.write("\r\n");
      out.write("\t\tvar osm_polygonlayer = new ol.layer.Tile({\r\n");
      out.write("\t\t\textent : extent4269,\r\n");
      out.write("\t\t\tsource : new ol.source.TileWMS({\r\n");
      out.write("\t\t\t\turl : 'http://localhost:8080/geoserver/wms',\r\n");
      out.write("\t\t\t\tparams : {\r\n");
      out.write("\t\t\t\t\t'LAYERS' : 'spring_web_map:planet_osm_polygon',\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\tserverType : 'geoserver'\r\n");
      out.write("\t\t\t})\r\n");
      out.write("\t\t});\r\n");
      out.write("\r\n");
      out.write("\t\tosm_polygonlayer.setOpacity(0.6);\r\n");
      out.write("\t\tvar mousePositionControl = new ol.control.MousePosition({\r\n");
      out.write("\t\t\tcoordinateFormat : ol.coordinate.createStringXY(4),\r\n");
      out.write("\t\t\tundefinedHTML : '&nbsp;'\r\n");
      out.write("\t\t});\r\n");
      out.write("\r\n");
      out.write("\t\tvar scaleLineControl = new ol.control.ScaleLine();\r\n");
      out.write("\r\n");
      out.write("\t\tvar zoomslider = new ol.control.ZoomSlider();\r\n");
      out.write("\r\n");
      out.write("\t\tvar map = new ol.Map({\r\n");
      out.write("\t\t\tcontrols : ol.control.defaults().extend(\r\n");
      out.write("\t\t\t\t\t[ mousePositionControl, scaleLineControl, zoomslider ]),\r\n");
      out.write("\t\t\tlayers : [ osm_polygonlayer, linelayer ],\r\n");
      out.write("\t\t\ttarget : 'map',\r\n");
      out.write("\t\t\tpixelRatio : 1,\r\n");
      out.write("\t\t\tview : new ol.View({\r\n");
      out.write("\t\t\t\tprojection : projection4269,\r\n");
      out.write("\t\t\t\tcenter : [ 11876769.5, 1206878.5 ],\r\n");
      out.write("\t\t\t\tzoom : 7,\r\n");
      out.write("\t\t\t\tmaxZoom : 12\r\n");
      out.write("\t\t\t})\r\n");
      out.write("\t\t});\r\n");
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t// \t\tmap.addLayer(linelayer);\r\n");
      out.write("\t\t// \t\tmap.addLayer(roadslayer);\r\n");
      out.write("\t\twindow.onresize = function() {\r\n");
      out.write("\t\t\tsetTimeout(function() {\r\n");
      out.write("\t\t\t\tmap.updateSize();\r\n");
      out.write("\t\t\t}, 200);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t// an hien panel\r\n");
      out.write("\r\n");
      out.write("\t\tvar acc = document.getElementsByClassName(\"accordion\");\r\n");
      out.write("\t\tvar i;\r\n");
      out.write("\r\n");
      out.write("\t\tfor (i = 0; i < acc.length; i++) {\r\n");
      out.write("\t\t\tacc[i].addEventListener(\"click\", function() {\r\n");
      out.write("\t\t\t\tthis.classList.toggle(\"active\");\r\n");
      out.write("\t\t\t\tvar panel = this.nextElementSibling;\r\n");
      out.write("\t\t\t\tif (panel.style.display === \"block\") {\r\n");
      out.write("\t\t\t\t\tpanel.style.display = \"none\";\r\n");
      out.write("\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\tpanel.style.display = \"block\";\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t}\r\n");
      out.write("\t</script>\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
