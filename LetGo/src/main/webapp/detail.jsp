<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>LetGo</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/proList.css"/>
       <link rel="stylesheet" type="text/css" href="css/common.css"/>
    <script src="js/jquery-1.12.4.min.js"></script>
	<script src="js/jquery.flexslider-min.js" type="text/javascript" charset="utf-8"></script>
	<script src="js/jquery.cookie.js" type="text/javascript" charset="utf-8"></script>
</head>
<body><!------------------------------head------------------------------>
<div class="head">
    <div class="wrapper clearfix">
		<%@ include file="head1.jsp" %>
		<%@ include file="head2.jsp" %>	
    </div>
</div><!-----------------address------------------------------->

<div class="detCon">
    <div class="proDet wrapper">
        <div class="proCon clearfix">
            <div class="proImg fl"><img class="det" id="img_show" src="img/temp/blank.png"/>
                <div class="smallImg clearfix"><img id="img_1"  src="img/temp/blank.png"
                                                    data-src="img/temp/proDet01_big.jpg"><img id="img_2" 
                        src="img/temp/blank.png" data-src="img/temp/proDet02_big.jpg"><img id="img_3" 
                        src="img/temp/blank.png" data-src="img/temp/proDet03_big.jpg"><img id="img_4" 
                        src="img/temp/blank.png" data-src="img/temp/proDet04_big.jpg"> <img id="img_5" 
                        src="img/temp/blank.png" data-src="img/temp/proDet04_big.jpg"></div>
            </div>
            <div class="fr intro">
                <div class="title"><h4  id="title"></h4>
                	<div class="state"><a id="state"></a></div>
                    <p id="desc"></p><span id="price">￥0.0</span><br><br><span id="count"></span>
                </div>
                <div class="proIntro">
                  <h3>
						卖家信息
					</h3>
					
						<p>卖家名称&nbsp<a id="name"></a>
							
						</p>
						<p>卖家地址&nbsp<span id="address"></span>
							
						</p>
						<p>联系方式（QQ)&nbsp<span id="contact"></span>
							
						</p>
                   
                  
                      
                </div>
                <div class="btns clearfix">
                	<a id="contactmerchant" href="#2"><p class="buy fl">联系商家</p></a><a href="#2">
                	<p id="cart_but" class="cart fr">加入收藏夹</p></a>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="introMsg wrapper clearfix">
    <div class="msgL fl" >
        <div class="msgTit clearfix"><a class="on">所有评价</a></div>
 
          
           
               <div class="comment_all">
              
                
                
            </div>
        <div class="list-page">
					 <a id="first_page">首页</a> <a id="previous_page">上一页</a> <a id="next_page">下一页</a>
					<a id="last_page">尾页</a>

				</div>
    </div>
    
</div>
<div class="like"><h4>发表评论</h4>
   <form id="myForm" onsubmit="return false";>
				<div class="response">
					<div class="response_to_area">
						<a>response to:</a><a class="response_to"></a>
					</div>
					<div>
						<textarea id="textarea" maxlength="240"  class="form-control" row="10"
							style="width: 100%; height: 200px; white-space: normal; word-wrap: break-word; font-size: 15px;"
							value="这是可以回复评论"></textarea>
					</div>
					<div>
						<button type="button" style="{float: right;}" id="submit" value="发表" class="btn btn-default btn-lg active pull-right">发布评论</button>
					</div>
				</div>
			</form>
</div><!--返回顶部-->

<div class="msk"></div><!--footer-->
<%@ include file="foot.jsp" %>
     </div>
<script src="js/jquery-1.12.4.min.js" type="text/javascript" charset="utf-8"></script>
<script src="js/jquery.SuperSlide.2.1.1.js" type="text/javascript" charset="utf-8"></script>
<script src="js/public.js" type="text/javascript" charset="utf-8"></script>
<script src="js/nav.js" type="text/javascript" charset="utf-8"></script>
<script src="js/pro.js" type="text/javascript" charset="utf-8"></script>
<script src="js/cart.js" type="text/javascript" charset="utf-8"></script>
<script src="js/jquery.flexslider-min.js" type="text/javascript" charset="utf-8"></script>
<script src="js/jquery.cookie.js" type="text/javascript" charset="utf-8"></script>
<script src="js/jquery.base64.js" type="text/javascript" charset="utf-8"></script>

<script type="text/javascript">
var storage=window.localStorage;

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
	var goodsID=getUrlParam("goodsID");
	/* var url="js/detail_test.js";*/ 
	var url="GoodsDetail";
	var args={
			"goodsID":goodsID
	}
	$.post(url,args,function(data){
		var goodsID =data.goodsID;
		var title=data.title;
		var type =data.type;
		var desc =data.desc;
		var state =data.state;
		var price=data.price;
		var count=data.count;
		var publisher=data.publisher;
		var publisherName=data.publisherName;
		var contact=data.contact;
		var address=data.address;
		
		var i=0;
		if(i<data.img.length){
			var img_1=data.img[i];
			i++;
			$("#img_1").attr("src",img_1);
		$("#img_1").attr("data-src",img_1);
		}
		if(i<data.img.length){
			var img_2=data.img[i];
			i++;
			$("#img_2").attr("src",img_2);
		$("#img_2").attr("data-src",img_2);
		}else{
			var img_2="img/flo5.jpg";
			$("#img_2").remove();
		}
		if(i<data.img.length){
			var img_3=data.img[i];
			i++;
			$("#img_3").attr("src",img_3);
		$("#img_3").attr("data-src",img_3);
		}else{
			var img_3="img/flo5.jpg";
			$("#img_3").remove();
				i++;
		}
		
		if(i<data.img.length){
			var img_4=data.img[i];
			i++;
				$("#img_4").attr("data-src",img_4);
		$("#img_4").attr("src",img_4);
		}else{
			var img_4="img/flo5.jpg";
				i++;
				$("#img_4").remove();
		}
		
		if(i<data.img.length){
			var img_5=data.img[i];
			i++;
			$("#img_5").attr("data-src",img_5);
		$("#img_5").attr("src",img_5);
		}else{
			var img_5="img/flo5.jpg";
				i++;
				$("#img_5").remove();
		}
		
		
		var publisher_href="othergxin.jsp?userID="+publisher;
		if(state=="1"){
			$("#state").text("已售罄");
		}
		 $("#title").text(title);
		 $("#desc").text(desc);
		 $("#count").text("总量: "+count);
		 $("#price").text("￥"+price);
		 $("#name").text(publisherName);
		 $("#name").attr("href",publisher_href);
		 $("#address").text(address);
		 $("#contact").text(contact);
		 var contact_href="tencent://message/?uin="+contact+"&Site=qq&Menu=yes";
		$("#contactmerchant").attr("href",contact_href);
		$("#img_show").attr("src",img_1);
		
		
		
	
		
		
	},"json")
	
})
$(function(){
	$("#cart_but").click(
			function(){
				if($.cookie("userID") != null && $.cookie("userID") != "null") {
					alert("请先登录");
					window.location.href="login.jsp";
					return;
				}

				var cart=$("#cart_but").text();
				
				if(cart=="加入收藏夹"){
					url="AddToFavorite";//加入收藏夹的接口
					var state="1";
					
				}else{
					url="RemoveFromFavorite";//移除收藏夹的接口
					var state="0";
				
				}
				var goodsID = getUrlParam("goodsID")
			var args={
					"userID":$.cookie("userID"),
					"goodsID":goodsID
				}
			$.post	(url,args,function(data){
				if(data.success="true"){
					if(state=="1"){
						alert("收藏成功");
						$("#cart_but").text("移除收藏夹");
						
					}else{
						alert("移除收藏成功");
						$("#cart_but").text("加入收藏夹");
					}
				}else{alert('后端返回false');}
			},"json")
				
			})
})
$(function(){
	var goodsID = getUrlParam("goodsID")
	var args={
			"userID":$.cookie("userID"),
			"goodsID":goodsID};
	var url="IsCartExist";//检测是否存在于用户收藏夹
			$.post(url,args,function(data){
				if(data.exist=="true"){
					$("#cart_but").text("移除收藏夹");
				}else{
					$("#cart_but").text("加入收藏夹");
				}
				
		
			
		
			},"json")
				
				
			
})
	$(function() {
			$(".comment_all")
					.on(
							'click',
							'[class="response_but"]',
							function(event) {
								var parent = $(event.target).attr("parent");
								var parentPublisher = $(event.target).attr(
										"parentPublisher");

								var publisherName = $(event.target).attr(
										"publisherName");
							
								$(".response_to").empty().append(
										publisherName);
								$(".response_to").attr("parent", parent);
								$(".response_to").attr("parentPublisher",
										parentPublisher);
								$('html,body').animate({
									scrollTop : $('#textarea').offset().top
								}, 800);

							})
		})
$(function() {
			$("#submit").click(
					function() {

						var content = $("#textarea").val();

						var parent = $(".response_to").attr('parent');
						var parentPublisher = $(".response_to").attr(
								'parentPublisher');
						if(parentPublisher==null||parentPublisher==""){
							parentPublisher="";
						}
						
				
						if(content==null||content==""){
							alert('请填写消息内容');
							return;			 //实际使用请把这个注释去掉
						}
					
						/*	params=params.replace(new RegExp("\n", "gm"), '<br/>'); */
						var goodsID = getUrlParam("goodsID")
						if($.cookie("userID") != null && $.cookie("userID") != "null") {
							alert("请先登录");
							window.location.href="login.jsp";
							return;
						} else {
							var commentPublisher = $.cookie('userID');
						}
						var url = "PublishComment"; //发表评论功能 对应功能3
							/*var url = "js/detail_comment_test.js";*/
					content=$('<div>').text(content).html();
					content=content.replace(/\ /g, "&nbsp");
					content=content.replace(new RegExp("\n", "gm"), '<br/>');
						
					
						var args = {
							"goodsID" : goodsID,
							"content" : content,
							"publisher" : commentPublisher,
							"parentUserID" : parentPublisher

						};
						
						
						$.post(url, args, function(data) {
							if (data.success == "true") {
								alert('发布成功');
								window.location.reload();
							} else {
								alert('发布失败');
							}

						}, "json")

					})

		})
$(function() {
			var url = "ShowGoodsComments";//对应帖子功能2 数据给你们 你们自己搞定
			/*var url = "js/detail_comment_test.js";*/
			var goodsID = getUrlParam("goodsID");
			var page = getUrlParam("page");
			if($.isEmptyObject(page)){
				page="1";
			}
			var args = {
				
				"goodsID" : goodsID,
				"page" : page
			};

			$
					.post(
							url,
							args,
							function(data) {

								var num = data.num;

								$(".comment_all").empty();
								for (i = 0; i < num; i++) {
									var commentID = data.commentList[i].commentID;
									var publisher = data.commentList[i].publisher;
									var publisherName = data.commentList[i].publisherName;
									var time = data.commentList[i].time;
									var icon = data.commentList[i].icon;
									var commentParentUsername = data.commentList[i].commentParentUsername;
									var content = data.commentList[i].content;
									var commentParentUserID = data.commentList[i].commentParentUserID;
									
									
									var publisher_href = "othergxin.jsp?userID="
											+ publisher;
									var comment_publisher_href = "othergxin.jsp?userID="
											+ commentParentUserID;

									var totalPage = data.totalPage;
									storage['totalPage'] = totalPage;
									var comment_all_append;
									if(commentParentUsername!=""){
										comment_all_append='<div class="per clearfix"><img class="fl" style="{width:20px;height:20px;}" src='+icon+'>'+
								                   '<div class="perR fl"><p ><a href='+publisher_href+'>'+publisherName+'</a></p>'+
								                       ' <p>'+content+'</p>'+
								                       ' <p><span>'+time+'</span><span>回复给：<a href='+comment_publisher_href+'>'+commentParentUsername+'</a></span></p> <div><a class="response_but" parent="'+commentID+'"parentPublisher="'+publisher+'"publisherName="'+publisherName+'"> 回复</a></div></div>'+
								                      
								               ' </div>'
									}else{
										comment_all_append='<div class="per clearfix"><img class="fl" style="{width:20px;height:20px;}" src='+icon+'>'+
								                   '<div class="perR fl"><p ><a href='+publisher_href+'>'+publisherName+'</a></p>'+
								                       ' <p>'+content+'</p>'+
								                       ' <p><span>'+time+'</span></p> <div><a class="response_but" parent="'+commentID+'"parentPublisher="'+publisher+'"publisherName="'+publisherName+'"> 回复</a></div></div>'+
								                      
								               ' </div>'
									}
									$(".comment_all")
											.append(comment_all_append);
									
									
								}

							}, "json");

		})
$(function(){

	
	 var goodsID=getUrlParam("goodsID");
	
	
	

	var page=getUrlParam("page");
	
	
	if(page=="null"||page==null){
		page=1;
		
	}else{
		page=Number(page);}
	
	
	$("#first_page").click(function(){
	var	href="detail.jsp?goodsID="+goodsID+"&page=1";
		window.location.href=href;
	})
	$("#last_page").click(function(){
		
		var	href="detail.jsp?goodsID="+goodsID+"&page="+storage.getItem('totalPage');
		window.location.href=href;
	})
	$("#previous_page").click(function(){
		
		if(Number(storage.getItem('totalPage'))>page&&page>1){
			page=page-1;
			var	href="detail.jsp?goodsID="+goodsID+"&page="+page;}else{ var href="detail.jsp?goodsID="+goodsID+"&page="+page;}
		window.location.href=href;
	})
	$("#next_page").click(function(){
		if(0<page&&page<Number(storage.getItem('totalPage'))){
			
			page=page+1;
			var href="detail.jsp?goodsID="+goodsID+"&page="+page;}else{
				var href="detail.jsp?goodsID="+goodsID+"&page="+page;}
			window.location.href=href;
	})
	

	
})
</script>
</body>
</html>