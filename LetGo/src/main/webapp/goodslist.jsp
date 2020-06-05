<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="utf-8"/>
    <title>最家</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/myorder.css"/>
	<link rel="stylesheet" type="text/css" href="css/mygrxx.css"/>

	<style type="text/css">
		.list-page a {
			margin: 0 5px;
			padding: 2px 7px;
			border: 1px solid #ccc;
			background: #f3f3f3;
		}
	</style>
</head>
<body><!------------------------------head------------------------------>
<div class="head">
    <div class="wrapper clearfix">
		<%@ include file="head1.jsp" %>
		<%@ include file="head2.jsp" %>	
    </div>
</div><!------------------------------idea------------------------------>
<div class="address mt">
    <div class="wrapper clearfix"><a href="index.jsp" class="fl">首页</a><span>/</span><a href="mygoods.jsp" class="on">我的商品</a><span>/</span><a
            href="goodslist.jsp" class="on">商品列表</a></div>
</div><!------------------------------Bott------------------------------>
<div class="Bott">
    <div class="wrapper clearfix">
        <div class="zuo fl">
			<%@ include file="head3.jsp" %>
		</div>
        <div class="you fl">
            <div class="my clearfix"><h2 class="fl">商品列表</h2><a href="#" class="fl">请谨防钓鱼链接或诈骗电话，了解更多&gt;</a></div>
            <div class="dlist clearfix">
                <ul class="fl clearfix" id="wa">
                    <li class="on"><a href="#2">全部有效订单</a></li>
                    <li><a href="#2">在售</a></li>
                    <li><a href="#2l">售罄</a></li>
                    <li><a href="#2">下架</a></li>
                </ul>
            </div>
            <div id="all" class="all">
				<!--
			    <div class="dkuang deng">
					<p class="one">在售</p>
					<div class="word clearfix">
						<p class="fr">售价：<span>99.00</span>元</p>
					</div>
					<div class="shohou clearfix">
						<a href="#" class="fl"><img src="img/g1.jpg"/></a>
						<p class="fl">
							<a href="#">介绍：<span>XXX</span></a>
							<a href="#">类别：<span>XXX</span></a>
							<a href="#">库存：<span>XXX</span></a>
						</p>
						<p class="fr">
							<a href="#2" id="edit0">修改状态</a>
							<a href="orderxq.jsp">订单详情</a>
						</p>
					</div>
				</div>
				<div class="dkuang deng">
					<p class="one">售罄</p>
					<div class="word clearfix">
						<p class="fr">售价：<span>99.00</span>元</p>
					</div>
					<div class="shohou clearfix">
						<a href="#" class="fl"><img src="img/g1.jpg"/></a>
						<p class="fl">
							<a href="#">介绍：<span>XXX</span></a>
							<a href="#">类别：<span>XXX</span></a>
							<a href="#">库存：<span>XXX</span></a>
						</p>
						<p class="fr">
							<a href="#2" id="edit0">修改状态</a>
							<a href="orderxq.jsp">订单详情</a>
						</p>
					</div>
				</div>
				<div class="dkuang deng">
					<p class="one">下架</p>
					<div class="word clearfix">
						<p class="fr">售价：<span>99.00</span>元</p>
					</div>
					<div class="shohou clearfix">
						<a href="#" class="fl"><img src="img/g1.jpg"/></a>
						<p class="fl">
							<a href="#">介绍：<span>XXX</span></a>
							<a href="#">类别：<span>XXX</span></a>
							<a href="#">库存：<span>XXX</span></a>
						</p>
						<p class="fr">
							<a href="#2" id="edit0">修改状态</a>
							<a href="orderxq.jsp">订单详情</a>
						</p>
					</div>
				</div>
				<div class="dkuang deng">
			
					<p class="one">售罄</p>
					<div class="word clearfix">
						<p class="fr">售价：<span>99.00</span>元</p>
					</div>
					<div class="shohou clearfix">
						<a href="#" class="fl"><img src="img/g1.jpg"/></a>
						<p class="fl">
							<a href="#">介绍：<span>XXX</span></a>
							<a href="#">类别：<span>XXX</span></a>
							<a href="#">库存：<span>XXX</span></a>
						</p>
						<p class="fr">
							<a href="#2" id="edit0">修改状态</a>
							<a href="orderxq.jsp">订单详情</a>
						</p>
					</div>
				</div>
				-->
			</div>
			<div class="list-page">
				<a id="first_page">首页</a>
				<a id="previous_page">上一页</a>
				<a id="next_page">下一页</a>
				<a id="last_page">尾页</a>
			</div>
        </div>
    </div>
</div>
<div class="mask"></div><!--编辑弹框-->
<div class="bj" id="A">
    <div class="clearfix"><a href="#" class="fr gb"><img src="img/icon4.png"/></a></div>
    <h3>修改商品信息</h3>
    <form action="#" method="get">
		<p>
			<label>商品名：</label><input id="edit_name" type="text" value="六六六" />
		</p>
		<p>
			<label>介 绍 ：</label><input id="edit_desc" type="text" />
		</p>
		<p>
			<label>价 格 ：</label><input id="edit_price" onkeydown="this.value=this.value.replace(/[^0-9.]/g,'')" type="text" />
		</p>
		<p>
			<label>库存 ：</label><input id="edit_count" onkeydown="this.value=this.value.replace(/[^0-9.]/g,'')" type="text" />
		</p>
		<p>
			<label>类别 ：</label>
			<select id="edit_type" value="1">
				<option value="1">学习资料</option>
				<option value="2">生活用品</option>
				<option value="3">小食分享</option>
				<option value="4">电子器械</option>
				<option value="5">二次元区</option>
				<option value="6">其他</option>
			</select>
		</p>
		<p>
			<label>状态 ：</label>
			<select id="edit_state" value="1">
				<option value="0">在售</option>
				<option value="1">售罄</option>
				<option value="2">下架</option>
			</select>
		</p>
        <div class="bc"><input type="button" value="保存" id="keep"/><input type="button" value="取消"/></div>
    </form>
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
<script src="js/jquery-1.12.4.min.js" type="text/javascript" charset="utf-8"></script>
<script src="js/public.js" type="text/javascript" charset="utf-8"></script>
<script src="js/user.js" type="text/javascript" charset="utf-8"></script>
<script src="js/jquery.flexslider-min.js" type="text/javascript" charset="utf-8"></script>
<script src="js/jquery.cookie.js" type="text/javascript" charset="utf-8"></script>
<script src="js/jquery.base64.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
var storage = window.localStorage;
	$(function(){
		var page=getUrlParam("page");
		
		if(page=="null"||page==null){
			page=1;	
		}else{
			page=Number(page);
		}
	
		$("#first_page").click(function(){
			href="goodslist.jsp?page=1";
			window.location.href=href;
		})
		$("#last_page").click(function(){	
			href="goodslist.jsp?page="+storage.getItem('totalPage');
			window.location.href=href;
		})
		$("#previous_page").click(function(){
			if(Number(storage.getItem('totalPage'))>page&&page>1){
				page=page-1;
				href="goodslist.jsp?page="+page;
			}else{
				href="goodslist.jsp?page="+page;
			}
			window.location.href=href;
		})
		$("#next_page").click(function(){
			if(0<page&&page<Number(storage.getItem('totalPage'))){
				page=page+1;
				href="goodslist.jsp?page="+page;
			}else{
				href="goodslist.jsp?page="+page;
			}
			window.location.href=href;
		})
	})
	$(function(){
	
		var userID = $.cookie("userID");

		var page=getUrlParam("page");
		if(page==""||page==null||page=="null"){
			page="1";
		}
		url="GoodsList";
		var args ={
			"userID":userID,
			"page":page
		};
	
		$.post(url,args,function(data){
			$("#all").empty();
			for(i=0;i<20;i++){
				var MGL_totalpage=data.MGL_totalPage;
				storage["MGL_totalpage"]=MGL_totalpage;
				var goodsID=data.goods[i].goodsID;
				var title=data.goods[i].title;
				var type=data.goods[i].type;
				var desc=data.goods[i].desc;
				var state=data.goods[i].state;
				var price=data.goods[i].price;
				var count=data.goods[i].count;
				var img1=data.goods[i].cover;
				switch(state){
					case"0":
						var state_name="在售";
						break;
					case"1":
						var state_name="售罄";
						break;
					case"2":
						var state_name="下架";
						break;
				}
				switch(type){
					case "1":
						var type_name="学习资料";
						break;
					case "2":
						var type_name="生活用品";
						break;
					case "3":
						var type_name="小食分享";
						break;
					case "4":
						var type_name="电子器械";
						break;
					case "4":
						var type_name="二次元区";
						break;
					case "6":
						var type_name="其他";
						break;
						
				}
				$("#all").append("<div class=\"dkuang deng\" id=\""+goodsID+"\"><p class=\"one\" id=\"state\">"+state_name+"</p><div class=\"word clearfix\"><p class=\"fr\" >售价：<span id=\"price\">"+price+"</span>元</p></div><div class=\"shohou clearfix\"><a href=\"#\" class=\"fl\"><img src=\""+img1+"\"/></a><p class=\"fl\"><a href=\"#\">商品名：<span id=\"title\">"+title+"</span></a><a href=\"#\">介绍：<span id=\"desc\">"+desc+"</span></a><a href=\"#\">类别：<span id=\"type\">"+type_name+"</span></a><a href=\"#\">库存：<span id=\"count\">"+count+"</span></a></p><p class=\"fr\"><a href=\"#A\" class=\"edit0\">修改状态</a></p></div></div>");
			}
		},"json")
	})
	
	$("#all").on("click",".edit0",function () {
        $(".mask").show();
        $(".bj").show();
		var id = $(this).parent().parent().parent().attr('id');
		var title=$("#all").find('#'+id).find('#title').text();
		var desc=$("#all").find('#'+id).find('#desc').text();
		var price=$("#all").find('#'+id).find('#price').text();
		var type=$("#all").find('#'+id).find('#type').text();
		var state=$("#all").find('#'+id).find('#state').text();
		switch(type){
		case "学习资料":
			var type_num=1;
		break;
		case "生活用品":
			var type_num=2;
		break;
		case "小食分享":
			var type_num=3;
			break;
		case "电子器械":
			var type_num=4;
			break;
		case "二次元区":
			var type_num=5;
			break;
		case "其他":
			var type_num=6;
			break;
		}
		switch(state){
			case "在售":
				var state_num=0;
				break;
			case "售罄":
				var state_num=1;
				break;
			case "下架":
				var state_num=2;
				break;
		}
				
		var count=$("#count").text();
		$("#edit_name").val(title);
		$("#edit_desc").val(desc);
		$("#edit_price").val(price);
		$("#edit_count").val(count);
		$("#edit_type").val(type_num);
		$("#edit_state").val(state_num);
		
		$("#keep").click(function(){
			var title=$("#edit_name").val();
			var desc=$("#edit_desc").val();
			var price=$("#edit_price").val();
			var type_num=$("#edit_type").val();
			var state_num=$("#edit_state").val();
			var type;
			var state;
			
			switch(type_num){
				case "1":
					type="学习资料";
				break;
				case "2":
					type="生活用品";
				break;
				case "3":
					type="小食分享";
				break;
				case "4":
					type="电子器械";
				break;
				case "5":
					type="二次元区";
				break;
				case "6":
					type="其他";
				break;
			}
			switch(state_num){
				case "0":
					var state="在售";
					break;
				case "1":
					var state="售罄";
					break;
				case "2":
					var state="下架";
					break;
			}
			
			var a,b;
			var goods_test = /^[\u4e00-\u9fa5_a-zA-Z0-9]+$/;
			if(title==""){
				alert("标题不能为空");
				a="0";
			}else if(!goods_test.test(title)){
				alert("标题存在非法字符");
				a="0";
			}else{
				a="1";
			}
			if(desc==""){
				alert("介绍不能为空");
				b="0";
			}else if(!goods_test.test(desc)){
				alert("介绍存在非法字符");
				b="0";
			}else{
				b="1";
			}
			if(a=="1"&&b=="1"){
				var count=$("#edit_count").val();
				$("#all").find('#'+id).find('#title').text(title);
				$("#all").find('#'+id).find('#desc').text(desc);
				$("#all").find('#'+id).find('#price').text(price);
				$("#all").find('#'+id).find('#count').text(count);
				$("#all").find('#'+id).find('#type').text(type);
				$("#all").find('#'+id).find('#type').attr("value",type_num);
				$("#all").find('#'+id).find('#state').text(state);
				$("#all").find('#'+id).find('#state').attr("value",state_num);
				
				
				var publisher=$.cookie("userID");
				var goodsID=id;
				var title=$("#all").find('#'+id).find('#title').text();
				var desc=$("#all").find('#'+id).find('#desc').text();
				var type=$("#all").find('#'+id).find('#type').attr("value");
				var state=$("#all").find('#'+id).find('#state').attr("value");
				var price=$("#all").find('#'+id).find('#price').text();
				var count=$("#all").find('#'+id).find('#count').text();
				var contact=storage.getItem("contact");
				var address=storage.getItem("address");
				if(title==""||desc==""||type==""||price==""||count==""||contact==""||address==""){
					alert("请确保个人信息内容充实和商品信息充实");
					/* return; */
				}
				if($.cookie("identity")==0){
					alert("对不起，您还没有通过卖家认证，请通过卖家认证再来发布");
					return; 
				}
				
				var url="ModifyGoods";
				var args={
					"goodsID":goodsID,
					"publisher":publisher,
					"title":title,
					"desc":desc,
					"type":type,
					"state":state,
					"price":price,
					"count":count,
					"contact":contact,
					"address":address,
				}
			
				$.post(url,args,function(data){
					if(data.success=="true"){
						alert("更改成功");
						window.location.reload(true);
					}else{
						alert("更改失败");
					}
				},"json");
			}else{
				alert("更改失败");
			}
			
			
		})
    });
	
</script>
</body>
</html>