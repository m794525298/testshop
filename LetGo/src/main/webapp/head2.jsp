<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="utf-8"/>

    
</head>
<body><!------------------------------head------------------------------>

        <ul class="clearfix" id="bott">
            <li><a href="index.jsp">首页</a></li>
            <li><a href="search.jsp?type=1">学习资料</a></li>
            <li><a href="search.jsp?type=2">生活用品</a></li>
            <li><a href="search.jsp?type=3">小食分享</a></li>
            <li><a href="search.jsp?type=4">电子器械</a></li>
            <li><a href="search.jsp?type=5">二次元区</a></li>
            <li><a href="search.jsp?type=6">其它 </a></li>
        </ul>


<script type="text/javascript">

$(function () {
    $('#home_slider').flexslider({
        animation: 'slide',
        controlNav: true,
        directionNav: true,
        animationLoop: true,
        slideshow: true,
        slideshowSpeed: 2000,
        useCSS: false
    });
});</script>
</body>
</html>