<%--
  Created by IntelliJ IDEA.
  User: Larimar
  Date: 2019/7/31
  Time: 19:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link rel="stylesheet" href="../../dist/css/bootstrap.css">
    <script src="../../dist/js/jquery-3.4.1.js"></script>
    <script src="../../dist/js/bootstrap.js"></script>
    <link rel="stylesheet" href="../../css/myhome.css">
    <link rel="stylesheet" href="../../css/blacklist.css">

</head>
<body class="back">
<h1>我的黑名单</h1>
<hr>
<div class="container3">
    <div class="row">
        <div class="col-md-2 col-xs-8 item div">
            <a href="#" class="thumbnail">
                <img src="../../img/focusimg/2.jpg" alt="lol" class="img-rounded">
                <div class="brand_name"><span>五五开</span></div>
                <div class="brand_name"><span>英雄联盟</span></div>
                <div class="brand_hot">
                    <button><span>取消黑名单</span></button>
                </div>
            </a>
        </div>
    </div>
</div>

</body>
<script>
    $(function () {
        $("button").mouseover(function () {
            $(this).css("backgroundColor", "#b54a23");
        })
        $("button").mouseleave(function () {
            $(this).css("backgroundColor", "#ff5d23");
        })
    })
</script>
</html>
