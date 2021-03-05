<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020-12-16
  Time: 16:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户管理</title>
    <%@include file="/pages/common/address.jsp"%>
</head>
<body>
<h3>用户管理</h3>
<table style="text-align: center">
    <tr>
        <th>id</th>
        <th>username</th>
        <th>password</th>
    </tr>
    <c:forEach items="${sessionScope.users}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.username}</td>
            <td>${user.password}</td>
            <td><a href="admin?action=delete&id=${user.id}">删除该用户</a></td>
        </tr>
    </c:forEach>
    <tr>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td><a href="pages/usermanage/addUser.jsp">增加新用户</a></td>
    </tr>

</table>

</body>
</html>
