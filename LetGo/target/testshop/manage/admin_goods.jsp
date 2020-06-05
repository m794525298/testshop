<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="admin_menu.jsp"%>
<!--/sidebar-->
<div class="main-wrap">

	<div class="crumb-wrap">
		<div class="crumb-list">
			<i class="icon-font"></i><a href="admin_index.jsp">首页</a><span
				class="crumb-step">&gt;</span><span class="crumb-name">商品管理</span>
		</div>
	</div>
	<div class="search-wrap">
		<div class="search-content">
			<form action="/testshop/manage/admin_dogoodsselect" method="get">
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
		<form action="/testshop/manage/admin_dogoodsdelete?page=${cpage}${search}" name="myform" id="myform" method="post">
			<div class="result-title">
				<div class="result-list">
					<a href="admin_goodsadd.jsp"><i class="icon-font"></i>新增商品</a>
					<a id="batchDel" href="javascript:deleteBatch('你确定删除这些商品吗?', 'myform')"><i class="icon-font"></i>批量删除</a>
					<a id="updateOrd" href="javascript:void(0)"><i
						class="icon-font"></i>更新排序</a>
				</div>
			</div>
			<div class="result-content">
				<table class="result-tab" width="100%">
					<tr>
						<th class="tc" width="5%"><input class="allChoose" name="" onclick="selectAll(this)" type="checkbox"></th>
						<th>ID</th>
						<th>商品名</th>
						<th>介绍</th>
						<th>单价</th>
						<th>总数</th>
						<th>类型</th>
						<th>卖家ID</th>
						<th>地址</th>
						<th>联系方式</th>
						<th>销售状态</th>				
						<th>OPERATOR</th>
					</tr>


					<c:forEach var="goods" items="${goodslist}">
						<tr>
							<td class="tc"><input name="id[]" value="${goods.id }" type="checkbox"></td>
							<td>${goods.id}</td>
							<td>${goods.title}</td>
							<td>${goods.desc}</td>
							<td>${goods.price}</td>
							<td>${goods.count}</td>
							<td>${goods.type}</td>
							<td>${goods.publisherId}</td>
							<td>${goods.address}</td>
							<td>${goods.contact}</td>
							<td>${goods.state}</td>
							

							<td>
								<a class="link-update" href="admin_togoodsupdate?id=${goods.id}&page=${cpage}${search}">修改</a> 
								<a class="link-del" href="javascript:Delete('你确定要删除商品【${goods.title }】吗?', '/testshop/manage/admin_dogoodsdelete?id=${goods.id}&page=${cpage}${search}')">删除</a>
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
						href="admin_dogoodsselect?page=1${search} ">首页</a> <a
						href="admin_dogoodsselect?page=${cpage<=1?1:cpage-1}${search} ">上一页</a> <a
						href="admin_dogoodsselect?page=${cpage>=tpage?tpage:cpage+1}${search} ">下一页</a>
					<a href="admin_dogoodsselect?page=${tpage}${search} ">尾页</a>
				</div>
			</div>
		</form>
	</div>
</div>
<!--/main-->
</div>
</body>
</html>