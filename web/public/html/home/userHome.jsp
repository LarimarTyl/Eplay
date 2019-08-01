<%--
  Created by IntelliJ IDEA.
  User: Larimar
  Date: 2019/7/31
  Time: 14:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>个人中心</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/public/dist/css/bootstrap.css">
    <script src="${pageContext.request.contextPath}/public/dist/js/jquery-3.4.1.js"></script>
    <script src="${pageContext.request.contextPath}/public/dist/js/bootstrap.js"></script>
</head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/public/css/myhome.css">
<script src="${pageContext.request.contextPath}/public/dist/js/jquery-3.4.1.js"></script>
<script>
    $(function () {
        $(".nav_right").find(".nav_item").mouseenter(function () {
            $(this).children("a").css("color", "#F86D5A")
        }).mouseleave(function () {
            $(this).children("a").css("color", "")
        });
        $(".left_navbar .nav_item").on("click", function () {
            $(this).addClass("left_active").siblings(".nav_item").removeClass("left_active");
        });
        $(".left_navbar .nav_item").mouseenter(function () {
            $(this).find("a").addClass("left_selected").siblings().removeClass("left_selected").parent().siblings().removeClass("left_selected")
        }).mouseleave(function () {
            $(this).find("a").removeClass("left_selected");
        })
    });
</script>
<style>
    body{
        background: #fafafa;
    }
</style>
<body>

<div class="main">
    <!-- 左侧导航 -->
    <div class="left_navbar" id="myScrollspy">
        <ul class="nav nav-tabs nav-stacked top_logo">
            <li class="navbar-brand"><span><a href="${pageContext.request.contextPath}/public/html/index/index2.jsp"><img src="${pageContext.request.contextPath}/public/img/Logo/Logo_small.png" alt="" width="65%"></a></span>
            </li>
        </ul>
        <ul class="nav  nav-stacked admin" id="myNav">
            <!-- <li><a href="#"><span class="glyphicon glyphicon-icon" aria-hidden="true"></span>Eplay</a></li> -->
            <li class="navbar-brand  nav_title">
                <span class="glyphicon glyphicon-th-list" aria-hidden="true"></span>&nbsp; 管理
            </li>
            <li class="nav_item active" role="presentation"><a href="orderlist.jsp" target="item_main">我的订单</a></li>
            <li class="nav_item" role="presentation"><a href="games.jsp" target="item_main">我的游戏</a></li>
            <li class="nav_item" role="presentation"><a href="message.jsp" target="item_main">我的消息</a></li>
            <li class="nav_item" role="presentation"><a href="facous.jsp" target="item_main">我的关注</a></li>
            <li class="nav_item" role="presentation"><a href="blacklist.jsp" target="item_main">我的黑名单</a></li>
            <li class="nav_item" role="presentation"><a href="recharge.jsp" target="item_main">余额充值</a></li>
            <li class="navbar-brand nav_title">
                <span class="glyphicon glyphicon-cog" aria-hidden="true"></span>&nbsp; 设置
            </li>
            <li class="nav_item" role="presentation"><a href="myprofile.jsp" target="item_main">个人资料</a></li>
            <li class="nav_item" role="presentation"><a href="securitycenter.jsp" target="item_main">安全中心</a></li>
            <li class="nav_item" role="presentation"><a href="#">游戏偏好</a></li>
            <li class="nav_item" role="presentation"><a href="protocol.jsp" target="item_main">申请入驻</a></li>
        </ul>
        <ul class="nav  nav-stacked QR_code">
            <li class="navbar-brand qr_item">
                <span><img src="${pageContext.request.contextPath}/public/img/qr_code/qr_code.png" alt="" width="60%"></span>
                <p><span style="font-size: 5px;">扫描二维码下载</span></p>
                <p><span style="font-size: 5px;">Eplay 一起来玩</span></p>
            </li>
        </ul>
    </div>
    <!-- 主要部分 -->
    <div class="main_navbar nav_right">
        <nav class="navbar navbar-default navbar-static-top">
            <!-- <a class="navbar-brand" href="#">Title</a> -->
            <ul class="nav navbar-nav navbar-right">
                <li class="nav_item icon">
                    <a href="#">
                        <span class="glyphicon glyphicon-envelope"></span> 消息
                    </a>
                </li>
                <li class="nav_item icon">
                    <a href="#">
                        <span class="glyphicon glyphicon-headphones"></span> 客服</a>
                </li>
                <li class="nav_item icon">
                    <a href="#">
                        <span class="glyphicon glyphicon-user"></span> NO:${user.getStaffNumber()}</a>
                </li>
                <li class="nav_item">
                    <a href="">
                        <div style="float: left;padding-right: 10px;"><img src="${pageContext.request.contextPath}/public/img/user/${user.getPhotoPath()}" alt="" width="60px" style="border-radius:50% ">
                        </div>
                        <div style="float: right;line-height: 30px">普通用户
                            <p>${user.getStaffName()}</p></div>
                    </a>
                </li>
                <li class="nav_item"><a href="${pageContext.request.contextPath}/exitLogin.user">
                    <span>退出</span>
                </a>
                </li>
            </ul>
        </nav>
        <div class="container4">
            <iframe src="orderlist.jsp" name="item_main" frameborder="0" width="100%" height="100%">

            </iframe>
        </div>
    </div>
</div>
</body>

</html>
