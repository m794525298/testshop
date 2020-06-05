<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="utf-8"/>
    <title>个人信息</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/mygxin.css"/>
    <link rel="stylesheet" type="text/css" href="css/cart.css"/>
    <link rel="stylesheet" type="text/css" href="css/common.css"/>
</head>
<body><!------------------------------head------------------------------>
<div class="head">
    <div class="wrapper clearfix">
		<%@ include file="head1.jsp" %>
		<%@ include file="head2.jsp" %>	
    </div>
</div><!------------------------------idea------------------------------>
<div class="Bott">
    <div class="wrapper clearfix">
        <div class="you fl" style="margin-bottom:10px;width:1060px;">
            <div class="tx clearfix">
                <div class="fl clearfix" style="float:left;margin-right:10px;"><a href="#" class="fl" id="img"></a>
                </div> 
                <div class="othergxin" style="float:left;">
                	<p><span id="OuserID"> </span>
                	<span id="Ousername"> </span>
	                <span id="OuserStun"> </span>
	                <span id="Ouseradd"> </span></p>
   			 	</div>                  
            </div>		
        </div>
        <div class="cart" style="float:left;margin-top:10px;background: #fff;">
        <div class="site"><p class=" wrapper clearfix"><span class="fl">他发布的商品</span></p></div>
			<div class="table wrapper">
        <div class="tr">
            <div>商品</div>
            <div>单价</div>
            <div>出售状态</div>
        </div>
        <div class="goods">

        </div>
        
        <div class="list-page">
					<div id="total_page" style="margin-bottom:20px;">一共条100，当前110</div> <a id="first_page">首页</a> <a id="previous_page">上一页</a> <a id="next_page">下一页</a>
					<a id="last_page">尾页</a>

				</div>
    </div>
</div>
</div>
</div>
<!--返回顶部-->
<div class="gotop"><a href="cart.html">
    <dl>
        <dt><img src="img/gt1.png"/></dt>
        <dd>去购<br/>物车</dd>
    </dl>
</a><a href="#" class="dh">
    <dl>
        <dt><img src="img/gt2.png"/></dt>
        <dd>联系<br/>客服</dd>
    </dl>
</a><a href="mygxin.html">
    <dl>
        <dt><img src="img/gt3.png"/></dt>
        <dd>个人<br/>中心</dd>
    </dl>
</a><a href="#" class="toptop" style="display: none;">
    <dl>
        <dt><img src="img/gt4.png"/></dt>
        <dd>返回<br/>顶部</dd>
    </dl>
</a>
    <p>400-800-8200</p></div><!--footer-->
<%@ include file="foot.jsp" %>
<script src="js/public.js" type="text/javascript" charset="utf-8"></script>
<script src="js/user.js" type="text/javascript" charset="utf-8"></script>
<script src="js/jquery.SuperSlide.2.1.1.js" type="text/javascript" charset="utf-8"></script>
<script src="js/jquery.flexslider-min.js" type="text/javascript" charset="utf-8"></script>
<script src="js/jquery.cookie.js" type="text/javascript" charset="utf-8"></script>
<script src="js/jquery.base64.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
var storage=window.localStorage;
window.onload = function(){
	var url = "js/other_userAccount.js";//对应帖子功能2 数据给你们 你们自己搞定
	var userID = getUrlParam("userID");
	var page = getUrlParam("page");
	if($.isEmptyObject(page)){
		page="1";
	}
	var args2 = {
		
		"userID" : userID,
		"page" : page
	};
	var args1 = {			
			"userID" : userID,
		};
	$.post(url,args1,function(data) {
		 userID=data.userID;			 			
		 var icon=data.icon;
		 var address=data.address;
		 var username=data.username;
		 var stunum=data.stunum;
		 $("#OuserID").text("用户ID："+userID);
		 $("#Ousername").text("用户昵称："+username);
		 $("#OuserStun").text("用户学号："+stunum);
		 $("#Ouseradd").text("用户地址："+address);
		 $("#img").eq(0).empty().append('<img src="'+icon+'"/>');
	}, "json")
	
	$.post(url,args2,function(data) {

						var num = data.num;

						$(".goods").empty();
						for (i = 0; i < num; i++) {
							var goodsID = data.goodsList[i].goodsID;
							var title = data.goodsList[i].title;
							var state = data.goodsList[i].state;
							var price = data.goodsList[i].price;
							var cover = data.goodsList[i].cover;
							
							
							
							var publisher_href = "detail.jsp?goodsID="
									+ goodsID;

							var totalPage = data.totalPage;
							storage['totalPage'] = totalPage;
							$(".goods")
									.append(
									        '<div class="th">'+
											'<div class="pro clearfix"><a class="fl"'+
                                            'href="#">'+
												'<dl class="clearfix">'+
												'<dt class="fl"><a  href="detail.jsp?goodsID='+goodsID+'"><img src='+cover+'></a></dt>'+
												'<dd class="fl"><p>'+title+'</p>'+
												'</dl>'+
												'</a></div>'+
												'<div class="price" style="text-align:center;">'+price+'</div>'+
												'<div class="price" style="text-align:center;"><a>'+state+'</a></div>'+
												'</div>');
							
							
						}

					}, "json")
		
}
jQuery(".bottom").slide({
    titCell: ".hd ul",
    mainCell: ".bd .likeList",
    autoPage: true,
    autoPlay: false,
    effect: "leftLoop",
    autoPlay: true,
    vis: 1
});

$(function(){

	
	 var userID=$.cookie("userID");
	
	
	

	var page=getUrlParam("page");
	
	
	if(page=="null"||page==null){
		page=1;
		
	}else{
		page=Number(page);}
	
	
	$("#first_page").click(function(){
	var	href="othergxin.jsp?userID="+userID+"&page=1";
		window.location.href=href;
	})
	$("#last_page").click(function(){
		
		var	href="othergxin.jsp?userID="+userID+"&page="+storage.getItem('totalPage');
		window.location.href=href;
	})
	$("#previous_page").click(function(){
		
		if(Number(storage.getItem('totalPage'))>page&&page>1){
			page=page-1;
			var	href="othergxin.jsp?userID="+userID+"&page="+page;}else{ var	href="othergxin.jsp?userID="+userID+"&page="+page;}
		window.location.href=href;
	})
	$("#next_page").click(function(){
		if(0<page&&page<Number(storage.getItem('totalPage'))){
			
			page=page+1;
			var	href="othergxin.jsp?userID="+userID+"&page="+page;}else{
				var	href="othergxin.jsp?userID="+userID+"&page="+page;}
			window.location.href=href;
	})
	

	
})

</script>
</body>
</html>