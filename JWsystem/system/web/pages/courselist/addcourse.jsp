<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020-12-10
  Time: 19:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>选课界面</title>
    <%@include file="/pages/common/head.jsp"%>
    <script type="text/javascript">
        // $(function (){
        //     //获取当前dom对象courseId的值
        //     var courseId=$(this).attr("courseId");
        //     $(".addItem").click(function (){
        //         // 设置地址
        //         // location.href="http://localhost:8080/system/listServlet?action=addItem&id"+courseId;
        //
        //     })
        // })

    </script>
</head>
<body>

<jsp:include page="/pages/common/navigation.jsp"/>
<h3>选课界面</h3>
<table style="text-align: center">
        <tr>
            <th colspan="1">id</th>
            <th colspan="1">coursename</th>
            <th colspan="1">teacher</th>
            <th colspan="1">操作</th>
        </tr>
        <br>
    <c:forEach items="${requestScope.courses}" var="course">
        <tr>
            <td colspan="1">${course.id}</td>
            <td colspan="1">${course.coursename}</td>
            <td colspan="1">${course.teacher}</td>
            <td><a href="listServlet?action=addItem&id=${course.id}" class="addItem">添加</a></td>
        </tr>
        <br>
    </c:forEach>
    <tr>
        <td></td>
        <td></td>
        <td></td>
        <td><a href="listServlet?action=selectlist">查看已选课程</a></td>
    </tr>
</table>
</body>
</html>
