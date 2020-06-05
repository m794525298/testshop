<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="utf-8"/>
    <title>个人信息</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/mygrxx.css"/>
</head>
<body><!------------------------------head------------------------------>
<div class="head">
    <div class="wrapper clearfix">
		<%@ include file="head1.jsp" %>
		<%@ include file="head2.jsp" %>	
    </div>
</div><!------------------------------idea------------------------------>
<div class="address mt">
    <div class="wrapper clearfix"><a href="index.jsp" class="fl">首页</a><span>/</span><a href="regrxx.jsp" class="on">个人中心</a><span>/</span><a
            href="remima.jsp" class="on">修改密码</a></div>
</div><!------------------------------Bott------------------------------>
<div class="Bott">
    <div class="wrapper clearfix">
        <div class="zuo fl">
			<%@ include file="head3.jsp" %>
		</div>
        <div class="you fl"><h2>修改密码</h2>
            <form action="#" method="get" class="remima">
                <p><span>原密码：</span><input type="password" id="pwd1" name="userPassWord"/><span class="error">请输入原密码</span></p>            
                <p><span>新密码：</span><input type="password" id="pwd2" name="userPassWord"/><span class="error">请输入新密码</span></p>
                <p><span>重复新密码：</span><input type="password" id="pwd3" name="rePassWord"/><span class="error">请再次输入密码</span></p>
				<input type="submit" value="提交" disabled="disabled" id="remima"/></form>
        </div>
    </div>
</div>
<!--返回顶部-->
<div class="gotop"><a href="cart.jsp">
    <dl>
        <dt><img src="img/gt1.png"/></dt>
        <dd>去购<br/>物车</dd>
    </dl>
</a><a href="#" class="dh">
    <dl>
        <dt><img src="img/gt2.png"/></dt>
        <dd>联系<br/>客服</dd>
    </dl>
</a><a href="regrxx.jsp">
    <dl>
        <dt><img src="img/gt3.png"/></dt>
        <dd>个人<br/>中心</dd>
    </dl>
</a><a href="#" class="toptop" style="display: none">
    <dl>
        <dt><img src="img/gt4.png"/></dt>
        <dd>返回<br/>顶部</dd>
    </dl>
</a></div><!--footer-->
<%@ include file="foot.jsp" %>
<script src="js/public.js" type="text/javascript" charset="utf-8"></script>
<script src="js/user.js" type="text/javascript" charset="utf-8"></script>
<script src="js/jquery.flexslider-min.js" type="text/javascript" charset="utf-8"></script>
<script src="js/jquery.cookie.js" type="text/javascript" charset="utf-8"></script>
<script src="js/jquery.base64.js" type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript">
	var username;
	var storage=window.localStorage;
	var id =$.cookie('userID');
	window.onload = function(){
					
		username=storage.getItem('username');
		$("#username1").text(username);			
	}
	$(function(){
	 	$('#remima').click(function(){
	 		
	 		
	 		var v1=$("#pwd1").eq(0).next().text();
		 	var v2=$("#pwd2").eq(0).next().text();
		 	var v3=$("#pwd3").eq(0).next().text();
	 	if(v1==""&& v2=="" && v3==""){
	 	var oldpassword=$("#pwd1").eq(0).val();
	 	var newpassword=$("#pwd2").eq(0).val(); 
		var url="ChangePassword";
		var args ={"userID":id,
					"oldPassword":oldpassword,
					"newPassword":newpassword};//这里是点击修改密码功能，对应接口文档功能二
		$.post(url,args,function(data){
			if(data.success=="true"){
				alert('修改成功');
				window.location.href="regrxx.jsp";
			}else{
				alert('原密码错误');
			}
		},"json")
	 	}})
	 
	 
	})

	function checkbutton(){//这是我的本地认证数据是否正确
			var v1=$("#pwd1").eq(0).next().text();
		 	var v2=$("#pwd2").eq(0).next().text();
		 	var v3=$("#pwd3").eq(0).next().text();
			
		 	
		 	
		 	if(v1==""&& v2=="" && v3==""){
			 $("#remima").removeAttr("disabled");
			 $("#remima").css({background:"#C10000"});
			
			 
		 	}else{
			 $("#remima").attr("disabled","disabled"); 
			 $("#remima").css({background:""});
		 	}
		}
		
	$("input").blur(function(){
		  var reg_test = /^\w+$/;
		  var reg_email_test = /([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)/;

		var p_name=this.name;

		switch (p_name){	
		case "userPassWord" :
			var p_value=this.value;
			
			if(p_value==""){
				
				$(this).next().empty().append("不能为空");
			}else{	
				
				
				if(!reg_test.test(p_value)){
					$(this).next().empty().append("非法字符");
			}else if(!(p_value.length>5&&p_value.length<17) ){
			 	$(this).next().empty().append("请限定长度在6—16"); 
			 }else{
				 $(this).next().empty();
			 }
				
		
			}
				
			
			
			checkbutton();
			break;
			;
		case "rePassWord" :
			var p_value=this.value;
			
			if(p_value==""){
				
				$("#pwd3").eq(0).next().empty().append("不能为空");
			}else{	
				
				
				if(!reg_test.test(p_value)){
				$("#pwd3").eq(0).next().empty().append("非法字符");
			}else if(!(p_value.length>5&&p_value.length<17) ){
			 	$(this).next().empty().append("请限定长度在6—16"); 
			 	}else{
			 		if(p_value!=$("#pwd2").eq(0).val()){
			 			$(this).next().empty().append("请输入正确密码");
			 		}else{
			 			$(this).next().empty();
					 }
			 	}
		
			}
			
			checkbutton();
			break;
			;
		
		
		
		}
		
		

	})
	</script>

</body>
</html>