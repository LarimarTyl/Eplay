<%--
  Created by IntelliJ IDEA.
  User: Larimar
  Date: 2019/7/31
  Time: 19:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="../../dist/css/bootstrap.css">
    <script src="../../dist/js/jquery-3.4.1.js"></script>
    <script src="../../dist/js/bootstrap.js"></script>
    <link rel="stylesheet" href="../../css/message.css">
</head>
<body class="back">
<h1>我的消息</h1>
<hr>
<button class="button"><span class="glyphicon glyphicon-share-alt"></span><span>返回全部消息</span></button>
<div class="pbody">
    <h2 class="head">标题</h2>
    <h4 class="time">2019-07-16 20:52</h4>
    <p class="content">
        新人礼包包含： 3天闪耀新星头衔（进入聊天室即可显示） 1张9.9元专区体验券（进入9.9专区下单） 120元优惠券礼包以及免费约玩次数（查看优惠券）
    </p>
</div>
</body>
<script>
    $(function () {
        $("button").click(function () {
            window.location.href = "messages.html";
        })
    })
</script>
</html>
