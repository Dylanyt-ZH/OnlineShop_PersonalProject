<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   

<%@include file='admin_menu.jsp' %>
<script type="text/javascript" src="js/Calendar.js"></script>
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i>
            <a href="/OnlineShop/manage/admin_index.jsp">首页</a>
            <span class="crumb-step">&gt;</span>
            <a class="crumb-name" href="/Onlineshop/newmanage/admin_cateselect">商品管理</a>
            <span class="crumb-step">&gt;</span><span>修改商品</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-content">
                <form action="/OnlineShop/newmanage/admin_doproductupdate" enctype="multipart/form-data" method="post" id="myform" name="myform" >
                <input type="hidden" name="id" value="${product.PRODUCT_ID}">
                    <table class="insert-tab" width="100%">
                        <tbody>
                        	<tr>
                                <th><i class="require-red">*</i>商品名称</th>
                                <td>
                                    <input class="common-text required" id="title" value="${product.PRODUCT_NAME}"name="Productname" size="50" value="" type="text">
                                </td>
                            </tr>
                            
                            <tr>
                                <th><i class="require-red">*</i>商品分类</th>
                                <td> 
                                	<select class="common-text required"  name="parentID" >      
                                    <c:forEach var="f" items="${flist}">
                                    	<option value="${f.CATE_ID }" disabled="disabled">|-${f.CATE_NAME }</option>
											<c:forEach var="c" items="${clist}">
												<c:if test="${c.CATE_PARENT_NAME==f.CATE_ID}">
												<option value="${f.CATE_ID }-${c.CATE_ID}" selected="selected">&nbsp; &nbsp;|--${c.CATE_NAME }</option>	 
												</c:if>
												
											</c:forEach>
                                    </c:forEach>
                                    </select>
                                </td>
                            </tr>
                            
                            <tr>
                                <th><i class="require-red">*</i>商品价格</th>
                                <td>
                                    <input class="common-text required" id="title" value="${product.PRODUCT_PRICE}"name="Productprice" size="50" value="" type="text">
                                </td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>商品图片</th>
                                <td>
                                    <input class="common-text required" id="title"  name="Productpicture" size="50" value="" type="file">
                                    	每次修改商品信息请重新提交照片信息，当前图片文件名：${product.PRODUCT_PICTURE}
                                </td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>商品描述</th>
                                <td>
                                    <input class="common-text required" id="title"  value="${product.PRODUCT_DESCRIPTION}" name="Productdescribe" size="50" value="" type="text">
                                </td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>商品库存</th>
                                <td>
                                    <input class="common-text required" id="title"  value="${product.PRODUCT_STOCK}" name="Productstock" size="50" value="" type="text">
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