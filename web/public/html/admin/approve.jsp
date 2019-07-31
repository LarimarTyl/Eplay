<%--
  Created by IntelliJ IDEA.
  User: Larimar
  Date: 2019/7/31
  Time: 14:37
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>审核中心</title>
    <link rel="stylesheet" href="../../dist/css/bootstrap.css">
    <script src="../../dist/js/jquery-3.4.1.js"></script>
    <script src="../../dist/js/bootstrap.js"></script>
    <link rel="stylesheet" href="../../css/admin-item.css">
    <link rel="stylesheet" href="../../css/approve.css">
</head>
<body>
<h1>审核中心</h1>
<br>
<div class="panel panel-default">
    <!-- 搜索部分 -->
    <div class="panel-body">
        <form class="form-inline" method="get" action="">
            <div class="form-group">
                <label for="">申请成为主播用户名称</label>
                <input type="text" class="form-control" id="" value="" name="">
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
        <th>性别</th>
        <th>电话</th>
        <th>游戏名</th>
        <th>段位</th>
        <td>操作</td>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>1</td>
        <th>用户名</th>
        <th>性别</th>
        <th>电话</th>
        <th>游戏名</th>
        <th>段位</th>
        <td>
            <a href="#" class="btn btn-primary btn-xs" data-toggle="modal" data-target="#userEditDialog" onclick="agreeapprove()">同意</a>
            <a href="#" class="btn btn-danger btn-xs" onclick="disagreeapprove()">不同意</a>
        </td>
    </tr>
    <tr>
        <td>2</td>
        <th>用户名</th>
        <th>性别</th>
        <th>电话</th>
        <th>游戏名</th>
        <th>段位</th>
        <td><a href="#" class="btn btn-primary btn-xs" data-toggle="modal" data-target="#userEditDialog" onclick="agreeapprove()">同意</a>
            <a href="#" class="btn btn-danger btn-xs" onclick="disagreeapprove()">不同意</a>
        </td>
    </tr>
    <tr>
        <td>3</td>
        <th>用户名</th>
        <th>性别</th>
        <th>电话</th>
        <th>游戏名</th>
        <th>段位</th>
        <td><a href="#" class="btn btn-primary btn-xs" data-toggle="modal" data-target="#userEditDialog" onclick="agreeapprove()">同意</a>
            <a href="#" class="btn btn-danger btn-xs" onclick="disagreeapprove()">不同意</a>
        </td>
    </tr>
    <tr>
        <td>4</td>
        <th>用户名</th>
        <th>性别</th>
        <th>电话</th>
        <th>游戏名</th>
        <th>段位</th>
        <td><a href="#" class="btn btn-primary btn-xs" data-toggle="modal" data-target="#userEditDialog" onclick="agreeapprove()">同意</a>
            <a href="#" class="btn btn-danger btn-xs" onclick="disagreeapprove()">不同意</a>
        </td>
    </tr>
    <tr>
        <td>5</td>
        <th>用户名</th>
        <th>性别</th>
        <th>电话</th>
        <th>游戏名</th>
        <th>段位</th>
        <td><a href="#" class="btn btn-primary btn-xs" data-toggle="modal" data-target="#userEditDialog" onclick="agreeapprove()">同意</a>
            <a href="#" class="btn btn-danger btn-xs" onclick="disagreeapprove()">不同意</a>
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
<script type="text/javascript">
    // 同意成为陪玩人员
    function agreeapprove() {
        if(confirm('确实同意该用户成为陪玩人员吗?')) {
            $.post("approve/agree.action",
                $("#edit_approve_form").serialize(),
                function(data){
                    if(data =="OK"){
                        alert("同意成功！");
                        window.location.reload();
                    }else{
                        alert("同意失败！");
                        window.location.reload();
                    }
                });
        }
    }
    // 不同意成为陪玩人员
    function disagreeapprove(id) {
        if(confirm('确实不同意该用户成为陪玩人员吗?')) {
            $.post("approve/disagree.action",{"id":id},
                function(data){
                    if(data =="OK"){
                        alert("不同意成功！");
                        window.location.reload();
                    }else{
                        alert("不同意失败！");
                        window.location.reload();
                    }
                });
        }
    }
</script>
</body>
</html>
