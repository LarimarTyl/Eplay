<%--
  Created by IntelliJ IDEA.
  User: Larimar
  Date: 2019/7/31
  Time: 19:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/public/dist/css/blacklist.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/public/dist/css/securitycenter.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/public/dist/css/bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/public/dist/css/bootstrap.css.map">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/public/css/index.css">
    <script src="${pageContext.request.contextPath}/public/dist/js/jquery-3.4.1.js"></script>
    <script src="${pageContext.request.contextPath}/public/dist/js/bootstrap.js"></script>
</head>
<body class="back">
<h1>安全中心      ${msg}</h1>
<hr>
<div class="user_name_box userInfo">
    <div class="info">
        <span>用户编号：</span>
    </div>
    <div class="info">
        <span>${user.staffNumber }</span>
    </div>
</div>
<div class="user_name_box userInfo">
    <div class="info">
        <span>登录密码：</span>
    </div>
    <div class="info">
        <span>********</span>
    </div>
    <div class="info1">
        <span><a href="#" data-toggle="modal" data-target="#modifyPwd" onclick="editUser()">修改</a></span>
    </div>
</div>
<div class="user_name_box userInfo">
    <div class="info">
        <span>手机号码：</span>
    </div>
    <div class="info">
        <span>${user.telephone }</span>
    </div>
    <div class="info1">
        <span><a href="#" data-toggle="modal" data-target="#modifyTelephone" onclick="editUser()">修改</a></span>
    </div>
</div>
<div class="user_name_box userInfo">
    <div class="info">
        <span>电子邮箱：</span>
    </div>
    <div class="info">
        <span>${user.telephone }</span>
    </div>
    <div class="info1">
        <span><a href="#" data-toggle="modal" data-target="#modifyEmail" onclick="editUser()">修改</a></span>
    </div>
</div>
<!-- 修改密码的模态框 -->
<div class="modal fade" id="modifyPwd" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="myModalLabel">
                    修改密码
                </h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" id="edit_user_Psw">
                    <input type="hidden"  name="id">
                    <div class="form-group">
                        <label for="old_loginPsw" class="col-sm-3 control-label">旧密码</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" id="old_loginPsw" placeholder="旧密码" name="loginPsw">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="new_loginPwd" class="col-sm-3 control-label">新密码</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" id="new_loginPwd" placeholder="新密码" name="newLoginPwd">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="new_loginPwdCheck" class="col-sm-3 control-label">验证新密码</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" id="new_loginPwdCheck" placeholder="验证新密码" name="loginPwdCheck">
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                </button>
                <button type="button" class="btn btn-primary" onclick="updateUserPsw()">确认修改</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
<!-- 修改电话号码 -->
<div class="modal fade" id="modifyTelephone" tabindex="-1" role="dialog" aria-labelledby="myModalLabe2" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="myModalLabe2">
                    修改电话号码
                </h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" id="edit_user_telephone">
                    <input type="hidden"  name="id">
                    <div class="form-group">
                        <label for="old_telephone" class="col-sm-2 control-label">旧电话</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" id="old_telephone" placeholder="旧电话" name="telephone">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="new_telephone" class="col-sm-2 control-label">新电话</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" id="new_telephone" placeholder="新电话" name="newTelephone">
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                </button>
                <button type="button" class="btn btn-primary" onclick="updateUserTelephone()">确认修改</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
<!-- 修改邮箱 -->
<div class="modal fade" id="modifyEmail" tabindex="-1" role="dialog" aria-labelledby="myModalLabe3" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="myModalLabe3">修改邮箱
                </h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" id="edit_user_Email">
                    <div class="form-group">
                        <input type="hidden"  name="id">
                        <label for="old_email" class="col-sm-2 control-label">旧邮箱</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" id="old_email" placeholder="旧邮箱" name="email">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="new_email" class="col-sm-2 control-label">新邮箱</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" id="new_email" placeholder="新邮箱" name="newEmail">
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                </button>
                <button type="button" class="btn btn-primary" onclick="updateUserEmail()">确认修改</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
<script>
    // 通过id获取修改的用户信息
    function editUser(id) {
        $.ajax({
            type:"get",
            url:"getuserById.action",
            data:{"id":id},
            success:function(data) {
                $("#edit_id").val(data.id);
                $("#edit_loginPwd").val(data.loginPwd);
                $("#edit_telephone").val(data.telephone);
                $("#edit_email").val(data.email);
            }
        });
    }
    // 执行修改用户操作
    function updateUserPsw() {
        $.post("updatePsw.action",
            $("#edit_user_Psw").serialize(),
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
    // 执行修改用户操作
    function updateUserTelephone() {
        $.post("updateTelephone.action",
            $("#edit_user_Telephone").serialize(),
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
    // 执行修改用户操作
    function updateUserEmail() {
        $.post("updateEmail.action",
            $("#edit_user_Email").serialize(),
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
</script>
</body>
</html>
