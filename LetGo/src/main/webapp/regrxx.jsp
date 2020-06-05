<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head lang="en">
<meta charset="utf-8" />
<title>编辑个人信息</title>
<link rel="stylesheet" type="text/css" href="css1/public.css" />
<link rel="stylesheet" type="text/css" href="css1/mygrxx1.css" />
</head>
<body>
	<!------------------------------head------------------------------>
	<div class="head">
		<div class="wrapper clearfix">
			<%@ include file="head1.jsp"%>
			<%@ include file="head2.jsp"%>
		</div>
	</div>
	<!------------------------------idea------------------------------>
	<div class="address mt">
		<div class="wrapper clearfix">
			<a href="index.jsp" class="fl">首页</a><span>/</span><a
				href="regrxx.jsp" class="on">个人中心</a><span>/</span><a
				href="regrxx.jsp" class="on">个人信息</a>
		</div>
	</div>
	</div>
	<!------------------------------Bott------------------------------>
	<div class="Bott">
		<div class="wrapper clearfix">
			<div class="zuo fl">
				<%@ include file="head3.jsp"%>
			</div>
			<div class="you fl">
				<h2>个人信息</h2>
				<div class="gxin">
					<div class="tx">
						<img id="img11" src="" /> <label class="btn-file" data-role="add">
							<p>修改头像</p> <input class="common-text required" id="icon"
							name="icon" size="50" value="" type="file" style="display: none;">
						</label>
					</div>
					<div class="xx">
						<h3 class="clearfix">
							<strong class="fl">基础资料</strong>
						</h3>
						<form action="#" method="post" class="remima" id="form">
							<p>
								<span>用户昵称: </span><input id="username" name="username" 
									type="text" />
							</p>
							<p>
								<span>用户账号:</span><input id="account" name="account" 
									readonly="readonly" type="text" />
							</p>
							<p>
								<span>身 份: </span><input id="identity" name="identity"
									readonly="readonly" type="text" />
							</p>
							<p>
								<span>用户邮箱: </span><input id="email" name="email"
									readonly="readonly" type="text" />
							</p>
							<p>
								<span>学 号: </span><input id="stuNum" name="stuNum"
									readonly="readonly" type="text" />
							</p>
							<p>
								<span>用户地址: </span><input id="address" name="address" 
									type="text" />
							</p>
							<p>
								<span>联系方式(QQ): </span><input id="contact" name="contact"
									type="text" />
							</p>
							<input type="submit" value="编辑" id="change"/>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--返回顶部-->
	<!--footer-->
	
<%@ include file="foot.jsp" %>
	<script src="js/jquery-1.12.4.min.js" type="text/javascript"
		charset="utf-8"></script>
	<script src="js/public.js" type="text/javascript" charset="utf-8"></script>
	<script src="js/user.js" type="text/javascript" charset="utf-8"></script>
	<script src="js/jquery.flexslider-min.js" type="text/javascript" charset="utf-8"></script>
	<script src="js/jquery.cookie.js" type="text/javascript" charset="utf-8"></script>
	<script src="js/jquery.base64.js" type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript">
	var storage = window.localStorage;
	var id =$.cookie('userID');
	$(function(){
		identity=storage.getItem('identity');
		email = storage.getItem('email');
		account=storage.getItem('account');
		stunum=storage.getItem('stuNum');
		icon = storage.getItem('icon');
		if(identity=="0"){
			$("#identity").val("买家")
		}else if(identity == "1"){
			$("#identity").val("卖家")
		}else if(identity =="2" ){
		$("#identity").val("管理员")
		}
		$("#email").val(email);
		$("#account").val(account);
		$("#stuNum").val(stunum);
		$("#img11").attr('src', icon);
			 
		contact=storage.getItem('contact');
		address=storage.getItem('address');
		username=storage.getItem('username');
		$("#contact").val(contact);
		$("#address").val(address);
		$("#username").val(username);
	});
	$("#form").on("click","#change",function () {
		var a,b,c;
		var username_test = /^\w+$/;
		var email_test = /([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)/;
		var address_test = /^[\u4e00-\u9fa5_a-zA-Z0-9]+$/;
		if($("#contact").val()==""){
			alert("联系方式不能为空");
			a="0"
		}else if((!username_test.test($("#contact").val()))&&(!email_test.test($("#contact").val()))){
			alert("联系方式存在非法字符");
			a="0";
		}else{
			a="1";
		}
		if($("#address").val()==""){
			alert("地址不为空");
			b="0"
		}else if(!address_test.test($("#address").val())){
			alert("地址中存在非法字符");
			b="0";
		}else{
			b="1";
		}
		if($("#username").val()==""){
			alert("用户名不能为空");
			c="0";
		}else if(!username_test.test($("#username").val())){
			alert("用户名中存在非法字符");
			c="0"
		}else{
			c="1";
		}
		
		if(a=="1"&&b=="1"&&c=="1"){
			var url="ChangeUserInfo";		
			var args={"time":new Date(),
				"contact":$("#contact").val(),
				"address":$("#address").val(),
				"username":$("#username").val(),
			}
			
			$.post(url,args,function(data){
				if(data.success=="true"){
					storage["contact"]=$("#contact").val();
					storage["address"]=$("#address").val();
					storage["username"]=$("#username").val();
					alert("更改成功");
				}else{
					alert("更改失败");
				}
			},"json")
		}else{
			alert("更改失败");
		}
	})
</script>
</body>
</html>