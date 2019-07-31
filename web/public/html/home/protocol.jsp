<%--
  Created by IntelliJ IDEA.
  User: Larimar
  Date: 2019/7/31
  Time: 19:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Title</title>
    <link rel="stylesheet" href="../../dist/css/bootstrap.css">
    <script src="../../dist/js/jquery-3.4.1.js"></script>
    <script src="../../dist/js/bootstrap.js"></script>
    <link rel="stylesheet" href="../../css/protocol.css">
    <script>
        function agree(){
            if(document.getElementById('control_che').checked){
                document.getElementById('button_xia').disabled=false;
                document.getElementById('button_xia').style.backgroundColor="red";
            } else{
                document.getElementById('button_xia').disabled='disabled';
                document.getElementById('button_xia').style.backgroundColor="#afb0b3";
            }
        }
    </script>
</head>
<body>
<div class="content_center">
    <div class="content_center_01">
        <div class="content_bigtitle">
            “Eplay”陪玩申请协议
        </div>
        <p class="content_text">
            本《陪玩申请协议》是您（下称"用户"）与深圳易玩在线科技有限公司（下称"易玩"）之间在申请成为易玩旗下Eplay开黑平台（下称"Eplay开黑"）陪玩人员（下称"陪陪"）时签署的协议。
        </p>
        <div class="content_title">
            1、重要须知---在签署本协议之前，易玩正式提醒用户：
        </div>
        <p class="content_text">
            1.1、您应认真阅读（未成年人应当在监护人陪同下阅读）、充分理解本《陪玩申请协议》中各条款，包括免除或者限制兔玩责任的免责条款及对用户的权利限制条款。
        </p>
        <p class="content_text">
            1.2、除非您接受本协议，否则用户无权也无必要继续接受易玩的服务，可以退出本次注册。用户点击接受并继续使用易玩的服务，视为用户已完全的接受本协议。
        </p>
        <p class="content_text">
            1.3、本协议一经签署，具有法律效力，请您慎重考虑是否接受本协议。
        </p>
        <p class="content_text">
            1.4、在您签署本协议之后，此文本可能因国家政策、产品以及履行本协议的环境发生变化而进行修改，修改后的协议发布在本网站上，若您对修改后的协议有异议的，请立即停止登录、使用易玩产品及服务，若您登录或继续使用易玩产品，视为对修改后的协议予以认可。
        </p>
        <div class="content_title">
            2、关于“Eplay开黑帐号”
        </div>
        <p class="content_text">
            2.1、兔玩旗下业务平台兔玩网（tuwan.com）、点点开黑（y.tuwan.com）以及英雄训练营（t.tuwan.com）上同时提供用户注册通道，用户在任一通道注册获得点点开黑帐号。
        </p>
        <p class="content_text">
            2.2、用户在首次注册点点开黑账户成功之后，兔玩会按系统规则自动分配给用户一个UID号码，UID号码与点点开黑账号一样是用户接受点点开黑服务的身份识别凭证。
        </p>
        <p class="content_text">
            2.3、点点开黑账号以及UID号码的性质上是兔玩提供服务授予用户的凭证，点点开黑账号和UID号码是兔玩相应计算机软件作品的一部分，即兔玩将相关产品计算机软件著作权授权给注册用户的授权凭证。
        </p>
        <p class="content_text">
            2.4、点点开黑账号还是用户持有、使用相关虚拟财产、道具的身份凭证。用户若需要接受兔玩提供的增值服务，点点开黑账号同时也是用户支付费用、接受增值服务的凭证。
        </p>
        <p class="content_text">
            2.5、用户应当妥善保管自己的点点开黑账号、密码，用户就其账号及密码项下之一切活动负全部责任，包括用户数据的修改，虚拟道具的损失以及其他所有的损失由用户自行承担。用户如发现他人未经许可使用其账号时立即通知兔玩。
        </p>
        <p class="content_text">
            2.6、用户点点开黑账号在丢失或遗忘密码后，可通过手机验证码的方式找回，如果未绑定手机号，需联系兔玩客服进行申诉找回帐号。用户应不断提供能增加账号安全性的个人密码保护资料。对用户因被他人冒名申诉而致的任何损失，兔玩不承担任何责任。
        </p>
        <p class="content_text">
            2.7、用户保证注册点点开黑账号时填写的身份信息是真实的，任何非法、不真实、不准确的用户信息所产生的责任由用户承担。如果因用户的注册信息不真实而引起的问题，以及对问题发生所带来的后果，兔玩不负任何责任。
        </p>
        <p class="content_text">
            2.8、如用户违反法律法规、兔玩各服务协议或点点开黑陪玩守则等规定，兔玩有权根据相关规则进行违规判定，并采取相应限制或处罚措施，包括但不限于：限制或冻结用户对点点开黑帐号的使用，限制或停止某项单独服务（如线上LOL陪玩），扣除保证金，扣减收入分成并根据实际情况决定是否恢复使用。
        </p>
    </div>
    <div class="protocol_box">
        <div class="switch">
            <input type="checkbox" id="control_che" class="control_checkbox" onclick="agree()" >
        </div>
        <div class="agree">我已阅读并同意此协议</div>
        <div class="point_out">温馨提示：阅读整个协议，才能进行下一步。</div>
    </div>
    <div class="botton_box" style="text-align: center" >
        <a href="entering.jsp"><input type="button" value="下一步&nbsp;&nbsp;&nbsp;>" id="button_xia" disabled="disabled" class="botton_box1" /></a>
    </div>

</div>
</body>
</html>
