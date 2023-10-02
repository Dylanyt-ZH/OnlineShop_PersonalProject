<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="utf-8"/>
    <title>
    <c:if test="${ctitle==null}">
    ${ftitle}
    </c:if>
    <c:if test="${ctitle != null}">
    ${ftitle}---${ctitle}
    </c:if>
    </title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/proList.css"/>
</head>
<body><!------------------------------head------------------------------>
<%@include file="header1.jsp" %>
<!------------------------------banner------------------------------>
<div class="banner"><a href="#"><img src="img/temp/banner2.jpg" style="width:1905px; height:500px"/></a></div>
<!-----------------address------------------------------->
<div class="address">
    <div class="wrapper clearfix"><a href="indexselect">首页</a><span>/</span>
    <a href="">${ftitle}</a><span>/</span><a href="" class="on">${ctitle}</a></div>
</div><!-------------------current---------------------->
<div class="current">
    <div class="wrapper clearfix"><h3 class="fl">${title}</h3>
        
    </div>
</div><!----------------proList------------------------->
<ul class="proList wrapper clearfix">
	<c:forEach var="p" items="${list}">
    <li><a href="selectproductdetail?id=${p.PRODUCT_ID}">
        <dl>
            <dt><img src="images/product/${p.PRODUCT_PICTURE}" alt="不好意思，暂无图片，DYLAN"></dt>
            <dd>${p.PRODUCT_NAME }</dd>
            <dd>${p.PRODUCT_PRICE}</dd>
        </dl>
    </a></li>
    </c:forEach>
    
</ul><!----------------mask------------------->
<!--返回顶部-->
<div class="gotop"><a href="showcart">
    <dl class="goCart">
        <dt><img src="img/gt1.png"/></dt>
        <dd>去购<br/>物车</dd>
        <span>1</span></dl>
</a><a href="#" class="dh">
    <dl>
        <dt><img src="img/gt2.png"/></dt>
        <dd>联系<br/>客服</dd>
    </dl>
</a><a href="mygxin.html">
    <dl>
        <dt><img src="img/gt3.png"/></dt>
        <dd>个人<br/>中心</dd>
    </dl>
</a><a href="#" class="toptop" style="display: none;">
    <dl>
        <dt><img src="img/gt4.png"/></dt>
        <dd>返回<br/>顶部</dd>
    </dl>
</a>
    <p>400-800-8200</p></div>
<div class="msk"></div><!--footer-->
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
 </div>

<script src="js/jquery-1.12.4.min.js" type="text/javascript" charset="utf-8"></script>
<script src="js/public.js" type="text/javascript" charset="utf-8"></script>
<script src="js/nav.js" type="text/javascript" charset="utf-8"></script>
<script src="js/pro.js" type="text/javascript" charset="utf-8"></script>
<script src="js/cart.js" type="text/javascript" charset="utf-8"></script>
</body>
</html>