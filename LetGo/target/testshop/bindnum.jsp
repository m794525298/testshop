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
            href="bindnum.jsp" class="on">绑定学号</a></div>
</div><!------------------------------Bott------------------------------>
<div class="Bott">
    <div class="wrapper clearfix">
        <div class="zuo fl">
			<%@ include file="head3.jsp" %>
		</div>
        <div class="you fl"><h2>绑定学号</h2>
            <form action="#" method="get" class="remima">
            	 
                <p><span>学号：</span><input id="stun1" name="Stu" type="text" value=""/><span class="error">请输入学号</span></p>
                
                <p><span>邮箱：</span><input id="stun2" name="userEmail" type="text" value="" readonly="readonly"/><span class="error">请输入武大邮箱</span></p>
                
                <p><span>验证码：</span><input id="stun3" class="code" name="code" type="text" autocomplete="off" placeholder="输入邮箱验证码" ><button  type="button" style="width:80px;height:40px; margin-left:10px;padding-top:6px;"
              disable="" onclick=settime(this); id="repwd1">发送验证码</button><span></span></p>
                <p><span>地址：</span><input id="addr" name="Add" type="text" value=""/><span class="error">请输入地址</span></p>
                <p><span>联系方式：</span><input id="cont" name="Cont" type="text" value=""/><span class="error">请输入联系方式</span></p>
				<input type="submit" value="提交" id="bindsum" disabled="disabled"/>
			</form>
        </div>
    </div>
</div><!--返回顶部-->
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
</a><a href="mygxin.jsp">
    <dl>
        <dt><img src="img/gt3.png"/></dt>
        <dd>个人<br/>中心</dd>
    </dl>
</a><a href="#" class="toptop" style="display: none">
    <dl>
        <dt><img src="img/gt4.png"/></dt>
        <dd>返回<br/>顶部</dd>
    </dl>
</a>
    <p>400-800-8200</p></div><!--footer-->
<div class="footer">
    <div class="top">
        <div class="wrapper">
            <div class="clearfix"><a href="#2" class="fl"><img src="img/foot1.png"/></a><span class="fl">7天无理由退货</span>
            </div>
            <div class="clearfix"><a href="#2" class="fl"><img src="img/foot2.png"/></a><span class="fl">15天免费换货</span>
            </div>
            <div class="clearfix"><a href="#2" class="fl"><img src="img/foot3.png"/></a><span class="fl">满599包邮</span>
            </div>
            <div class="clearfix"><a href="#2" class="fl"><img src="img/foot4.png"/></a><span class="fl">手机特色服务</span>
            </div>
        </div>
    </div>
    <p class="dibu">最家家居&copy;2013-2017公司版权所有 京ICP备080100-44备0000111000号<br/>
        违法和不良信息举报电话：400-800-8200，本网站所列数据，除特殊说明，所有数据均出自我司实验室测试</p></div>
<script src="js/public.js" type="text/javascript" charset="utf-8"></script>
<script src="js/user.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
var username;
var countdown=60;
var id =$.cookie('userID');
/*
window.onload = function(){
	var url="js/bind.js?userID="+id;
	var args ={"userID":id};//这里是验证是否已绑定学号功能，对应接口文档功能三
	$.post(url,args,function(data){ 			
		 username=storage.getItem('username');
		 $("#username1").text(username);
		 if(data.found=="true"){
			 stunum=storage.getItem('stunum');
			 contact=storage.getItem('contact');
			 address=storage.getItem('address');
			 $("#stun1").val(stunum);
			 $("#addr").val(address);
			 $("#con").val(contact);
			 $("#stun1").eq(0).next().empty();
			}
	},"json")
		
}
*/

$(function(){
 	$('#bindsum').click(function(){
 		
 		
 		var v1=$("#stun1").eq(0).next().text();
	 	var v2=$("#stun2").eq(0).next().text();
	 	var v3=$("#stun3").eq(0).next().next().text();
	 	var v4=$("#addr").eq(0).next().text();
	 	var v5=$("#cont").eq(0).next().text();
 	if(v1=="" && v2==""&& v3=="ok"&& v4=="" && v5==""){
 	var stuNum=$("#stun1").eq(0).val();
 	var address=$("#addr").eq(0).val(); 
 	var contact=$("#cont").eq(0).val();
	var url="BindStuNum";
	var args ={"userID":id,
				"stuNum":stuNum,
				"address":address,
				"contact":contact};//这里是点击卖家认证功能，对应接口文档功能四
	$.post(url,args,function(data){
		if(data.success=="true"){
			$cookie("identity")=1;
			window.location.href="mygxin.jsp";
		}else{
			alert('error');
		}
	},"json")
 	}})
 
 
})

function checkbutton(){//这是我的本地认证数据是否正确
		var v1=$("#stun1").eq(0).next().text();
	 	var v2=$("#stun2").eq(0).next().text();
	 	var v3=$("#stun3").eq(0).next().next().text();
	 	var v4=$("#addr").eq(0).next().text();
	 	var v5=$("#cont").eq(0).next().text();
	 	
	 	if(v1=="" && v2==""&& v3=="ok"&& v4=="" && v5==""){
		 $("#bindsum").removeAttr("disabled");
		 $("#bindsum").css({background:"#C10000"});
		
		 
	 	}else{
		 $("#bindsum").attr("disabled","disabled"); 
		 $("#bindsum").css({background:""});
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
		var c=$("#stun2").eq(0).next().text();
		var p_value=$("#stun2").eq(0).val();
		if(c==""){
			var url="js/bind.js?email="+p_value;//发送email按钮然后接受验证码,对应功能四
			var args ={"email":p_value};
			$.post(url,args,function(data){
				email_code=data.captcha;
				alert(email_code);
			},"json")
		}
	})
})

$("input").blur(function(){
	  var reg_test = /^\d+$/;
	  var keywords_test=/[@#\$%\^&\*<>]+/g;
	  var reg_email_test = /([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)/;
	var p_name=this.name;

	switch (p_name){
	case "Stu" :
		
		var p_value=this.value;		
		if(p_value==""){
			
			$("#stun1").eq(0).next().empty().append("不能为空");
		}else{	
			
			
			if(!reg_test.test(p_value)){
				
				$("#stun1").eq(0).next().empty().append("非法字符");
		}else {
			
		 $(function(){
			 var url="js/bind.js?userID="+id;
				
				var args ={"userID":id};//这里是验证是否已绑定学号功能，对应接口文档功能三

				$.post(url,args,function(data){
						if(data.exist!="true"){
							$("#stun1").eq(0).next().empty();
							$("#stun2").eq(0).val($("#stun1").eq(0).val()+"@whu.edu.cn");
							alert($("#stun2").eq(0).val());							
							$("#repwd1").removeAttr("disabled");
							 $("#repwd1").css({background:"#C10000"});
							 
						}else{
							$("input").eq(1).next().empty().append("此学号已存在");
							$("#repwd1").attr("disabled","disabled"); 
							 $("#repwd1").css({background:""});
												 
						}
					
				},"json")
			})
			
	
		}
		}
		checkbutton();
		break;
		;
	case "userEmail" :
		var p_value=this.value;
		if(p_value==""){
			
			$("#stun2").eq(0).next().empty().append("不能为空");
			$("#repwd1").attr("disabled","disabled"); 
			 $("#repwd1").css({background:""});
		}else{	if(!reg_email_test.test(p_value)){
			$("#stun2").eq(0).next().empty().append("格式不符合邮箱");
			$("#repwd1").attr("disabled","disabled"); 
			 $("#repwd1").css({background:""});
		}else{
			$("#stun2").eq(0).next().empty();
			$("#repwd1").removeAttr("disabled");
			 $("#repwd1").css({background:"#C10000"});
		}}
		checkbutton();
		break;
		;
	case "code" :
		var captcha=this.value;
		if(captcha==""){
			$("#stun3").eq(0).next().next().text("不能为空");
		}else{
			var url="js/bind.js"; //这里是后台验证验证码是否正确 对应功能6
			
			var email=$("#stun2").eq(0).val();
			
			args={"email":email,"captcha":captcha};
			$.post(url,args,function(data){
				if(data.correct=="true"){
					$("#stun3").eq(0).next().next().text("ok");
					checkbutton();
					
				}
			},"json");
		}
		
		checkbutton();
		break;
		;
		
	case "Add" :
	case "Cont" :
	var p_value=this.value;
		
		if(p_value==""){
			
			$(this).next().empty().append("不能为空");
		}else{
			if(keywords_test.test(p_value)){
				$(this).next().empty().append("非法字符");
			}else{
				$(this).next().empty();
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