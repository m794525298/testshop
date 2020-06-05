<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="utf-8"/>
    <title>我的消息</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/myorder.css"/>
    <link rel="stylesheet" type="text/css" href="css/common.css"/>
</head>
<body><!------------------------------head------------------------------>
<div class="head">
    <div class="wrapper clearfix">
		<%@ include file="head1.jsp" %>
		<%@ include file="head2.jsp" %>	
    </div>
</div><!------------------------------idea------------------------------>
<div class="address mt">
    <div class="wrapper clearfix"><a href="index.jsp" class="fl">首页</a><span>/</span><a href="mymessage.jsp" class="on">我的交易</a><span>/</span><a
            href="mymessage.jsp" class="on">我的消息</a></div>
</div><!------------------------------Bott------------------------------>
<div class="Bott">
    <div class="wrapper clearfix">
        <div class="zuo fl">
			<%@ include file="head3.jsp" %>
		</div>
        <div class="you fl">
            <div class="my clearfix" style="margin:40px 0 32px;"><h2 class="fl">我的消息</h2></div>
            
            <div class="message_all">
              
                
                
            </div>           
            <div class="list-page">
					 <a id="first_page">首页</a> <a id="previous_page">上一页</a> <a id="next_page">下一页</a>
					<a id="last_page">尾页</a>

				</div>
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
<script src="js/jquery.SuperSlide.2.1.1.js" type="text/javascript" charset="utf-8"></script>
<script src="js/jquery.flexslider-min.js" type="text/javascript" charset="utf-8"></script>
<script src="js/jquery.cookie.js" type="text/javascript" charset="utf-8"></script>
<script src="js/jquery.base64.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
var storage=window.localStorage;
window.onload = function(){
	/* var url = "js/message.js";//对应帖子功能2 数据给你们 你们自己搞定 */
	var url = "ShowUserReply"
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

						$(".message_all").empty();
						for (i = 0; i < num; i++) {
							var goodsID = data.commentList[i].goodsID;
							var publisher = data.commentList[i].publisher;
							var publisherName = data.commentList[i].publisherName;
							var time = data.commentList[i].time;
							var icon = data.commentList[i].icon;
							var content = data.commentList[i].content;
							
							var goods_href = "detail.jsp?goodsID="
								+ goodsID;
							var publisher_href = "othergxin.jsp?userID="
									+ publisher;

							var totalPage = data.totalPage;
							storage['totalPage'] = totalPage;
							$(".message_all")
									.append(
											'<div class="dkuang"><p class="one">'+content+'</p>'+
							                '<div class="word clearfix">'+
							                    '<ul class="fl clearfix">'+							                        
							                        '<li><a href="'+publisher_href+'" class="fl"><img src="'+icon+'" style="width:90px;"/></a>'+
							                        '<li style="color:#262626;font-size:15px;"><p>用户昵称：'+publisherName+'</p>'+
							                        '<p>时间：'+time+'</p>'+
							                        '<p><a  href="javascript:void(0);" onClick="del('+goodsID+')">点此跳转至商品页面</a></p>'+
							                        '</li>'+							                        
							                    '</ul>'+
							                    '</div>'+
							            '</div>' 
							            );
							
							
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
		window.location.href="detail.jsp?goodsID="+goodsID;		
}

$(function(){

	
	 var userID=$.cookie("userID");
	
	
	

	var page=getUrlParam("page");
	
	
	if(page=="null"||page==null){
		page=1;
		
	}else{
		page=Number(page);}
	
	
	$("#first_page").click(function(){
	var	href="mymessage.jsp?userID="+userID+"&page=1";
		window.location.href=href;
	})
	$("#last_page").click(function(){
		
		var	href="mymessage.jsp?userID="+userID+"&page="+storage.getItem('totalPage');
		window.location.href=href;
	})
	$("#previous_page").click(function(){
		
		if(Number(storage.getItem('totalPage'))>page&&page>1){
			page=page-1;
			var	href="mymessage.jsp?userID="+userID+"&page="+page;}else{ var	href="mymessage.jsp?userID="+userID+"&page="+page;}
		window.location.href=href;
	})
	$("#next_page").click(function(){
		if(0<page&&page<Number(storage.getItem('totalPage'))){
			
			page=page+1;
			var	href="mymessage.jsp?userID="+userID+"&page="+page;}else{
				var	href="mymessage.jsp?userID="+userID+"&page="+page;}
			window.location.href=href;
	})
	

	
})
</script>
</body>
</html>