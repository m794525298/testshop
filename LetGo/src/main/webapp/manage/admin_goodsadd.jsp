<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="admin_menu.jsp"%>
<!--/sidebar-->
<div class="main-wrap">

	<div class="crumb-wrap">
		<div class="crumb-list">
			<i class="icon-font"></i><a href="admin_index.jsp">首页</a><span
				class="crumb-step">&gt;</span><a class="crumb-name"
				href="/testshop/manage/admin_dogoodsselect">商品管理</a><span class="crumb-step">&gt;</span><span>新增商品</span>
		</div>
	</div>
	<div class="result-wrap">
		<div class="result-content">
			<form action="/testshop/manage/admin_dogoodsadd" method="post"
				id="myform" name="myform">
				<table class="insert-tab" width="100%">
					<tbody>
						<tr>
							<th><i class="require-red">*</i>商品名称：</th>
							<td><input class="common-text required" id="GOODS_TITLE" name="GOODS_TITLE" size="50" value="" type="text"></td>
						</tr>
						<tr>
							<th><i class="require-red">*</i>商品介绍：</th>
							<td><input class="common-text required" id="GOODS_DESC" name="GOODS_DESC" size="50" value="" type="text"></td>
						</tr>
						<tr>
							<th><i class="require-red">*</i>单价：</th>
							<td><input class="common-text required" id="GOODS_PRICE" name="GOODS_PRICE" size="50" value="" type="text"></td>
						</tr>
						<tr>
							<th><i class="require-red">*</i>总数：</th>
							<td><input class="common-text" name="GOODS_COUNT" size="50" value="" type="text"></td>
						</tr>
						<tr>
							<th><i class="require-red">*</i>类型：</th>
							<td><input class="common-text" name="GOODS_TYPE" size="50" value="" type="text"></td>
						</tr>
						<tr>
							<th><i class="require-red">*</i>卖家ID：</th>
							<td><input class="common-text" name="GOODS_PUBLISHER" size="50" value="" type="text"></td>
						</tr>
						<tr>
							<th><i class="require-red">*</i>地址：</th>
							<td><input class="common-text" name="GOODS_ADDRESS" size="50" value="" type="text"></td>
						</tr>
						<tr>
							<th><i class="require-red">*</i>联系方式：</th>
							<td><input class="common-text" name="GOODS_CONTACT" size="50" value="" type="text"></td>
						</tr>
						<tr>
							<th><i class="require-red">*</i>销售状态：</th>
							<td><input class="common-text" name="GOODS_STATE" size="50" value="" type="text"></td>
						</tr>

						<tr>
							<th></th>
							<td><input class="btn btn-primary btn6 mr10" value="提交"
								type="submit"> <input class="btn btn6"
								onClick="history.go(-1)" value="返回" type="button"></td>
						</tr>
					</tbody>
				</table>
			</form>
		</div>
	</div>

</div>
<!--/main-->
</div>
</body>
</html>