<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020-12-03
  Time: 10:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>教务系统登录界面</title>
<%--    静态包含base标签，css，jquery--%>
<%@include file="/pages/common/head.jsp"%>
    <script type="text/javascript">
        $(function (){
            //给注册绑定单击事件
            $("#sub_btn").click(function (){
                //验证用户名，必须由字母，数字下划线组成，长度为5到12
                //获取用户名输入的内容
                var usernametext=$("#username").val();
                //创建正则表达式来限制输入内容
                var usernamepatt=/^\w{5,12}$/;
                //使用test方法验证
                if (!usernamepatt.test(usernametext)){
                    $("span.errorMsg").text("用户名不合法");
                    return false;//当它不合法时，不让它跳转，否是无论是否合法都会跳转
                }
                //验证密码是否合格
                //获取用户名输入的内容
                var passwordtext=$("#password").val();
                //创建正则表达式来限制输入内容
                var passwordpatt=/^\w{5,12}$/;
                //使用test方法验证
                if (!passwordpatt.test(passwordtext)){
                    $("span.errorMsg").text("密码不合法");
                    return false;//当它不合法时，不让它跳转，否是无论是否合法都会跳转
                }
                //再次验证密码
                //获取确认密码内容
                var repwdtext=$("#repwd").val();
                //和密码比较
                if (repwdtext!=passwordtext){
                    $("span.errorMsg").text("前后密码不一致");
                    return false;}
                //验证码，现在只需要验证用户已输入，因为还没讲到服务器，验证码生成
                var codetext=$("#code").val();
                //避免其中有空格，要去掉
                codetext=$.trim(codetext);
                if (codetext==null||codetext==""){
                    $("span.errorMsg").text("验证码不能为空")
                    return false;}
            })
        })
    </script>
</head>
<body>
<form action="UserServlet" method="post" >
    <input type="hidden" name="action" value="regist">
        <div  id="rejist"  >
            <h3>用户注册</h3>
            <td><span class="errorMsg"></span></td>
            <br>
        <label>用户名称：</label>
        <input  type="text"  placeholder="请输入用户名" autocomplete="off" tabindex="1" name="username" id="username" />
        <br />
        <br />
        <label>用户密码：</label>
        <input  type="password"   placeholder="请输入密码" autocomplete="off" tabindex="1" name="password" id="password" />
        <br />
        <br />
        <label>确认密码：</label>
        <input  type="password"  placeholder="确认密码" autocomplete="off" tabindex="1" name="repwd" id="repwd" />
        <br />
        <br />
        <lable>验证码：</lable>
            <input type="text" tabindex="1"id="code" value="abcde" name="code">
            <br>
            <br>
            <tr>
                <td><input type="submit" value="注册" id="sub_btn"></td>
                <td><input type="reset" value="重置"></td>
            </tr>
        </div>

</form>
</body>
</html>
