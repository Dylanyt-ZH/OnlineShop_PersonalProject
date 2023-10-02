<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@include file='admin_menu.jsp' %>
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="index.html">首页</a>
            <span class="crumb-step">&gt;</span><span class="crumb-name">商品管理</span></div>
        </div>
        <form action="/OnlineShop/newmanage/admin_productselect" method="get">
                    <table class="search-tab">
                        <tr>
                            <th width="90">搜索商品:</th>
                            <td><input class="common-text" placeholder="关键字" name="keywords" value="${param.keywords}" id="" type="text"></td>
                            <td><input class="btn btn-primary btn2" name="sub" value="查询" type="submit"></td>
                        </tr>
                    </table>
         </form>
        <div class="result-wrap">
            <form action="/OnlineShop/newmanage/admin_doproductdel" id="myform" method="post">
            
                <div class="result-title">
                    <div class="result-list">
                        <a href="/OnlineShop/newmanage/admin_toproductadd"><i class="icon-font"></i>新增商品</a>
                        <a id="batchDel" href="javascript:delmore('你确定删除这些商品吗？','myform')"><i class="icon-font"></i>批量删除</a>
                    
                    </div>
                </div>
                <div class="result-content">
                    <table class="result-tab" width="100%">
                        <tr>
                            <th class="tc" width="5%"><input class="allChoose" name="" onclick="selectall(this)" type="checkbox"></th>
                            <th>商品ID</th>
                            <th>商品图片</th>
                            <th>商品价格</th>
                            <th>商品库存</th>
                            <th>商品分类</th>
                            <th>商品描述</th>
                            <th>操作</th>
                        </tr>
                        
                        <c:forEach var="p" items="${plist}">
                        	<tr>
                        		<td class="tc"><input name="id[]" value="${p.PRODUCT_ID}" type="checkbox"></td>
                        		<td>${p.PRODUCT_ID}</td>
                        		
                        		<td>
                        		
                        		<img src="../images/product/${p.PRODUCT_PICTURE }" width="100" height="100"  alt="不好意思，暂无图片，DYLAN"/>

                        		 ${p.PRODUCT_NAME}</td>
                        		<td>${p.PRODUCT_PRICE}</td>
                        		<td>${p.PRODUCT_STOCK}</td>
                        		
                        		<td>
                        		<c:forEach var="f" items="${catelist}">
                        			<c:if test="${f.CATE_ID==p.PRODUCT_FID }">
                        				<c:forEach var="c" items="${catelist}">
                        					<c:if test="${c.CATE_ID==p.PRODUCT_CID }">
                        						${c.CATE_NAME}---${f.CATE_NAME}
                        					</c:if>
                        				</c:forEach>
                        			</c:if>
                        		</c:forEach>
                        		</td>
                        	
                        		<td>${p.PRODUCT_DESCRIPTION}</td>
                        		<td>
                        		 <a class="link-update" href="/OnlineShop/newmanage/admin_toproductupdate?id=${p.PRODUCT_ID}&cpage=${cpage}">修改</a>
                        		<a class="link-del" href="javascript:Delete('你确定要删除商品【${p.PRODUCT_NAME}】吗？','/OnlineShop/newmanage/admin_doproductdel?id=${p.PRODUCT_ID}&cpage=${cpage}')">删除</a>
                        		</td>
                        		
                        	</tr>
                        
                        </c:forEach>
                       
                        <script>
                        	function Delete(mess,url){
                        		if(confirm(mess)){
                        			location.href=url;
                        		}
                        	}
                        	function selectall(o){
                        		var a=document.getElementsByName('id[]');
                        		for(var i=0;i<a.length;i++){
                        			a[i].checked=o.checked;
                        		}
                        	}
                        	function delmore(mess,formname){
                        		if(confirm(mess)){
                        			var form =document.getElementById(formname);
                        			form.submit();
                        		}
                        	}
                        </script>
                    </table>
                    <div class="list-page"> 
					共${tsum}条记录 当前${cpage}/${tpage}页
					<a href="admin_productselect?cp=1${SearchParams}">首页</a>
					<a href="admin_productselect?cp=${cpage-1<1?1:cpage-1}${SearchParams}">上一页</a>
					<a href="admin_productselect?cp=${cpage+1>tpage?tpage:cpage+1}${SearchParams}">下一页</a>
					<a href="admin_productselect?cp=${tpage}${SearchParams}">尾页</a>
					
					</div>
                </div>
            </form>
        </div>
    </div>
    <!--/main-->
</div>
</body>
</html>