<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head lang="en">
<meta charset="utf-8" />
<title>个人信息</title>
<link rel="stylesheet" type="text/css" href="css/public.css" />
<link rel="stylesheet" type="text/css" href="css/post_goods.css" />
</head>

<body>


	<!------------------------------head------------------------------>
	<div class="head">
		<div class="wrapper clearfix">
			<%@ include file="head1.jsp"%>
			<%@ include file="head2.jsp"%>
		</div>
	</div>
	<!------------------------------idea------------------------------>
	<div class="address mt">
		<div class="wrapper clearfix">
			<a href="index.jsp" class="fl">首页</a><span>/</span><a
				href="mygoods.jsp" class="on">我的商品</a><span>/</span><a
				href="mygoods.jsp" class="on">发布商品</a>
		</div>
	</div>
	<!------------------------------Bott------------------------------>
	<div class="Bott">
		<div class="wrapper clearfix">
			<div class="zuo fl">
				<%@ include file="head3.jsp"%>
			</div>
			<div class="you fl">
				<h2>发布商品</h2>
				<div class="gxin">
					<div class="xx">
						<h3 class="clearfix">
							<strong class="fl">商品资料</strong><a href="#" class="fr" id="edit1">编辑</a>
						</h3>
						<div>
							商品名：<a id="goods_name"></a>
						</div>
						<div>
							介 绍 ：<a id="desc"></a>
						</div>

						<div>
							价 格 ：<a id="price"></a>
						</div>
						<div>
							类别 ：<a id="type"></a>
						</div>
						<div>
							库存：<a id="count"></a>
						</div>
						<div>
							联系方式：<a id="contact"></a>
						</div>
						<div>
							地址：<a id="address"></a>
						</div>
					</div>
				</div>
				<div class="tx">
					<a href="#"><img id="img1" src="img/tx.png" />
						<p id="avatar1">商品封面</p> <input value="上传图片" type="file"
						class="file" id="file1" name="file" /></a> <a><img id="img2"
						src="img/tx.png" />
						<p id="avatar2">商品图片</p> <input value="上传图片" type="file"
						class="file" id="file2" name="file" /></a> <a> <img id="img3"
						src="img/tx.png" />
						<p id="avatar3">商品图片</p> <input value="上传图片" type="file"
						class="file" id="file3" name="file" /></a> <a> <img id="img4"
						src="img/tx.png" />
						<p id="avatar4">商品图片</p> <input value="上传图片" type="file"
						class="file" id="file4" name="file" /></a> <a> <img id="img5"
						src="img/tx.png" />
						<p id="avatar5">商品图片</p> <input value="上传图片" type="file"
						class="file" id="file5" name="file" /></a>

				</div>
				<div class="submit">
					<button id="img_bot">确认图片</button>
					<button id="post_bot">发布商品</button>
				</div>
			</div>
		</div>
	</div>
	<!--遮罩-->
	<div class="mask"></div>
	<!--编辑弹框-->
	<div class="bj">
		<div class="clearfix">
			<a href="#" class="fr gb"><img src="img/icon4.png" /></a>
		</div>
		<h3>编辑商品资料</h3>
		<form action="#" method="get">
			<p>
				<label>商品名：</label><input id="edit_name" type="text" value="" />
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
				<label>地址 ：</label><input id="edit_address" type="text" />
			</p>
			<p>
				<label>联系：</label><input id="edit_contact" onkeydown="this.value=this.value.replace(/[^0-9.]/g,'')" type="text" />
			</p>
			<p>
				<label>类别 ：</label><select id="edit_type" value="1">
					<option value="1">学习资料</option>
					<option value="2">生活用品</option>
					<option value="3">小食分享</option>
					<option value="4">电子器械</option>
					<option value="5">二次元区</option>
					<option value="6">其他</option>
				</select>
			</p>
			<div class="bc">
			
				<input type="button" value="保存" id="keep" /><input type="button" value="取消" />
			</div>
		</form>
	</div>
	<!--修改头像-->
	<div class="avatar">
		<div class="clearfix">
			<a href="#" class="fr gb"><img src="img/icon4.png" /></a>
		</div>
		<h3>上传图片</h3>

		<form action="#" method="get">
			<h4>请上传图片</h4>
			<input type="button" value="上传图片" />
			<p>jpg或png，大小不超过2M</p>
			<input type="submit" value="提交" />
		</form>
	</div>
	<!--返回顶部-->
	<!--footer-->
	<%@ include file="foot.jsp"%>


	<script src="js/jquery.flexslider-min.js" type="text/javascript"
		charset="utf-8"></script>
	<script src="js/jquery.cookie.js" type="text/javascript"
		charset="utf-8"></script>
	<script src="js/jquery.base64.js" type="text/javascript"
		charset="utf-8"></script>
	<script src="js/public.js" type="text/javascript" charset="utf-8"></script>
	<script src="js/nav.js" type="text/javascript" charset="utf-8"></script>
	<script src="js/pro.js" type="text/javascript" charset="utf-8"></script>
	<script src="js/cart.js" type="text/javascript" charset="utf-8"></script>

	<script>
		var storage = window.localStorage;
		var img1="";
		var img2="";
		var img3="";
		var img4="";
		var img5="";
		$(function(){
			var address=storage.getItem("address");
			var contact=storage.getItem("contact");
			if(address!=null){
			$("#address").text(address);
			}
			if(contact!=null){
				$("#contact").text(contact);
			}
		})
		$(function(){
			$("#edit1").click(function(){
				
				var name=$("#goods_name").text();
				var desc=$("#desc").text();
				var price=$("#price").text();
				var type=$("#type").text();
				var address=$("#address").text();
				var contact=$("#contact").text();
						
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
				default:
				var type_num=1;
				break;
				}
				
				var count=$("#count").text();
				
				$("#edit_name").val(name);
				$("#edit_desc").val(desc);
				$("#edit_price").val(price);
				$("#edit_count").val(count);
				$("#edit_bookType").val(type_num);
				$("#edit_contact").val(contact);
				$("#address").val(address);
			})
		})
		function isNumber(val){

    var regPos = /^\d+(\.\d+)?$/; //非负浮点数
   
    if(regPos.test(val) ){
        return true;
    }else{
        return false;
    }

}
		function isNumber_2(val){

    var regPos = /(^[1-9]\d*$)/; //非负整数
   
    if(regPos.test(val) ){
        return true;
    }else{
        return false;
    }

}
		$(function(){
			$("#keep").click(function(){
				var name=$("#edit_name").val();
				var desc=$("#edit_desc").val();
				var price=$("#edit_price").val();
				var type=$("#edit_type").val();
				var address=$("#edit_address").val();
				var contact=$("#edit_contact").val();
				var count=$("#edit_count").val();
				var type_num;
				
							
				if(isNumber(price)){
					
				}else{alert("请输入正确的价格");
					return;}
				if((!isNumber_2(contact))){
					alert("请输入正确的QQ信息");
					return;
				}else{}
					if((!isNumber_2(count))){
					alert("请输入正确的库存信息");
					return;
				}else{}
				switch(type){
				case "1":
					type_num="学习资料";
				break;
				case "2":
					type_num="生活用品";
				break;
				case "3":
					type_num="小食分享";
				break;
				case "4":
					type_num="电子器械";
				break;
				case "5":
					type_num="二次元区";
				break;
				case "6":
					type_num="其他";
				break;
				}
				
				
				
				$("#goods_name").text(name);
				$("#desc").text(desc);
				$("#price").text(price);
				$("#count").text(count);
				$("#type").text(type_num);
				$("#type").attr("value",type);
				$("#contact").text(contact);
				$("#address").text(address);
				
			})
		})
		$(function() {

			$('#file1').change(function(e) {
				var _URL = window.URL || window.webkitURL;
				var file, img;

				if ((file = this.files[0])) {
					img = new Image();
					img.onload = function() {
						$('#img1').attr('src', this.src);
					};
					img.src = _URL.createObjectURL(file);
				}
			})
			$('#file2').change(function(e) {
				var _URL = window.URL || window.webkitURL;
				var file, img;
				if ((file = this.files[0])) {
					img = new Image();
					img.onload = function() {
						$('#img2').attr('src', this.src);
					};
					img.src = _URL.createObjectURL(file);
				}
			})
			$('#file3').change(function(e) {
				var _URL = window.URL || window.webkitURL;
				var file, img;
				if ((file = this.files[0])) {
					img = new Image();
					img.onload = function() {
						$('#img3').attr('src', this.src);
					};
					img.src = _URL.createObjectURL(file);
				}
			})
			$('#file4').change(function(e) {
				var _URL = window.URL || window.webkitURL;
				var file, img;
				if ((file = this.files[0])) {
					img = new Image();
					img.onload = function() {
						$('#img4').attr('src', this.src);
					};
					img.src = _URL.createObjectURL(file);
				}
			})
			$('#file5').change(function(e) {
				var _URL = window.URL || window.webkitURL;
				var file, img;
				if ((file = this.files[0])) {
					img = new Image();
					img.onload = function() {
						$('#img5').attr('src', this.src);
					};
					img.src = _URL.createObjectURL(file);
				}
			})
		})
	$(function () {
			$("#img_bot").click(function() {
				
				/* if($.cookie("userID")==""||$.cookie("identity")!="1"||storage.getItem('address')==""||storage.getItem('contact')==""){
					alert("请登录并且输入有关卖家申请信息后发布商评");
					
				} */
				
		
			if(check_img($("#file1").val())){
				
				 run($("#file1")[0].files[0], function(data) {
					img1 =data.substr(data.indexOf(',') + 1);
				});
			}else{
				 img1="";
			}
			if(check_img($("#file2").val())){
				 run($("#file2")[0].files[0], function(data) {
					 img2 =data.substr(data.indexOf(',') + 1);
				});
			}else{
				 img2="";
			}
			if(check_img($("#file3").val())){
				 run($("#file3")[0].files[0], function(data) {
					 img3 =data.substr(data.indexOf(',') + 1);
				});
			}else{
				img3="";
			}
			if(check_img($("#file4").val())){
				 run($("#file4")[0].files[0], function(data) {
					 img4 =data.substr(data.indexOf(',') + 1);
				});
			}else{
				 img4="";
			}
			if(check_img($("#file5").val())){
				 run($("#file5")[0].files[0], function(data) {
					 img5 =data.substr(data.indexOf(',') + 1);
				});
			}else{
				 img5="";
			}
			
				alert("上传图片成功");

			})
		})
	$(function(){
		$("#post_bot").click(function() {
				if(img1==""){
					alert("封面不能为空");
					/* return; */
				}
				
			var url="PublishGoods";
			var publisher=$.cookie("userID");
			var title=$("#goods_name").text();
			var desc=$("#desc").text();
			var type=$("#type").attr("value");
			var price=$("#price").text();
			var count=$("#count").text();
			var contact=$("#contact").text();
			var address=$("#address").text();
			if(title==""||desc==""||type==""||price==""||count==""||contact==""||address==""){
				alert("请确保个人信息内容充实和商品信息充实");
				/* return; *///解除这里的注释进行实际测试
			}
			if($.cookie("identity")!=1){
				alert("对不起，您还没有通过卖家认证，请通过卖家认证再来发布");
				return; 	//解除这里的注释进行实际测试
			}
			title=title.replace(/\</g, "");
			title=title.replace(/\>/g, "");
			desc=desc.replace(/\</g, "");
			desc=desc.replace(/\>/g, "");
			price=price.replace(/\</g, "");
			price=price.replace(/\>/g, "");
			count=count.replace(/\</g, "");
			count=count.replace(/\>/g, "");
			contact=contact.replace(/\</g, "");
			contact=contact.replace(/\>/g, "");
			address=address.replace(/\</g, "");
			address=address.replace(/\>/g, "");
			var args={
					
				"publisher":publisher,
				"title":title,
				"desc":desc,
				"type":type,
				"price":price,
				"count":count,
				"contact":contact,
				"address":address,
				"img1":img1,
				"img2":img2,
				"img3":img3,
				"img4":img4,
				"img5":img5
				
				
			}
		
			$.post(url,args,function(data){
				if(data.success=="true"){
					alert("发布成功");
					window.location.reload();
				}else{
					alert("发布失败");
				}
			},"json")
		})
			
			/* 
			
		 */
	})
		function check_img(path) {
			var imgPath = path;
			if (imgPath == "") {
			
				return false;
			}
			var strExtension = imgPath.substr(imgPath.lastIndexOf('.') + 1);
			if (strExtension != 'jpg' && strExtension != 'gif'
					&& strExtension != 'png' && strExtension != 'bmp') {
				alert("请保证文件全是图片文件");
				return ;
			}
			
			return true;
		}

		function run(file_DOM, get_data) {
			/*input_file：文件按钮对象*/
			/*get_data: 转换成功后执行的方法*/

			if (typeof (FileReader) === 'undefined') {
				alert("抱歉，你的浏览器不支持 FileReader，不能将图片转换为Base64，请使用现代浏览器操作！");
			} else {
				try {
					/*图片转Base64 核心代码*/
					var filemaxsize = 1024 * 2;
					var file = file_DOM

					var fileSize = file.size;
					var size = fileSize / 1024;
					if (size > filemaxsize) {
						alert("附件大小不能大于" + filemaxsize / 1024 + "M！");

						return false;
					}
					if (size <= 0) {
						alert("附件大小不能为0M！");

						return false;
					}
					//这里我们判断下类型如果不是图片就返回 去掉就可以上传任意文件  
					if (!/image\/\w+/.test(file.type)) {
						alert("请确保文件为图像类型");
						return false;
					}
					var reader = new FileReader();
					reader.onload = function() {
						get_data(this.result);
					}
					reader.readAsDataURL(file);
				} catch (e) {
					alert('请不要传递空文件或非图片文件' + e.toString())
				}
			}
		}
	</script>
</body>
</html>