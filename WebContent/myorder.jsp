<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="utf-8"/>
    <title>我的订单</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/myorder.css"/>
</head>
<body><!------------------------------head------------------------------>
<%@include file="header1.jsp" %>
</div><!------------------------------idea------------------------------>
<div class="address mt">
    <div class="wrapper clearfix"><a href="indexselect" class="fl">首页</a><span>/</span><a
            href="mygxin.jsp">个人中心</a><span>/</span><a href="myorder.jsp" class="on">我的订单</a></div>
</div><!------------------------------Bott------------------------------>
<div class="Bott">
    <div class="wrapper clearfix">
        <div class="zuo fl">
            <h3><a href="#"><img src="img/tx.png"/></a>
                <p class="clearfix"><span class="fl">[${name.USER_ID}]</span><span class="fr">[<a href="logout">退出登录</a>]</span></p></h3>
            <div><h4>我的交易</h4>
                <ul>
                    <li><a href="showcart">我的购物车</a></li>
                    <li><a href="personorderselect">我的订单</a></li>
                    
            </div>
        </div>
        <div class="you fl">
            <div class="my clearfix"><h2 class="fl">我的订单</h2></div>
            <div class="dlist clearfix">
                <ul class="fl clearfix" id="wa">
                    <li class="on"><a href="#2">全部有效订单</a></li>
                    
                </ul>
                
            </div>
            
            <c:forEach var="o" items="${order}">
            <c:forEach var="p" items="${product}">
            <c:if test="${p.PRODUCT_ID==o.product_id}">
            <div class="dkuang"><p class="one">
            	<c:if test="${o.order_status==1 }">
                          	  等待发货
                </c:if>
                <c:if test="${o.order_status==2 }">
                          	  运输中
                </c:if>
                <c:if test="${o.order_status==3 }">
                          	 买家已收货
                </c:if></p>
                <div class="word clearfix">
                    <ul class="fl clearfix">
                        <li>${o.puacher_time}</li>
                        <li>${o.buyer_id}</li>
                        <li>快递号:${o.order_delivery_num}</li>
                        <li>${o.order_delivery}</li>
                    </ul>
                    <p class="fr">订单金额：<span>${o.product_amount * p.PRODUCT_PRICE}</span>元</p></div>
                <div class="shohou clearfix"><a href="selectproductdetail?id=${p.PRODUCT_ID}" class="fl"><img src="images/product/${p.PRODUCT_PICTURE}" ></a>
                    <p class="fl"><a href="selectproductdetail?id=${p.PRODUCT_ID}">${p.PRODUCT_NAME}</a><a href="#">¥${p.PRODUCT_PRICE}×${o.product_amount}</a></p>
                    <c:if test="${o.order_status==2 }">
                    <p class="fr"><a href="buyerrecive?id=${o.order_id}">确认收货</a></p>
                    </c:if>
                    </div>
                    
            </div>
            </c:if>
            </c:forEach>
            </c:forEach>
            
            
            
            

            
        </div>
    </div>
</div><!--返回顶部-->
<div class="gotop"><a href="cart.html">
    <dl>
        <dt><img src="showcart"/></dt>
        <dd>去购<br/>物车</dd>
    </dl>
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
</a><a href="#" class="toptop" style="display: none">
    <dl>
        <dt><img src="img/gt4.png"/></dt>
        <dd>返回<br/>顶部</dd>
    </dl>
</a>
    <p>400-800-8200</p></div><!--footer-->
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
<script src="js/user.js" type="text/javascript" charset="utf-8"></script>
</body>
</html>