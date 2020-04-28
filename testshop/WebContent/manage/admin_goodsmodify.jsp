<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="admin_menu.jsp"%>
<!--/sidebar-->
<div class="main-wrap">

	<div class="crumb-wrap">
		<div class="crumb-list">
			<i class="icon-font">
				</i><a href="/testshop/manage/admin_index.jsp">首页</a><span class="crumb-step">&gt;</span><a class="crumb-name"
				href="/testshop/manage/admin_dogoodsselect">商品管理</a>
				<span class="crumb-step">&gt;</span><span>修改商品</span>
		</div>
	</div>
	<div class="result-wrap">
		<div class="result-content">
			<form action="/testshop/manage/admin_douserupdate" method="post" id="myform" name="myform">
				<input type="hidden" name="GOODSID" value="${user.GOODS_ID }">
				<input type="hidden" name="cpage" value="${cpage}">
				<input type="hidden" name="keywords" value="${keywords }">
				<table class="insert-tab" width="100%">
					<tbody>
						<tr>
							<th><i class="require-red">*</i>商品名称：</th>
							<td><input class="common-text required" id="GOODSNAME" name="GOODSNAME" size="50" value="${goods.GOODS_NAME }" type="text"></td>
						</tr>
						<tr>
							<th><i class="require-red">*</i>商品介绍：</th>
							<td><input class="common-text required" id="GOODSDESC" name="GOODSDESC" size="50" value="${goods.GOODS_DESC }" type="text"></td>
						</tr>
						<tr>
							<th><i class="require-red">*</i>商品图片：</th>
							<td><input class="common-text required" id="GOODSIMG" name="GOODSIMG" size="50" value="${goods.GOODS_IMG }" type="text"></td>
						</tr>
						<tr>
							<th><i class="require-red">*</i>单价：</th>
							<td><input class="common-text required" id="GOODSPRICE" name="GOODSPRICE" size="50" value="${goods.GOODS_PRICE }" type="text"></td>
						</tr>
						<tr>
							<th><i class="require-red">*</i>个数：</th>
							<td><input class="common-text" name="GOODSCOUNT" size="50" value="${goods.GOODS_COUNT }" type="text"></td>
						</tr>
						<tr>
							<th>类型：</th>
							<td><input class="common-text" name="GOODSTYPE" size="50" value="${goods.GOODS_TYPE }" type="text"></td>
						</tr>
						<tr>
							<th><i class="require-red">*</i>卖家ID：</th>
							<td><input class="common-text" name="USERID" size="50" value="${goods.USER_ID }" type="text"></td>
						</tr>
						<tr>
							<th><i class="require-red">*</i>商家联系方式：</th>
							<td><input class="common-text" name="USERCONTACT" size="50" value="${goods.USER_CONTACT }" type="text"></td>
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