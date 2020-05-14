<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="utf-8"/>
    <title>武大小黑市</title>
    <script src="js/jquery-1.12.4.min.js" type="text/javascript" charset="utf-8"></script>
<script src="js/public.js" type="text/javascript" charset="utf-8"></script>
<script src="js/nav.js" type="text/javascript" charset="utf-8"></script>
<script src="js/pro.js" type="text/javascript" charset="utf-8"></script>
<script src="js/cart.js" type="text/javascript" charset="utf-8"></script>
<script src="js/jquery.flexslider-min.js" type="text/javascript" charset="utf-8"></script>
<script src="js/jquery.cookie.js" type="text/javascript" charset="utf-8"></script>
</head>
<body><!------------------------------head------------------------------>
        <div class="clearfix" id="top"><h1 class="fl"><a href="index.jsp"><img src="img/logo.png"/></a></h1>
            <div class="fr clearfix" id="top1"><p class="fl"><a href="login.jsp" id="login">登录</a><a href="#" id="reg.jsp">注册</a>
            </p>
               <form action="#" method="get" class="fl"><input id="keywords" type="text" placeholder="web开发"/><input
                        type="button" id="search_button"/></form>
                <div class="btn fl clearfix"><a href="mygxin.jsp"><img src="img/grzx.png"/></a>
                <a href="#" class="er1"><img
                        src="img/ewm.png"/></a><a href="cart.jsp"><img src="img/gwc.png"/></a>
                    <p><a href="#"><img src="img/smewm.png"/></a></p></div>
            </div>
        </div>

<script type="text/javascript">
function getUrlParam(name) {//封装方法
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
	var r = window.location.search.substr(1).match(reg); //匹配目标参数
	if (r != null) return unescape(r[2]);
	return null;} //返回参数值

$(function(){
	$("#search_button").click(function(){
		var keywords=$("#keywords").val();
		var placeholder=$("#keywords").attr("placeholder");
	
		if(keywords == ''){
			alert(placeholder);
			keywords=placeholder;
		}
		 var _t = encodeURI(encodeURI(keywords));
		 window.location.href="search.jsp?"+"keywords="+_t;
		
	})
})
$(function(){
	
	if($.cookie('userID')){
		var username=storage.getItem('username');
	$(".fl").eq(1).empty().append("<a href='#' id='login'>欢迎 "+username+"</a>");
		
	}
		
	var userID=$.cookie('userID');
	
		var uid = storage.getItem('icon');
		
})


</script>
</body>
</html>