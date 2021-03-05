<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020-12-06
  Time: 21:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>课程增加页面</title>
    <%@include file="/pages/common/head.jsp"%>
</head>
<body>
<form action="CourseServlet" method="post">
    <input type="hidden" name="action" value="${empty param.id?"add":"update"}">
    <input type="hidden" name="id" value="${requestScope.course.id}">
    <table>
        <tr>
            <td>coursename</td>
            <td>teacher</td>
            <td>classes</td>
            <td>place</td>
            <td>time</td>
        </tr>
        <tr>
            <td><input type="text" name="coursename" value="${requestScope.course.coursename}"></td>
            <td><input type="text" name="teacher" value="${requestScope.course.teacher}"></td>
            <td><input type="text" name="classes" value="${requestScope.course.classes}"></td>
            <td><input type="text"name="place" value="${requestScope.course.place}"></td>
            <td><input type="text"name="time" value="${requestScope.course.time}"></td>
            <td><input type="submit"value="submit"></td>
        </tr>
    </table>
</form>

</body>
</html>
