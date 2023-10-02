<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>注册界面</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/login.css"/>
    <script type="text/javascript" src="js/Calendar.js"></script>
    <script type="text/javascript" src="js/function.js"></script>
    <script type="text/javascript" src="js/jquery-1.12.4.min.js"></script>
    
    <style>
     .reg p .error{
     display:inline-block;
     border:1px solid #ff855a;
     background-color:#ffe8e0;
     height:20px;
     line_height:20px;
     padding:0px 10px;
     margin-left:20px;
     
     }
     
     .reg p .right{
     <!-------------------display:inline-block-------------------------->
     <!------>
     border:1px solid #ff855a;
     font-color:#adff2f;
     height:20px;
     line_height:20px;
     padding:0px 10px;
     margin-left:20px;
     
     }
    
    </style>
</head>
<body><!-------------------reg-------------------------->
<div class="reg">
    <form action="register" method="post" onsubmit="checkform(this)"><h1><a href="index.html"><img style="height:70px;" src="img/temp/logo.png"></a></h1>
        <h1 style="padding:0px;font-size:30px;background:grey;text-align:center;line-height:60px;color:#FFFFFF">网上商城用户注册</h1>
        <p><input type="text" name="userName" value="" onfocus="FocusItem(this)" onblur="CheckItem(this)" placeholder="请输入用户名"><span></span></p>
        <p><input type="text" name="name" value="" onfocus="FocusItem(this)" onblur="CheckItem(this)" placeholder="请输入真实姓名"><span></span></p>
        <p><input type="password" name="password" value="" onfocus="FocusItem(this)" onblur="CheckItem(this)" placeholder="请输入密码"><span></span></p>
         <p><input type="password" name="repassword" value="" onfocus="FocusItem(this)" onblur="CheckItem(this)" placeholder="请确认密码"><span></span></p>
        <p>
        <input style="width:30px;height:15px;" type="radio" name="sex" value="T" checked="checked">男
        <input style="width:30px;height:15px;" type="radio" name="sex" value="F" checked="checked">女
        </p>
        <p><input type="text" name="birthday" value="" onfocus="new Calendar().show(this);" placeholder="请确认出生日期"></p>
         <p><input type="text" name="email" value="" placeholder="请输入邮箱"><span></span></p>
        <p><input type="text" name="mobile" value="" placeholder="请输入手机号"><span></span></p>
        <p><input type="text" name="address" value="" onfocus="FocusItem(this)" onblur="CheckItem(this)" placeholder="请输入收获地址"><span></span></p>
        <p><input class="code" type="text" name="veryCode" value="" onfocus="FocusItem(this)" onblur="CheckItem(this)" placeholder="验证码">
        <img src="getcode" alt="看不清，换一张" onclick="change(this)"><span></span></p>
        <p><input type="submit" name="" value="注册"></p>
        <p><a href="login.jsp"><span></span>已有账号登录</a>
        <a href="index.jsp"><span></span>返回主页</a></p>
        <!--<a href="#" class="off"><img src="img/temp/off.png"></a>--></form>
</div>
</body>
</html>