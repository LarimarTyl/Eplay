<%--
  Created by IntelliJ IDEA.
  User: Larimar
  Date: 2019/7/31
  Time: 19:08
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
    <link rel="stylesheet" href="../../css/facous.css">
    <title>Document</title>
</head>
<body class="back">
<h1>我的关注</h1>
<hr>
<!--<nav class="navbar navbar-default" role="navigation" style="background-color: white">-->
<!--    <div class="container-fluid">-->
<!--        <div class="navbar-header"><h1>我的关注</h1></div>-->
<!--    </div>-->
<!--</nav>-->
<div class="container3">
    <div class="row">
        <div class="col-md-3 col-xs-8 item div">
            <a href="#" class="thumbnail">
                <img class="img" src="../../img/focusimg/p5.jpg" alt="">
                <div class="bottom"><span><img src="../../img/focusimg/1.jpg" alt="lol"
                                               class="img-circle"
                                               width="18%"></span>
                    <div class="one">
                        <ul>
                            <li><span>芜湖大司马</span><span class="right">英雄联盟</span></li>
                            <li class="down"><span>4:00准时抽奖</span><span class="right">666万</span><span
                                    class="right glyphicon glyphicon-fire"></span></li>
                        </ul>
                    </div>
                </div>
            </a>
        </div>
        <div class="col-md-3 col-xs-8 item div">
            <a href="#" class="thumbnail">
                <img class="img" src="../../img/focusimg/p5.jpg" alt="">
                <div class="bottom"><span><img src="../../img/focusimg/1.jpg" alt="lol"
                                               class="img-circle"
                                               width="18%"></span>
                    <div class="one">
                        <ul>
                            <li><span>芜湖大司马</span><span class="right">英雄联盟</span></li>
                            <li class="down"><span>4:00准时抽奖</span><span class="right">666万</span><span
                                    class="right glyphicon glyphicon-fire"></span></li>
                        </ul>
                    </div>
                </div>
            </a>
        </div>
        <div class="col-md-3 col-xs-8 item div">
            <a href="#" class="thumbnail">
                <img class="img" src="../../img/focusimg/p5.jpg" alt="">
                <div class="bottom"><span><img src="../../img/focusimg/1.jpg" alt="lol"
                                               class="img-circle"
                                               width="18%"></span>
                    <div class="one">
                        <ul>
                            <li><span>芜湖大司马</span><span class="right">英雄联盟</span></li>
                            <li class="down"><span>4:00准时抽奖</span><span class="right">666万</span><span
                                    class="right glyphicon glyphicon-fire"></span></li>
                        </ul>
                    </div>
                </div>
            </a>
        </div>
        <div class="col-md-3 col-xs-8 item div">
            <a href="#" class="thumbnail">
                <img class="img" src="../../img/focusimg/p5.jpg" alt="">
                <div class="bottom"><span><img src="../../img/focusimg/1.jpg" alt="lol"
                                               class="img-circle"
                                               width="18%"></span>
                    <div class="one">
                        <ul>
                            <li><span>芜湖大司马</span><span class="right">英雄联盟</span></li>
                            <li class="down"><span>4:00准时抽奖</span><span class="right">666万</span><span
                                    class="right glyphicon glyphicon-fire"></span></li>
                        </ul>
                    </div>
                </div>
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
