<%--
  Created by IntelliJ IDEA.
  User: Larimar
  Date: 2019/7/31
  Time: 14:36
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>管理中心</title>
    <link rel="stylesheet" href="../../dist/css/bootstrap.css">
    <script src="../../dist/js/jquery-3.4.1.js"></script>
    <script src="../../dist/js/bootstrap.js"></script>
    <link rel="stylesheet" href="../../css/admin.css">
</head>
<script src="../../dist/js/jquery-3.4.1.js"></script>
<script>
    $(function () {
        $(".left_navbar .nav_item").on("click", function () {
            $(this).addClass("left_active").siblings(".nav_item").removeClass("left_active");
        });
        $(".left_navbar .nav-item").mouseenter(function () {
            $(this).find("a").css("background-color", "#F2F6F9").siblings().css("background-color", "").parent().siblings().css("background-color", "")
        }).mouseleave(function () {
            $(this).find("a").css("background-color", "");
        });
        $(".btn").click(function () {
            //    console.log($(".nav_item .font").toggle().parents(".left_navbar"))
            $(".nav_item .font").toggle().parents(".left_navbar").toggleClass("short");
            $(".main .item").toggleClass("long")
        })
    });
</script>

<body>

<!-- 顶部导航 -->
<nav class="navbar navbar-default navbar-top" role="navigation">
    <span><a class="navbar-brand" href="#"><img src="../../img/Logo/Logo_admin.png" width="60%"></a></span>
    <div class="button"><button class="btn" type="button"><span class="glyphicon glyphicon-align-justify"
                                                                aria-hidden="true"></span> </button></div>
    <ul class="nav navbar-nav navbar-right">
        <li>
            <a href="#"><span style="display: inline-block;line-height: 70px; color: #ABAFC1"> admin</span>
                <div class="img" style="float: right;margin: 10px;">
                    <img src="../../img/user/user.JPEG" width="50px" style="border-radius:50%"></div>
            </a>
        </li>
        <li>
            <a href="#" style="padding-top: 40px;margin-right: 40px;"><span>退出</span></a>
        </li>
    </ul>
</nav>
<!-- 主体内容 -->
<div class="main">
    <div class="row ">
        <div class="left_navbar  col-xs-2 col-sm-2 col-md-2 col-lg-2">
            <div class="nav_list" id="left_navbar">
                <ul class="nav  nav-stacked">
                    <li class="nav_item active"><a href="home.jsp" target="item-page">
                            <span class="glyphicon glyphicon-home" aria-hidden="true">
                            </span><span class="font">&emsp;管理中心</span></a>
                    </li>
                    <li class="nav_item"><a href="user.jsp" target="item-page">
                            <span class="glyphicon glyphicon-user" aria-hidden="true">
                            </span><span class="font">&emsp;用户管理</span></a></li>
                    <li class="nav_item"><a href="player.jsp" target="item-page">
                            <span class="glyphicon glyphicon-flag" aria-hidden="true">
                            </span><span class="font">&emsp;入驻管理</span></a></li>
                    <li class="nav_item"><a href="approve.jsp" target="item-page">
                            <span class="glyphicon glyphicon-log-in" aria-hidden="true">
                            </span><span class="font">&emsp;审核中心</span></a></li>
                    <li class="nav_item"><a href="orderlist.jsp" target="item-page">
                            <span class="glyphicon glyphicon-list-alt" aria-hidden="true">
                            </span><span class="font">&emsp;订单管理</span></a></li>
                    <li class="nav_item"><a href="recharge.jsp" target="item-page">
                            <span class="glyphicon glyphicon-usd" aria-hidden="true">
                            </span><span class="font">&emsp;充值管理</span></a></li>
                    <li class="nav_item"><a href="message.jsp" target="item-page">
                            <span class="glyphicon glyphicon-comment" aria-hidden="true">
                            </span><span class="font">&emsp;消息管理</span></a></li>
                    <li class="nav_item"><a href="list.jsp" target="item-page">
                            <span class="glyphicon glyphicon-equalizer" aria-hidden="true">
                            </span><span class="font">&emsp;榜单管理</span></a></li>
                    <li class="nav_item"><a href="poster.jsp" target="item-page">
                            <span class="glyphicon glyphicon-send" aria-hidden="true">
                            </span><span class="font">&emsp;广告管理</span></a></li>
                </ul>
            </div>
        </div>

        <div class="col-xs-10 col-sm-10 col-md-10 col-lg-10 item">
            <div class= "iframe">
<%--                <jsp:include page="home.jsp"></jsp:include>--%>
                <iframe src="home.jsp" frameborder="0" name="item-page">

                </iframe>
            </div>
        </div>


    </div>
</div>
</body>

</html>
