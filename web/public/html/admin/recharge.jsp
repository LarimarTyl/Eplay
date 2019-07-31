<%--
  Created by IntelliJ IDEA.
  User: Larimar
  Date: 2019/7/31
  Time: 14:42
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>充值管理</title>
    <link rel="stylesheet" href="../../dist/css/bootstrap.css">
    <script src="../../dist/js/jquery-3.4.1.js"></script>
    <script src="../../dist/js/bootstrap.js"></script>
    <link rel="stylesheet" href="../../css/admin-item.css">
    <link rel="stylesheet" href="../../css/recharge.css">
</head>
<body>
<h1>充值管理</h1>
<br>
<div class="panel panel-default">
    <!-- 搜索部分 -->
    <div class="panel-body">
        <form class="form-inline" method="get" action="">
            <div class="form-group">
                <label for="">用户名</label>
                <input type="text" class="form-control" id="" value="" name="">
            </div>
            <div class="form-group">
                <label for="playTime">时间</label>
                <input type="datetime-local" class="form-control" id="playTime" placeholder="充值时间" name="time">
            </div>
            <div class="form-group">
                <label for="playType">充值方式</label>
                <select class="form-control" id="playType" name="type">
                    <option value="1">支付宝</option>
                    <option value="2">微信</option>
                </select>
            </div>
            <button type="submit" class="btn btn-primary">查询</button>
        </form>
    </div>
</div>
<table class="table table-striped">
    <thead class="thead-light">
    <tr>
        <th>#</th>
        <th>用户名</th>
        <th>金额</th>
        <th>充值方式</th>
        <th>充值时间</th>
        <td>操作</td>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>1</td>
        <th>用户名</th>
        <th>金额</th>
        <th>充值方式</th>
        <th>充值时间</th>
        <td>
            <a href="#" class="btn btn-primary btn-xs" data-toggle="modal" data-target="#rechargeEditDialog" onclick="editrecharge(1)">修改</a>
            <a href="#" class="btn btn-danger btn-xs" onclick="deleterecherge(1)">删除</a>
        </td>
    </tr>
    <tr>
        <td>2</td>
        <th>用户名</th>
        <th>金额</th>
        <th>充值方式</th>
        <th>充值时间</th>
        <td><a href="#" class="btn btn-primary btn-xs" data-toggle="modal" data-target="#rechargeEditDialog" onclick="editrecharge(2)">修改</a>
            <a href="#" class="btn btn-danger btn-xs" onclick="deleterecherge(2)">删除</a>
    </tr>
    </tbody>
</table>

<!-- 修改充值模态框 -->
<div class="modal fade" id="rechargeEditDialog" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
                <h4 class="modal-title" id="myModalLabel">修改用户信息</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" id="edit_recharge_form">
                    <input type="hidden" id="edit_id" name="id">
                    <div class="form-group">
                        <label for="edit_userName" class="col-sm-2 control-label">用户名</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="edit_userName" placeholder="用户名" name="loginName">
                        </div>
                        <label for="edit_money" class="col-sm-2 control-label">金钱</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="edit_money" placeholder="金额" name="money">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="edit_type" class="col-sm-2 control-label">充值方式</label>
                        <div class="col-sm-4">
                            <select class="form-control" id="edit_type" name="type">
                                <option value="1">支付宝</option>
                                <option value="2">微信</option>
                            </select>
                        </div>
                        <label for="edit_time" class="col-sm-2 control-label">充值时间</label>
                        <div class="col-sm-4">
                            <input type="datetime-local" class="form-control" id="edit_time" placeholder="充钱时间" name="time">
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" onclick="updaterecharge()">保存修改</button>
            </div>
        </div>
    </div>
</div>
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
<script type="text/javascript">
    // 通过id获取修改的充值信息
    function editrecharge(id) {
        $.ajax({
            type:"get",
            url:"recharge/getrechargeById.action",
            data:{"id":id},
            success:function(data) {
                $("#edit_id").val(data.id);
                $("#edit_userName").val(data.lgoinName);
                $("#edit_money").val(data.money);
                $("#edit_type").val(data.type);
                $("#edit_time").val(data.time);


            }
        });
    }
    // 执行修改充值操作
    function updaterecharge() {
        $.post("recharge/update.action",
            $("#edit_recharge_form").serialize(),
            function(data){
                if(data =="OK"){
                    alert("充值信息更新成功！");
                    window.location.reload();
                }else{
                    alert("充值信息更新失败！");
                    window.location.reload();
                }
            });
    }
    // 删除充值信息
    function deleterecherge(id) {
        if(confirm('确实要删除该充值信息吗?')) {
            $.post("recharge/delete.action",{"id":id},
                function(data){
                    if(data =="OK"){
                        alert("删除成功！");
                        window.location.reload();
                    }else{
                        alert("删除失败！");
                        window.location.reload();
                    }
                });
        }
    }
</script>
</body>
</body>
</html>
