<%--
  Created by IntelliJ IDEA.
  User: Larimar
  Date: 2019/7/31
  Time: 14:43
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>用户管理</title>
    <link rel="stylesheet" href="../../dist/css/bootstrap.css">
    <script src="../../dist/js/jquery-3.4.1.js"></script>
    <script src="../../dist/js/bootstrap.js"></script>
    <link rel="stylesheet" href="../../css/admin-item.css">
    <link rel="stylesheet" href="../../css/user.css">
</head>
<body>
<h1>用户管理</h1><br>
<div class="panel panel-default">
    <!-- 搜索部分 -->
    <div class="panel-body">
        <form class="form-inline" method="get" action="">
            <div class="form-group">
                <label for="">用户名称</label>
                <input type="text" class="form-control" id="" value="" name="loginName">
            </div>
            <div class="form-group">
                <label for="playgender">性别</label>
                <select class="form-control" id="playgender" name="gender">
                    <option value="男">男</option>
                    <option value="女">女</option>
                </select>
            </div>
            <div class="form-group">
                <label for="playRegisterStatus">用户的状态</label>
                <select class="form-control" id="playRegisterStatus" name="registerStatus">
                    <option value="0">未激活状态</option>
                    <option value="1">激活状态</option>
                </select>
            </div>
            <div class="form-group">
                <label for="playStatus">用户的身份</label>
                <select class="form-control" id="playStatus" name="tatus">
                    <option value="1">用户</option>
                    <option value="2">申请成为主播用户</option>
                    <option value="3">主播</option>
                    <option value="4">管理员</option>
                </select>
            </div>
            <button type="submit" class="btn btn-primary">查询</button>
        </form>
    </div>
</div>
<a href="#" class="btn btn-primary" data-toggle="modal" data-target="#newUserDialog" onclick="clearstudent()">新建</a>
<table class="table table-striped">
    <thead class="thead-light">
    <tr>
        <th>#</th>
        <th>用户名</th>
        <th>性别</th>
        <th>电话</th>
        <th>消费金额</th>
        <th>余额</th>
        <th>身份</th>
        <th>是否被激活</th>
        <td>操作</td>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>1</td>
        <th>用户名</th>
        <th>性别</th>
        <th>电话</th>
        <th>消费金额</th>
        <th>余额</th>
        <th>身份</th>
        <th>是否被激活</th>
        <td>
            <a href="#" class="btn btn-primary btn-xs" data-toggle="modal" data-target="#userEditDialog" onclick="edituser()">修改</a>
            <a href="#" class="btn btn-danger btn-xs" onclick="deleteuser()">删除</a>
        </td>
        </td>
    </tr>
    <tr>
        <td>2</td>
        <th>用户名</th>
        <th>性别</th>
        <th>电话</th>
        <th>消费金额</th>
        <th>余额</th>
        <th>身份</th>
        <th>是否被激活</th>
        <td><a href="#" class="btn btn-primary btn-xs" data-toggle="modal" data-target="#userEditDialog" onclick="edituser()">修改</a>
            <a href="#" class="btn btn-danger btn-xs" onclick="deleteuser()">删除</a>
        </td>
    </tr>
    <tr>
        <td>3</td>
        <th>用户名</th>
        <th>性别</th>
        <th>电话</th>
        <th>消费金额</th>
        <th>余额</th>
        <th>身份</th>
        <th>是否被激活</th>
        <td><a href="#" class="btn btn-primary btn-xs" data-toggle="modal" data-target="#userEditDialog" onclick="edituser()">修改</a>
            <a href="#" class="btn btn-danger btn-xs" onclick="deleteuser()">删除</a>
        </td>
    </tr>
    <tr>
        <td>4</td>
        <th>用户名</th>
        <th>性别</th>
        <th>电话</th>
        <th>消费金额</th>
        <th>余额</th>
        <th>身份</th>
        <th>是否被激活</th>
        <td><a href="#" class="btn btn-primary btn-xs" data-toggle="modal" data-target="#userEditDialog" onclick="edituser()">修改</a>
            <a href="#" class="btn btn-danger btn-xs" onclick="deleteuser()">删除</a>
        </td>
    </tr>
    <tr>
        <td>5</td>
        <th>用户名</th>
        <th>性别</th>
        <th>电话</th>
        <th>消费金额</th>
        <th>余额</th>
        <th>身份</th>
        <th>是否被激活</th>
        <td><a href="#" class="btn btn-primary btn-xs" data-toggle="modal" data-target="#userEditDialog" onclick="edituser()">修改</a>
            <a href="#" class="btn btn-danger btn-xs" onclick="deleteuser()">删除</a>
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
<!-- /.panel-body -->
</div>
<!-- 创建用户模态框 -->
<div class="modal fade" id="newUserDialog" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
                <h4 class="modal-title" id="myModalLabel">新建用户信息</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" id="new_user_form">
                    <div class="form-group">
                        <label for="new_loginName" class="col-sm-2 control-label">用户名</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="new_loginName" placeholder="用户名" name="loginName">
                        </div>
                        <label for="new_loginPwd" class="col-sm-2 control-label">密码</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="new_loginPwd" placeholder="密码" name="loginPwd">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="new_gender" class="col-sm-2 control-label">
                            性别</label>
                        <div class="col-sm-4">
                            <select class="form-control" id="new_gender" name="gender">
                                <option value="女">女</option>
                                <option value="男">男</option>
                            </select>
                        </div>
                        <label for="new_email" class="col-sm-2 control-label">Email</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="new_email" placeholder="用户名" name="email">
                        </div>

                    </div>

                    <div class="form-group">
                        <label for="new_telephone" class="col-sm-2 control-label">电话号码</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="new_telephone" placeholder="电话号码" name="telephone">
                        </div>
                        <label for="new_QQ" class="col-sm-2 control-label">QQ</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="new_QQ" placeholder="QQ号码" name="QQ">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="new_status" class="col-sm-2 control-label">身份</label>
                        <div class="col-sm-4">
                            <select class="form-control" id="new_status" name="status">
                                <option value="1">用户</option>
                                <option value="2">申请成为陪玩的用户</option>
                                <option value="3">陪玩人员</option>
                                <option value="0">管理员</option>
                            </select>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" onclick="createuser()">创建用户</button>
            </div>
        </div>
    </div>
</div>
<!-- 修改用户模态框 -->
<div class="modal fade" id="userEditDialog" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
                <h4 class="modal-title" id="myModalLabel">修改用户信息</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" id="edit_user_form">
                    <input type="hidden" id="edit_id" name="id">
                    <div class="form-group">
                        <label for="edit_userName" class="col-sm-2 control-label">用户名</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="edit_userName" placeholder="用户名" name="loginname">
                        </div>
                        <label for="edit_gender" class="col-sm-2 control-label">性别</label>
                        <div class="col-sm-4">
                            <select class="form-control" id="edit_gender" name="gender">
                                <option value="女">女</option>
                                <option value="男">男</option>
                            </select>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="edit_telephone" class="col-sm-2 control-label">电话号码</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="edit_telephone" placeholder="电话号码" name="telephone">
                        </div>
                        <label for="edit_QQ" class="col-sm-2 control-label">QQ</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="edit_QQ" placeholder="QQ号码" name="QQ">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="edit_status" class="col-sm-2 control-label">身份</label>
                        <div class="col-sm-5">
                            <select class="form-control" id="edit_status" name="status">
                                <option value="1">用户</option>
                                <option value="3">陪玩人员</option>
                                <option value="4">管理员</option>
                            </select>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" onclick="updateuser()">保存修改</button>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    //清空新建用户窗口中的数据
    function clearstudent() {
        $("#new_loginName").val("");
        $("#new_loginPwd").val("");
        $("#new_gender").val("");
        $("#new_telephone").val("");
        $("#new_QQ").val("");
        $("#new_status").val("");
    }
    // 创建用户
    function createuser() {
        $.post("user/create.action",
            $("#new_user_form").serialize(),
            function(data){
                if(data =="OK"){
                    alert("用户创建成功！");
                    window.location.reload();
                }else{
                    alert("用户创建失败！");
                    window.location.reload();
                }
            });
    }
    // 通过id获取修改的用户信息
    function edituser(id) {
        $.ajax({
            type:"get",
            url:"student/getuserById.action",
            data:{"id":id},
            success:function(data) {
                $("#edit_id").val(data.id);
                $("#edit_loginName").val(data.loginName);
                $("#edit_gender").val(data.gender);
                $("#edit_telephone").val(data.telephone);
                $("#edit_QQ").val(data.QQ);
                $("#edit_status").val(data.status);

            }
        });
    }
    // 执行修改用户操作
    function updateuser() {
        $.post("user/update.action",
            $("#edit_user_form").serialize(),
            function(data){
                if(data =="OK"){
                    alert("用户信息更新成功！");
                    window.location.reload();
                }else{
                    alert("用户信息更新失败！");
                    window.location.reload();
                }
            });
    }
    // 删除用户
    function deleteuser(id) {
        if(confirm('确实要删除该用户吗?')) {
            $.post("user/delete.action",{"id":id},
                function(data){
                    if(data =="OK"){
                        alert("用户删除成功！");
                        window.location.reload();
                    }else{
                        alert("删除用户失败！");
                        window.location.reload();
                    }
                });
        }
    }
</script>
</body>
</html>
