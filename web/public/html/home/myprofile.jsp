<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/public/dist/css/blacklist.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/public/dist/css/myprofile.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/public/dist/css/bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/public/dist/css/bootstrap.css.map">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/public/css/index.css">
    <script src="${pageContext.request.contextPath}/public/dist/js/jquery-3.4.1.js"></script>
    <script src="${pageContext.request.contextPath}/public/dist/js/bootstrap.js"></script>
    <script>
        function YYYYMMDDstart()
        {
            MonHead = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];

            //先给年下拉框赋内容
            var y  = new Date().getFullYear();
            for (var i = (y-30); i < (y+10); i++) //以今年为准，前30年，后30年
                document.myprofile_form.YYYY.options.add(new Option(" "+ i +" 年", i));

            //赋月份的下拉框
            for (var i = 1; i < 13; i++)
                document.myprofile_form.MM.options.add(new Option(" " + i + " 月", i));

            document.myprofile_form.YYYY.value = y;
            document.myprofile_form.MM.value = new Date().getMonth() + 1;
            var n = MonHead[new Date().getMonth()];
            if (new Date().getMonth() ==1 && IsPinYear(YYYYvalue)) n++;
            writeDay(n); //赋日期下拉框Author:meizz
            document.myprofile_form.DD.value = new Date().getDate();
        }
        if(document.attachEvent)
            window.attachEvent("onload", YYYYMMDDstart);
        else
            window.addEventListener('load', YYYYMMDDstart, false);
        function YYYYDD(str) //年发生变化时日期发生变化(主要是判断闰平年)
        {
            var MMvalue = document.myprofile_form.MM.options[document.myprofile_form.MM.selectedIndex].value;
            if (MMvalue == ""){ var e = document.myprofile_form.DD; optionsClear(e); return;}
            var n = MonHead[MMvalue - 1];
            if (MMvalue ==2 && IsPinYear(str)) n++;
            writeDay(n)
        }
        function MMDD(str)   //月发生变化时日期联动
        {
            var YYYYvalue = document.myprofile_form.YYYY.options[document.myprofile_form.YYYY.selectedIndex].value;
            if (YYYYvalue == ""){ var e = document.myprofile_form.DD; optionsClear(e); return;}
            var n = MonHead[str - 1];
            if (str ==2 && IsPinYear(YYYYvalue)) n++;
            writeDay(n)
        }
        function writeDay(n)   //据条件写日期的下拉框
        {
            var e = document.myprofile_form.DD; optionsClear(e);
            for (var i=1; i<(n+1); i++)
                e.options.add(new Option(" "+ i + " 日", i));
        }
        function IsPinYear(year)//判断是否闰平年
        {     return(0 == year%4 && (year%100 !=0 || year%400 == 0));}
        function optionsClear(e)
        {
            e.options.length = 1;
        }
    </script>
</head>
<body class="back">
<%
    String msg1="";
    user user=(user) session.getAttribute("user");
    String msg=(String) request.getAttribute("msg");
    if (msg!=null){
        msg1=msg;
    }
%>
<h1>个人资料           ${msg1 }</h1>
<hr>
<div class="head_portrait_box">
    <div class="head_portrait">
        <img src="${pageContext.request.contextPath}/img/user/ia_10047.jpg">
    </div>
    <ul class="portrait_text">
        <li class="portrait_btn">上传头像</li>
        <li>支持jpg、gif、png、或bmp格式的图片，文件必须小于1M</li>
    </ul>
</div>
<div class="gameID_all" >

    <form action="modifyInfo.user" method="get" name="myprofile_form">
        <div class="game_ID">
            用户编号：<input type="text" name="staffNumber" value="${user.StaffNumber}111" readonly="readonly"/></div>
        <div class="game_ID">
            用&nbsp;户&nbsp;名&nbsp;：<input type="text" name="staffName"  value="${user.StaffName }111"></div>
        <div class="game_ID">
            生&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;日&nbsp;：
            <select name="YYYY" onchange="YYYYDD(this.value)">
                <option value="">请选择 年</option>
            </select>
            <select name="MM" onchange="MMDD(this.value)">
                <option value="">选择 月</option>
            </select>
            <select name="DD">
                <option value="">选择 日</option>
            </select>
        </div>

        <div class="game_ID">
            性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别&nbsp;：
            <select name="gender" class="sex">
                <option value="男">男</option>
                <option value="女">女</option>
            </select></div>
        <div class="game_ID">
            邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;箱&nbsp;：<input type="email" name="email" value="${user.email}111"></div>
        <div class="game_ID">
            电&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;话&nbsp;：<input type="text" name="telephone" value="${user.Telephone }111" ></div>
        <div class="game_ID">
            QQ&nbsp;&nbsp;&nbsp;&nbsp;号&nbsp;：<input type="text" name="QQ" value="${user.QQ }111" ></div>
        <div class="submit_box">
            <input type="submit" value="提交修改">
        </div>
    </form>
</div>
</body>
</html>