<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="utf-8"/>
    <title>安全设置-找回密码</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/proList.css"/>
    <link rel="stylesheet" type="text/css" href="css/forgetpassword.css"/>
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
<body><!--------------------forget------------------>
<div class="reg">
    <form action="#" method="post" id="reg_form"><h1><a href="index.html"><img src="img/temp/logo.png"></a></h1>
        <p class="reg_title">密码重置</p>      
        <p>
		<span>
			<input type="text" name="userEmail" id="userEmail" value="" oninput="myFunction()"  placeholder="请输入邮箱" >
			</span>
			<span>
			<button  type="button" id="repwd1" disabled="" onclick=settime(this); >发送验证码</button>
			</span>
			</p>		
       	<p><input type="text" name="code" value="" placeholder="请输入验证码" ><span class="error">请输入验证码</span></p>
        <p><input type="password" name="userPassWord" value=""  placeholder="请输入新密码"><span class="error">请输入密码</span></p>
     	<p><input type="password" name="rePassWord" value=""  placeholder="请再次输入密码"><span class="error">请输入密码</span></p>        
        <p><input type="submit" id="repwd2" name="" value="重置" disabled="disabled" ></p>
        

        <p class="txt"><a href="reg.jsp"><span></span>没有账号？去注册</a></p>
        <!--<a href="#" class="off"><img src="img/temp/off.png"></a>--></form>
</div>
<script src="js/jquery.flexslider-min.js" type="text/javascript" charset="utf-8"></script>
<script src="js/jquery.cookie.js" type="text/javascript" charset="utf-8"></script>
<script src="js/jquery.base64.js" type="text/javascript" charset="utf-8"></script>
<script>
	var countdown=60;
	var email_code="a";
	$(function(){
	 	$('#repwd2').click(function(){
		var v1=$("input").eq(0).next().text();
	 	var v2=$("input").eq(1).next().text();
	 	var v3=$("input").eq(2).next().text();
	 	var v4=$("input").eq(3).next().text();
	 	if(v1==""&& v2=="ok" && v3=="" && v4 ==""){
		 
		var email=$("input").eq(0).val(); 
		var password=$("input").eq(2).val();
		var url="js/forget_userAccount.js?password="+password+"&email="+email;
		var args ={"email":$("input").eq(0).val(),
					"newPassword":$("input").eq(2).val()};//这里是点击修改密码功能，对应接口文档功能三
		$.post(url,args,function(data){
			if(data.success=="true"){
				window.location.href="login.jsp";
			}else{
				alert('error');
			}
		},"json")
	 	}})
	 
	 
	})
	
	function myFunction() {
		$("input").eq(1).next().empty();
	}
	
	function checkbutton(){//这是我的本地认证数据是否正确
		var v1=$("input").eq(0).next().text();
	 	var v2=$("input").eq(1).next().text();
	 	var v3=$("input").eq(2).next().text();
	 	var v4=$("input").eq(3).next().text();
		
	 	
	 	
	 	if(v1==""&& v2=="ok" && v3=="" && v4 ==""){
		 $("#repwd2").removeAttr("disabled");
		 $("#repwd2").css({background:"#C10000"});
		
		 
	 	}else{
		 $("#repwd2").attr("disabled","disabled"); 
		 $("#repwd2").css({background:""});
	 	}
	}
	
	function settime(val) {
		             var e = $("#userEmail").next().text();
		             
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
			var c=$("#userEmail").next().text();
			var p_value=$("#userEmail").val();
			if(c==""){
				var url="js/forget_userAccount.js?email="+p_value;//发送email按钮然后接受验证码
				var args ={"email":$("input").eq(0).val()};
				$.post(url,args,function(data){
					email_code=data.captcha;
					alert(email_code);
				},"json")
			}
		})
	})
	$(function(){
		$()
		
		$("input").focus(function(){
			var p_name=this.name;
			switch (p_name){
			case "userEmail" :
			
				$(this).next().empty();
				break;
				;
			case "code" :
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
			
			
			}
			
			
		})
		$("input").blur(function(){
			  var reg_test = /^\w+$/;
			  var reg_email_test = /([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)/;

			var p_name=this.name;
		
			switch (p_name){
			case "userEmail" :
				var p_value=this.value;
				if(p_value==""){
					
					$(this).next().empty().append("不能为空");
					$("#repwd1").attr("disabled","disabled"); 
					 $("#repwd1").css({background:""});
				}else{	if(!reg_email_test.test(p_value)){
					$("input").eq(1).next().empty().append("格式不符合邮箱");
					$("#repwd1").attr("disabled","disabled"); 
					 $("#repwd1").css({background:""});
				}else(
						$(function(){
						var url="js/forget_userAccount.js?email="+p_value;//查找邮箱是否存在，验证邮箱唯一
						var args ={"email":$("input").eq(0).val()};
						$.post(url,args,function(data){
						
								if(data.exist!="true"){
									$("input").eq(1).next().empty();
									$("#repwd1").removeAttr("disabled");
									 $("#repwd1").css({background:"#C10000"});
									 
								}else{
									$("input").eq(1).next().empty().append("此email已存在");
									$("#repwd1").attr("disabled","disabled"); 
									 $("#repwd1").css({background:""});
														 
								}
							
						},"json")
						
						})
						)}
				checkbutton();
				break;
				;
			case "code" :
				var p_value=this.value;
				if(p_value==email_code){		
					$(this).next().empty().append("ok")
						}else{
							$(this).next().empty().append("no")}
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
					$("input").eq(3).next().empty().append("非法字符");
				}else if(!(p_value.length>5&&p_value.length<17) ){
				 	$(this).next().empty().append("请限定长度在6—16"); }else{
				 		if(p_value!=$("input").eq(2).val()){
				 			$(this).next().empty().append("请输入正确密码");
				 		}
				 	}
			
				}
				checkbutton();
				break;
				;
			
			
			
			}
			
			
		})
	})
	

	</script>
</body>
</html>