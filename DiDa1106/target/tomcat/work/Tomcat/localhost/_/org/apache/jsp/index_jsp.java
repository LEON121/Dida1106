/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2018-11-10 08:38:17 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"utf-8\">\r\n");
      out.write("    <meta name=\"viewport\"\r\n");
      out.write("          content=\"width=device-width, initial-scale=1, maximum-scale=1\">\r\n");
      out.write("    <title>滴答办公系统-主页</title>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/media/layui/css/layui.css\" media=\"all\">\r\n");
      out.write("    <!-- <link rel=\"stylesheet\" type=\"text/css\" href=\"http://www.jq22.com/jquery/font-awesome.4.6.0.css\"> -->\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/media/css/app.css\" media=\"all\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/media/css/font-awesome.min.css\">\r\n");
      out.write("    <style type=\"text/css\">\r\n");
      out.write("        iframe{\r\n");
      out.write("            width: 98%;\r\n");
      out.write("            height: 98%;\r\n");
      out.write("        }\r\n");
      out.write("        .layui-tab-item{\r\n");
      out.write("            height: 98%;\r\n");
      out.write("        }\r\n");
      out.write("    </style>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("<div class=\"layui-layout layui-layout-admin kit-layout-admin\">\r\n");
      out.write("    <div class=\"layui-header\">\r\n");
      out.write("        <div class=\"layui-logo\" >\r\n");
      out.write("         \r\n");
      out.write("            <img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/media/images/qf_logo.png\" style=\"margin-right: 10px\"/><span\r\n");
      out.write("                style=\"font-size: 22px\" >滴答办公系统</span>\r\n");
      out.write("         \r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <!-- 头部区域（可配合layui已有的水平导航） -->\r\n");
      out.write("        <ul class=\"layui-nav layui-layout-left\">\r\n");
      out.write("            <li class=\"layui-nav-item kit-side-fold\" lay-unselect >\r\n");
      out.write("                <a href=\"javascript:flexible();\" title=\"侧边伸缩\">\r\n");
      out.write("                    <i class=\"layui-icon layui-icon-shrink-right\" id=\"LAY_flexible\"></i>\r\n");
      out.write("                </a>\r\n");
      out.write("\r\n");
      out.write("            </li>\r\n");
      out.write("            <li class=\"layui-nav-item\" lay-unselect>\r\n");
      out.write("                <a href=\"index.jsp\" layadmin-event=\"refresh\" title=\"刷新\">\r\n");
      out.write("                    <i class=\"layui-icon layui-icon-refresh-3\"></i>\r\n");
      out.write("                </a>\r\n");
      out.write("            </li>\r\n");
      out.write("        </ul>\r\n");
      out.write("        <ul class=\"layui-nav layui-layout-right\">\r\n");
      out.write("            <li class=\"layui-nav-item\" style=\"margin-right: 20px\">\r\n");
      out.write("                <a href=\"javascript:showTab(1001,'processlist.html','待办事项');\">待办事项<span class=\"layui-badge\">99+</span></a>\r\n");
      out.write("            </li>\r\n");
      out.write("            <li class=\"layui-nav-item\">\r\n");
      out.write("                <a href=\"javascript:;\">\r\n");
      out.write("                    <img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/media/images/qf_logo.png\" class=\"layui-nav-img\">\r\n");
      out.write("                    ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${lguser.username }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\r\n");
      out.write("                </a>\r\n");
      out.write("                <dl class=\"layui-nav-child\">\r\n");
      out.write("                    <dd><a href=\"javascript:showTab(1001,'userInfo.jsp','我的信息');\">我的信息</a></dd>\r\n");
      out.write("                    <dd><a href=\"javascript:showTab(1001,'photo.jsp','更改头像');\">更改头像</a></dd>\r\n");
      out.write("                    <dd><a href=\"javascript:showTab(1002,'password.jsp','修改密码');\">修改密码</a></dd>\r\n");
      out.write("                </dl>\r\n");
      out.write("            </li>\r\n");
      out.write("            <li class=\"layui-nav-item\"><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/user/logout\">注销</a></li>\r\n");
      out.write("        </ul>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <div class=\"layui-side layui-bg-black \">\r\n");
      out.write("        <div class=\"layui-side-scroll\">\r\n");
      out.write("\r\n");
      out.write("            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->\r\n");
      out.write("            <ul class=\"layui-nav layui-nav-tree\"  lay-shrink=\"all\" id=\"lm\">\r\n");
      out.write("            \r\n");
      out.write("            \t<li class=\"layui-nav-item\">\r\n");
      out.write("\t\t\t     <a href=\"javascript:;\" id=\"1\"><i class=\"layui-icon layui-icon-app\"></i>&nbsp;我的工具</a>\r\n");
      out.write("\t\t\t      <dl class=\"layui-nav-child\">\r\n");
      out.write("\t\t\t      \t  <dd><a href=\"javascript:;\" id=\"2\" onclick=\"showTab(1,'clock.jsp','我的日历')\">&nbsp;&nbsp;&nbsp;&nbsp;我的日历</a></dd>\r\n");
      out.write("\t\t\t      \t  <dd><a href=\"javascript:;\" id=\"2\" onclick=\"showTab(2,'weather.jsp','天气查询')\">&nbsp;&nbsp;&nbsp;&nbsp;天气查询</a></dd>\r\n");
      out.write("\t\t\t      \t  <dd><a href=\"javascript:;\" id=\"2\" onclick=\"showTab(3,'map.jsp','地图查询')\">&nbsp;&nbsp;&nbsp;&nbsp;地图查询</a></dd>\r\n");
      out.write("\t\t\t      </dl>\r\n");
      out.write("\t\t\t    </li>\r\n");
      out.write("\t\t\t    <li class=\"layui-nav-item\">\r\n");
      out.write("\t\t\t      <a href=\"javascript:;\" id=\"1\"><i class=\"fa fa-sitemap\"></i>&nbsp;部门管理</a>\r\n");
      out.write("\t\t\t      <dl class=\"layui-nav-child\">\r\n");
      out.write("\t\t\t      \t  <dd><a href=\"javascript:;\" id=\"2\" onclick=\"showTab(1,'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/depart/list/1','部门列表')\">&nbsp;&nbsp;&nbsp;&nbsp;部门列表</a></dd>\r\n");
      out.write("\t\t\t      \t  <dd><a href=\"javascript:;\" id=\"2\" onclick=\"showTab(2,'departadd.jsp','部门新增')\">&nbsp;&nbsp;&nbsp;&nbsp;部门新增</a></dd>\r\n");
      out.write("\t\t\t      </dl>\r\n");
      out.write("\t\t\t    </li>\r\n");
      out.write("\t\t\t    <li class=\"layui-nav-item\">\r\n");
      out.write("\t\t\t     <a href=\"javascript:;\" id=\"1\"><i class=\"layui-icon layui-icon-user\"></i>&nbsp;员工管理</a>\r\n");
      out.write("\t\t\t      <dl class=\"layui-nav-child\">\r\n");
      out.write("\t\t\t      \t  <dd><a href=\"javascript:;\" id=\"2\" onclick=\"showTab(1,'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/emp/list/1','员工列表')\">&nbsp;&nbsp;&nbsp;&nbsp;员工列表</a></dd>\r\n");
      out.write("\t\t\t      \t  <dd><a href=\"javascript:;\" id=\"2\" onclick=\"showTab(2,'empadd.jsp','员工新增')\">&nbsp;&nbsp;&nbsp;&nbsp;员工新增</a></dd>\r\n");
      out.write("\t\t\t      </dl>\r\n");
      out.write("\t\t\t    </li>\r\n");
      out.write("                <li class=\"layui-nav-item\">\r\n");
      out.write("\t\t\t     <a href=\"javascript:;\" id=\"1\"><i class=\"fa fa-graduation-cap\"></i>&nbsp;专业管理</a>\r\n");
      out.write("\t\t\t      <dl class=\"layui-nav-child\">\r\n");
      out.write("\t\t\t      \t  <dd><a href=\"javascript:;\" id=\"2\" onclick=\"showTab(1,'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/course/list/1','专业列表')\">&nbsp;&nbsp;&nbsp;&nbsp;专业列表</a></dd>\r\n");
      out.write("\t\t\t      \t  <dd><a href=\"javascript:;\" id=\"2\" onclick=\"showTab(2,'courseadd.jsp','专业新增')\">&nbsp;&nbsp;&nbsp;&nbsp;专业新增</a></dd>\r\n");
      out.write("\t\t\t      </dl>\r\n");
      out.write("\t\t\t    </li>\r\n");
      out.write("\t\t\t    <li class=\"layui-nav-item\">\r\n");
      out.write("\t\t\t     <a href=\"javascript:;\" id=\"1\"><i class=\"fa fa-cube\"></i>&nbsp;班级管理</a>\r\n");
      out.write("\t\t\t      <dl class=\"layui-nav-child\">\r\n");
      out.write("\t\t\t      \t  <dd><a href=\"javascript:;\" id=\"2\" onclick=\"showTab(1,'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/grade/list/1','班级列表')\">&nbsp;&nbsp;&nbsp;&nbsp;班级列表</a></dd>\r\n");
      out.write("\t\t\t      \t  <dd><a href=\"javascript:;\" id=\"2\" onclick=\"showTab(2,'gradeadd.jsp','班级新增')\">&nbsp;&nbsp;&nbsp;&nbsp;班级新增</a></dd>\r\n");
      out.write("\t\t\t      </dl>\r\n");
      out.write("\t\t\t    </li>\r\n");
      out.write("\t\t\t    <li class=\"layui-nav-item\">\r\n");
      out.write("\t\t\t     <a href=\"javascript:;\" id=\"1\"><i class=\"fa fa-user-secret\"></i>&nbsp;学生管理</a>\r\n");
      out.write("\t\t\t      <dl class=\"layui-nav-child\">\r\n");
      out.write("\t\t\t      \t  <dd><a href=\"javascript:;\" id=\"2\" onclick=\"showTab(1,'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/student/list/1','学生列表')\">&nbsp;&nbsp;&nbsp;&nbsp;学生列表</a></dd>\r\n");
      out.write("\t\t\t      \t  <dd><a href=\"javascript:;\" id=\"2\" onclick=\"showTab(2,'studentadd.jsp','学生新增')\">&nbsp;&nbsp;&nbsp;&nbsp;学生新增</a></dd>\r\n");
      out.write("\t\t\t      \t  <dd><a href=\"javascript:;\" id=\"2\" onclick=\"showTab(2,'studentbatch.jsp','学生导入')\">&nbsp;&nbsp;&nbsp;&nbsp;学生导入</a></dd>\r\n");
      out.write("\t\t\t      </dl>\r\n");
      out.write("\t\t\t    </li>\r\n");
      out.write("\r\n");
      out.write("            </ul>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"layui-body\" id=\"container\" >\r\n");
      out.write("        <!-- 内容主体区域 -->\r\n");
      out.write("        <div class=\"layui-tab\" lay-filter=\"demo\" style=\"width: 100%;height: 90%\">\r\n");
      out.write("            <ul class=\"layui-tab-title\"></ul>\r\n");
      out.write("            <div class=\"layui-tab-content\" style=\"width: 99%;height: 98%\"></div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <div class=\"layui-footer\">\r\n");
      out.write("        <p>\r\n");
      out.write("            Copyright 2011-2018 <a href=\"http://www.1000phone.com/\"\r\n");
      out.write("                                   rel=\"nofollow\" target=\"_blank\" title=\"千锋互联\">北京滴答科技有限公司 Feri\r\n");
      out.write("            版权所有</a> 京ICP备12003911号-3 京公网安备11010802011455号\r\n");
      out.write("        </p>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/media/js/jquery.min.js\"></script>\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/media/layui/layui.js\"></script>\r\n");
      out.write("<script>\r\n");
      out.write("    //JavaScript代码区域\r\n");
      out.write("    var element;\r\n");
      out.write("    layui.config({\r\n");
      out.write("        base: 'media/layui/lay/modules/'\r\n");
      out.write("    }).use(['element','app'], function(){\r\n");
      out.write("        element = layui.element;\r\n");
      out.write("        showTab(20000,\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/loginlog/list\",\"首页\");\r\n");
      out.write("    });\r\n");
      out.write("    var tid=-1;\r\n");
      out.write("    function showTab(id,u,n) {\r\n");
      out.write("        if(tid>0){\r\n");
      out.write("            element.tabDelete('demo',tid);\r\n");
      out.write("        }\r\n");
      out.write("        element.tabAdd('demo', {\r\n");
      out.write("            title:n\r\n");
      out.write("            ,content: '<iframe data-frameid=\"'+id+'\" scrolling=\"auto\" frameborder=\"0\" src=\"'+u+'\"></iframe>' //支持传入html\r\n");
      out.write("            ,id:id\r\n");
      out.write("        });\r\n");
      out.write("        element.tabChange('demo', id);\r\n");
      out.write("        element.render();\r\n");
      out.write("        tid=id;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("</html>");
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