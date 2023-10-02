<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file='admin_menu.jsp' %>
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i>
            <a href="/OnlineShop/newmanage/admin_index.jsp">首页</a>
            <span class="crumb-step">&gt;
            </span><a class="crumb-name" href="/OnlineShop/newmanage/admin_orderselect">订单管理</a>
            <span class="crumb-step">&gt;</span><span>修改订单</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-content">
                <form action="/OnlineShop/newmanage/admin_doorderupdate" method="post" id="myform" name="myform" >
                <input type="hidden" name ="orderid" value="${order.order_id}">
                <input type="hidden" name ="cpage" value="${cpage}">
                    <table class="insert-tab" width="100%">
                        <tbody>
                        	
                            <tr>
                                <th><i class="require-red">*</i>订单编号：</th>
                                <td>
                                    <input class="common-text required" id="orderid" name="orderid" size="50" value="${order.order_id}" type="text" disabled="disabled">
                                </td>
                            </tr>
                            
                            <tr>
                                <th><i class="require-red">*</i>用户ID:</th>
                                <td>
                                    <input class="common-text required" id="title" name="Name" size="50" value="${order.buyer_id}" type="text" readonly>
                                </td>
                            </tr>
                            
                            <tr>
                                <th><i class="require-red">*</i>商品ID</th>
                                <td>
                                    <input class="common-text required" id="title" name="password" size="50" value="${order.product_id}" type="text" readonly>
                                </td>
                            </tr>
                            
                            <tr><th>下单时间</th>
                            <td>
                              <input class="common-text required" id="title" name="password" size="50" value="${order.puacher_time}" type="text" disabled="disabled">
                              
                            </td>
                        	</tr>
                        	
                        	<tr>
                                <th>快递公司</th>
                                <td><input class="common-text" name="birthday" size="50" type="text" value="${order.order_delivery}" readonly></td>
                            </tr>
                          
                            <tr>
                                <th><i class="require-red">*</i>快递单号：</th>
                                <td>
                                    <input class="common-text required" id="title" name="delivery_num" size="50" value="${order_order_delivery_num}" type="text">
                                </td>
                            </tr>
                            
                            
                            
                            
                            
                            <tr>
                                <th></th>
                                <td>
                                    <input class="btn btn-primary btn6 mr10" value="提交" type="submit">
                                    <input class="btn btn6" onClick="history.go(-1)" value="返回" type="button">
                                </td>
                            </tr>
                        </tbody></table>
                </form>
            </div>
        </div>

    </div>
    <!--/main-->
</div>
</body>
</html>