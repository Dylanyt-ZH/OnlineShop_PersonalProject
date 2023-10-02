<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@include file='admin_menu.jsp' %>
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="index.html">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">订单管理</span></div>
        </div>
        <div class="search-wrap">
            <div class="search-content">
                <form action="/OnlineShop/newmanage/admin_orderselect" method="get">
                    <table class="search-tab">
                        <tr>
                            <th width="90">搜索用户ID:</th>
                            <td><input class="common-text" placeholder="关键字" name="keywords" value="${param.keywords}" id="" type="text"></td>
                            <td><input class="btn btn-primary btn2" name="sub" value="查询" type="submit"></td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
        <div class="result-wrap">
            <form action="/OnlineShop/newmanage/admin_douserdel" id="myform" method="post">
                <div class="result-title">
                    <div class="result-list">
                       
                    </div>
                </div>
                <div class="result-content">
                    <table class="result-tab" width="100%">
                        <tr>
                            
                            <th>订单ID</th>
                            <th>买家ID</th>
                            <th>商品名</th>
                            <th>下单时间</th>
                            <th>购买数量</th>
                            <th>快递公司</th>
                            <th>快递单号</th>
                            <th>订单状态</th>
                            <th>操作</th>
                        </tr>
                        <c:forEach var="o" items="${orderlist}">
                        <tr>
                            
                            <td>${o.order_id}</td>
                            <td>${o.buyer_id}</td>
                           
                            <td>
                            <c:forEach var="p" items="${plist}">
                            <c:if test="${p.PRODUCT_ID==o.product_id}">
                            ${p.PRODUCT_NAME}
                            </c:if>
                            </c:forEach>
                            </td>
                          
                            <td>${o.puacher_time}</td>
                            <td>${o.product_amount}</td>
                            <td>${o.order_delivery}</td>
                            <td>${o.order_delivery_num}</td>
                            <td>
                            <c:if test="${o.order_status==1 }">
                          	  等待发货
                            </c:if>
                            <c:if test="${o.order_status==2 }">
                          	  运输中
                            </c:if>
                            <c:if test="${o.order_status==3 }">
                          	  买家已收货
                            </c:if>
                            </td>
                            <td>
                               <a class="link-update" href="/OnlineShop/newmanage/admin_toorderupdate?id=${o.order_id}&cpage=${cpage}">添加快递单号</a>  
                               
                            </td>
                        </tr>
                        </c:forEach>
                        
                        
                        
                    </table>
                    <div class="list-page"> 
					共${tsum}条记录 当前${cpage}/${tpage}页
					<a href="admin_orderselect?cp=1${SearchParams}">首页</a>
					<a href="admin_orderselect?cp=${cpage-1<1?1:cpage-1}${SearchParams}">上一页</a>
					<a href="admin_orderselect?cp=${cpage+1>tpage?tpage:cpage+1}${SearchParams}">下一页</a>
					<a href="admin_orderselect?cp=${tpage}${SearchParams}">尾页</a>
					
					</div>
                </div>
            </form>
        </div>
    </div>
    <!--/main-->
</div>
</body>
</html>