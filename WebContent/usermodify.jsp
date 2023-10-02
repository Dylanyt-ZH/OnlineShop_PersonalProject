<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>用户修改界面</title>
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
    <form action="dousermodify" method="post" onsubmit="checkform(this)"><h1><a href="index.html"><img style="height:70px;" src="img/temp/logo.png"></a></h1>
        <h1 style="padding:0px;font-size:30px;background:grey;text-align:center;line-height:60px;color:#FFFFFF">用户信息修改</h1>
        <p><input type="text" name="userName" value="${name.USER_ID}" onfocus="FocusItem(this)"   readonly><span></span></p>
        <p><input type="text" name="name" value="${name.USER_NAME}" onfocus="FocusItem(this)" onblur="CheckItem(this)" placeholder="请输入真实姓名"><span></span></p>
        <p><input type="password" name="password" value="${name.USER_PASSWORD}" onfocus="FocusItem(this)" onblur="CheckItem(this)" placeholder="请输入密码"><span></span></p>
         <p><input type="password" name="repassword" value="${name.USER_PASSWORD}" onfocus="FocusItem(this)" onblur="CheckItem(this)" placeholder="请确认密码"><span></span></p>
        <p>
        <input style="width:30px;height:15px;" type="radio" name="sex" value="T" checked="checked">男
        <input style="width:30px;height:15px;" type="radio" name="sex" value="F" checked="checked">女
        </p>
        <p><input type="text" name="birthday" value="${name.USER_BIRTHDAY}" onfocus="new Calendar().show(this);" placeholder="请确认出生日期"></p>
         <p><input type="text" name="email" value="${name.USER_EMAIL}" placeholder="请输入邮箱"><span></span></p>
        <p><input type="text" name="mobile" value="${name.USER_MOBILE}" placeholder="请输入手机号"><span></span></p>
        <p><input type="text" name="address" value="${name.USER_ADDRESS}" onfocus="FocusItem(this)" onblur="CheckItem(this)" placeholder="请输入收获地址"><span></span></p>
        <p><input class="code" type="text" name="veryCode" value="" onfocus="FocusItem(this)" onblur="CheckItem(this)" placeholder="验证码">
        <img src="getcode" alt="看不清，换一张" onclick="change(this)"><span></span></p>
        <p><input type="submit" name="" value="提交修改"></p>
        <p>
        <a href="indexselect"><span></span>返回主页</a></p>
        </form>
</div>
</body>
</html>