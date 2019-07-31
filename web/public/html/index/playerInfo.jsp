<%--
  Created by IntelliJ IDEA.
  User: Larimar
  Date: 2019/7/31
  Time: 14:32
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Eplay</title>
    <link rel="stylesheet" href="../../dist/css/bootstrap.css">
    <link rel="stylesheet" href="../../dist/css/bootstrap.css.map">
    <script src="../../dist/js/jquery-3.4.1.js"></script>
    <script src="../../dist/js/bootstrap.js"></script>
    <link rel="stylesheet" href="../../css/playerinfo.css">
    <script>
        $(function () {
            $(".games").mouseenter(function () {
                $(this).children(".label").toggleClass("select-game");
            });
            $(function () {
                $(".pic li").mouseenter(function () {
                    $(".big").attr("src",$(this).children("img").attr("src"));
                })
            });
        })
    </script>
    <script>
        $("#my-carousel").carousel({
            interval: 2000,
        });
    </script>
</head>

<body>
<!-- 头部导航 -->
<div class="top">
    <nav class="navbar navbar-default navbar-static-top top-item" role="navigation">
        <a class="navbar-brand logo" href="#">
            <div style="float:left"><img src="../../img/Logo/ep-logo-l.png" alt="" width="70px"></div>
            <div class="font" style="float: right"><span class="title">Eplay</span>
                <p style="margin-top: 5px;">一起娱乐一起交友</p>
            </div>
        </a>
        <ul class="nav navbar-nav">
            <li class="nav-item actived">
                <a href="index.jsp">主页</a>
            </li>
            <li class="nav-item">
                <a href="list.jsp">约陪玩</a>
            </li>
            <li class="nav-item">
                <a href="#">开黑大厅</a>
            </li>
            <li class="nav-item">
                <a href="../home/userHome.jsp?target=recharge">充值</a>
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
                <a href="../home/userHome.jsp?target=message">
                        <span class="glyphicon glyphicon-tasks" aria-hidden="true">
                            <p class="font">消息</p>
                        </span>
                </a>
            </li>
            <li class="mar">|</li>
            <li class="nav-item top-right">
                <a href="../home/userHome.jsp?target=protocol">
                        <span class="glyphicon glyphicon-flag" aria-hidden="true">
                            <p class="font">入驻</p>
                        </span>
                </a>
            </li>
            <!-- 判断是否登录 显示哪个内容 -->
            <li class="nav_item userinfo" style="display: none">
                <a href="../home/userHome.jsp?target=orderlist">
                    <div class="img"><img src="../../img/user/user.JPEG" alt="" width="60px"
                                          style="border-radius:50% ">
                    </div>
                    <div class="info"><span class="leve">普通用户</span>
                        <p class="name">Larimar</p>
                    </div>
                </a>
            </li>
            <li class="nav_item login-rigster">
                <button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#login">注册/登录</button>
            </li>
            <li class="nav_item">
                <a href="">退出</a>
            </li>
        </ul>
    </nav>
</div>
<!-- 玩家详细信息 -->
<div class="playerinfo">
    <div class="container">
        <!-- 头部信息 -->
        <div class="title">
            <img class="player-icon" src="../../img/user/ia_10014.jpg">
            <div class="info">
                <p class="name">康康ღ</p>
                <p class="mess">
                    <span class="label label-warning">真人认证</span>
                </p>
            </div>
            <div class="button">
                <button type="button" class="btn btn-success">微信下单</button>
                <button type="button" class="btn btn-danger"><span class="glyphicon glyphicon-link"></span>
                    分享</button>
                <button type="button" class="btn btn-primary">关注</button>
                <div class="item"><span class="age">♂ 21</span><span class="location">
                            <span class="glyphicon glyphicon-map-marker"></span>
                            江西南昌</span></div>
            </div>
        </div>
        <!-- 左边头像和资料 -->
        <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
            <div class="left-info">
                <img class="big" src="../../img/user/ia_10012.jpg">

                <div class="pic">
                    <ul class="nav nav-tabs">

                        <span class="glyphicon glyphicon-triangle-left left"></span>

                        <li>
                            <img class="small" src="../../img/user/ia_10013.jpg">
                        </li>
                        <li>
                            <img class="small"  src="../../img/user/ia_10014.jpg">
                        </li>
                        <li>
                            <img class="small"  src="../../img/user/ia_10015.jpg">
                        </li>
                        <li>
                            <img class="small"  src="../../img/user/ia_10016.jpg">
                        </li>
                        <span class="glyphicon glyphicon-triangle-right right"></span>
                    </ul>
                    <h3 style="text-align: center">用户名</h3>
                </div>
            </div>
        </div>
        <!-- 右边下单和详情 -->
        <div class="col-xs-8 col-sm-8 col-md-8 col-lg-8">
            <div class="right-info">

                <div role="tabpanel">
                    <!-- Nav tabs -->
                    <ul class="nav nav-tabs" role="tablist">
                        <li role="presentation" class="active">
                            <a href="#game1" aria-controls="game1" role="tab" data-toggle="tab">LOL</a>
                        </li>
                        <li role="presentation">
                            <a href="#game2" aria-controls="game2" role="tab" data-toggle="tab">绝地求生</a>
                        </li>
                    </ul>

                    <!-- Tab panes -->
                    <div class="tab-content">
                        <div role="tabpanel" class="tab-pane active" id="game1">
                            <ul class="nav nav-stacked">
                                <li class="player-game top">
                                    <div class="gameicon">
                                        <img src="../../img/gameimg/lol.png" alt="">
                                    </div>
                                    <div class="gameinfo">
                                        <h3>
                                            线上LOL
                                        </h3>
                                        <p class="level">
                                            <span class="label label-default">荣耀黄金三</span>
                                        </p>
                                        <p class="acount">
                                            <span class="glyphicon glyphicon-bullhorn">&nbsp;接单次数：120次</span>
                                        </p>
                                    </div>
                                    <div class="order">
                                        <p class="price">
                                            <span>￥40</span>&nbsp;/小时
                                        </p>
                                        <button type="button" class="btn btn-danger">下单约他</button>
                                    </div>
                                </li>
                                <li class="player-game introduce">
                                    <h3>介绍<span>/INTRODUCE</span></h3>
                                    <p>草从霸主，野区骚猪,输出全靠吼</p>
                                    <p>提莫队长正在送命 杀人啦~~~~~</p>
                                    <p> 还有我是广东人,偶尔可以飚几句粤语</p>
                                    <p>喜欢听粤语歌也可以唱给你听</p>
                                    <p>下单两小时起 我在约玩等你哦</p>
                                </li>
                                <li class="player-game comment">
                                    <h3>评论<span>/COMMENT</span></h3>
                                    <h4 class="point">评分：<span>9.9</span></h4>
                                    <div class="usercommint">
                                        <ul class="nav navstack">
                                            <li class="comments"><span class="username">卿卿：</span> 挺好的 <span
                                                    class="time">2019-02-18</span></li>
                                            <li class="comments"><span class="username">秋秋：</span> 人美声甜 <span
                                                    class="time">2019-04-25</span></li>
                                            <li class="comments"><span class="username">阿飞：</span>技术流 <span
                                                    class="time">2019-04-23</span></li>
                                        </ul>
                                    </div>
                                </li>
                            </ul>
                        </div>
                        <div role="tabpanel" class="tab-pane" id="game2">
                            <ul class="nav nav-stacked">
                                <li class="player-game top">
                                    <div class="gameicon">
                                        <img src="../../img/gameimg/pubg.png" alt="">
                                    </div>
                                    <div class="gameinfo">
                                        <h3>
                                            线上LOL
                                        </h3>
                                        <p class="level">
                                            <span class="label label-default">1800分</span>
                                        </p>
                                        <p class="acount">
                                            <span class="glyphicon glyphicon-bullhorn">&nbsp;接单次数：110次</span>
                                        </p>
                                    </div>
                                    <div class="order">
                                        <p class="price">
                                            <span>￥35</span>/小时
                                        </p>
                                        <button type="button" class="btn btn-danger">下单约他</button>
                                    </div>
                                </li>
                                <li class="player-game introduce">
                                    <h3>介绍<span>/INTRODUCE</span></h3>
                                    <p>救死扶伤,移动药箱,输出全靠吼</p>
                                    <p> 还有我是广东人,偶尔可以飚几句粤语</p>
                                    <p>喜欢听粤语歌也可以唱给你听</p>
                                    <p>下单两小时起 我在约玩等你哦</p>
                                </li>
                                <li class="player-game comment">
                                    <h3>评论<span>/COMMENT</span></h3>
                                    <h4 class="point">评分：<span>9.9</span></h4>
                                    <div class="usercommint">
                                        <ul class="nav navstack">
                                            <li class="comments"><span class="username">卿卿：</span> 挺好的 <span
                                                    class="time">2019-02-18</span></li>
                                            <li class="comments"><span class="username">秋秋：</span> 人美声甜 <span
                                                    class="time">2019-04-25</span></li>
                                            <li class="comments"><span class="username">阿飞：</span>技术流 <span
                                                    class="time">2019-04-23</span></li>
                                        </ul>
                                    </div>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </div>

</div>
</div>
<!-- 尾部信息 -->
<div class="foot">
    <div class="help_box mt30">
        <div class="pic"><img src="../../img/bg/consume_new.jpg"></div>
        <div class="font">
            <div class="fl ml35 pr30 border_right"><i class="icon custom mr10"></i>客服电话：<span
                    class="custom_01">010-68608228</span><span class="custom_02">咨询时间：7X24小时
                        &nbsp;&nbsp;|&nbsp;&nbsp; </span></div>
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
                        <form class="form-horizontal" id="user_form" >
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
                                        <img src="../../img/bg/ia_10281.jpg" onclick="changeCode()"/><a href="javascript:changeCode()" >看不清换一张</a><br>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                        <button type="button" class="btn btn-primary" onclick="loginUser()">登录</button>
                    </div></div>
                <div role="tabpanel" class="tab-pane" id="tab"><div class="modal-body">
                    <form class="form-horizontal" id="register_user_form" >
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
                    </form>
                </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                        <button type="button" class="btn btn-primary" onclick="registerUser()">注册</button>
                    </div>
                </div>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
<!-- 注册登录模块框 -->
</body>

</html>
