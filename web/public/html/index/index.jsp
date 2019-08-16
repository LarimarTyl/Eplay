<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Larimar
  Date: 2019/7/31
  Time: 14:30
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Eplay</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/public/dist/css/bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/public/dist/css/bootstrap.css.map">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/public/css/index.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/public/css/base.css">
    <script src="${pageContext.request.contextPath}/public/dist/js/jquery-3.4.1.js"></script>
    <script src="${pageContext.request.contextPath}/public/dist/js/bootstrap.js"></script>
    <script>
    $(function () {
            $(".games").mouseenter(function () {
                $(this).children(".label").toggleClass("select-game");
            });
            $(".newPlayer li").mouseenter(function () {
                $(this).children("a").stop().animate({ top: -15 }, 500);
            }).mouseleave(function () {
                $(this).children("a").stop().animate({ top: 0 }, 500);
            })
        });
    </script>
    <script>
        $("#my-carousel").carousel({
            interval: 2000,
        });
    </script>
    <%--得到图片--%>
    <script type="text/javascript">
        function changeCode(){
            //得到图片元素
            var img = document.getElementById("checkCodeImg");
            img.src = "${pageContext.request.contextPath}/code?time="+new Date().getTime();
        };
    </script>
    <script>
        $(function () {
            $("#loginbtn").click( function loginUser(){
                $("#dologin").click();
            });
                $("#registerBtn").click( function loginUser(){
                    $("#doRegister").click();
                });
        });
    </script>
</head>

<body>
<!-- 头部导航 -->
<div class="top">
    <nav class="navbar navbar-default navbar-static-top top-item" role="navigation">
        <a class="navbar-brand logo" href="${pageContext.request.contextPath}/public/html/index/index.jsp">
            <div style="float:left"><img src="${pageContext.request.contextPath}/public/img/Logo/ep-logo-l.png" alt="" width="70px"></div>
            <div class="font" style="float: right"><span class="title">Eplay</span>
                <p style="margin-top: 5px;">一起娱乐一起交友</p>
            </div>
        </a>
        <ul class="nav navbar-nav">
            <li class="nav-item actived">
                <a href="${pageContext.request.contextPath}/public/html/index/index.jsp">主页</a>
            </li>
            <li class="nav-item">
                <a href="${pageContext.request.contextPath}/listByGame.player?gameName=全部玩家">约陪玩</a>
            </li>
            <li class="nav-item">
                <a href="#">开黑大厅</a>
            </li>
            <li class="nav-item">
                <a href="${pageContext.request.contextPath}/public/html/home/userHome.jsp?target=recharge">充值</a>
            </li>
            <li class="nav-item">
                <a href="#">APP下载</a>
            </li>
            <li class="nav-item">
                <form class="navbar-form search">
                    <div class="form-group">
                        <input type="text" class="form-control" placeholder="搜索昵称">

                    </div>
                </form>
            </li>
            <li class="nav-item  top-right">
                <a href="#">
                        <span class="glyphicon glyphicon-headphones" aria-hidden="true">
                            <p class="font">客服</p>
                        </span>
                </a>
            </li>
            <li class="mar">|</li>
            <li class="nav-item top-right">
                <a href="${pageContext.request.contextPath}/public/html/home/userHome.jsp?target=message">
                        <span class="glyphicon glyphicon-tasks" aria-hidden="true">
                            <p class="font">消息</p>
                        </span>
                </a>
            </li>
            <li class="mar">|</li>
            <li class="nav-item top-right">
                <a href="${pageContext.request.contextPath}/public/html/home/userHome.jsp?target=protocol">
                        <span class="glyphicon glyphicon-flag" aria-hidden="true">
                            <p class="font">入驻</p>
                        </span>
                </a>
            </li>
            <!-- 判断是否登录 显示哪个内容 -->
            <%
                boolean isLogin=false;
                Object user = request.getSession().getAttribute("user");
                if (user!=null){
                    isLogin = true;
                }
                request.getSession().setAttribute("isLogin",isLogin);
            %>
            <c:if test="${sessionScope.isLogin}" var="flage" scope="session">
                <li class="nav_item userinfo"  >
                    <a href="${pageContext.request.contextPath}/public/html/home/userHome.jsp?target=orderlist">
                        <div class="img"><img src="${pageContext.request.contextPath}/public/img/user/${user.getPhotoPath()}" alt="" width="60px"
                                              style="border-radius:50% ">
                        </div>
                        <div class="info"><span class="leve">${user.getStaffNumber()}</span>
                            <p class="name">${user.getStaffName()}</p>
                        </div>
                    </a>
                </li>
                <li class="nav_item">
                    <a href="${pageContext.request.contextPath}/exitLogin.user">退出</a>
                </li>
            </c:if>
            <c:if test="${!flage}" var="flage"  scope="session">
                <li class="nav_item login-rigster">
                    <button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#login">注册/登录</button>
                </li>
                <li class="loginMsg">
                        ${loginMsg}${registerMsg}
                </li>
            </c:if>
        </ul>
    </nav>
</div>
<div class="slider-item">
    <!-- 大广告轮播图 -->
    <div class="container container-top">
        <div id="carousel-item" class="carousel slide">
            <ol class="carousel-indicators">
                <li data-target="#carousel-item" data-slide-to="0" class=""></li>
                <li data-target="#carousel-item" data-slide-to="1" class=""></li>
                <li data-target="#carousel-item" data-slide-to="2" class=""></li>
                <li data-target="#carousel-item" data-slide-to="3" class=""></li>
                <li data-target="#carousel-item" data-slide-to="4" class=""></li>
                <li data-target="#carousel-item" data-slide-to="5" class=""></li>
                <li data-target="#mycarousel" data-slide-to="6" class="active"></li>
            </ol>
            <div class="carousel-inner">
                <div class="item" style="background: #223240">
                    <a href="#"><img src="${pageContext.request.contextPath}/public/img/big-picture/1.jpg" alt=""></a>
                </div>
                <div class="item " style="background: #223240">
                    <a href="#"><img src="${pageContext.request.contextPath}/public/img/big-picture/2.jpg" alt=""></a>
                </div>
                <div class="item" style="background: #223240">
                    <a href="#"><img src="${pageContext.request.contextPath}/public/img/big-picture/3.png" alt=""></a>
                </div>
                <div class="item active" style="background: #223240">
                    <a href="#"><img src="${pageContext.request.contextPath}/public/img/big-picture/4.jpg" alt=""></a>
                </div>
                <div class="item active" style="background: #223240">
                    <a href="#"><img src="${pageContext.request.contextPath}/public/img/big-picture/5.jpg" alt=""></a>
                </div>
                <div class="item active" style="background: #223240">
                    <a href="#"><img src="${pageContext.request.contextPath}/public/img/big-picture/6.jpg" alt=""></a>
                </div>
                <div class="item active" style="background: #223240">
                    <a href="#"><img src="${pageContext.request.contextPath}/public/img/big-picture/7.jpg" alt=""></a>
                </div>
            </div>
            <a class="left carousel-control" href="#carousel-item" data-slide="prev"><span
                    class="glyphicon glyphicon-chevron-left"></span></a>
            <a class="right carousel-control" href="#carousel-item" data-slide="next"><span
                    class="glyphicon glyphicon-chevron-right"></span></a>
        </div>

    </div>
</div>
<!-- 主体信息 -->
<div class="container">
    <!-- 陪玩信息 -->
    <div class="player">
        <!-- 陪玩菜单 -->
        <nav class="navbar  navbar-top navbar-default player-top" role="navigation">
            <a class="navbar-brand">
                    <span class="glyphicon"><img src="${pageContext.request.contextPath}/public/img/picture/686589.png" alt="" width="55px">
                        游戏陪玩</span></a>
            <ul class="nav navbar-nav gamelist">
                <li class="games">
                    <a href="${pageContext.request.contextPath}/listByGame.player?gameName=王者荣耀">
                        <span class="label label-default">王者荣耀</span>
                    </a>
                </li>
                <li class="games">
                    <a href="${pageContext.request.contextPath}/listByGame.player?gameName=英雄联盟">
                        <span class="label label-default">英雄联盟</span>
                    </a>
                </li>
                <li class="games">
                    <a href="${pageContext.request.contextPath}/listByGame.player?gameName=绝地求生">
                        <span class="label label-default">绝地求生</span>
                    </a>
                </li>
                <li class="games">
                    <a href="${pageContext.request.contextPath}/listByGame.player?gameName=DOTA2自走棋">
                        <span class="label label-default">DOTA2自走棋</span>
                    </a>
                </li>
                <li class="games">
                    <a href="${pageContext.request.contextPath}/listByGame.player?gameName=守望先锋">
                        <span class="label label-default">守望先锋</span>
                    </a>
                </li>
                <li class="games">
                    <a href="${pageContext.request.contextPath}/listByGame.player?gameName=地下城">
                        <span class="label label-default">地下城</span>
                    </a>
                </li>
                <li class="games">
                    <a href="${pageContext.request.contextPath}/listByGame.player?gameName=CS：GO">
                        <span class="label label-default">CS：GO</span>
                    </a>
                </li>
                <li class="games reflash">
                    <a href="${pageContext.request.contextPath}/listByGame.player?gameName=">
                        换一批&nbsp;<span class="glyphicon glyphicon-refresh" aria-hidden="true"></span>
                    </a>
                </li>
            </ul>
        </nav>
        <!-- 陪玩详细信息 -->
        <c:forEach items="${playerBeans}" var="play">
            <div class="col-xs-3 col-sm-3 col-md-3 col-lg-3 player-info">
                <div class="thumbnail">
                    <a class="pull-top" href="${pageContext.request.contextPath}/showPlayerInfo.player?playerID=${play.playerID}&&playerName=${play.staffName}">
                        <img class="img" src="${pageContext.request.contextPath}/public/img/user/${play.photoPath}" alt="Image">
                    </a>
                    <div class="media-body">
                        <h4 class="media-heading">${play.staffName}</h4>
                        <p class="dec">
                        <p class="game"><span>${play.gameName}</span></p>
                        <h3 class="price">${play.money} 元/小时</h3>
                        </p>
                    </div>
                </div>
            </div>
        </c:forEach>
        <%--<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3 player-info">
            <div class="thumbnail">
                <a class="pull-top" href="playerInfo.jsp">
                    <img class="img" src="${pageContext.request.contextPath}/public/img/user-big/ia_10015.jpg" alt="Image">
                </a>
                <div class="media-body">
                    <h4 class="media-heading">狂野傲娇小萝莉</h4>
                    <p class="dec">
                    <p class="game"><span>王者荣耀</span></p>
                    <h3 class="price">35元/小时</h3>
                    </p>
                </div>
            </div>
        </div>
        <div class="col-xs-3 col-sm-3 col-md-3 col-lg-3 player-info">
            <div class="thumbnail">
                <a class="pull-top" href="playerInfo.jsp">
                    <img class="img" src="${pageContext.request.contextPath}/public/img/user-big/ia_10013.jpg" alt="Image">
                </a>
                <div class="media-body">
                    <h4 class="media-heading">可爱丸子</h4>
                    <p class="dec">
                    <p class="game"><span>英雄联盟</span></p>
                    <h3 class="price">30元/小时</h3>
                </div>
            </div>
        </div>
        <div class="col-xs-3 col-sm-3 col-md-3 col-lg-3 player-info">
            <div class="thumbnail">
                <a class="pull-top" href="playerInfo.jsp">
                    <img class="img" src="${pageContext.request.contextPath}/public/img/user-big/ia_10023.jpg" alt="Image">
                </a>
                <div class="media-body">
                    <h4 class="media-heading">皮皮猪</h4>
                    <p class="dec">
                    <p class="game"><span>CS：GO</span></p>
                    <h3 class="price">20元/小时</h3>
                </div>
            </div>
        </div>
        <div class="col-xs-3 col-sm-3 col-md-3 col-lg-3 player-info">
            <div class="thumbnail">
                <a class="pull-top" href="playerInfo.jsp">
                    <img class="img" src="${pageContext.request.contextPath}/public/img/user-big/ia_10097.jpg" alt="Image">
                </a>
                <div class="media-body">
                    <h4 class="media-heading">柯基的绿毛龟</h4>
                    <p class="dec">
                    <p class="game"><span>王者荣耀</span></p>
                    <h3 class="price">35元/小时</h3>
                </div>
            </div>
        </div>
        <div class="col-xs-3 col-sm-3 col-md-3 col-lg-3 player-info">
            <div class="thumbnail">
                <a class="pull-top" href="playerInfo.jsp">
                    <img class="img" src="${pageContext.request.contextPath}/public/img/user-big/ia_10096.jpg" alt="Image">
                </a>
                <div class="media-body">
                    <h4 class="media-heading">小仙女@锦梨</h4>
                    <p class="dec">
                    <p class="game"><span>绝地求生</span></p>
                    <h3 class="price">18元/小时</h3>
                </div>
            </div>
        </div>
        <div class="col-xs-3 col-sm-3 col-md-3 col-lg-3 player-info">
            <div class="thumbnail">
                <a class="pull-top" href="playerInfo.jsp">
                    <img class="img" src="${pageContext.request.contextPath}/public/img/user-big/ia_10095.jpg" alt="Image">
                </a>
                <div class="media-body">
                    <h4 class="media-heading">狂野小狸猫</h4>
                    <p class="dec">
                    <p class="game"><span>第五人格</span></p>
                    <h3 class="price">15元/小时</h3>
                </div>
            </div>
        </div>
        <div class="col-xs-3 col-sm-3 col-md-3 col-lg-3 player-info">
            <div class="thumbnail">
                <a class="pull-top" href="playerInfo.jsp">
                    <img class="img" src="${pageContext.request.contextPath}/public/img/user-big/ia_10012.jpg" alt="Image">
                </a>
                <div class="media-body">
                    <h4 class="media-heading">可爱鬼*-*</h4>
                    <p class="dec">
                    <p class="game"><span>绝地求生</span></p>
                    <h3 class="price">30元/小时</h3>
                </div>
            </div>
        </div>
        <div class="col-xs-3 col-sm-3 col-md-3 col-lg-3 player-info">
            <div class="thumbnail">
                <a class="pull-top" href="playerInfo.jsp">
                    <img class="img" src="${pageContext.request.contextPath}/public/img/user-big/ia_10014.jpg" alt="Image">
                </a>
                <div class="media-body">
                    <h4 class="media-heading">小甜心</h4>
                    <p class="dec">
                    <p class="game"><span>英雄联盟</span></p>
                    <h3 class="price">28元/小时</h3>
                </div>
            </div>
        </div>--%>
    </div>
    <!-- 新秀陪玩 -->
    <div class="newPlayer">
        <ul class="nav navbar-nav">
            <h3>新秀推荐</h3>
            <c:forEach items="${newPlayer}" var="player">
                <li>
                    <a class="play-info" href="${pageContext.request.contextPath}/showPlayerInfo.player?playerID=${player.playerID}&&playerName=${player.staffName}">
                        <img class="player-icon" src="${pageContext.request.contextPath}/public/img/user/${player.photoPath}" alt="Image">
                        <p class="userName">${player.staffName}</p>
                        <p class="info">
                            <span class="label address ">南昌</span>
                        <c:if test="${player.gender=='女'}" var="flage" scope="session">
                        <span class="label age label-pink">♀ <%=(int)Math.random()*20+10%></span>
                        </c:if>
                        <c:if test="${!flage}" var="flage" scope="session">
                        <span class="label age label-primary">♂ <%=(int)Math.random()*20+10%></span>
                        </c:if>
                        </p>
                    </a>
                </li>
            </c:forEach>
            <%--<li>
                <a class="play-info" href="playerInfo.jsp">
                    <img class="player-icon" src="${pageContext.request.contextPath}/public/img/user/ia_10075.jpg" alt="">
                    <p class="userName">酷酷</p>
                    <p class="info">
                        <span class="label address ">南昌</span>
                        <span class="label age label-primary">♂ 19</span>
                    </p>
                </a>
            </li>
            <li>
                <a class="play-info" href="playerInfo.jsp">
                    <img class="player-icon" src="${pageContext.request.contextPath}/public/img/user/ia_10233.jpg" alt="">
                    <p class="userName">软软泡o</p>
                    <p class="info">
                        <span class="label address ">北京</span>
                        <span class="label age label-pink">♀ 23</span>
                    </p>
                </a>
            </li>
            <li>
                <a class="play-info" href="playerInfo.jsp">
                    <img class="player-icon" src="${pageContext.request.contextPath}/public/img/user/ia_10364.jpg" alt="">
                    <p class="userName">小嘴0.0嘟嘟</p>
                    <p class="info">
                        <span class="label address ">西安</span>
                        <span class="label age label-pink">♀ 19</span>
                    </p>
                </a>
            </li>
            <li>
                <a class="play-info" href="playerInfo.jsp">
                    <img class="player-icon" src="${pageContext.request.contextPath}/public/img/user/ia_10368.jpg" alt="">
                    <p class="userName">UU酱</p>
                    <p class="info">
                        <span class="label address ">浙江</span>
                        <span class="label age label-pink">♀ 19</span>
                    </p>
                </a>
            </li>
            <li>
                <a class="play-info" href="playerInfo.jsp">
                    <img class="player-icon" src="${pageContext.request.contextPath}/public/img/user/ia_10047.jpg" alt="">
                    <p class="userName">明玉的苏大强</p>
                    <p class="info">
                        <span class="label address ">山东</span>
                        <span class="label age label-primary">♂ 34</span>
                    </p>
                </a>
            </li>
            <li>
                <a class="play-info" href="playerInfo.jsp">
                    <img class="player-icon" src="${pageContext.request.contextPath}/public/img/user/ia_10372.jpg" alt="">
                    <p class="userName">佛系糖糖</p>
                    <p class="info">
                        <span class="label address ">上海</span>
                        <span class="label age label-pink">♀ 19</span>
                    </p>
                </a>
            </li>
            <li>
                <a class="play-info" href="playerInfo.jsp">
                    <img class="player-icon" src="${pageContext.request.contextPath}/public/img/user/ia_10061.jpg" alt="">
                    <p class="userName">好哥哥</p>
                    <p class="info">
                        <span class="label address ">深圳</span>
                        <span class="label age label-primary">♂ 23</span>
                    </p>
                </a>
            </li>--%>
        </ul>
    </div>
    <!-- 开黑信息 -->
    <div class="together">
        <nav class="nav navbar-default">
            <li><a class="navbar-brand ">
                        <span class="glyphicon"><img src="${pageContext.request.contextPath}/public/img/picture/686589.png" alt="" width="55px">
                            游戏开黑大厅</span></a></li>
        </nav>
        <!-- 开黑信息详细 -->
        <div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
            <div class="thumbnail">
                <a class="pull-top" href="#">
                    <img class="img" src="${pageContext.request.contextPath}/public/img/game-picture/ia_10031.jpg" alt="Image">
                </a>
                <div class="media-body">
                    <h4 class="media-heading">LOL上分厅</h4>
                    <p class="dec">
                    <p class="admin"><span class="glyphicon">
                                    <img src="${pageContext.request.contextPath}/public/img/user/ia_10068.jpg" alt="">迷人的微笑</span></p>
                    <p class="number">65人</p>
                    </p>
                </div>
            </div>
        </div>
        <div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
            <div class="thumbnail">
                <a class="pull-top" href="#">
                    <img class="img" src="${pageContext.request.contextPath}/public/img/game-picture/ia_10032.jpg" alt="Image">
                </a>
                <div class="media-body">
                    <h4 class="media-heading">LOL开黑二厅</h4>
                    <p class="dec">
                    <p class="admin"><span class="glyphicon">
                                    <img src="${pageContext.request.contextPath}/public/img/user/ia_10047.jpg" alt="">小迷糊</span></p>
                    <p class="number">32人</p>
                    </p>
                </div>
            </div>
        </div>
        <div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
            <div class="thumbnail">
                <a class="pull-top" href="#">
                    <img class="img" src="${pageContext.request.contextPath}/public/img/game-picture/ia_10033.jpg" alt="Image">
                </a>
                <div class="media-body">
                    <h4 class="media-heading">LOL开黑一厅</h4>
                    <p class="dec">
                    <p class="admin"><span class="glyphicon">
                                    <img src="${pageContext.request.contextPath}/public/img/user/ia_10065.jpg" alt="">大鼻子露^(*￣(oo)￣)</span></p>
                    <p class="number">76人</p>
                    </p>
                </div>
            </div>
        </div>
        <div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
            <div class="thumbnail">
                <a class="pull-top" href="#">
                    <img class="img" src="${pageContext.request.contextPath}/public/img/game-picture/ia_10034.jpg" alt="Image">
                </a>
                <div class="media-body">
                    <h4 class="media-heading">LOL自由开黑厅</h4>
                    <p class="dec">
                    <p class="admin"><span class="glyphicon">
                                    <img src="${pageContext.request.contextPath}/public/img/user/ia_10075.jpg" alt="">怼怼o(=•ェ•=)o</span></p>
                    <p class="number">45人</p>
                    </p>
                </div>
            </div>
        </div>
        <div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
            <div class="thumbnail">
                <a class="pull-top" href="#">
                    <img class="img" src="${pageContext.request.contextPath}/public/img/game-picture/ia_10035.jpg" alt="Image">
                </a>
                <div class="media-body">
                    <h4 class="media-heading">绝地求生开黑厅</h4>
                    <p class="dec">
                    <p class="admin"><span class="glyphicon">
                                    <img src="${pageContext.request.contextPath}/public/img/user/ia_10065.jpg" alt="">寒王</span></p>
                    <p class="number">86人</p>
                    </p>
                </div>
            </div>
        </div>
        <div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
            <div class="thumbnail">
                <a class="pull-top" href="#">
                    <img class="img" src="${pageContext.request.contextPath}/public/img/game-picture/ia_10036.jpg" alt="Image">
                </a>
                <div class="media-body">
                    <h4 class="media-heading">DNF跨4A打团厅</h4>
                    <p class="dec">
                    <p class="admin"><span class="glyphicon">
                                    <img src="${pageContext.request.contextPath}/public/img/user/ia_10047.jpg" alt="">苏然染</span></p>
                    <p class="number">45人</p>
                    </p>
                </div>
            </div>
        </div>
        <div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
            <div class="thumbnail">
                <a class="pull-top" href="#">
                    <img class="img" src="${pageContext.request.contextPath}/public/img/game-picture/ia_10105.jpg" alt="Image">
                </a>
                <div class="media-body">
                    <h4 class="media-heading">自走棋开黑厅</h4>
                    <p class="dec">
                    <p class="admin"><span class="glyphicon">
                                    <img src="${pageContext.request.contextPath}/public/img/user/ia_10118.jpg" alt="">棋菜·没有子</span></p>
                    <p class="number">62人</p>
                    </p>
                </div>
            </div>
        </div>
        <div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
            <div class="thumbnail">
                <a class="pull-top" href="#">
                    <img class="img" src="${pageContext.request.contextPath}/public/img/game-picture/ia_10037.jpg" alt="Image">
                </a>
                <div class="media-body">
                    <h4 class="media-heading">和平精英开黑厅</h4>
                    <p class="dec">
                    <p class="admin">
                                <span class="glyphicon">
                                    <img src="${pageContext.request.contextPath}/public/img/user/user.JPEG" alt="">超级伏地魔</span></p>
                    <p class="number">105人</p>
                    </p>
                </div>
            </div>
        </div>
    </div>
    <!-- 排行榜信息 -->
    <div class="item rank">
        <ul class="nav navbar-nav title">
            <h3>排行榜</h3>
        </ul>
        <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4 ranks ">
            <div class="rank-item">
                <p class="rank-list">
                    <img class="icon" src="${pageContext.request.contextPath}/public/img/bg/ia_10314.png"> 热度榜
                </p>
                <div class="best">
                    <div class="first">
                        <img src="${pageContext.request.contextPath}/public/img/user/ia_10072.jpg">
                    </div>
                    <div class="second">
                        <img src="${pageContext.request.contextPath}/public/img/user/ia_10074.jpg">
                    </div>
                </div>
                <ul class="nav nav-stacked">
                    <li class="rank-items">
                        <img src="${pageContext.request.contextPath}/public/img/user/ia_10019.jpg">

                        <span class="info">
                                <p class="name">阿媚</p>
                                <p class="level"><span class="label label-warning">铂金</span></p>
                            </span>
                        <span class="number">
                                <p><span class="label label-pink age">♀ 27</span></p>
                                <p><span class="count">接单：302次</span></p>
                            </span>
                    </li>
                    <li class="rank-items">
                        <img src="${pageContext.request.contextPath}/public/img/user/ia_10013.jpg">

                        <span class="info">
                                <p class="name">小迷糊</p>
                                <p class="level"><span class="label label-warning">钻石</span></p>
                            </span>
                        <span class="number">
                                <p><span class="label label-pink age">♀ 22</span></p>
                                <p><span class="count">接单：242次</span></p>
                            </span>
                    </li>
                    <li class="rank-items">
                        <img src="${pageContext.request.contextPath}/public/img/user/ia_10025.jpg">

                        <span class="info">
                                <p class="name">咕咕叽</p>
                                <p class="level"><span class="label label-warning">大师</span></p>
                            </span>
                        <span class="number">
                                <p><span class="label label-pink age">♂ 19</span></p>
                                <p><span class="count">接单：106次</span></p>
                            </span>
                    </li>
                    <li class="rank-items">
                        <img src="${pageContext.request.contextPath}/public/img/user/ia_10062.jpg">

                        <span class="info">
                                <p class="name">乔·影</p>
                                <p class="level"><span class="label label-warning">铂金</span></p>
                            </span>
                        <span class="number">
                                <p><span class="label label-primary age">♀ 21</span></p>
                                <p><span class="count">接单：169次</span></p>
                            </span>
                    </li>
                    <li class="rank-items">
                        <img src="${pageContext.request.contextPath}/public/img/user/ia_10021.jpg">

                        <span class="info">
                                <p class="name">紫妍</p>
                                <p class="level"><span class="label label-warning">钻石</span></p>
                            </span>
                        <span class="number">
                                <p><span class="label label-pink age">♀ 19</span></p>
                                <p><span class="count">接单：62次</span></p>
                            </span>
                    </li>
                    <li class="rank-items">
                        <img src="${pageContext.request.contextPath}/public/img/user/ia_10019.jpg">

                        <span class="info">
                                <p class="name">倩倩</p>
                                <p class="level"><span class="label label-warning">铂金</span></p>
                            </span>
                        <span class="number">
                                <p><span class="label label-pink age">♀ 23</span></p>
                                <p><span class="count">接单：226次</span></p>
                            </span>
                    </li>
                </ul>
            </div>
        </div>
        <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4 ranks">
            <div class="rank-item">
                <p class="rank-list">
                    <img src="${pageContext.request.contextPath}/public/img/bg/ia_10305.png"> 收入榜
                </p>
                <div class="best">
                    <div class="first">
                        <img src="${pageContext.request.contextPath}/public/img/user/ia_10072.jpg">
                    </div>
                    <div class="second">
                        <img src="${pageContext.request.contextPath}/public/img/user/ia_10074.jpg">
                    </div>
                </div>
                <ul class="nav nav-stacked">
                    <li class="rank-items">
                        <img src="${pageContext.request.contextPath}/public/img/user/ia_10019.jpg">

                        <span class="info">
                                <p class="name">阿媚</p>
                                <p class="level"><span class="label label-warning">铂金</span></p>
                            </span>
                        <span class="number">
                                <p><span class="label label-pink age">♀ 27</span></p>
                                <p><span class="count">收入：345元</span></p>
                            </span>
                    </li>
                    <li class="rank-items">
                        <img src="${pageContext.request.contextPath}/public/img/user/ia_10013.jpg">

                        <span class="info">
                                <p class="name">小迷糊</p>
                                <p class="level"><span class="label label-warning">钻石</span></p>
                            </span>
                        <span class="number">
                                <p><span class="label label-pink age">♀ 22</span></p>
                                <p><span class="count">收入：242元</span></p>
                            </span>
                    </li>
                    <li class="rank-items">
                        <img src="${pageContext.request.contextPath}/public/img/user/ia_10025.jpg">

                        <span class="info">
                                <p class="name">咕咕叽</p>
                                <p class="level"><span class="label label-warning">大师</span></p>
                            </span>
                        <span class="number">
                                <p><span class="label label-pink age">♂ 19</span></p>
                                <p><span class="count">收入：106元</span></p>
                            </span>
                    </li>
                    <li class="rank-items">
                        <img src="${pageContext.request.contextPath}/public/img/user/ia_10062.jpg">

                        <span class="info">
                                <p class="name">乔·影</p>
                                <p class="level"><span class="label label-warning">铂金</span></p>
                            </span>
                        <span class="number">
                                <p><span class="label label-primary age">♀ 21</span></p>
                                <p><span class="count">收入：169元</span></p>
                            </span>
                    </li>
                    <li class="rank-items">
                        <img src="${pageContext.request.contextPath}/public/img/user/ia_10021.jpg">

                        <span class="info">
                                <p class="name">紫妍</p>
                                <p class="level"><span class="label label-warning">钻石</span></p>
                            </span>
                        <span class="number">
                                <p><span class="label label-pink age">♀ 19</span></p>
                                <p><span class="count">收入：62元</span></p>
                            </span>
                    </li>
                    <li class="rank-items">
                        <img src="${pageContext.request.contextPath}/public/img/user/ia_10019.jpg">

                        <span class="info">
                                <p class="name">倩倩</p>
                                <p class="level"><span class="label label-warning">铂金</span></p>
                            </span>
                        <span class="number">
                                <p><span class="label label-pink age">♀ 23</span></p>
                                <p><span class="count">收入：226元</span></p>
                            </span>
                    </li>
                </ul>
            </div>
        </div>

        <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4 ranks">
            <div class="rank-item">
                <p class="rank-list">
                    <img src="${pageContext.request.contextPath}/public/img/bg/ia_10310.png"> 土豪榜
                </p>
                <div class="best">
                    <div class="first">
                        <img src="${pageContext.request.contextPath}/public/img/user/ia_10072.jpg">
                    </div>
                    <div class="second">
                        <img src="${pageContext.request.contextPath}/public/img/user/ia_10074.jpg">
                    </div>
                </div>
                <ul class="nav nav-stacked">
                    <li class="rank-items">
                        <img src="${pageContext.request.contextPath}/public/img/user/ia_10019.jpg">

                        <span class="info">
                                <p class="name">阿媚</p>
                                <p class="level"><span class="label label-warning">铂金</span></p>
                            </span>
                        <span class="number">
                                <p><span class="label label-pink age">♀ 27</span></p>
                                <p><span class="count">消费：302元</span></p>
                            </span>
                    </li>
                    <li class="rank-items">
                        <img src="${pageContext.request.contextPath}/public/img/user/ia_10013.jpg">

                        <span class="info">
                                <p class="name">小迷糊</p>
                                <p class="level"><span class="label label-warning">钻石</span></p>
                            </span>
                        <span class="number">
                                <p><span class="label label-pink age">♀ 22</span></p>
                                <p><span class="count">消费：242元</span></p>
                            </span>
                    </li>
                    <li class="rank-items">
                        <img src="${pageContext.request.contextPath}/public/img/user/ia_10025.jpg">

                        <span class="info">
                                <p class="name">咕咕叽</p>
                                <p class="level"><span class="label label-warning">大师</span></p>
                            </span>
                        <span class="number">
                                <p><span class="label label-pink age">♂ 19</span></p>
                                <p><span class="count">消费：106元</span></p>
                            </span>
                    </li>
                    <li class="rank-items">
                        <img src="${pageContext.request.contextPath}/public/img/user/ia_10062.jpg">

                        <span class="info">
                                <p class="name">乔·影</p>
                                <p class="level"><span class="label label-warning">铂金</span></p>
                            </span>
                        <span class="number">
                                <p><span class="label label-primary age">♀ 21</span></p>
                                <p><span class="count">消费：169元</span></p>
                            </span>
                    </li>
                    <li class="rank-items">
                        <img src="${pageContext.request.contextPath}/public/img/user/ia_10021.jpg">

                        <span class="info">
                                <p class="name">紫妍</p>
                                <p class="level"><span class="label label-warning">钻石</span></p>
                            </span>
                        <span class="number">
                                <p><span class="label label-pink age">♀ 19</span></p>
                                <p><span class="count">消费：62元</span></p>
                            </span>
                    </li>
                    <li class="rank-items">
                        <img src="${pageContext.request.contextPath}/public/img/user/ia_10019.jpg">

                        <span class="info">
                                <p class="name">倩倩</p>
                                <p class="level"><span class="label label-warning">铂金</span></p>
                            </span>
                        <span class="number">
                                <p><span class="label label-pink age">♀ 23</span></p>
                                <p><span class="count">消费：226元</span></p>
                            </span>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>
</div>
</div>
<div class="foot">
    <div class="help_box mt30">
        <div class="pic"><img src="${pageContext.request.contextPath}/public/img/bg/consume_new.jpg"></div>
        <div class="font">
            <div class="fl ml35 pr30 border_right"><i class="icon custom mr10"></i>客服电话：<span
                    class="custom_01">010-68608228</span><span class="custom_02">咨询时间：7X24小时 &nbsp;&nbsp;|&nbsp;&nbsp; </span></div>
            <div class="fl pl30" id="dd_kefu_pcbottom" style="cursor: pointer;"><i
                    class="icon QQ mr10"></i>客服QQ：<span class="custom_01">800184580</span></div>
            <div class="fl pl30"><span class="custom_02">咨询时间：7X24小时</span></div>
            <div class="fl ml40">
                <a href="javascript:" title="" class="fl help">帮助中心</a>
                <a href="javascript:" title="" class="fl help">服务保障</a>
                <a href="javascript:" title="" class="fl help">陪玩守则</a>
            </div>
        </div>
        <div class="clearfix"></div>
    </div>
    <div class="foot-info">
        <div class="Copy">
            电话号码:010-68608228&nbsp;&nbsp;公司地址:北京市石景山区鲁谷路74号院中国瑞达大厦6层601&nbsp;&nbsp;公司全称:北京陶乐科技有限公司&nbsp;&nbsp;备案号：京ICP备18042855号-2
        </div>
        <div class="Copy" style="margin-top:10px;">京ICP备18042855号-2 Copyright 2014-2019 TaoLe Corporation,All Rights
            Reserved</div>
    </div>
</div>
<!-- 注册登录模块框 -->
<div class="modal fade" id="login" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">
                    <div role="tabpanel">
                        <!-- Nav tabs -->
                        <ul class="nav nav-tabs" role="tablist">
                            <li role="presentation" class="active">
                                <a href="#home" aria-controls="login" role="tab" data-toggle="tab">登录</a>
                            </li>
                            <li role="presentation">
                                <a href="#tab" aria-controls="register" role="tab" data-toggle="tab">注册</a>
                            </li>
                        </ul>
                    </div>
                </h4>
            </div>
            <div class="tab-content">
                <div role="tabpanel" class="tab-pane active" id="home">
                    <div class="modal-body">
                        <form class="form-horizontal" id="user_form" method="post" action="${pageContext.request.contextPath}/login.user" >
                            <div class="form-group">
                                <label for="new_loginName" class="col-sm-2 control-label">账号</label>
                                <div class="col-sm-8">
                                    <input type="text" class="form-control" id="new_loginName" placeholder="账号" name="loginName">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="new_loginPwd" class="col-sm-2 control-label">密码</label>
                                <div class="col-sm-8">
                                    <input type="text" class="form-control" id="new_loginPwd" placeholder="密码" name="loginPwd">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="login_code" class="col-sm-2 control-label">验证码</label>
                                <div class="col-sm-4">
                                    <input type="text" class="form-control" id="login_code" placeholder="验证码" name="code">
                                    <div class="code" style="float: right">
                                        <img src="${pageContext.request.contextPath}/code" onclick="changeCode()" id="checkCodeImg"/>
                                        <a href="javascript:changeCode()" >看不清换一张</a><br>
                                    </div>
                                </div>
                            </div>
                            <input type="submit" value="" id="dologin" style="display: none">
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                        <button type="button" class="btn btn-primary"  id="loginbtn" >登录</button>
                    </div></div>
                <div role="tabpanel" class="tab-pane" id="tab"><div class="modal-body">
                    <form class="form-horizontal" id="register_user_form" method="post" action="register.user" >
                        <div class="form-group">
                            <label for="register_loginName" class="col-sm-2 control-label">账号</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" id="register_loginName" placeholder="账号" name="loginName">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="register_loginPwd" class="col-sm-2 control-label">密码</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" id="register_loginPwd" placeholder="密码" name="loginPwd">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="register_gender" class="col-sm-2 control-label">性别</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" id="register_gender" placeholder="性别" name="gender">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="register_email" class="col-sm-2 control-label">Email</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" id="register_email" placeholder="Email" name="email">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="register_telephone" class="col-sm-2 control-label">电话</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" id="register_telephone" placeholder="电话" name="telephone">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="register_QQ" class="col-sm-2 control-label">QQ</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" id="register_QQ" placeholder="QQ账号" name="QQ">
                            </div>
                        </div>
                        <input type="submit" value="" id="doRegister" style="display: none">
                    </form>
                </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                        <button type="button" class="btn btn-primary" id="registerBtn">注册</button>
                    </div>
                </div>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
<!-- 注册登录模块框 -->
</body>

</html>
