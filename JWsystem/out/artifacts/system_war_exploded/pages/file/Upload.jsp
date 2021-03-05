<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020-12-03
  Time: 18:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<base href="http://localhost:8080/system/">
<html>
<head>
    <title>书本资源</title>
    <%@include file="/pages/common/head.jsp"%>
</head>
<body>
<jsp:include page="/pages/common/navigation.jsp"/>
<h2>资源库</h2>
<h3>在这里可以上传或下载书本的电子版文件</h3><br>
<h3>上传</h3>
<form action="upload" method="post" enctype="multipart/form-data">
书&nbsp;&nbsp;名:<input type="text" name="bookame"><br>
<%--    multiple实现多文件上传--%>
    提交：<input type="file"name="提交的书本资源" multiple/>
    <input type="submit"value="提交">
</form>

<c:if test="${sessionScope.filename}!=null">
    你已成功上传${sessionScope.filename}
</c:if>

<hr>
<h3>下载</h3>

<a href="download">C程序设计电子书pdf</a>

</body>
</html>
