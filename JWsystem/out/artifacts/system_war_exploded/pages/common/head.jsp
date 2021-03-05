<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020-12-06
  Time: 0:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--    设置动态地址--%>
<%
    String basePath=request.getScheme()
        +"://"
        +request.getServerName()
        +":"
        +request.getServerPort()
        +request.getContextPath()
        +"/";
%>

<%--设置绝对路径--%>
<base href="<%=basePath%>">
<link type="text/css" rel="stylesheet" href="static/style.css">
<script type="text/javascript" src="static/script/jquery-1.7.2.js"></script>
