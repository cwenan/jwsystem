<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020-12-03
  Time: 10:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
<%--    包含各种相同的头部信息--%>
   <%@include file="/pages/common/head.jsp"%>
         <%--    ../是相对于当前目录的上一级目录--%>
    <script type="text/javascript" >
    // $(function (){
    //
    //     $("#username").blur(function (){
    //         //获取用户名
    //         var username=$("#username").val();
    //
    //         $.ajax({
    //             url:"UserServlet?action=existUser&name="+username,
    //             // data:{name:username},
    //             // contentType:"application/json:charset=UTF-8",
    //             contentType:"application/x-www-form-urlencoded",
    //             type:"POST",
    //
    //             success:function (data){
    //                 console.log(data);
    //                 if (data.existUser){
    //                     $(".errorMsg").html("用户名无效，请重新确认")
    //                 }else {
    //                     $(".errorMsg").html("用户名有效")
    //                 }
    //                 // data=jQuery.parseJSON(data);
    //                 // $(".errorMsg").text(data.result);
    //             }
    //         })
    //
    //
    //     })
    //
    //
    // })

    var xmlHttp;
    function createXmlHttpRequest(){
        if (window.XMLHttpRequest){
            xmlHttp=new XMLHttpRequest();
        }else {
            xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
        }
    }
    function handleStateChange(){
        if (xmlHttp.readyState==4){
            if (xmlHttp.status==200){
                var message=xmlHttp.responseXML.getElementsByTagName("message")[0].firstChild.data;
                var infomessage=document.getElementById("message");
                infomessage.innerHTML="<p>"+message+"<p>";
            }else {
                alert(xmlHttp.status);
            }
        }
    }
    function stratrequest(){
        xmlHttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
        createXmlHttpRequest();
        var username=document.getElementById("username").value;
        var url="UserServlet?action=eGETxistUser&username="+username;
        xmlHttp.open("POST",url,true);
        xmlHttp.onreadystatechange=handleStateChange();
        xmlHttp.send();
    }

    // function ajPost(){
    //     var xhr = new XMLHttpRequest();
    //     var username=document.getElementById("username").value;
    //     var url="UserServlet?action=existUser&username="+username;
    //     xhr.open('post',url,true);
    //     xhr.send(null);
    //
    //     xhr.onreadystatechange = function(){
    //         if(xhr.readyState == 4 && xhr.status == 200){
    //             console.log('成功!');
    //             var message=xhr.responseXML.getElementsByTagName("message")[0].firstChild.data;
    //             var infomessage=document.getElementById("message");
    //             infomessage.innerHTML="<p>"+message+"<p>";
    //         }else{
    //             console.log('失敗!');
    //         }
    //     }
    // }


    </script>
</head>
<body>
<form action="UserServlet" method="post" >
    <input type="hidden"name="action" value="login">
    ${sessionScope.message}<br>

    <div id="login">

        <h3>用户登录</h3>
        <div class="errorMsg" id="message"></div>
        <label>用户名称：</label>
        <td><input  type="text"  placeholder="请输入用户名"  tabindex="1" name="username"  id="username"  /></td>
        <td><span><input type="button" value="检测" onclick="stratrequest()"></span></td>
        <br />
        <br>
        <td><label>用户密码：<input  type="password"   placeholder="请输入密码"  tabindex="1" name="password"  id="password" /></label></td>
        <td></td>
        <br />
        <br />
        <input type="checkbox" name="autologin" value="auto_login" checked>自动登录
        <input type="submit"value="登录" id="lg_btn">
    </div>
</form>
</body>
</html>
