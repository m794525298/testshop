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
				<input type="hidden" name="COMMENTID" value="${comment.id }">
				<input type="hidden" name="cpage" value="${cpage}">
				<input type="hidden" name="keywords" value="${keywords }">
				<table class="insert-tab" width="100%">
					<tbody>
						<tr>
							<th><i class="require-red">*</i>用户ID：</th>
							<td><input class="common-text required" id="COMMENT_PUBLISHER" name="COMMENT_PUBLISHER" size="50" value="${comment.publisherId }" type="text"></td>
						</tr>
						<tr>
							<th><i class="require-red">*</i>商品ID：</th>
							<td><input class="common-text required" id="COMMENT_GOODSID" name="COMMENT_GOODSID" size="50" value="${comment.goodsId }" type="text"></td>
						</tr>
						<tr>
							<th>被回复用户ID：</th>
							<td><input class="common-text required" id="COMMENT_PARENT" name="COMMENT_PARENT" size="50" value="${comment.parentId }" type="text"></td>
						</tr>
						<tr>
							<th><i class="require-red">*</i>评论内容：</th>
							<td><input class="common-text required" id="COMMENT_CONTENT" name="COMMENT_CONTENT" size="50" value="${comment.content }" type="text"></td>
						</tr>
						<tr>
							<th><i class="require-red">*</i>发表时间：</th>
							<td><input class="common-text required" id="COMMENT_TIME" name="COMMENT_TIME" size="50" value="${comment.time }" type="text"></td>
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