<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020-12-06
  Time: 16:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>课程管理</title>
    <%@include file="/pages/common/head.jsp"%>
    <script type="text/javascript" language="JavaScript">
        $(function (){
            $("a.sure").click(function (){
                /**
                 * confirm是确认提示框函数
                 * 参数为它的提示内容
                 * 返回true表示点击了
                 * 返回false表示取消了
                 */
                return confirm("你确定要删除这一门课程吗？")

            })
        })

    </script>
</head>
<body>
<%@include file="/pages/common/navigation.jsp"%>
<h3>课表管理</h3>
<table style="text-align: center">
    <tr>
        <th colspan="1">id</th>
        <th colspan="1">coursename</th>
        <th colspan="1">teacher</th>
        <th colspan="1">classes</th>
        <th colspan="1">place</td>
        <th colspan="1">time</th>
        <th colspan="1">操作</th>
        <hr>
    </tr>

<c:forEach items="${requestScope.courses}" var="course">
    <tr>
        <td colspan="1">${course.id}</td>
        <td colspan="1">${course.coursename}</td>
        <td colspan="1">${course.teacher}</td>
        <td colspan="1">${course.classes}</td>
        <td colspan="1">${course.place}</td>
        <td colspan="1">${course.time}</td>
        <td><a href="CourseServlet?action=getCourse&id=${course.id}">修改</a></td>
        <td><a  class="sure" href="CourseServlet?action=delete&id=${course.id}">删除</a></td>
    </tr>
</c:forEach>
    <tr>
        <td colspan="2"></td>
        <td colspan="2"></td>
        <td colspan="3"></td>
        <td colspan="4"></td>
        <td colspan="3"></td>
        <td colspan="3"></td>
        <td><a href="pages/course/course_edit.jsp">添加课程</a></td>
    </tr>
</table>

</body>
</html>
