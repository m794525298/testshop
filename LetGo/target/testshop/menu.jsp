<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>  
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="head">
    <div class="wrapper clearfix">
        <div class="clearfix" id="top"><h1 class="fl"><a href="index.jsp"><img src="img/logo.png"/></a></h1>
            <div class="fr clearfix" id="top1"><p class="fl">
            <c:if test="${isLogin !=1 &&  isAdminLogin !=1}">
            	<a href="login.jsp" id="login">登录</a><a href="reg.jsp" id="reg">注册</a>
            </c:if>
            <c:if test="${isLogin ==1 }">
            	<b>你好,用户</b><a href="mygxin.jsp" id="login">${name.USER_NAME }</a>	
            </c:if>
            <c:if test="${isAdminLogin ==1 }">
            	<b>你好：管理员</b><a href="mygxin.jsp" id="login">${name.USER_NAME }</a>
            	<a href="manage/admin_index.jsp" id="login1">进入后台</a>
            </c:if>
            </p>
                <form action="#" method="get" class="fl"><input type="text" placeholder="搜索"/><input
                        type="button"/></form>
                <div class="btn fl clearfix">
                	<c:if test="${isLogin ==1 }">  
                        <a href="mygxin.jsp"><img src="img/grzx.png"/></a>
                        <a href="showcart"><img src="img/gwc.png"/></a>
                    </c:if> 
            </div>
        </div>
        <ul class="clearfix" id="bott">
            <li><a href="index.jsp">首页</a></li>
            <li><a href="#">所有商品</a>
                <div class="sList">
                    <div class="wrapper  clearfix"><a href="paint.html">
                        <dl>
                            <dt><img src="img/nav1.jpg"/></dt>
                            <dd>二手书籍</dd>
                        </dl>
                    </a><a href="paint.html">
                        <dl>
                            <dt><img src="img/nav2.jpg"/></dt>
                            <dd>电子设备</dd>
                        </dl>
                    </a><a href="paint.html">
                        <dl>
                            <dt><img src="img/nav3.jpg"/></dt>
                            <dd>生活用品</dd>
                        </dl>
                    </a><a href="paint.html">
                        <dl>
                            <dt><img src="img/nav6.jpg"/></dt>
                            <dd>小吃分享</dd>
                        </dl>
                    </a><a href="paint.html">
                        <dl>
                            <dt><img src="img/nav7.jpg"/></dt>
                            <dd>其他内容</dd>
                        </dl>
                    </a></div>
                </div>
            </li>
            <li><a href="flowerDer.jsp">学习相关</a>
                <div class="sList2">
                    <div class="clearfix"><a href="selectproductlist?type=123">学习书籍</a><a href="vase_proList.jsp">作业指导</a></div>
                </div>
            </li>
            <li><a href="decoration.jsp">生活用品</a>
                <div class="sList2">
                    <div class="clearfix"><a href="zbproList.jsp">二手好货</a><a href="bzproList.jsp">电子设备</a></div>
                </div>
            </li>
            <li><a href="paint.jsp">小食分享</a></li>
            <li><a href="perfume.jsp">二次元相关</a></li>
            <li><a href="idea.jsp">其他</a></li>
        </ul>
    </div>
</div>