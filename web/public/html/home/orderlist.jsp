<%--
  Created by IntelliJ IDEA.
  User: Larimar
  Date: 2019/7/31
  Time: 19:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>我的订单</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/public/dist/css/bootstrap.css">
    <script src="${pageContext.request.contextPath}/public/dist/js/jquery-3.4.1.js"></script>
    <script src="${pageContext.request.contextPath}/public/dist/js/bootstrap.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/public/css/orderlist.css">
</head>
<style>
    h1 {
        padding-left: 50px;
        border-left: 16px solid #F86D5A;
    }

    .back {
        background-color: white;
        margin-left: 30px;
    }

    table {
        font-size: 20px;
    }

    .left {
        margin-left: -36px;
    }

    .ml {
        margin-left: 8px;
    }

</style>
<body class="back">
<h1>我的订单</h1>
<hr>
<ul class="nav nav-tabs" role="tablist">
    <li role="presentation" class="active">
        <a href="#home" aria-controls="home" role="tab" data-toggle="tab">全部订单</a>
    </li>
    <li role="presentation">
        <a href="#money" aria-controls="money" role="tab" data-toggle="tab">收入订单</a>
    </li>
    <li role="presentation">
        <a href="#tab" aria-controls="tab" role="tab" data-toggle="tab">我的订单</a>
    </li>
</ul>

<!-- Tab panes -->
<div class="tab-content">
    <div role="tabpanel" class="tab-pane active" id="home">
        <table class="table table-striped">
            <thead class="thead-light">
            <tr>
                <td>用户名</td>
                <td>用户</td>
                <td>开始时间</td>
                <td>结束时间</td>
                <td>价格</td>
                <td>备注</td>
                <td>操作</td>
            </tr>
            </thead>
            <tbody class="father">
            <c:forEach var="order" items="${playOrders}" varStatus="status">
                <tr>
                    <td>${order.playerName}</td>
                    <td>${order.staffName}</td>
                    <td>${order.starttime}</td>
                    <td>${order.endtime}</td>
                    <td>${order.price}</td>
                    <td>${order.remark}</td>
                    <td>
                        <div class="left">
                            <button name="${order.id}" type="button" class="btn btn-primary ml accept">接收</button>
                            <button name="${order.id}" type="button" class="btn btn-danger reject">拒绝</button>
                        </div>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div role="tabpanel" class="tab-pane" id="money">
        <table class="table table-striped">
            <thead class="thead-light">
            <tr>
                <td>用户名</td>
                <td>用户</td>
                <td>开始时间</td>
                <td>结束时间</td>
                <td>价格</td>
                <td>备注</td>
                <td>操作</td>
            </tr>
            </thead>
            <tbody class="father">
            <c:forEach var="order" items="${acceptPlayOrders}">
                <tr>
                    <td>${order.playerName}</td>
                    <td>${order.staffName}</td>
                    <td>${order.starttime}</td>
                    <td>${order.endtime}</td>
                    <td>${order.price}</td>
                    <td>${order.remark}</td>
                    <td>
                        <button name="${order.id}" type="button" class="btn btn-danger ml reject">删除</button>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div role="tabpanel" class="tab-pane" id="tab">
        <table class="table table-striped">
            <thead class="thead-light">
            <tr>
                <td>用户名</td>
                <td>用户</td>
                <td>开始时间</td>
                <td>结束时间</td>
                <td>价格</td>
                <td>备注</td>
                <td>操作</td>
            </tr>
            </thead>
            <tbody class="father">
            <c:forEach var="order" items="${userOrders}">
                <tr>
                    <td>${order.playerName}</td>
                    <td>${order.staffName}</td>
                    <td>${order.starttime}</td>
                    <td>${order.endtime}</td>
                    <td>${order.price}</td>
                    <td>${order.remark}</td>
                    <td>
                        <div class="left">
                            <button name="${order.id}" type="button" class="btn btn-primary ml" data-toggle="modal"
                                    data-target="#myModal">评论
                            </button>
                            <button name="${order.id}" type="button" class="btn btn-danger reject">删除</button>
                        </div>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</div>

<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                </button>
                <h4 class="modal-title" id="myModalLabel">
                    有什么相对陪玩说的，发表一下您的看法吧
                </h4>
            </div>
            <%--            //${pageContext.request.contextPath}/user_commentOrder--%>
            <div class="modal-body">
                <input id="orderNum" type="text" name="orderNum" hidden>
                <textarea id="comment" cols="70" rows="8" name="comment"></textarea>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                </button>
                <button type="submit" class="btn btn-primary submitComment">
                    提交评论
                </button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
</body>
<script>
    $(function () {
        $("#tab").find("button").click(function () {
            $("#orderNum").val($(this).attr("name"));
        })

        var that=this;

        //拒绝后执行的前后端代码
        $(".father").on("click",'.reject',function (){
            //ajax去后台sha删除
            //删除缓存发送数据
            console.log($(this).attr('name'));
            console.log("进行删除");
            var args = {
                "date": new Date(),
                "id":$(this).attr('name')
            }

            //前端删除
            $(this).closest("tr").remove();

            //发送请求
            var url = "${pageContext.request.contextPath}/rejectOrder.user";

            //post请求
            $.post(url, args);
        })

        <%--$(".reject").on("click",function () {--%>
        <%--      //ajax去后台sha删除--%>
        <%--      //删除缓存发送数据--%>
        <%--    console.log("进行删除");--%>
        <%--      var args = {--%>
        <%--          "date": new Date(),--%>
        <%--          "id": $(this).attr("name")--%>
        <%--      }--%>

        <%--      //前端删除--%>
        <%--      $(this).closest("tr").remove();--%>

        <%--      //发送请求--%>
        <%--      var url = "${pageContext.request.contextPath}/rejectOrder.user";--%>

        <%--      //post请求--%>
        <%--      $.post(url, args);--%>
        <%--  })--%>


        //接收后执行的前后端代码
        $("#home").find(".accept").click(function () {
            console.log($(this).attr("name"));
            //ajax去后台sha删除
            //删除缓存发送数据
            var args = {
                "date": new Date(),
                "id": $(this).attr("name")
            };
            //前端删除
            $(this).closest("tr").remove();
            //发送请求
            var url = "${pageContext.request.contextPath}/acceptOrder.user";

            //post请求
            $.post(url, args, function (data) {
                var str = "";
                let obj = data;
                if(obj.remark==null){
                    obj.remark="";
                }
                str += "<tr><td>" + obj.playerName + "</td><td>" + obj.staffName + "</td><td>" + obj.starttime + "</td><td>"
                    + obj.endtime + "</td><td>" + obj.price + "</td><td>" + obj.remark + "</td><td><button name='"+obj.id+"' type=\"button\" class=\"btn btn-danger ml reject\">删除</button></td></tr>";
                // });
                $("#money>table>tbody").append(str);
            }, "json");
        })


        $(".submitComment").click(function () {
            console.log($("#orderNum").val());
            console.log($("#comment").val());

            var args = {
                "date":new Date(),
                "id":$("#orderNum").val(),
                "comment":$("#comment").val()
            }

            var url = "${pageContext.request.contextPath}/CommentOrder.user";
            $.post(url, args);
            console.log("评论提交");
            $("#myModal").modal('hide');
        })
    })
</script>
</html>
