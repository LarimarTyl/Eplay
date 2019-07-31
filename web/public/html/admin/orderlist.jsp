<%--
  Created by IntelliJ IDEA.
  User: Larimar
  Date: 2019/7/31
  Time: 14:40
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>订单管理</title>
    <link rel="stylesheet" href="../../dist/css/bootstrap.css">
    <script src="../../dist/js/jquery-3.4.1.js"></script>
    <script src="../../dist/js/bootstrap.js"></script>
    <link rel="stylesheet" href="../../css/admin-item.css">
    <link rel="stylesheet" href="../../css/orderlist.css">
</head>
<body>
<h1>订单管理</h1><br>

<div class="panel panel-default">
    <!-- 搜索部分 -->
    <div class="panel-body">
        <form class="form-inline" method="get" action="">
            <div class="form-group">
                <label for="">订单号</label>
                <input type="text" class="form-control" id="" value="" name="">
            </div>
            <button type="submit" class="btn btn-primary">查询</button>
        </form>
    </div>
</div>
<table class="table table-striped">
    <thead class="thead-light">
    <tr>
        <th>订单号</th>
        <th>主播名</th>
        <th>用户名</th>
        <th>游戏</th>
        <th>金额</th>
        <th>用户评价</th>
        <td>操作</td>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>1</td>
        <th>主播名</th>
        <th>用户名</th>
        <th>游戏</th>
        <th>金额</th>
        <th>用户评价</th>
        <td>
            <a href="#" class="btn btn-primary btn-xs" data-toggle="modal" data-target="#orderlistEditDialog" onclick="editorderlist(1)">修改</a>
            <a href="#" class="btn btn-danger btn-xs" onclick="deleteorderlist(1)">删除</a>
        </td>
    </tr>
    <tr>
        <td>2</td>
        <th>主播名</th>
        <th>用户名</th>
        <th>游戏</th>
        <th>金额</th>
        <th>用户评价</th>
        <td><a href="#" class="btn btn-primary btn-xs" data-toggle="modal" data-target="#orderlistEditDialog" onclick="editorderlist(1)">修改</a>
            <a href="#" class="btn btn-danger btn-xs" onclick="deleteorderlist(1)">删除</a>
        </td>
    </tr>
    </tbody>
</table>
<div class="col-md-12 text-right">
    <nav>
        <ul class="pagination">
            <li ><a href="#">首页 </a></li>
            <li ><a href="#">上一页 </a></li>
            <li><a href="#">1</a></li>
            <li ><a href="#">下一页</a></li>
            <li ><a href="#">尾页</a></li>
        </ul>
    </nav>
</div>
<!-- 修改用户模态框 -->
<div class="modal fade" id="orderlistEditDialog" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
                <h4 class="modal-title" id="myModalLabel">修改用户信息</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" id="edit_orderlist_form">
                    <input type="hidden" id="edit_id" name="id">
                    <div class="form-group">
                        <label for="edit_playerName" class="col-sm-2 control-label">主播名</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="edit_playerName" placeholder="主播名" name="playername">
                        </div>
                        <label for="edit_username" class="col-sm-2 control-label">用户名</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="edit_username" placeholder="用户名" name="username">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="edit_gamename" class="col-sm-2 control-label">游戏名</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="edit_gamename" placeholder="游戏名" name="gamename">
                        </div>
                        <label for="edit_price" class="col-sm-2 control-label">价格</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="edit_price" placeholder="价格" name="price">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="edit_appraise" class="col-sm-2 control-label">用户评价</label>
                        <div class="col-sm-5">
                            <input type="text" class="form-control" id="edit_appraise" placeholder="用户评价" name="price">
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" onclick="updateorderlist()">保存修改</button>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    // 通过id获取修改的订单信息
    function editorderlist(id) {
        $.ajax({
            type:"get",
            url:"orderlist/getorderlistById.action",
            data:{"id":id},
            success:function(data) {
                $("#edit_id").val(data.id);
                $("#edit_playername").val(data.playername);
                $("#edit_username").val(data.uesrname);
                $("#edit_gamename").val(data.gamename);
                $("#edit_price").val(data.price);
                $("#edit_appraise").val(data.appraise);

            }
        });
    }
    // 执行修改订单操作
    function updateorderlist() {
        $.post("orderlist/update.action",
            $("#edit_user_form").serialize(),
            function(data){
                if(data =="OK"){
                    alert("订单信息更新成功！");
                    window.location.reload();
                }else{
                    alert("订单信息更新失败！");
                    window.location.reload();
                }
            });
    }
    // 删除订单
    function deleteorderlist(id) {
        if(confirm('确实要删除该订单吗?')) {
            $.post("orderlist/delete.action",{"id":id},
                function(data){
                    if(data =="OK"){
                        alert("订单删除成功！");
                        window.location.reload();
                    }else{
                        alert("删除订单失败！");
                        window.location.reload();
                    }
                });
        }
    }
</script>
</body>
</html>
