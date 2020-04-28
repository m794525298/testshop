<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="admin_menu.jsp"%>
<!--/sidebar-->
<div class="main-wrap">

	<div class="crumb-wrap">
		<div class="crumb-list">
			<i class="icon-font">
				</i><a href="/testshop/manage/admin_index.jsp">首页</a><span class="crumb-step">&gt;</span><a class="crumb-name"
				href="/testshop/manage/admin_docommentselect">评论管理</a>
				<span class="crumb-step">&gt;</span><span>修改评论</span>
		</div>
	</div>
	<div class="result-wrap">
		<div class="result-content">
			<form action="/testshop/manage/admin_docommentupdate" method="post" id="myform" name="myform">
				<input type="hidden" name="COMMENTID" value="${comment.COMMENT_ID }">
				<input type="hidden" name="cpage" value="${cpage}">
				<input type="hidden" name="keywords" value="${keywords }">
				<table class="insert-tab" width="100%">
					<tbody>
						<tr>
							<th><i class="require-red">*</i>用户ID：</th>
							<td><input class="common-text required" id="USERID" name="USERID" size="50" value="${comment.USER_ID }" type="text"></td>
						</tr>
						<tr>
							<th><i class="require-red">*</i>商品ID：</th>
							<td><input class="common-text required" id="GOODSID" name="GOODSID" size="50" value="${comment.GOODS_ID }" type="text"></td>
						</tr>
						<tr>
							<th>被回复评论ID：</th>
							<td><input class="common-text required" id="COMMENTPARENT" name="COMMENTPARENT" size="50" value="${comment.COMMENT_PARENT }" type="text"></td>
						</tr>
						<tr>
							<th><i class="require-red">*</i>评论内容：</th>
							<td><input class="common-text required" id="COMMENTCONTENT" name="COMMENTCONTENT" size="50" value="${comment.COMMENT_CONTENT }" type="text"></td>
						</tr>
						<tr>
							<th><i class="require-red">*</i>发表时间：</th>
							<td><input class="common-text required" id="COMMENTTIME" name="COMMENTTIME" size="50" value="${comment.COMMENT_TIME }" type="text"></td>
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