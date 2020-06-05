<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="utf-8"/>
    <title>个人信息</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/mygrxx.css"/>
</head>
<body><!------------------------------head------------------------------>
<%@ include file="menu.jsp" %>
<!------------------------------idea------------------------------>
<div class="address mt">
    <div class="wrapper clearfix"><a href="index.jsp" class="fl">首页</a><span>/</span><a href="mygxin.jsp" class="on">个人信息</a>
    </div>
</div><!------------------------------Bott------------------------------>
<div class="Bott">
    <div class="wrapper clearfix">
        <div class="zuo fl">
            <h3><a href="#"><img src="img/tx.png"/></a>
                <p class="clearfix"><span class="fl">[${user.USER_NAME }]</span><span>[<a href="logout">退出登录</a>]</span></p></h3>
            <div><h4>我的交易</h4>
                <ul>
                    <li><a href="cart.jsp">我的购物车</a></li>
                    <li><a href="myorderq.jsp">我的订单</a></li>
                    <li><a href="myprod.jsp">评价晒单</a></li>
                </ul>
                <h4>个人中心</h4>
                <ul>
                    <li><a href="mygxin.jsp">我的中心</a></li>
                    <li class="on"><a href="mygrxx.jsp">个人信息</a></li>
                </ul>
            </div>
        </div>
        <div class="you fl"><h2>个人信息</h2>
            <div class="gxin">
                <div class="tx"><a href="#"><img src="img/tx.png"/>
                    <p id="avatar">修改头像</p></a></div>
                <div class="xx"><h3 class="clearfix"><strong class="fl">基础资料</strong><a href="#" class="fr" id="edit1">编辑</a>
                </h3>
                    <div> 用户昵称: ${user.USER_NAME  }</div>
	                <div> 用户名: ${user.USER_ACCOUNT  }</div>
	                <div> 用户密码: ${user.USER_PASSWORD  }</div>
	                <div> 用户邮箱: ${user.USER_EMAIL  }</div>
	                <div> 用户学号: ${user.USER_STUNUM  }</div>
	                <div> 用户地址: ${user.USER_ADDRESS  }</div>
                </div>
            </div>
        </div>
    </div>
</div><!--遮罩-->
<div class="mask"></div><!--编辑弹框-->
<div class="bj">
    <div class="clearfix"><a href="#" class="fr gb"><img src="img/icon4.png"/></a></div>
    <h3>编辑基础资料</h3>

    <form action="dologinerupdata" method="post"><p><label>用户名：</label><input name="userAcount" size="50" value="${user.USER_ACCOUNT }" readonly="readonly" type="text"></p>
    	<p><label>昵称：</label><input name="name" size="50" value="${user.USER_NAME }" type="text"></p>
    	<p><label>密码：</label><input name="passWord" size="500" value="" type="text"></p>
        <p><label>邮箱：</label><input name="email" size="50" value="${user.USER_EMAIL }" type="text"></p>
        <p><label>手机：</label><input name="stunum" size="50" value="${user.USER_STUNUM }" type="text"></p>
        <p><label>地址：</label><input name="address" size="50" value="${user.USER_ADDRESS }" type="text"></p>
        <div class="bc"><input type="submit" value="保存"/><input type="button" onClick="history.go(-1)" value="取消"/></div>
    </form>
</div>
<!--修改头像-->
<div class="avatar">
    <div class="clearfix"><a href="#" class="fr gb"><img src="img/icon4.png"/></a></div>
    <h3>修改头像</h3>
    <form action="#" method="get"><h4>请上传图片</h4><input type="button" value="上传头像"/>
        <p>jpg或png，大小不超过2M</p><input type="submit" value="提交"/></form>
</div><!--返回顶部-->
<div class="gotop"><a href="showcart">
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
</a><a href="#" class="toptop" style="display: none">
    <dl>
        <dt><img src="img/gt4.png"/></dt>
        <dd>返回<br/>顶部</dd>
    </dl>
</a>
    <p>400-800-8200</p></div><!--footer-->
<div class="footer">
    <div class="top">
        <div class="wrapper">
            <div class="clearfix"><a href="#2" class="fl"><img src="img/foot1.png"/></a><span class="fl">7天无理由退货</span>
            </div>
            <div class="clearfix"><a href="#2" class="fl"><img src="img/foot2.png"/></a><span class="fl">15天免费换货</span>
            </div>
            <div class="clearfix"><a href="#2" class="fl"><img src="img/foot3.png"/></a><span class="fl">满599包邮</span>
            </div>
            <div class="clearfix"><a href="#2" class="fl"><img src="img/foot4.png"/></a><span class="fl">手机特色服务</span>
            </div>
        </div>
    </div>
</div>
<script src="js/jquery-1.12.4.min.js" type="text/javascript" charset="utf-8"></script>
<script src="js/public.js" type="text/javascript" charset="utf-8"></script>
<script src="js/user.js" type="text/javascript" charset="utf-8"></script>
</body>
</html>