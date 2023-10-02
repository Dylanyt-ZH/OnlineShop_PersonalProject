<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@include file='admin_menu.jsp' %>
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="index.html">首页</a>
            <span class="crumb-step">&gt;</span><span class="crumb-name">分类管理</span></div>
        </div>
        
        <div class="result-wrap">
            <form action="/OnlineShop/newmanage/admin_douserdel" id="myform" method="post">
                <div class="result-title">
                    <div class="result-list">
                        <a href="/OnlineShop/newmanage/admin_tocateadd"><i class="icon-font"></i>新增分类</a>
                        <a id="batchDel" href="javascript:delmore('你确定删除这些用户吗？','myform')"><i class="icon-font"></i>批量删除</a>
                    
                    </div>
                </div>
                <div class="result-content">
                    <table class="result-tab" width="40%">
                        <tr>
                            
                            <th>分类ID</th>
                            <th>分类名称</th>
                            <th>操作</th>
                        </tr>
                        
                        <c:forEach var="cate" items="${catelist}">
                        
                        <c:if test="${cate.CATE_PARENT_NAME==0 }">
                        
                        <tr>
                        <td>${cate.CATE_ID }</td>
                        <td>|--${cate.CATE_NAME }</td>
                        <td> <a href="admin_tocateupdate?id=${cate.CATE_ID }">修改</a></td>
                        </tr>
                        	<c:forEach var="cateson" items="${catelist}">
                        	<c:if test="${cateson.CATE_PARENT_NAME==cate.CATE_ID }">
                        	<tr>
                        	<td>${cateson.CATE_ID }</td>
                        	<td>&nbsp;&nbsp;&nbsp;&nbsp;|--${cateson.CATE_NAME }</td>
                        	<td> <a href="admin_tocateupdate?id=${cateson.CATE_ID}">修改</a> </td>
                        	</tr>
                        	</c:if>
                        	</c:forEach>
                        </c:if>
                        </c:forEach>
                       
                        <script>
                        	function Delete(mess,url){
                        		if(confirm(mess)){
                        			location.href=url;
                        		}
                        	}
                        	
                        	}
                        </script>
                    </table>
                    <!----<div class="list-page"> 
					共${tsum}条记录 当前${cpage}/${tpage}页
					<a href="admin_douserselect?cp=1${SearchParams}">首页</a>
					<a href="admin_douserselect?cp=${cpage-1<1?1:cpage-1}${SearchParams}">上一页</a>
					<a href="admin_douserselect?cp=${cpage+1>tpage?tpage:cpage+1}${SearchParams}">下一页</a>
					<a href="admin_douserselect?cp=${tpage}${SearchParams}">尾页</a>
					
					</div>--->
                </div>
            </form>
        </div>
    </div>
    <!--/main-->
</div>
</body>
</html>