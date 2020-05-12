<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="utf-8"/>
    <title>最家</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/index.css"/>
</head>
<body><!------------------------------head------------------------------>

        <ul class="clearfix" id="bott">
            <li><a href="index.html">首页</a></li>
            <li><a href="#">学习资料</a></li>
            <li><a href="flowerDer.html">生活用品</a></li>
            <li><a href="decoration.html">小食分享</a></li>
            <li><a href="paint.html">电子器械</a></li>
            <li><a href="perfume.html">二次元区</a></li>
            <li><a href="idea.html">其它 </a></li>
        </ul>

<script src="js/jquery-1.12.4.min.js" type="text/javascript" charset="utf-8"></script>
<script src="js/public.js" type="text/javascript" charset="utf-8"></script>
<script src="js/nav.js" type="text/javascript" charset="utf-8"></script>
<script src="js/jquery.flexslider-min.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">$(function () {
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