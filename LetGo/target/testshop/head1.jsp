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
<script src="js/jquery.base64.js" type="text/javascript" charset="utf-8"></script>
</head>
<body><!------------------------------head------------------------------>
        <div class="clearfix" id="top"><h1 class="fl"><a href="index.jsp"><img src="img/logo.png"/></a></h1>
            <div class="fr clearfix" id="top1"><p class="fl"><a href="login.jsp" id="login">登录</a><a href="reg.jsp" id="reg.jsp">注册</a>
            </p>
               <form class="fl"><input id="keywords"  onkeydown="clientClickButton(event)" type="text" placeholder="鲁滨逊漂流记"/><input
                        type="button" id="search_button"/></form>
                <div class="btn fl clearfix"><a href="regrxx.jsp"><img src="img/grzx.png"/></a>
                <a href="post.jsp" class="er1"><img
                        src="img/ewm.png"/></a>
                    </div>
            </div>
        </div>

<script type="text/javascript">
function getUrlParam(name) {//封装方法
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
	var r = window.location.search.substr(1).match(reg); //匹配目标参数
	if (r != null) return unescape(r[2]);
	return null;} //返回参数值
function clientClickButton(event) {
        if (event.keyCode == 13) {
            var searchSpan = $("#search_button");
            searchSpan.click();
            event.returnValue = false;
        }
    }


$(function(){
	$("#search_button").click(function(){
		var keywords_test=/[#\$%\^&\*<>]+/g;
		var keywords=$("#keywords").val();
		if(keywords_test.test(keywords)){
		alert("请不要搜索非法字符");
		
		return;
	}
		var placeholder=$("#keywords").attr("placeholder");
		var type=getUrlParam("type");
	
		if($.isEmptyObject(type)){
			type=null;
		}
		if(keywords ==''||keywords ==null){
			
			keywords=placeholder;
		}
		 var _t = $.base64.encode(keywords);
		 window.location.href="search.jsp?"+"keywords="+_t+"&type="+type;
		
	})
})
$(function(){
	var keywords_test=/[@#\$%\^&\*<>]+/g;
		
	var keywords=getUrlParam("keywords");	
	if(keywords==null||keywords=="null"){
		
	}else{
		
	var decode_keywords =$.base64.decode(keywords);
	if(keywords_test.test(decode_keywords)){
		alert("请不要搜索非法字符");
		
		return;
	}
	if(decode_keywords=='null'){
		
	}else{
		
		$("#keywords").val(decode_keywords);
	}
		
	}
})	
$(function(){
	
	if($.cookie('userID')&&storage.getItem('username')!=null){
		var username=storage.getItem('username');
	$(".fl").eq(1).empty().append("<a href='#' id='login'>欢迎 "+username+"</a>");
	var userID=$.cookie('userID');
	
	var uid = storage.getItem('icon');
	}
		

		
})


</script>

</body>
</html>