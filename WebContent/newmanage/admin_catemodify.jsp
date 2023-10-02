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
            <a class="crumb-name" href="/Onlineshop/newmanage/admin_cateselect">分类管理</a>
            <span class="crumb-step">&gt;</span><span>新增用户</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-content">
                <form action="/OnlineShop/newmanage/admin_docateupdate" method="post" id="myform" name="myform" >
                <input type="hidden" name="id" value="${cate1.CATE_ID}">
                    <table class="insert-tab" width="100%">
                        <tbody>
                        
                            <tr>
                                <th><i class="require-red">*</i>父级分类</th>
                                <td>
                                    <select class="common-text required"  name="parentID" >
                                    <option value="0">无</option>
                                    <c:forEach var="cate" items="${catelist}">
                                    	<c:if test="${cate.CATE_PARENT_NAME==0 }">
                                    		<c:if test="${cate1.CATE_PARENT_NAME==cate.CATE_ID }">
                                    			<option value="${cate.CATE_ID }"selected="selected">${cate.CATE_NAME }</option>
                                    		</c:if>
                                    		<c:if test="${cate1.CATE_PARENT_NAME!=cate.CATE_ID }">
                                    			<option value="${cate.CATE_ID }">${cate.CATE_NAME }</option>
                                    		</c:if>
                                    	</c:if>
                                    </c:forEach>
                                    </select>
                                </td>
                            </tr>
                            
                            <tr>
                                <th><i class="require-red">*</i>分类名称</th>
                                <td>
                                    <input class="common-text required" id="title" name="Catename" size="50" value="${cate1.CATE_NAME }" type="text">
                                </td>
                            </tr>
                            
                            
                            
                            
                            <tr>
                                <th></th>
                                <td>
                                    <input class="btn btn-primary btn6 mr10" value="修改" type="submit">
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