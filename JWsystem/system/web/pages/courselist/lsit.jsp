<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020-12-10
  Time: 22:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>已选课程页面</title>
    <%@include file="/pages/common/head.jsp"%>
</head>
<body>
<jsp:include page="/pages/common/navigation.jsp"/>
<h3>已选课程</h3>
<table>
<div>
    <tr>
    <th colspan="2">ID</th>
    <th colspan="2">课程名称</th>
    <th colspan="2">任课老师</th>
    <th colspan="4">操作</th>
</tr>
</div>
    <div>
<c:forEach items="${requestScope.courseItems}" var="courseItem">
    <tr>
        <td colspan="2">${courseItem.id}</td>
        <td colspan="2">${courseItem.name}</td>
        <td colspan="2">${courseItem.teacher}</td>
        <td colspan="4"><a href="listServlet?action=deleteItem&id=${courseItem.id}">取消</a></td>
    </tr>
    <br>
</c:forEach>
<%--<c:if test="${not empty sessionScope.selectList.items}">--%>
<%--    一共选了${sessionScope.selectList.totalCount}门课程--%>
<%--</c:if>--%>
    </div>
</table>

</body>
</html>
