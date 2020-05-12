<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="admin_menu.jsp"%>
<!--/sidebar-->
<div class="main-wrap">

	<div class="crumb-wrap">
		<div class="crumb-list">
			<i class="icon-font"></i><a href="admin_index.jsp">首页</a><span
				class="crumb-step">&gt;</span><span class="crumb-name">购物车管理</span>
		</div>
	</div>
	<div class="search-wrap">
		<div class="search-content">
			<form action="/testshop/manage/admin_docartselect" method="get">
				<table class="search-tab">
					<tr>
						<!--  <th width="120">选择分类:</th>
                            <td>
                                <select name="search-sort" id="">
                                    <option value="">全部</option>
                                    <option value="19">精品界面</option><option value="20">推荐界面</option>
                                </select>
                            </td> -->
						<th width="70">关键字:</th>
						<td><input class="common-text" placeholder="关键字" name="keywords" value="${keywords}" id="" type="text"></td>
						<td><input class="btn btn-primary btn2" name="sub" value="查询" type="submit"></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<div class="result-wrap">
		<form action="/testshop/manage/admin_docartdelete?page=${cpage}${search}" name="myform" id="myform" method="post">
			<div class="result-title">
				<div class="result-list">
					<a href="admin_cartadd.jsp"><i class="icon-font"></i>新增购物车</a>
					<a id="batchDel" href="javascript:deleteBatch('你确定删除这些购物项吗?', 'myform')"><i class="icon-font"></i>批量删除</a>
					<a id="updateOrd" href="javascript:void(0)"><i
						class="icon-font"></i>更新排序</a>
				</div>
			</div>
			<div class="result-content">
				<table class="result-tab" width="100%">
					<tr>
						<th class="tc" width="5%"><input class="allChoose" name="" onclick="selectAll(this)" type="checkbox"></th>
						<th>ID</th>
						<th>卖家ID</th>
						<th>商品ID</th>
						<th>操作</th>
					</tr>


					<c:forEach var="cart" items="${cartlist}">
						<tr>
							<td class="tc"><input name="id[]" value="${cart.CART_ID }" type="checkbox"></td>
							<td>${cart.CART_ID}</td>
							<td>${cart.CART_USER_ID}</td>
							<td>${cart.CART_GOODS_ID}</td>

							<td>
								<a class="link-update" href="admin_tocartupdate?id=${cart.CART_ID}&page=${cpage}${search}">修改</a> 
								<a class="link-del" href="javascript:Delete('你确定要删除购物车【${cart.CART_ID }】吗?', '/testshop/manage/admin_docartdelete?id=${cart.CART_ID}&page=${cpage}${search}')">删除</a>
							</td>
						</tr>
					</c:forEach>
					
					<script>
						function Delete(mess, url) {
							if(confirm(mess)) {
								location.href = url;
							}
						}
						
						function selectAll(o) {
							var a = document.getElementsByName("id[]");
							
							for(var i=0; i<a.length; ++i) {
								a[i].checked = o.checked
							}
						}
						
						function deleteBatch(mess, formName) {
							if(confirm(mess)) {
								var form = document.getElementById(formName);
								form.submit();
							}
						}
					</script>
					
				</table>
				<div class="list-page">
					一共${tsum} 条，当前 ${cpage} / ${tpage} <a
						href="admin_docartselect?page=1${search} ">首页</a> <a
						href="admin_docartselect?page=${cpage<=1?1:cpage-1}${search} ">上一页</a> <a
						href="admin_docartselect?page=${cpage>=tpage?tpage:cpage+1}${search} ">下一页</a>
					<a href="admin_docartselect?page=${tpage}${search} ">尾页</a>

				</div>
			</div>
		</form>
	</div>
</div>
<!--/main-->
</div>
</body>
</html>