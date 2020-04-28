<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="admin_menu.jsp"%>
<!--/sidebar-->
<div class="main-wrap">

	<div class="crumb-wrap">
		<div class="crumb-list">
			<i class="icon-font">
				</i><a href="/testshop/manage/admin_index.jsp">首页</a><span class="crumb-step">&gt;</span><a class="crumb-name"
				href="/testshop/manage/admin_douserselect">用户管理</a>
				<span class="crumb-step">&gt;</span><span>修改用户</span>
		</div>
	</div>
	<div class="result-wrap">
		<div class="result-content">
			<form action="/testshop/manage/admin_douserupdate" method="post" id="myform" name="myform">
				<input type="hidden" name="USERID" value="${user.USER_ID }">
				<input type="hidden" name="cpage" value="${cpage}">
				<input type="hidden" name="keywords" value="${keywords }">
				<table class="insert-tab" width="100%">
					<tbody>
						<tr>
							<th><i class="require-red">*</i>用户昵称：</th>
							<td><input class="common-text required" id="USERNAME"
								name="USERNAME" size="50" value="${user.USER_NAME }" type="text"></td>
						</tr>
						<tr>
							<th><i class="require-red">*</i>用户账号：</th>
							<td><input class="common-text required" id="USERACCOUNT" name="USERACCOUNT" size="50" value="${user.USER_ACCOUNT }" type="text"></td>
						</tr>
						<tr>
							<th><i class="require-red">*</i>用户密码：</th>
							<td><input class="common-text required" id="USERPASSWORD" name="USERPASSWORD" size="50" value="${user.USER_PASSWORD }" type="text"></td>
						</tr>
						<tr>
							<th><i class="require-red">*</i>用户身份：</th>
							<td><input class="common-text required" id="USERIDENTITY" name="USERIDENTITY" size="50" value="${user.USER_IDENTITY }" type="text"></td>
						</tr>
						<tr>
							<th><i class="require-red">*</i>电子邮箱：</th>
							<td><input class="common-text" name="USEREMAIL" size="50" value="${user.USER_EMAIL }" type="text"></td>
						</tr>
						<tr>
							<th>用户学号：</th>
							<td><input class="common-text" name="USERSTUNUM" size="50" value="${user.USER_STUNUM }" type="text"></td>
						</tr>
						<tr>
							<th>居住地址：</th>
							<td><input class="common-text" name="USERADDRESS" size="50" value="${user.USER_ADDRESS }" type="text"></td>
						</tr>
						<tr>
							<th>用户头像：</th>
							<td><input class="common-text" name="USERICON" size="50" value="${user.USER_ICON }" type="text"></td>
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