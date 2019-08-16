<%@ page import="java.util.List" %>
<%@ page import="java.lang.reflect.Array" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="bean.PlayerBean" %>
<%@ page import="bean.OrderBean" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/public/dist/css/bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/public/dist/css/bootstrap.css.map">
    <script src="${pageContext.request.contextPath}/public/dist/js/jquery-3.4.1.js"></script>
    <script src="${pageContext.request.contextPath}/public/dist/js/bootstrap.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/public/css/base.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/public/css/playerinfo.css">
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
        <a class="navbar-brand logo" href="#">
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
<!-- 玩家详细信息 -->
<div class="playerinfo">
    <div class="container">
        <!-- 头部信息 -->
        <div class="title">
            <img class="player-icon" src="${pageContext.request.contextPath}/public/img/user/${playerInfo.photoPath}">
            <div class="info">
                <p class="name">${playerInfo.staffName}</p>
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
                <%!
                    List<String> picPaths =  new ArrayList<String>();
                    List<String > introduce = new ArrayList<String>();
                    List<PlayerBean> playerBeans = new ArrayList<PlayerBean>();
                    Map<String,String> games = new HashMap<>();
                    Map<String,List<String>>gameIntroduce = new HashMap<>();
                %>
                <%
                    PlayerBean playerInfo = (PlayerBean) request.getSession().getAttribute("playerInfo");
                    String picPath = playerInfo.getPicPath();
                    String[] split = picPath.split("=");
                    for (int i = 0; i < split.length; i++) {
                        List<String> picPaths =  new ArrayList<String>();
                        picPaths.add(split[i]);
                        System.out.println(picPaths);
                    }
                    /*获取玩家信息*/
                    games = (HashMap<String, String>) application.getAttribute("gameList");
                    /*获取玩家详细介绍*/
                    playerBeans = (List<PlayerBean>) request.getSession().getAttribute("playerGameInfo");
                    for (PlayerBean player:playerBeans) {
                        String split1 = player.getIntroduce();
                        introduce.add(split1);
                        gameIntroduce = new HashMap<>();
                        gameIntroduce.put(player.getGameName(),introduce);
                        System.out.println(gameIntroduce);
                    }

                %>
                <img class="big" src="${pageContext.request.contextPath}/public/img/user/<%=picPaths.get(0)%>">

                <div class="pic">
                    <ul class="nav nav-tabs">
                        <span class="glyphicon glyphicon-triangle-left left"></span>

                        <li>
                            <img class="small" src="${pageContext.request.contextPath}/public/img/user/<%=picPaths.get(0)%>">
                        </li>
                        <li>
                            <img class="small"  src="${pageContext.request.contextPath}/public/img/user/<%=picPaths.get(1)%>">
                        </li>
                        <li>
                            <img class="small"  src="${pageContext.request.contextPath}/public/img/user/<%=picPaths.get(2)%>">
                        </li>
                        <li>
                            <img class="small"  src="${pageContext.request.contextPath}/public/img/user/<%=picPaths.get(3)%>">
                        </li>
                        <span class="glyphicon glyphicon-triangle-right right"></span>
                    </ul>
                    <h3 style="text-align: center">${playerInfo.staffName}</h3>
                </div>
            </div>
        </div>
        <!-- 右边下单和详情 -->
        <div class="col-xs-8 col-sm-8 col-md-8 col-lg-8">
            <div class="right-info">
                <div role="tabpanel">
                    <!-- Nav tabs -->
                    <ul class="nav nav-tabs" role="tablist">
                        <%
                            playerBeans = (List<PlayerBean>)request.getSession().getAttribute("playerGameInfo");
                        %>
                        <li role="presentation" class="active">
                            <a href="#game1" aria-controls="game1" role="tab" data-toggle="tab"><%=playerBeans.get(0).getGameName()%></a>
                        </li>
                        <c:forEach items="${playerGameInfo}" var="playerGame" begin="1" varStatus="status">
                            <li role="presentation">
                                <a href="#game${status.index+1}" aria-controls="game${status.index+1}" role="tab" data-toggle="tab">${playerGame.gameName}</a>
                            </li>
                        </c:forEach>
                    </ul>

                    <!-- Tab panes -->
                    <div class="tab-content">
                        <div role="tabpanel" class="tab-pane active" id="game1">
                            <ul class="nav nav-stacked">
                                <li class="player-game top">
                                    <div class="gameicon">

                                        <img src="${pageContext.request.contextPath}/public/img/gameimg/<%=games.get(playerBeans.get(0).getGameName())%>" alt="">
                                    </div>
                                    <div class="gameinfo">
                                        <h3>
                                            <%=playerBeans.get(0).getGameName()%>
                                        </h3>
                                        <p class="level">
                                            <span class="label label-default"> <%=playerBeans.get(0).getGameLeve()%></span>
                                        </p>
                                        <p class="acount">
                                            <span class="glyphicon glyphicon-bullhorn">&nbsp;<%=playerBeans.get(0).getOrderNum()%></span>
                                        </p>
                                    </div>
                                    <div class="order">
                                        <p class="price">
                                            <span><%=playerBeans.get(0).getMoney()%></span>&nbsp;/小时
                                        </p>
                                        <button type="button" class="btn btn-danger">下单约他</button>
                                    </div>
                                </li>
                                <li class="player-game introduce">
                                    <h3>介绍<span>/INTRODUCE</span></h3>
                                    <%
                                        List<String> strings = gameIntroduce.get(playerBeans.get(0).getGameName());
                                    %>
                                    <% for (int i = 0; i < strings.size(); i++) {

                                    %>
                                    <p><%=strings.get(i)%></p>
                                    <%
                                        }
                                    %>
                                    <%--<p>可盐可甜？可奶可狼？输出全靠吼</p>
                                    <p>提莫队长正在送命 杀人啦~~~~~</p>
                                    <p>可话痨可沉默 O(∩_∩)O</p>
                                    <p>可坑不可carry 嘻嘻嘻</p>
                                    <p> 可口可乐百事可乐加冰双倍快乐</p>--%>
                                </li>
                                <li class="player-game comment">
                                    <h3>评论<span>/COMMENT</span></h3>
                                    <h4 class="point">评分：<span>9.9</span></h4>
                                    <div class="usercommint">
                                        <ul class="nav navstack">
                                            <c:forEach items="${playerOrders}" var="order">
                                                <li class="comments"><span class="username">${order.staffName}：</span> ${order.appraise} <span
                                                        class="time">${order.endtime}</span></li>
                                            </c:forEach>
                                            <%--<li class="comments"><span class="username">阿飞：</span>技术流 <span
                                                    class="time">2019-04-23</span></li>--%>
                                        </ul>
                                    </div>
                                </li>
                            </ul>
                        </div>
                        <%--                        <c:forEach items=""--%>
                        <div role="tabpanel" class="tab-pane" id="game2">
                            <ul class="nav nav-stacked">
                                <li class="player-game top">
                                    <div class="gameicon">
                                        <img src="${pageContext.request.contextPath}/public/img/gameimg/<%=games.get(playerBeans.get(1).getGameName())%>" alt="">
                                    </div>
                                    <div class="gameinfo">
                                        <h3>
                                            <%=playerBeans.get(1).getGameName()%>
                                        </h3>
                                        <p class="level">
                                            <span class="label label-default"> <%=playerBeans.get(1).getGameLeve()%></span>
                                        </p>
                                        <p class="acount">
                                            <span class="glyphicon glyphicon-bullhorn">&nbsp;<%=playerBeans.get(1).getOrderNum()%></span>
                                        </p>
                                    </div>
                                    <div class="order">
                                        <p class="price">
                                            <span><%=playerBeans.get(1).getMoney()%></span>&nbsp;/小时
                                        </p>
                                        <button type="button" class="btn btn-danger">下单约他</button>
                                    </div>
                                </li>
                                <li class="player-game introduce">
                                    <h3>介绍<span>/INTRODUCE</span></h3>
                                    <%
                                        List<String> strings2 = gameIntroduce.get(playerBeans.get(1).getGameName());
                                    %>
                                    <% for (int i = 0; i < strings2.size(); i++) {

                                    %>
                                    <p><%=strings2.get(i)%></p>
                                    <%
                                        }
                                    %>
                                </li>
                                <li class="player-game comment">
                                    <h3>评论<span>/COMMENT</span></h3>
                                    <h4 class="point">评分：<span>9.9</span></h4>
                                    <div class="usercommint">
                                        <ul class="nav navstack">
                                            <%--                                            <li class="comments"><span class="username">阿龙：</span> 小姐姐超甜的 <span--%>
                                            <%--                                                    class="time">2019-02-18</span></li>--%>
                                            <c:forEach items="${playerOrders}" var="order">
                                                <li class="comments"><span class="username">${order.staffName}：</span> ${order.appraise} <span
                                                        class="time">${order.endtime}</span></li>
                                            </c:forEach>
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
        <div class="pic"><img src="${pageContext.request.contextPath}/public/img/bg/consume_new.jpg"></div>
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
