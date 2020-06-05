<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="utf-8"/>
    <title>个人信息</title>
	<script src="js/public.js" type="text/javascript" charset="utf-8"></script>
	<script src="js/user.js" type="text/javascript" charset="utf-8"></script>
</head>
<body onlaod="load()">

        
            <h3><a href="#" id="img0"></a>
                <p class="clearfix"><span id="username1" class="fl">[羊羊羊]</span><span class="fr" onclick="logout()">[退出登录]</span></p></h3>
            <div>
				<h4>个人中心</h4>
                <ul>
                    <li><a href="regrxx.jsp">个人信息</a></li>
                    <li><a href="remima.jsp">修改密码</a></li>
					<li><a href="bindnum.jsp">学号绑定</a></li>
                </ul>
				<h4>我的交易</h4>
                <ul>
                    <li><a href="mymessage.jsp">我的消息</a></li>
                    <li><a href="mycomment.jsp">我的评论</a></li>
                </ul>
				<h4>我的商品</h4>
                <ul>
                    <li><a href="mygoods.jsp">发布商品</a></li>
                    <li><a href="goodslist.jsp">商品列表</a></li>
                </ul>
				<!--
				<h4>我的交易</h4>
                <ul>
                    <li><a href="cart.jsp">我的购物车</a></li>
                    <li><a href="myorderq.jsp">我的订单</a></li>
                    <li><a href="myprod.jsp">评价晒单</a></li>
                </ul>
                <h4>个人中心</h4>
                <ul>
                    <li><a href="mygxin.jsp">我的中心</a></li>
                    <li><a href="address.jsp">地址管理</a></li>
					<li><a href="mygoods.jsp">发布商品</a></li>
                </ul>
                <h4>账户管理</h4>
                <ul>
                    <li class="on"><a href="mygrxx.jsp">个人信息</a></li>
                    <li><a href="remima.jsp">修改密码</a></li>
                </ul>
				-->
            </div>
<script type="text/javascript">
//用户名还未处理
		var icon;
        var email;
        var username;
        
        $(document).ready(function() { 
         
        	icon=storage.getItem('icon');
			 email=storage.getItem('email');
			 username=storage.getItem('username');
			 $("#username").text(username);
			 $("#username1").text(username);
			 $("#useremail").text("邮箱："+email);
			 $("#img0").eq(0).empty().append('<img src="'+icon+'"/>');
			 $("#img").eq(0).empty().append('<img src="'+icon+'"/>');
        }); 
        
        	
//退出登录
function logout()
{
	//还未处理session
	//window.localStorage.clear();
	$.cookie('userID', null);
	$.cookie('account', null);
	$.cookie('identity', null);
	localStorage.removeItem("icon");
	localStorage.removeItem("account");
	localStorage.removeItem("contact");
	localStorage.removeItem("address");
	localStorage.removeItem("email");
	localStorage.removeItem("username");
	localStorage.removeItem("stunum");
	window.location.href="login.jsp";
}

</script>
</body>
</html>