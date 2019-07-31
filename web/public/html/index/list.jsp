<%--
  Created by IntelliJ IDEA.
  User: Larimar
  Date: 2019/7/31
  Time: 14:31
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
    <link rel="stylesheet" href="../../css/base.css">
    <link rel="stylesheet" href="../../css/list.css">
    <script>
        $(function () {
            $(".games").mouseenter(function () {
                $(this).children(".label").toggleClass("select-game");
            });
            $(function () {
                $(".pic li").mouseenter(function () {
                    $(".big").attr("src",$(this).children("img").attr("src"));
                });
                $(".levels .level").mouseenter(function(){
                    $(this).children("span").addClass("label-select");
                }).mouseleave(function(){
                    $(this).children("span").removeClass("label-select");
                });
                $(".levels .level").click(function(){
                    $(this).children("span").addClass("label-active").removeClass("label-select").parent().siblings().children("span").removeClass("label-active").removeClass("label-select");
                });
                $(".genders .gender").mouseenter(function(){
                    $(this).children("span").addClass("label-select");
                }).mouseleave(function(){
                    $(this).children("span").removeClass("label-select");
                });
                $(".genders .gender").click(function(){
                    $(this).children("span").addClass("label-active").removeClass("label-select").parent().siblings().children("span").removeClass("label-active").removeClass("label-select");
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
                <a href="#">主页</a>
            </li>
            <li class="nav-item">
                <a href="#">约陪玩</a>
            </li>
            <li class="nav-item">
                <a href="#">开黑大厅</a>
            </li>
            <li class="nav-item">
                <a href="#">充值</a>
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
                <a href="#">
                        <span class="glyphicon glyphicon-tasks" aria-hidden="true">
                            <p class="font">消息</p>
                        </span>
                </a>
            </li>
            <li class="mar">|</li>
            <li class="nav-item top-right">
                <a href="#">
                        <span class="glyphicon glyphicon-flag" aria-hidden="true">
                            <p class="font">入驻</p>
                        </span>
                </a>
            </li>
            <!-- 判断是否登录 显示哪个内容 -->
            <li class="nav_item userinfo" style="display: none">
                <a href="">
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
<!-- 游戏和玩家主体部分 -->
<div class="container">
    <!-- 游戏信息 -->
    <div class="gamelist">
        <table class="table table-light top">
            <tbody>
            <tr class="games">
                <td class="title">游戏服务</td>
                <td>
                    <ul class="nav nav-pills">
                        <li class="game"><a href=""><img src="../../img/gameimg/glory.png"><span>王者荣耀</span></a> </li>
                        <li class="game"><a href=""><img src="../../img/gameimg/pubg.png"><span>绝地求生</span></a> </li>
                        <li class="game"><a href=""><img src="../../img/gameimg/csgo.jpg"><span>CS：Go</span></a> </li>
                        <li class="game"><a href=""><img src="../../img/gameimg/zhanchang.png"><span>和平精英</span></a> </li>
                        <li class="game"><a href=""><img src="../../img/gameimg/apex.png"><span>Apex英雄</span></a> </li>
                        <li class="game"><a href=""><img src="../../img/gameimg/dotazzq.png"><span>Dota自走棋</span></a> </li>
                        <li class="game"><a href=""><img src="../../img/gameimg/lol.png"><span>英雄联盟</span></a> </li>
                        <li class="game"><a href=""><img src="../../img/gameimg/yunding.png"><span>云顶之役</span></a> </li>
                    </ul>
                </td>
            </tr>
            <tr class="levels">
                <td class="title">等级分类</td>
                <td>
                    <ul class="nav nav-pills">
                        <li class="level">
                            <span class="label-select label-active">全部</span></li>
                        <li class="level"><span>黄金以下</span></li>
                        <li class="level"><span>黄金</span></li>
                        <li class="level"><span>铂金</span></li>
                        <li class="level"><span>钻石</span></li>
                        <li class="level"><span>星耀</span></li>
                        <li class="level"><span>王者</span></li>
                    </ul>
                </td>
            </tr>
            <tr class="genders">
                <td class="title">玩家性别</td>
                <td>
                    <ul class="nav nav-pills">
                        <li class="gender"> <span class="label-select label-active">男</span></li>
                        <li class="gender"><span>女</span></li>
                    </ul>
                </td>
            </tr>
            </tbody>
        </table>
    </div>
    <!-- 玩家信息 -->
    <div class="player">
        <div class="col-xs-3 col-sm-3 col-md-3 col-lg-3 player-info">
            <div class="thumbnail">
                <a class="pull-top" href="#">
                    <img class="img" src="../../img/user-big/ia_10015.jpg" alt="Image">
                </a>
                <div class="media-body">
                    <h4 class="media-heading">狂野傲娇小萝莉</h4>
                    <p class="dec">
                    <p class="game"><span><span class="label age label-pink">♀ 19</span> 王者荣耀</span></p>
                    <h3 class="price">35元/小时</h3>
                    </p>
                </div>
            </div>
        </div>
        <div class="col-xs-3 col-sm-3 col-md-3 col-lg-3 player-info">
            <div class="thumbnail">
                <a class="pull-top" href="#">
                    <img class="img" src="../../img/user-big/ia_10013.jpg" alt="Image">
                </a>
                <div class="media-body">
                    <h4 class="media-heading">可爱丸子</h4>
                    <p class="dec">
                    <p class="game"><span><span class="label age label-pink">♀ 19</span> 英雄联盟</span></p>
                    <h3 class="price">30元/小时</h3>
                </div>
            </div>
        </div>
        <div class="col-xs-3 col-sm-3 col-md-3 col-lg-3 player-info">
            <div class="thumbnail">
                <a class="pull-top" href="#">
                    <img class="img" src="../../img/user-big/ia_10023.jpg" alt="Image">
                </a>
                <div class="media-body">
                    <h4 class="media-heading">皮皮猪</h4>
                    <p class="dec">
                    <p class="game"><span><span class="label age label-pink">♀ 19</span> CS：GO</span></p>
                    <h3 class="price">20元/小时</h3>
                </div>
            </div>
        </div>
        <div class="col-xs-3 col-sm-3 col-md-3 col-lg-3 player-info">
            <div class="thumbnail">
                <a class="pull-top" href="#">
                    <img class="img" src="../../img/user-big/ia_10097.jpg" alt="Image">
                </a>
                <div class="media-body">
                    <h4 class="media-heading">柯基的绿毛龟</h4>
                    <p class="dec">
                    <p class="game"><span><span class="label age label-pink">♀ 19</span> 王者荣耀</span></p>
                    <h3 class="price">35元/小时</h3>
                </div>
            </div>
        </div>

        <div class="col-xs-3 col-sm-3 col-md-3 col-lg-3 player-info">
            <div class="thumbnail">
                <a class="pull-top" href="#">
                    <img class="img" src="../../img/user-big/ia_10096.jpg" alt="Image">
                </a>
                <div class="media-body">
                    <h4 class="media-heading">小仙女@锦梨</h4>
                    <p class="dec">
                    <p class="game"><span><span class="label age label-pink">♀ 19</span> 绝地求生</span></p>
                    <h3 class="price">18元/小时</h3>
                </div>
            </div>
        </div>
        <div class="col-xs-3 col-sm-3 col-md-3 col-lg-3 player-info">
            <div class="thumbnail">
                <a class="pull-top" href="#">
                    <img class="img" src="../../img/user-big/ia_10095.jpg" alt="Image">
                </a>
                <div class="media-body">
                    <h4 class="media-heading">狂野小狸猫</h4>
                    <p class="dec">
                    <p class="game"><span><span class="label age label-pink">♀ 19</span> 第五人格</span></p>
                    <h3 class="price">15元/小时</h3>
                </div>
            </div>
        </div>
        <div class="col-xs-3 col-sm-3 col-md-3 col-lg-3 player-info">
            <div class="thumbnail">
                <a class="pull-top" href="#">
                    <img class="img" src="../../img/user-big/ia_10012.jpg" alt="Image">
                </a>
                <div class="media-body">
                    <h4 class="media-heading">可爱鬼*-*</h4>
                    <p class="dec">
                    <p class="game"><span><span class="label age label-pink">♀ 19</span> 绝地求生</span></p>
                    <h3 class="price">30元/小时</h3>
                </div>
            </div>
        </div>
        <div class="col-xs-3 col-sm-3 col-md-3 col-lg-3 player-info">
            <div class="thumbnail">
                <a class="pull-top" href="#">
                    <img class="img" src="../../img/user-big/ia_10014.jpg" alt="Image">
                </a>
                <div class="media-body">
                    <h4 class="media-heading">小甜心</h4>
                    <p class="dec">
                    <p class="game"><span><span class="label age label-pink">♀ 19</span> 英雄联盟</span></p>
                    <h3 class="price">28元/小时</h3>
                </div>
            </div>
        </div>
    </div>
    <!-- 排行榜信息 -->
    <div class="item rank">
        <div class="ranks ">
            <div class="rank-item">
                <p class="rank-list">
                    <img class="icon" src="../../img/bg/ia_10314.png"> 热度榜
                </p>
                <ul class="nav nav-stacked">
                    <li class="rank-items">
                        <img src="../../img/user/ia_10019.jpg">

                        <span class="info">
                                <p class="name">阿媚</p>
                            </span>
                        <span class="number">
                                <p><span class="label label-pink age">♀ 27</span></p>
                                <p><span class="count">接单：302次</span></p>
                            </span>
                    </li>
                    <li class="rank-items">
                        <img src="../../img/user/ia_10013.jpg">

                        <span class="info">
                                <p class="name">小迷糊</p>

                            </span>
                        <span class="number">
                                <p><span class="label label-pink age">♀ 22</span></p>
                                <p><span class="count">接单：242次</span></p>
                            </span>
                    </li>
                    <li class="rank-items">
                        <img src="../../img/user/ia_10025.jpg">

                        <span class="info">
                                <p class="name">咕咕叽</p>

                            </span>
                        <span class="number">
                                <p><span class="label label-pink age">♂ 19</span></p>
                                <p><span class="count">接单：106次</span></p>
                            </span>
                    </li>
                    <li class="rank-items">
                        <img src="../../img/user/ia_10062.jpg">

                        <span class="info">
                                <p class="name">乔·影</p>

                            </span>
                        <span class="number">
                                <p><span class="label label-primary age">♀ 21</span></p>
                                <p><span class="count">接单：169次</span></p>
                            </span>
                    </li>
                    <li class="rank-items">
                        <img src="../../img/user/ia_10021.jpg">

                        <span class="info">
                                <p class="name">紫妍</p>

                            </span>
                        <span class="number">
                                <p><span class="label label-pink age">♀ 19</span></p>
                                <p><span class="count">接单：62次</span></p>
                            </span>
                    </li>
                    <li class="rank-items">
                        <img src="../../img/user/ia_10019.jpg">

                        <span class="info">
                                <p class="name">倩倩</p>
                            </span>
                        <span class="number">
                                <p><span class="label label-pink age">♀ 23</span></p>
                                <p><span class="count">接单：226次</span></p>
                            </span>
                    </li>
                </ul>
            </div>
        </div>
        <div class="ranks">
            <div class="rank-item">
                <p class="rank-list">
                    <img src="../../img/bg/ia_10305.png"> 收入榜
                </p>
                <ul class="nav nav-stacked">
                    <li class="rank-items">
                        <img src="../../img/user/ia_10019.jpg">

                        <span class="info">
                                <p class="name">阿媚</p>

                            </span>
                        <span class="number">
                                <p><span class="label label-pink age">♀ 27</span></p>
                                <p><span class="count">收入：345元</span></p>
                            </span>
                    </li>
                    <li class="rank-items">
                        <img src="../../img/user/ia_10013.jpg">

                        <span class="info">
                                <p class="name">小迷糊</p>

                            </span>
                        <span class="number">
                                <p><span class="label label-pink age">♀ 22</span></p>
                                <p><span class="count">收入：242元</span></p>
                            </span>
                    </li>
                    <li class="rank-items">
                        <img src="../../img/user/ia_10025.jpg">

                        <span class="info">
                                <p class="name">咕咕叽</p>

                            </span>
                        <span class="number">
                                <p><span class="label label-pink age">♂ 19</span></p>
                                <p><span class="count">收入：106元</span></p>
                            </span>
                    </li>
                    <li class="rank-items">
                        <img src="../../img/user/ia_10062.jpg">

                        <span class="info">
                                <p class="name">乔·影</p>

                            </span>
                        <span class="number">
                                <p><span class="label label-primary age">♀ 21</span></p>
                                <p><span class="count">收入：169元</span></p>
                            </span>
                    </li>
                    <li class="rank-items">
                        <img src="../../img/user/ia_10021.jpg">

                        <span class="info">
                                <p class="name">紫妍</p>

                            </span>
                        <span class="number">
                                <p><span class="label label-pink age">♀ 19</span></p>
                                <p><span class="count">收入：62元</span></p>
                            </span>
                    </li>
                    <li class="rank-items">
                        <img src="../../img/user/ia_10019.jpg">

                        <span class="info">
                                <p class="name">倩倩</p>

                            </span>
                        <span class="number">
                                <p><span class="label label-pink age">♀ 23</span></p>
                                <p><span class="count">收入：226元</span></p>
                            </span>
                    </li>
                </ul>
            </div>
        </div>
    </div>
    <!-- <div class="exit">

    </div> -->
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
