<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<div class="head">
    <div class="wrapper clearfix">
        <div class="clearfix" id="top"><h1 class="fl"><a href="index.html"><img style="width:200px;" src="img/logo.png"/></a></h1>
            <div class="fr clearfix" id="top1"><p class="fl">
            <c:if test="${isLogin!=1}">
            <a href="login.jsp" id="login">登录</a><a href="reg.jsp" id="reg">注册</a>
            </c:if>
            <c:if test="${isLogin==1}">
            	你好：<a href="login.jsp" id="login">${name.USER_ID}</a>
            </c:if>
            </p>
                <form action="#" method="get" class="fl"><input type="text" placeholder="热门搜索：限量球鞋"/><input
                        type="button"/></form>
                <div class="btn fl clearfix">
                <c:if test="${isLogin==1}">
                <a href="mygxin.jsp"><img src="img/grzx.png"/></a>
                <a href="showcart"><img src="img/gwc.png"/></a>
                </c:if>
                
                
                    </div>
            </div>
        </div>
        <ul class="clearfix" id="bott">
            <li><a href="indexselect">首页</a></li>
            <!-- 循环显示分类表 -->
            <c:forEach var="f" items="${flist}">
            <li><a href="selectproductlist?fid=${f.CATE_ID}">${f.CATE_NAME}</a>
                <div class="sList2">
                    <div class="clearfix">
                    <c:forEach var="c" items="${clist}">
                    <c:if test="${f.CATE_ID==c.CATE_PARENT_NAME}">
                    	<a href="selectproductlist?cid=${c.CATE_ID }">${c.CATE_NAME}</a>
                    </c:if>
                    </c:forEach>	
                    </div>
                </div>
            </li>
            </c:forEach>
        </ul>
    </div>   
</div>