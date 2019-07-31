<%--
  Created by IntelliJ IDEA.
  User: Larimar
  Date: 2019/7/31
  Time: 19:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="../../dist/css/bootstrap.css">
    <script src="../../dist/js/jquery-3.4.1.js"></script>
    <script src="../../dist/js/bootstrap.js"></script>
    <link rel="stylesheet" href="../../css/entering.css">
    <script>
        $(function () {
            $(".head_title").click(function () {
                $("#photoPath").click();
            })
        })
    </script>
</head>
<body>
<div class="user_center" >
    <form method="post" enctype="multipart/form-data" >
        <div>
            <div class="head_samlling">
                <img src="../../img/user/ia_10047.jpg" id="ent_head_img" />
            </div>
            <div class="head_title">修改头像</div>
            <input type="file" id="photoPath" name="photoPath" style="display: none" />
        </div>
        <div class="mt10 care_text">支持jpg/gif/png格式的图片，文件必须小于3M</div>
        <div class="mt50 border_text_box">
            <div class="fl pb30 border_text">基本资料</div>
            <div class="fl remind ml35">标题标*为必填项，请务必填写真实资料</div>
        </div>
        <div class="mt30">
            <div class="fl mt10 mr50">
                <span class="star">*</span>用户名：
            </div>
            <input type="text" class="fl pl10 name_text"  name="staffName" />
        </div>
        <div class="mt30">
            <div class="fl mr70 ml158">
                <span class="star">*</span>性别：
            </div>
            <div class="mt20">
                <input type="radio" class=""  name="gender" value="nan" />&nbsp;&nbsp;男&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="radio" class=""  name="gender" value="nv"/>&nbsp;&nbsp;女
            </div>
        </div>
        <div>
            <div class="fl mr40 ml158">
                <span class="star">*</span>封面照片：
            </div>
            <input type="file" name="FMphotoPath" />
        </div>
        <div class="photo_look">
            <img />
        </div>
        <div class="mt50 border_text_box">
            <div class="fl pb30 border_text">开通服务</div>
            <div class="fl remind ml35">标题标*为必填项，请务必填写真实资料（个人最多申请开通四项服务）</div>
        </div>
        <div class="mt30">
            <div>
                <div class="fl mr40 ">
                    <span class="star">*</span>游戏及段位：
                </div>
                <select>
                    <option value="0">请选择游戏</option>
                    <option value="lol">英雄联盟</option>
                    <option value="wzry">王者荣耀</option>
                    <option value="cf">穿越火线</option>
                    <option value="swxf">守望先锋</option>
                </select>
                &nbsp;&nbsp;&nbsp;&nbsp;
                <select>
                    <option value="1">请选择段位</option>
                    <option value="hj">黄金及以下</option>
                    <option value="bj">铂金</option>
                    <option value="zs">钻石</option>
                    <option value="zs1">宗师及以上</option>
                </select>
            </div>
        </div>
        <div class="mt30_1">
            <div class="mt10 ml158">
                <span class="star">*</span>服务描述：
            </div>

            <textarea style="margin-left: 158px" cols="80" rows="10"></textarea>
        </div>
        <input type="submit" value="申请导师" class="sure_box1">

    </form>

</div>
</body>
</html>
