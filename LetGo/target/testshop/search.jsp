<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="utf-8"/>
    <title>武大小黑市</title>
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
</div><!------------------------------banner------------------------------>
<div class="banner"><a href="#"><img id="banner" src="img/temp/banner1.jpg"/></a></div>
<!-----------------address------------------------------->
<div class="address">
    <div class="wrapper clearfix" id="wrapper_clearfix">
    <a href="index.jsp">首页</a>
    <span>/</span>
    <a href="flowerDer.jsp">装饰摆件</a>
            <span>/</span>
            <a href="proList.jsp" class="on">
            干花花艺</a>
            </div>
</div><!-------------------current---------------------->
<!----------------proList------------------------->
<ul class="proList wrapper clearfix" id="search_list">
   <!-- <li><a href="proDetail.jsp">
        <dl>
            <dt><img src="img/temp/pro01.jpg"></dt>
            <dd>【最家】跳舞兰仿真花干花</dd>
            <dd>￥17.90</dd>
        </dl>
    </a></li>
      -->
</ul>
<div class="list-page">
				 <a id="first_page">首页</a> <a id="previous_page">上一页</a> <a id="next_page">下一页</a>
					<a id="last_page">尾页</a>

				</div><!----------------mask------------------->
<div class="mask"></div><!-------------------mask内容------------------->
	<div class="proDets">
		<img class="off" src="img/temp/off.jpg" />
		<div class="tit clearfix">
			<h4 class="fl" id="big_title">1</h4>
			<span class="fr" id="big_price">￥17.90</span>
		</div>
		<div class="proCon clearfix">
			<div class="proImg fl">
				<img class="list" src="img/temp/proDet.jpg" />
				<div class="smallImg clearfix">
					<img id="img_1" src="img/temp/proDet01.jpg"
						data-src="img/temp/proDet01_big.jpg"><img id="img_2"
						src="img/temp/proDet02.jpg" data-src="img/temp/proDet02_big.jpg"><img id="img_3"
						src="img/temp/proDet03.jpg" data-src="img/temp/proDet03_big.jpg"><img id="img_4"
						src="img/temp/proDet04.jpg" data-src="img/temp/proDet04_big.jpg">
						<img id="img_5"
						src="img/temp/proDet04.jpg" data-src="img/temp/proDet04_big.jpg">
				</div>
			</div>
			<div class="fr">
				<div class="proIntro">
					<p>商品介绍</p>
					
						<p id="desc" >1231231231111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111</p>
				
					<h3>
						卖家信息
					</h3>
					
						<p>卖家名称&nbsp<span id="name">请问请问</span>
							
						</p>
						<p>卖家地址&nbsp<span id="address">请问请问</span>
							
						</p>
						<p>卖家联系方式&nbsp<span id="contact">请问请问</span>
							
						</p>
					
				</div>
				<div class="btns clearfix">
					<a href="#2"><p class="buy fl">联系卖家</p></a><a href="#2">
					<p class="cart fr">加入收藏夹</p></a>
				</div>
			</div>
		</div>
		<a class="more" href="detail.jsp">查看更多细节</a>
	</div>
	<!--返回顶部-->

<div class="mask"></div><!--footer-->
	<%@ include file="foot.jsp" %>

<script>

var storage=window.localStorage;
$(function(){
	var banner_type=getUrlParam("type");
	switch(banner_type){
	case "1":
		$("#banner").attr("src","img/banner_book.jpg");
		break;
	
	case "2":
		$("#banner").attr("src","img/banner_shenghuo.jpg");
		break;
	case "3":
		$("#banner").attr("src","img/banner_food.jpg");
		break;
	case "4":
		$("#banner").attr("src","img/banner_qixie.jpg");
		break;
	case "5":
			$("#banner").attr("src","img/1.jpg");
		break;
	case "6":
		$("#banner").attr("src","img/banner_other.jpg");
		break;
	
	}
})
$(function(){
	var keywords=getUrlParam("keywords");
	if(keywords=="null"){
		keywords=null;
	}
	var b = $.isEmptyObject(keywords);
	if(b||keywords=="null"||keywords==null){
		
	}else{
		var decode_keywords=$.base64.decode(keywords);}
	
	var type=getUrlParam("type");
	if(type=="null"){
		type=null;
	}
	var page=getUrlParam("page");
	$("#wrapper_clearfix").empty();
	if(keywords==null&&type!=null){
		
		switch(type){
		case "1":
			var href="search.jsp?type="+type;
			var type_name="学习资料";
			
			break;
		case "2":
			var href="search.jsp?type="+type;
			var type_name="生活用品";
			
			break;
		case "3":
			var href="search.jsp?type="+type;
			var type_name="小食分享";
			
			break;
		case "4":
			var href="search.jsp?type="+type;
			var type_name="电子器械";
		
			break;
		case "5":
			var href="search.jsp?type="+type;
			var type_name="二次元专区";
			break;
		case "6":
			var href="search.jsp?type="+type;
			var type_name="其他";
		
			break;
		}
		
		$("#wrapper_clearfix").append("<a href='index.jsp'>首页</a>"+ "<span>/</span>"+
	    "<a href="+href+">"+type_name+"</a>");
		
	}
	if(keywords!=null&&type==null){
		
		href_keywords="search.jsp?keywords="+keywords;
		
		
		$("#wrapper_clearfix").append("<a href='index.jsp'>首页</a>"+ "<span>/</span>"+
	    "<a href="+href_keywords+">"+decode_keywords+"</a>");
		
	}
	if(keywords!=null&&type!=null){
	
		href_keywords="search.jsp?keywords="+keywords;
	
	decode_keywords=$.base64.decode(keywords);

		switch(type){
		case "1":
			var href="search.jsp?type="+type;
			var type_name="学习资料";
			break;
		case "2":
			var href="search.jsp?type="+type;
			var type_name="生活用品";
			break;
		case "3":
			var href="search.jsp?type="+type;
			var type_name="小食分享";
			break;
		case "4":
			var href="search.jsp?type="+type;
			var type_name="电子器械";
			break;
		case "5":
			var href="search.jsp?type="+type;
			var type_name="其他";
			break;
			
		}
		
		$("#wrapper_clearfix").append("<a href='index.jsp'>首页</a>"+ "<span>/</span>"+
	    "<a href="+href+">"+type_name+"</a>"+"<span>/</span>"+
       "<a href="+href_keywords+" class='on'>"+
       decode_keywords +"</a>");
		
	}
	
	
	
})
/*  function getsearchservler(){
	var keyword=getUrlParam("keywords");
	var type=getUrlParam("type");

	var page=getUrlParam("page");
	url="js/search_test.js";
	var args ={"keyword":keyword,
			"type":type,
			"page":page};
	
$.post(url,args,function(data){
	for(i=0;i<20;i++){
		var totalpage=data.totalPage;
		var goodsID=data.goods.good[i].goodsID;
		var title=data.goods.good[i].title;
		var price=data.goods.good[i].price;
		var cover=data.goods.good[i].cover;
		 var href="detail.jsp?goodsID="+goodsID;
		storage["totalPage"]=data.totalPage;
		
	
		 $("#search_list").append( 
        " <li><a href='proDetail.jsp'>"+
	       " <dl>"+
"  <dt><img src='img/temp/pro01.jpg'></dt>"+
" <dd>【最家】跳舞兰仿真花干花</dd>"+
 "<dd>￥17.90</dd>"+
"     </dl>"+
" </a></li>"	 
				 
			); 
		 $("#total_page").empty().text("一共"+storage.getItem("totalPage")+",现在第"+page+"页");
	}
},"json")
}  */

$(function(){

	
	 var keyword=getUrlParam("keywords");
	
	
	var type=getUrlParam("type");

	var page=getUrlParam("page");
	if(keywords=="null"){
		keywords=null;
	}
	if(type=="null"){
		type=null;
	}
	if(page=="null"||page==null){
		page=1;
		
	}else{
		page=Number(page);}
	
	
	$("#first_page").click(function(){
		href="search.jsp?keywords="+keyword+"&type="+type+"&page=1";
		window.location.href=href;
	})
	$("#last_page").click(function(){
		
		href="search.jsp?keywords="+keyword+"&type="+type+"&page="+storage.getItem('totalPage');
		window.location.href=href;
	})
	$("#previous_page").click(function(){
		
		if(Number(storage.getItem('totalPage'))>page&&page>1){
			page=page-1;
		href="search.jsp?keywords="+keyword+"&type="+type+"&page="+page;}else{href="search.jsp?keywords="+keyword+"&type="+type+"&page="+page;}
		window.location.href=href;
	})
	$("#next_page").click(function(){
		if(0<page&&page<Number(storage.getItem('totalPage'))){
			
			page=page+1;
			href="search.jsp?keywords="+keyword+"&type="+type+"&page="+page;}else{
				href="search.jsp?keywords="+keyword+"&type="+type+"&page="+page;}
			window.location.href=href;
	})
	

	
})
 $(function(){
	
	var keyword=getUrlParam("keywords");
	if(keyword==""||keyword==null||keyword=="null"){
		keyword=null;
	}
	var type=getUrlParam("type");
	if(type==""||type==null||type=="null"){
		type=null;
	}
	var page=getUrlParam("page");
	if(page==""||page==null||page=="null"){
		page="1";
	}
	/* url="js/search_test.js";		// 搜索功能 */
	url="SearchGoods";
	var args ={
			"keyword":keyword,
			"type":type,
			"page":page};
	
$.post(url,args,function(data){
	
	for(i=0;i<20;i++){
		var totalpage=data.totalPage;
		var goodsID=data.goods[i].goodsID;
		var title=data.goods[i].title;
		var price=data.goods[i].price;
		var cover=data.goods[i].cover;
		 var href="detail.jsp?goodsID="+goodsID;
		 storage["totalPage"]=data.totalPage;
	var add_code="<li><a href="+href+">"+
    "  <dl>"+
    " <dt><img class='search_item'  src="+cover+"></dt>"+
     "<dd>"+title+"</dd>"+
    " <dd>￥"+price+"</dd>"+
    "<a class='show_detail' id='show_detail' value="+goodsID+" >显示详细</a>"+
 "</dl>"+
" </a></li>";

var row=$(add_code);
		 $("#search_list").append( row	);  

	
		
	}

	

},"json")
}) 
$(function(){
	$("#search_list").on('click','[class="show_detail"]',function(){
		var goodID=$(this).attr("value");
		url="js/detail_test.js";
		arg={
				"goodID":goodID
		};
		$.post(url,arg,function(data){
			
			
			var goodsID =data.goodsID;
			var title=data.title;
			var type =data.type;
			var desc =data.desc;
			var state=data.state;
			var  price=data.price;
			var count=data.count;
			var publisher=data.publisher;
			var publisherName=data.publisherName;
			var contact=data.contact;
			var address=data.address;
			var img_1=data.imgs[0].img;
			var img_2=data.imgs[1].img;
			var img_3=data.imgs[2].img;
			var img_4=data.imgs[3].img;
			var img_5=data.imgs[4].img;
			var detail_href="detail.jsp?goodsID="+goodsID;
			$("#big_title").text(title);
			 $("#big_price").text("￥"+price);
			 $("#desc").text(desc);
			 $("#name").text(publisherName);
			 $("#address").text(address);
			 $("#contact").text(contact);
			$(".mask").css("display","block");
			$(".proDets").css("display","block");
			$("#img_1").attr("src",img_1);
			$("#img_1").attr("data-src",img_1);
			$("#img_2").attr("src",img_2);
			$("#img_2").attr("data-src",img_2);
			$("#img_3").attr("src",img_3);
			$("#img_3").attr("data-src",img_3);
			$("#img_4").attr("data-src",img_4);
			$("#img_4").attr("src",img_4);
			$("#img_5").attr("data-src",img_5);
			$("#img_5").attr("src",img_5);
			$(".more").attr("href",detail_href);
		},"json")
		
	})
})
$(function(){
	 
})

/*  $(function(){
	 $("dasd").click(function(){
		var keyword=getUrlParam("keywords");
		var type=getUrlParam("type");

		var page=getUrlParam("page");
		url="js/search_test.js";
		var args ={"keyword":keyword,
				"type":type,
				"page":page};
	$.post(url,args,function(data){
		for(i=0;i<20;i++){
			var totalpage=data.totalPage;
			var goodsID=data.goods.good[i].goodsID;
			var title=data.goods.good[i].title;
			var price=data.goods.good[i].price;
			var cover=data.goods.good[i].cover;
			var href="detail.jsp?goodsID="+goodsID;
			 $("#search_list").append( "<li class='search_list' value="+goodsID+"><a href="+href+">"+
				      "  <dl>"+
			           " <dt><img src="+cover+"></dt>"+
			            "<dd>"+title+"</dd>"+
			           " <dd>￥"+price+"</dd>"+
			        "</dl>"+
			   " </a></li>"
					 
					 
				); 
		}
	},"json")
	})})
 */
	

</script>

</body>
</html>