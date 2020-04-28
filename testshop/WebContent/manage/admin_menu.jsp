<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>后台管理</title>
    <link rel="stylesheet" type="text/css" href="css/common.css"/>
    <link rel="stylesheet" type="text/css" href="css/main.css"/>
</head>
<body>
<div class="topbar-wrap white">
    <div class="topbar-inner clearfix">
        <div class="topbar-logo-wrap clearfix">
            
            <ul class="navbar-list clearfix">
                <li><a class="on" href="admin_index.jsp">首页</a></li>
                <li><a href="#" target="_blank">网站首页</a></li>
            </ul>
        </div>
        <div class="top-info-wrap">
            <ul class="top-info-list clearfix">
                
               
                <li><a href="admin_login.jsp">退出</a></li>
            </ul>
        </div>
    </div>
</div>
<div class="container clearfix">
    <div class="sidebar-wrap">
        <div class="sidebar-title">
            <h1>菜单</h1>
        </div>
        <div class="sidebar-content">
            <ul class="sidebar-list">
                <li>
                    <a href="#"><i class="icon-font">&#xe003;</i>常用操作</a>
                    <ul class="sub-menu">
                        <li><a href="/testshop/manage/admin_douserselect"><i class="icon-font">&#xe008;</i>用户管理</a></li>
                        <li><a href="/testshop/manage/admin_docartselect"><i class="icon-font">&#xe005;</i>购物车管理</a></li>
                        <li><a href="/testshop/manage/admin_dogoodsselect"><i class="icon-font">&#xe006;</i>商品管理</a></li>
                        <li><a href="admin_order.jsp"><i class="icon-font">&#xe004;</i>订单管理</a></li>
                        <li><a href="/testshop/manage/admin_docommentselect"><i class="icon-font">&#xe012;</i>评论管理</a></li>
                        <li><a href="admin_sell.jsp"><i class="icon-font">&#xe052;</i>出售管理</a></li>
                        <li><a href="#"><i class="icon-font">&#xe033;</i>xx</a></li>
                    </ul>
                </li>
                <li>
                    <a href="#"><i class="icon-font">&#xe018;</i>系统管理</a>
                    <ul class="sub-menu">
                        <li><a href="system.html"><i class="icon-font">&#xe017;</i>待开发</a></li>
                        <li><a href="system.html"><i class="icon-font">&#xe037;</i>待开发</a></li>
                        <li><a href="system.html"><i class="icon-font">&#xe046;</i>待开发</a></li>
                        <li><a href="system.html"><i class="icon-font">&#xe045;</i>待开发</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>