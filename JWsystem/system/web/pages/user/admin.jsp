<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020-12-16
  Time: 16:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="demo" uri="http://www.mydomain.com/sample" %>
<html>
<head>
    <title>管理员页面</title>
    <%@include file="/pages/common/head.jsp"%>
</head>
<body>
<h3><a href="admin?action=listUser">用户管理</a></h3>
<h2>欢迎${sessionScope.username},您已成功登录</h2>
<hr>
当前在线人数为：${applicationScope.onlineCount}
<br>
<br>
<demo:time/>
</body>
</html>