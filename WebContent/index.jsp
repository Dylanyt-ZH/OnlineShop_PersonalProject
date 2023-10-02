<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="utf-8"/>
    <title>学年设计网上商城首页</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/index.css"/>
</head>
<body><!------------------------------head------------------------------>
<%@include file="header1.jsp" %>
<!-------------------------banner--------------------------->
<div class="block_home_slider">
    <div id="home_slider" class="flexslider">
        <ul class="slides">
            <li>
                <div class="slide"><img src="img/banner2.jpg"/></div>
            </li>
            <li>
                <div class="slide"><img src="img/banner1.jpg"/></div>
            </li>
        </ul>
    </div>
    
    
    
<div class="people">
    <div class="wrapper">
    
        <div class="pList clearfix tran">
        
        <c:forEach var='p' items='${pro1}'>
        <a href="selectproductdetail?id=${p.PRODUCT_ID}">
            <dl>
                <dt><span class="abl"></span><img src="images/product/${p.PRODUCT_PICTURE}" style="width:268px "  alt="不好意思，暂无图片，DYLAN"/>
                <span class="abr"></span>
                </dt>
                <dd>${p.PRODUCT_NAME }</dd>
                <dd><span>￥${p.PRODUCT_PRICE}</span></dd>
            </dl>
        </a>
        </c:forEach>
        </div>
        
        
        
        <div class="pList clearfix tran">
        <c:forEach var='p' items='${pro2}'>
        <a href="selectproductdetail?id=${p.PRODUCT_ID}">
            <dl>
                <dt><span class="abl"></span><img src="images/product/${p.PRODUCT_PICTURE}" style="width:268px "  alt="不好意思，暂无图片，DYLAN"/>
                <span class="abr"></span>
                </dt>
                <dd>${p.PRODUCT_NAME }</dd>
                <dd><span>￥${p.PRODUCT_PRICE}</span></dd>
            </dl>
        </a>
        </c:forEach>
        </div>
        
        
        
        
    </div>
</div><!--返回顶部-->
<div class="gotop"><a href="showcart">
    <dl>
        <dt><img src="img/gt1.png"/></dt>
        <dd>去购<br/>物车</dd>
    </dl>
</a>

</a><a href="mygxin.jsp">
    <dl>
        <dt><img src="img/gt3.png"/></dt>
        <dd>个人<br/>中心</dd>
    </dl>
</a><a href="#" class="toptop" style="display: none">
    <dl>
        <dt><img src="img/gt4.png"/></dt>
        <dd>返回<br/>顶部</dd>
    </dl>
</a>
 </div><!-------------------login--------------------------><!--footer-->
<div class="footer">
    <div class="top">
        <div class="wrapper">
            <div class="clearfix"><a href="#2" class="fl"><img src="img/foot1.png"/></a><span class="fl">7天无理由退货</span>
            </div>
            <div class="clearfix"><a href="#2" class="fl"><img src="img/foot2.png"/></a><span class="fl">15天免费换货</span>
            </div>
            <div class="clearfix"><a href="#2" class="fl"><img src="img/foot3.png"/></a><span class="fl">满599包邮</span>
            </div>
            <div class="clearfix"><a href="#2" class="fl"><img src="img/foot4.png"/></a><span class="fl">手机特色服务</span>
            </div>
        </div>
  <%@include file="bottom.jsp" %>  
<script src="js/jquery-1.12.4.min.js" type="text/javascript" charset="utf-8"></script>
<script src="js/public.js" type="text/javascript" charset="utf-8"></script>
<script src="js/nav.js" type="text/javascript" charset="utf-8"></script>
<script src="js/jquery.flexslider-min.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">$(function () {
    $('#home_slider').flexslider({
        animation: 'slide',
        controlNav: true,
        directionNav: true,
        animationLoop: true,
        slideshow: true,
        slideshowSpeed: 2000,
        useCSS: false
    });
});</script>
</body>
</html>