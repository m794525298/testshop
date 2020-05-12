<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>注册</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/login.css"/>
	<script src="js/jquery-1.12.4.min.js"></script>
		

	<style>
.reg .reg_title{
				width:80px;
				
				padding:0px 200px;
				font-size:20px;
				text-align:center;
				
			}
.reg p .error{
	display:inline-block;
	padding:0px 20px;
	height:25px;
	line-height:25px;
	color:#313131;
	
}

	</style>
</head>
<body><!-------------------reg-------------------------->
<div class="reg">
    <form action="#" method="post" id="reg_form"><h1><a href="index.html"><img src="img/temp/logo.png"></a></h1>
        <p class="reg_title">用户注册</p>
		<p><input type="text" name="userAccount" value="" placeholder="请输入账号" ><span class="error">请输入账号</span></p>
       
        <p><input type="password" name="userPassWord" value=""  placeholder="请输入密码"><span class="error">请输入密码</span></p>
        <p><input type="password" name="rePassWord" value=""  placeholder="请确认密码"><span class="error">请确认密码</span></p>
		<p><input type="text" name="email" id="email" value=""   placeholder="请输入邮箱"><span class="error">请输入邮箱</span></p>
        <p class="txtL txt"><input class="code" name="code" type="text" placeholder="输入邮箱验证码" ><button  type="button" style="width:80px;height:40px; margin-left:10px;padding-top:6px;"
              disable="" onclick=settime(this); >发送验证码</button><span></span></p>
        <p><input type="submit" id="reg" name="" value="注册" disabled="disabled" ></p>
        <p class="txtL txt">完成此注册，即表明您同意了我们的<a href="#">
            <使用条款和隐私策略>
        </a></p>
        <p class="txt"><a href="#"><span></span>已有账号登录</a></p>
        <!--<a href="#" class="off"><img src="img/temp/off.png"></a>--></form>
</div>

	<script>
	 var countdown=60;
	 var email_code="a";
	 $(function(){
		 $('#reg').click(function(){
			 var v1=$("input").eq(0).next().text();
		 var v2=$("input").eq(1).next().text();
		 var v3=$("input").eq(2).next().text();
		 var v4=$("input").eq(3).next().text();
		 var v5=$("input").eq(4).next().next().text();
		 if(v1==""&&v2==""&&v3==""&&v4==""&&v5=="ok"){
			 
			var account=$("input").eq(0).val(); 
			var password=$("input").eq(1).val();
			var email=$("input").eq(3).val();
			var url="js/reg_userAccount.js?account="+account+"&password="+password+"&email="+email+"&username"+account;
			var args ={"time":new Date()};//这里是点击注册功能，对应接口文档功能四
			$.getJSON(url,args,function(data){
				if(data.success=="true"){
					window.location.href="login.jsp";
				}else{
					alert('error');
				}
			})
		 }})
		 
		 
	 })
	 function checkbutton(){//这是我的本地认证数据是否正确
		 var v1=$("input").eq(0).next().text();
		 var v2=$("input").eq(1).next().text();
		 var v3=$("input").eq(2).next().text();
		 var v4=$("input").eq(3).next().text();
		 var v5=$("input").eq(4).next().next().text();
	
		 if(v1==""&&v2==""&&v3==""&&v4==""&&v5=="ok"){
			 $("#reg").removeAttr("disabled");
			 $("#reg").css({background:"#C10000"});
			
			 
		 }else{
			 $("#reg").attr("disabled","disabled"); 
			 $("#reg").css({background:""});
		 }
	 }
	function settime(val) {
		             var e = $("#email").next().text();
		             
		            //本地内容的验证，后端哥们不用看
		        
		         if(e==""){
		        	 
		        	   if (countdown == 0) {
			                val.removeAttribute("disabled");
			              $("button").empty().append("发送验证码")
				                
				                return;
				             } else {
				                val.setAttribute("disabled", true);
				                $("button").empty().append(countdown+"秒");
				                countdown--;
				               
				             }
				             setTimeout(function() {
					                settime(val)
					             },1000)
		        	 
		        	
		         }else{
		           
		          
		        }
	}
	$(function(){
		$("button").click(function(){
			var c=$("#email").next().text();
			var p_value=$("#email").val();
			if(c==""){
				var url="js/reg_userAccount.js?email="+p_value;//发送email按钮然后接受验证码
				var args ={"time":new Date()};
				$.getJSON(url,args,function(data){
					email_code=data.captcha;
					alert(email_code);
				})
			}
		})
	})
	$(function(){
		$()
		
		$("input").focus(function(){
			var p_name=this.name;
			switch (p_name){
			case "userAccount" :
			
				$(this).next().empty();
				break;
				;
			case "userPassWord" :
				$(this).next().empty();
				break;
				;
			case "rePassWord" :
				$(this).next().empty();
				break;
				;
			case "email" :
				$(this).next().empty();
				break;
				;
			
			
			}
			
			
		})
		$("input").blur(function(){
			  var reg_test = /^\w+$/;
			  var reg_email_test = /([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)/;

			var p_name=this.name;
		
			switch (p_name){
			case "userAccount" :
				var p_value=this.value;
				if(p_value==""){
					
					$(this).next().empty().append("不能为空");
				}else{	if(!reg_test.test(p_value)){
					$("input").eq(0).next().empty().append("非法字符");
					
				}else{
					if(!(p_value.length>5&&p_value.length<17) ){
					 	$(this).next().empty().append("请限定长度在6—16"); }
					else(
						$(function(){
						var url="js/reg_userAccount.js?account="+p_value;//这里是验证账号验证是否重复的内容
						var args ={"time":new Date()};
						$.getJSON(url,args,function(data){
						
								if(data.exist!="true"){
									$("input").eq(0).next().empty();
								 	
								}else{
									
									$("input").eq(0).next().empty().append("此账号已存在");
								
								}
							
						})
						
						})
						)}}
			
				checkbutton();
				break;
				;
			case "userPassWord" :
				var p_value=this.value;
				
				if(p_value==""){
					
					$(this).next().empty().append("不能为空");
				}else{	
					
					
					if(!reg_test.test(p_value)){
					$("input").eq(2).next().empty().append("非法字符");
				}else if(!(p_value.length>5&&p_value.length<17) ){
				 	$(this).next().empty().append("请限定长度在6—16"); }
			
				}
				checkbutton();
				break;
				;
			case "rePassWord" :
				var p_value=this.value;
				
				if(p_value==""){
					
					$(this).next().empty().append("不能为空");
				}else{	
					
					
					if(!reg_test.test(p_value)){
					$("input").eq(2).next().empty().append("非法字符");
				}else if(!(p_value.length>5&&p_value.length<17) ){
				 	$(this).next().empty().append("请限定长度在6—16"); }else{
				 		if(p_value!=$("input").eq(1).val()){
				 			$(this).next().empty().append("请输入正确密码");
				 		}
				 	}
			
				}
				checkbutton();
				break;
				;
			case "email" :
				var p_value=this.value;
				if(p_value==""){
					
					$(this).next().empty().append("不能为空");
				}else{	if(!reg_email_test.test(p_value)){
					$("input").eq(3).next().empty().append("格式不符合邮箱");
				}else(
						$(function(){
						var url="js/reg_userAccount.js?email="+p_value;//查找邮箱是否存在，验证邮箱唯一
						var args ={"time":new Date()};
						$.getJSON(url,args,function(data){
						
								if(data.exist!="true"){
									$("input").eq(3).next().empty();
								
								}else{
									$("input").eq(3).next().empty().append("此email已存在");
								
								 
								}
							
						})
						
						})
						)}
				checkbutton();
				break;
				
			case "code" :
				var p_value=this.value;
				if(p_value==email_code){		
					$(this).next().next().empty().append("ok")
						}else{
							$(this).next().next().empty().append("no")}
				checkbutton();
				break;
				;
			
			
			}
			
			
		})
	})
	</script>
</body>
</html>