<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file ="admin_menu.jsp" %>
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="index.html">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">用户管理</span></div>
        </div>
        <div class="search-wrap">
            <div class="search-content">
                <form action="#" method="post">
                    <table class="search-tab">
                        <tr>
                            <th width="120">选择分类:</th>
                            <td>
                                <select name="search-sort" id="">
                                    <option value="">全部</option>
                                    <option value="19">精品界面</option><option value="20">推荐界面</option>
                                </select>
                            </td>
                            <th width="70">关键字:</th>
                            <td><input class="common-text" placeholder="关键字" name="keywords" value="" id="" type="text"></td>
                            <td><input class="btn btn-primary btn2" name="sub" value="查询" type="submit"></td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
        <div class="result-wrap">
            <form name="myform" id="myform" method="post">
                <div class="result-title">
                    <div class="result-list">
                        <a href="admin_useradd.jsp"><i class="icon-font"></i>新增用户</a>
                        <a id="batchDel" href="javascript:void(0)"><i class="icon-font"></i>批量删除</a>
                        <a id="updateOrd" href="javascript:void(0)"><i class="icon-font"></i>更新排序</a>
                    </div>
                </div>
                <div class="result-content">
                    <table class="result-tab" width="100%">
                        <tr>
                            
                           
                            <th>ID</th>
                            <th>name</th>
                            <th>password</th>
                            <th>IDENTITY</th>
                            <th>EMAIL</th>
                            <th>STUNUM</th>
                            <th>QQ</th>
                            
                        </tr> 
                        
                      
                       <c:forEach var="u" items="${userlist}">
                        <tr>
                            <%-- <td class="tc"><input name="id[]" value="${u.UESR_ID}" type="checkbox"></td> --%>
                         	 <td>  ${u.USER_ID} </td>
                             <td>  ${u.USER_NAME} </td>
                             <td>  ${u.USER_PASSWORD} </td>
                              <td>  ${u.USER_IDENTITY} </td>
                               <td>  ${u.USER_EMAIL} </td>
                                <td>  ${u.USER_STUNUM} </td>
                                 <td>  ${u.USER_QQ} </td>
                             
                           
                         
                            <td>
                                <a class="link-update" href="#">修改</a>
                                <a class="link-del" href="#">删除</a>
                            </td>
                        </tr>
                      </c:forEach> 
                    </table>
                    <div class="list-page">
                    	一共${tsum} 条，当前 ${cp} / ${tpage}
                    	<a href="admin_douserselect?cp=1">首页</a>
                    	<a href="admin_douserselect?cp=${cp-1<1?1:cp-1}">上一页</a>
                    	<a href="admin_douserselect?cp=${cp+1>tpage?tpage:cp+1}">下一页</a>
                    	<a href="admin_douserselect?cp=${tpage}">尾页</a>
                    	
                    
                    </div>
                </div>
            </form>
        </div>
    </div>
    <!--/main-->
</div>
</body>
</html>