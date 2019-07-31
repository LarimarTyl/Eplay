<%--
  Created by IntelliJ IDEA.
  User: Larimar
  Date: 2019/7/31
  Time: 19:09
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
    <link rel="stylesheet" href="../../css/myhome.css">
    <link rel="stylesheet" href="../../css/game.css">
    <title>Document</title>

</head>
<body class="back">
<h1>我的游戏</h1>
<hr>
<div class="container3">
    <div class="row">
        <div class="col-md-2 col-xs-8 item div">
            <a href="#" class="thumbnail">
                <img src="../../img/gameimg/lol.jpg" alt="lol" class="img-rounded">
                <div class="brand_name"><span>英雄联盟</span></div>
                <div class="brand_hot"><span class="glyphicon glyphicon-fire"></span><span>588.7万</span></div>
            </a>
        </div>
        <div class="col-md-2 col-xs-8 item div">
            <a href="#" class="thumbnail">
                <img src="../../img/gameimg/cj.jpg" alt="绝地求生" class="img-rounded">
                <div class="brand_name"><span>绝地求生</span></div>
                <div class="brand_hot"><span class="glyphicon glyphicon-fire"></span><span>399.7万</span></div>
            </a>
        </div>
        <div class="col-md-2 col-xs-8 item div">
            <a href="#" class="thumbnail">
                <img src="../../img/gameimg/csgo.jpg" alt="vsgo" class="img-rounded">
                <div class="brand_name"><span>CSGO</span></div>
                <div class="brand_hot"><span class="glyphicon glyphicon-fire"></span><span>666.7万</span></div>
            </a>
        </div>
    </div>
</div>
<script>
    $(function () {
        $(".div").mouseover(function () {
            $(this).find("span").css("color", "#ff5d23");
        })
        $(".div").mouseleave(function () {
            $(this).find("span").css("color", "");
        })
    })
</script>
</body>
</html>
