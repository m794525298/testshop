<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="utf-8"/>
    <title>收藏夹</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/cart.css"/>
    <link rel="stylesheet" type="text/css" href="css/common.css"/>
</head>
<body><!--------------------------------------cart--------------------->
<div class="head">
    <div class="wrapper clearfix">
		<%@ include file="head1.jsp" %>
		<%@ include file="head2.jsp" %>	
    </div>
</div>
<div class="cart mt" style="margin-top:20px;"><!-----------------logo------------------->
    <!--<div class="logo"><h1 class="wrapper clearfix"><a href="index.html"><img class="fl" src="img/temp/logo.png"></a><img class="top" src="img/temp/cartTop01.png"></h1></div>-->
    <!-----------------site------------------->
    <div class="site"><p class=" wrapper clearfix"><span class="fl">收藏夹</span><a
            href="index.jsp" class="fr">继续购物&gt;</a></p></div><!-----------------table------------------->
    <div class="table wrapper">
        <div class="tr">
            <div>商品</div>
            <div>单价</div>
            <div>描述</div>
            <div>操作</div>
        </div>
        <div class="goods">

        </div>
        
        <div class="list-page">
					<div id="total_page" style="margin-bottom:20px;">一共条100，当前110</div> <a id="first_page">首页</a> <a id="previous_page">上一页</a> <a id="next_page">下一页</a>
					<a id="last_page">尾页</a>

				</div>
    </div>
</div>
<div class="mask"></div>
<div class="tipDel"><p>确定要从收藏夹移除该商品吗？</p>
    <p class="clearfix"><a class="fl cer" href="#">确定</a><a class="fr cancel" href="#">取消</a></p></div>
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
<script src="js/pro.js" type="text/javascript" charset="utf-8"></script>
<script src="js/jquery.SuperSlide.2.1.1.js" type="text/javascript" charset="utf-8"></script>
<script src="js/jquery.flexslider-min.js" type="text/javascript" charset="utf-8"></script>
<script src="js/jquery.cookie.js" type="text/javascript" charset="utf-8"></script>
<script src="js/jquery.base64.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
var storage=window.localStorage;
window.onload = function(){
	var url = "ShowUserCart";//对应帖子功能2 数据给你们 你们自己搞定
	var page = getUrlParam("page");
	if($.isEmptyObject(page)){
		page="1";
	}
	var args = {
		
		"userID" : $.cookie("userID"),
		"page" : page
	};

	$.post(
					url,
					args,
					function(data) {

						var num = data.num;

						$(".goods").empty();
						for (i = 0; i < num; i++) {
							var goodsID = data.goodsList[i].goodsID;
							var title = data.goodsList[i].title;
							var desc = data.goodsList[i].desc;
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
												'<div class="price">'+price+'</div>'+
												'<div class="price sAll" style="line-height:22px;">'+desc+'</div>'+
												'<div class="price"><a  href="javascript:void(0);" onClick="del('+goodsID+')">删除</a></div>'+
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

function del(goodsID){
	$(".mask").show();
    $(".tipDel").show();
    $(".cer").click(function () {
    	var url = "RemoveFromCart";
    	var args = {   		
    		"userID" : $.cookie("userID"),
    		"goodsID" : goodsID
    	};
    	$.post(url,args,function(data){
			if(data.success="true"){
				alert('删除成功');
				window.location.href="cart.jsp";
			}else{alert('删除失败');}
		},"json")
    	
        })
}

$(function(){

	
	 var userID=$.cookie("userID");
	
	
	

	var page=getUrlParam("page");
	
	
	if(page=="null"||page==null){
		page=1;
		
	}else{
		page=Number(page);}
	
	
	$("#first_page").click(function(){
	var	href="cart.jsp?userID="+userID+"&page=1";
		window.location.href=href;
	})
	$("#last_page").click(function(){
		
		var	href="cart.jsp?userID="+userID+"&page="+storage.getItem('totalPage');
		window.location.href=href;
	})
	$("#previous_page").click(function(){
		
		if(Number(storage.getItem('totalPage'))>page&&page>1){
			page=page-1;
			var	href="cart.jsp?userID="+userID+"&page="+page;}else{ var	href="cart.jsp?userID="+userID+"&page="+page;}
		window.location.href=href;
	})
	$("#next_page").click(function(){
		if(0<page&&page<Number(storage.getItem('totalPage'))){
			
			page=page+1;
			var	href="cart.jsp?userID="+userID+"&page="+page;}else{
				var	href="cart.jsp?userID="+userID+"&page="+page;}
			window.location.href=href;
	})
	

	
})
</script>
</body>
</html>