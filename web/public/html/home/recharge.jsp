<%--
  Created by IntelliJ IDEA.
  User: Larimar
  Date: 2019/7/31
  Time: 14:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <link rel="stylesheet" href="../../dist/css/bootstrap.css">
    <script src="../../dist/js/jquery-3.4.1.js"></script>
    <script src="../../dist/js/bootstrap.js"></script>
    <link rel="stylesheet" href="../../css/recharge.css">
    <title>Document</title>

    <title>余额充值</title>

</head>
<body class="back">
<h1>余额充值</h1>
<hr>
<div class="wrap">
    <div class="top">
        <div class="col1">账户余额:</div>
        <div class="col2">￥0</div>
        <div class="clear"></div>
    </div>
    <div class="top">
        <div class="col1">充值金额:</div>
        <div class="col1">
            <ul class="list ul1">
                <li><span class="content">50元</span><span class="ver"></span></li>
                <li><span class="content">100元</span><span class="ver"></span></li>
                <li><span class="content">300元</span><span class="ver"></span></li>
                <li><span class="content">500元</span><span class="ver"></span></li>
                <li><span class="content">1000元</span><span class="ver"></span></li>
                <li><span class="content">6666元</span><span class="ver"></span></li>
            </ul>
            <input class="list m_left input" type="text" placeholder="输入充值金额" value="" oninput="update()">
            <span class="list font">元</span>
        </div>
        <div class="clear"></div>
    </div>
    <div class="top">
        <div class="col1">充值货币:</div>
        <div class="col3">￥<span class="charge">0</span></div>
        <div class="clear"></div>
    </div>
    <div class="top">
        <div class="col1">充值方式:</div>
        <div class="col1 m_left big">
            <img class="col1 img1" src="../../img/money/wechat.png" alt="">
            <img class="col1 none img2" src="../../img/money/wechat_hover.jpg" alt="">
        </div>
        <div class="col1 m_left big">
            <img class="col1 img3" src="../../img/money/alipay.jpg" alt="">
            <img class="col1 none img4" src="../../img/money/alipay_hover.jpg" alt="">
        </div>
        <div class="clear"></div>
        <button class="ant-btn ant-btn-red">去充值</button>
    </div>
</div>
</body>
<script>
    $(function () {
        $(".input").focus(function () {
            $(".font").css("color", "#25E198");
        }).blur(function () {
            $(".font").css("color", "black");
        })

        $("img").click(function () {
            $(this).hide().siblings().show();
        })


        $(".img1").click(function () {
            if ($(".img4").css("display") == "block") {
                $(".img4").hide();
                $(".img3").show();
            }
        })

        $(".img3").click(function () {
            if ($(".img2").css("display") == "block") {
                $(".img2").hide();
                $(".img1").show();
            }
        })

        $("li").click(function () {
            console.log($(this).css("border"));
            if ($(this).css("border") == "1px solid rgb(165, 173, 175)") {
                $(this).css("border", "1px solid #25E198").css("background", "url(../../img/money/true.png) no-repeat 96px 24px").css("color", "#25E198");
                var i = $(this).find(".content").text();
                $(".charge").text(i);
            } else {
                $(this).css("background", "#f6f6f6").css("border", "1px solid #a5adaf").css("color", "#cbcbcb");
            }
            $(this).siblings().css("background", "#f6f6f6").css("border", "1px solid #a5adaf").css("color", "#cbcbcb");
        })
    })

    function update() {
        var i = $(".input").val();
        $(".charge").text(i);
        var reg = /^[1-9]\d*$/;
        if (!reg.test($(".input").val())) {
            $(".input").val(null);
            $(".charge").text(0);
            2
        }
    }
</script>
</html>