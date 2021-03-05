<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020-12-16
  Time: 17:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加用户</title>
    <%@include file="/pages/common/address.jsp"%>
</head>
<body>
<form action="admin">
    <input type="hidden" name="action" value="add">
    用户名：<input type="text" name="username"><br>
    密码：<input type="password" name="password">
    <input type="submit" value="提交">
</form>

</body>
</html>
