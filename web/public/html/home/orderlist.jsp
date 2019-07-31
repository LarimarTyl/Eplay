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
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>我的订单</title>
    <link rel="stylesheet" href="../../dist/css/bootstrap.css">
    <script src="../../dist/js/jquery-3.4.1.js"></script>
    <script src="../../dist/js/bootstrap.js"></script>
</head>
<link rel="stylesheet" href="../../css/orderlist.css">
<script src="../../dist/js/jquery-3.4.1.js"></script>
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

    #orderNum {
        display: none;
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
                <td>#</td>
                <td>用户名</td>
                <td>用户id</td>
                <td>时间</td>
                <td>价格</td>
                <td>备注</td>
                <td>操作</td>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>1</td>
                <td>用户名</td>
                <td>用户id</td>
                <td>时间</td>
                <td>价格</td>
                <td>备注</td>
                <td>
                    <div class="left">
                        <button type="button" class="btn btn-primary ml">接收</button>
                        <button type="button" class="btn btn-danger">拒绝</button>
                    </div>
                </td>
            </tr>
            <tr>
                <td>2</td>
                <td>用户名</td>
                <td>用户id</td>
                <td>时间</td>
                <td>价格</td>
                <td>备注</td>
                <td>
                    <div class="left">
                        <button type="button" class="btn btn-primary ml">接收</button>
                        <button type="button" class="btn btn-danger">拒绝</button>
                    </div>
                </td>
            </tr>
            </tbody>
        </table>
    </div>
    <div role="tabpanel" class="tab-pane" id="money">
        <table class="table table-striped">
            <thead class="thead-light">
            <tr>
                <td>#</td>
                <td>用户名</td>
                <td>用户id</td>
                <td>时间</td>
                <td>价格</td>
                <td>备注</td>
                <td>操作</td>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>1</td>
                <td>用户名</td>
                <td>用户id</td>
                <td>时间</td>
                <td>价格</td>
                <td>备注</td>
                <td>
                    <button type="button" class="btn btn-danger ml">删除</button>
                </td>
            </tr>
            <tr>
                <td>2</td>
                <td>用户名</td>
                <td>用户id</td>
                <td>时间</td>
                <td>价格</td>
                <td>备注</td>
                <td>
                    <button type="button" class="btn btn-danger ml">删除</button>
                </td>
            </tbody>
        </table>
    </div>
    <div role="tabpanel" class="tab-pane" id="tab">
        <table class="table table-striped">
            <thead class="thead-light">
            <tr>
                <td>#</td>
                <td>用户名</td>
                <td>用户id</td>
                <td>时间</td>
                <td>价格</td>
                <td>备注</td>
                <td>操作</td>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>1</td>
                <td>用户名</td>
                <td>用户id</td>
                <td>时间</td>
                <td>价格</td>
                <td>备注</td>
                <td>
                    <button id="1" type="button" class="btn btn-primary ml" data-toggle="modal" data-target="#myModal">
                        评论
                    </button>
                </td>
            </tr>
            <tr>
                <td>2</td>
                <td>用户名</td>
                <td>用户id</td>
                <td>时间</td>
                <td>价格</td>
                <td>备注</td>
                <td>
                    <button id="2" type="button" class="btn btn-primary ml" data-toggle="modal" data-target="#myModal">
                        评论
                    </button>
                </td>
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
            <form id="mform" action="">
                <div class="modal-body">
                    <input id="orderNum" type="text" name="orderNum">
                    <textarea cols="30" rows="6"></textarea>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                    </button>
                    <button type="submit" class="btn btn-primary">
                        提交评论
                    </button>
                </div>
            </form>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
</body>
<script>
    $(function () {
        $("#tab").find("button").click(function () {
            $("#orderNum").val($(this).attr("id"));
        })
    })
</script>
</html>
