/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.36
 * Generated at: 2018-08-02 20:02:29 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.yahoo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class yahoo_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(12);
    _jspx_dependants.put("/WEB-INF/lib/spring-webmvc-5.0.8.RELEASE.jar", Long.valueOf(1532985282749L));
    _jspx_dependants.put("jar:file:/C:/cygwin64/home/jts123/FinalProject/Internship/Tomcat/apache-tomcat-8.0.50/webapps/ProjectTemplate/WEB-INF/lib/spring-security-taglibs-4.2.7.RELEASE.jar!/META-INF/security.tld", Long.valueOf(1528874458000L));
    _jspx_dependants.put("/WEB-INF/lib/taglibs-standard-impl-1.2.5.jar", Long.valueOf(1528837673907L));
    _jspx_dependants.put("/WEB-INF/lib/spring-security-taglibs-4.2.7.RELEASE.jar", Long.valueOf(1529097384773L));
    _jspx_dependants.put("jar:file:/C:/cygwin64/home/jts123/FinalProject/Internship/Tomcat/apache-tomcat-8.0.50/webapps/ProjectTemplate/WEB-INF/lib/tiles-jsp-3.0.8.jar!/META-INF/tld/tiles-jsp.tld", Long.valueOf(1506823684000L));
    _jspx_dependants.put("jar:file:/C:/cygwin64/home/jts123/FinalProject/Internship/Tomcat/apache-tomcat-8.0.50/webapps/ProjectTemplate/WEB-INF/lib/spring-webmvc-5.0.8.RELEASE.jar!/META-INF/spring-form.tld", Long.valueOf(1532607906000L));
    _jspx_dependants.put("/WEB-INF/layouts/include.jsp", Long.valueOf(1533070815218L));
    _jspx_dependants.put("/WEB-INF/lib/tiles-jsp-3.0.8.jar", Long.valueOf(1528837674788L));
    _jspx_dependants.put("jar:file:/C:/cygwin64/home/jts123/FinalProject/Internship/Tomcat/apache-tomcat-8.0.50/webapps/ProjectTemplate/WEB-INF/lib/taglibs-standard-impl-1.2.5.jar!/META-INF/fn.tld", Long.valueOf(1425996670000L));
    _jspx_dependants.put("jar:file:/C:/cygwin64/home/jts123/FinalProject/Internship/Tomcat/apache-tomcat-8.0.50/webapps/ProjectTemplate/WEB-INF/lib/taglibs-standard-impl-1.2.5.jar!/META-INF/c.tld", Long.valueOf(1425996670000L));
    _jspx_dependants.put("jar:file:/C:/cygwin64/home/jts123/FinalProject/Internship/Tomcat/apache-tomcat-8.0.50/webapps/ProjectTemplate/WEB-INF/lib/taglibs-standard-impl-1.2.5.jar!/META-INF/fmt.tld", Long.valueOf(1425996670000L));
    _jspx_dependants.put("jar:file:/C:/cygwin64/home/jts123/FinalProject/Internship/Tomcat/apache-tomcat-8.0.50/webapps/ProjectTemplate/WEB-INF/lib/spring-webmvc-5.0.8.RELEASE.jar!/META-INF/spring.tld", Long.valueOf(1532607906000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody;

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

final java.lang.String _jspx_method = request.getMethod();
if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
return;
}

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div class=\"row\">\r\n");
      out.write("\t<h1 class=\"underline col-sm-12\">Last.FM Monitor</h1>\r\n");
      out.write("</div>\r\n");
      out.write("\t\r\n");
      out.write("\r\n");
      out.write("<div class=\"row well\">\r\n");
      out.write("\t<h2 class=\"col-sm-3\">Description</h2>\r\n");
      out.write("    <p class=\"col-sm-12\">\r\n");
      out.write("        This Last.FM monitor service will track the recently \"loved\" tracks for Opticronius \r\n");
      out.write("        record them to the database. The most recent loved track has been retrieved from\r\n");
      out.write("        the account and listed below in the table. A scheduler will monitor the inbox for new\r\n");
      out.write("        emails every 10 seconds. As a new email comes in, the table will be updated. Select\r\n");
      out.write("        the checkboxes below, enter a valid cellhpone number ###-###-####, press the \"send\" button,\r\n");
      out.write("         and then receive the loved songs below as an SMS message. Once the SMS message has been sent\r\n");
      out.write("         succesfully, the event is falgged as \"sent\" and the checkbox is removed.\r\n");
      out.write("    </p>\r\n");
      out.write("</div>\t\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<form action=\"\" class=\"form\" data-dojo-type=\"dijit/form/Form\" id=\"basicDialogForm\">\r\n");
      out.write("\t<div class=\"row\"> \r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<div class=\"form-group col-sm-3\">\r\n");
      out.write("\t\t\t<label for=\"\" class=\"control-label\">Phone Number</label> \r\n");
      out.write("\t\t\t<input class=\"form-control\"\r\n");
      out.write("\t\t\t\t   type=\"text\" \r\n");
      out.write("\t\t\t\t   name=\"phone\"\r\n");
      out.write("\t\t\t\t   data-dojo-type=\"dijit/form/ValidationTextBox\" \r\n");
      out.write("\t      \t\t   data-dojo-props=\"regExp:'[\\\\w]+'\"\r\n");
      out.write("\t      \t\t   placeholder=\"417-429-7123\"\r\n");
      out.write("\t\t\t/>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</form>\r\n");
      out.write("<div class=\"dijitDialogFooter\">\r\n");
      out.write("\t<button data-dojo-type=\"oreilly/types/form/Button\" \r\n");
      out.write("\t\t\tdata-dojo-props=\"spinOnClick: false\" \r\n");
      out.write("\t\t\tclass=\"btn btn-primary\" \r\n");
      out.write("\t\t\ttype=\"submit\" \r\n");
      out.write("\t\t\tid=\"basicFormSubmitBtn\"> Submit\r\n");
      out.write("\t</button>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\r\n");
      out.write("<div class=\"row mt10\">\r\n");
      out.write("\t<div class=\"col-sm-12\">\r\n");
      out.write("\t\t<div class=\"table-responsive\">\r\n");
      out.write("\t\t\t<!-- Declare the memory store -->\r\n");
      out.write("\t\t\t<div data-dojo-id=\"carPartStore\" data-dojo-type=\"dojo/store/Memory\"\r\n");
      out.write("\t\t\t\tdata-dojo-props=\"data: [], idProperty: 'partNumber'\"></div>\r\n");
      out.write("\t\t\t<!-- Build the table (head only) -->\r\n");
      out.write("\t\t\t<div id=\"table-container4\" class=\"span12\">\r\n");
      out.write("\t\t\t\t<table id=\"carParts\" class=\"table table-striped table-bordered\"\r\n");
      out.write("\t\t\t\t\tdata-dojo-type=\"oreilly/types/dgrid/PagingGrid\"\r\n");
      out.write("\t\t\t\t\tdata-dojo-props=\"store: carPartStore, loadDataOnStartup: true\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<thead>\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<th class=\"hyperlink\"\r\n");
      out.write("\t\t\t\t\t\t\t\tdata-dgrid-column='{field: \"eventId\",name: \"eventId\"}'>Event\r\n");
      out.write("\t\t\t\t\t\t\t\tId</th>\r\n");
      out.write("\t\t\t\t\t\t\t<th class=\"hyperlink\"\r\n");
      out.write("\t\t\t\t\t\t\t\tdata-dgrid-column='{field: \"eventDate\", name: \"eventDate\"}'>Event\r\n");
      out.write("\t\t\t\t\t\t\t\tDate</th>\r\n");
      out.write("\t\t\t\t\t\t\t<th class=\"hyperlink\"\r\n");
      out.write("\t\t\t\t\t\t\t\tdata-dgrid-column='{field: \"lovedDate\", name: \"LovedDate\"}'>Loved\r\n");
      out.write("\t\t\t\t\t\t\t\tDate</th>\r\n");
      out.write("\t\t\t\t\t\t\t<th class=\"hyperlink\"\r\n");
      out.write("\t\t\t\t\t\t\t\tdata-dgrid-column='{field: \"trackName\", name: \"trackName\"}'>Track\r\n");
      out.write("\t\t\t\t\t\t\t\tName</th>\r\n");
      out.write("\t\t\t\t\t\t\t<th class=\"hyperlink\"\r\n");
      out.write("\t\t\t\t\t\t\t\tdata-dgrid-column='{field: \"artistName\", name: \"artistName\"}'>Artist\r\n");
      out.write("\t\t\t\t\t\t\t\tName</th>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t</thead>\r\n");
      out.write("\t\t\t\t</table>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<div class=\"row hidden\"></div>\r\n");
      out.write("\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\trequire([ 'dojo/request', 'dijit/registry', 'dojo/ready' ], function(\r\n");
      out.write("\t\t\trequest, registry, ready) {\r\n");
      out.write("\t\tready(function() {\r\n");
      out.write("\t\t\tvar grid = registry.byId(\"carParts\");\r\n");
      out.write("\t\t\tvar store = registry.byId(\"carPartStore\");\r\n");
      out.write("\t\t\trequest('");
      if (_jspx_meth_c_005furl_005f0(_jspx_page_context))
        return;
      out.write("').then(function(data) {\r\n");
      out.write("\t\t\t\tgrid.store.setData(JSON.parse(data));\r\n");
      out.write("\t\t\t\tgrid.refresh();\r\n");
      out.write("\t\t\t}, function(err) {\r\n");
      out.write("\t\t\t\tconsole.log(\"Error: \" + err);\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\tgrid.refresh();\r\n");
      out.write("\t\t});\r\n");
      out.write("\t});\r\n");
      out.write("</script>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005furl_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f0 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f0.setParent(null);
    // /WEB-INF/views/yahoo/yahoo.jsp(95,12) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f0.setValue("/yahoo/getYahoo");
    int _jspx_eval_c_005furl_005f0 = _jspx_th_c_005furl_005f0.doStartTag();
    if (_jspx_th_c_005furl_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f0);
    return false;
  }
}
