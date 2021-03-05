<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020-12-03
  Time: 13:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="demo" uri="http://www.mydomain.com/sample" %>
<html>
<head>
    <title>教务系统</title>
    <%@include file="/pages/common/head.jsp"%>
</head>
<body>
<jsp:include page="/pages/common/navigation.jsp"/>
<h2>欢迎${sessionScope.username},您已成功登录</h2>
<hr>
当前在线人数为：${applicationScope.onlineCount}
<br>
<br>
<demo:time/>
</body>
</html>
