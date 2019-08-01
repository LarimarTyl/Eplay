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
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/public/dist/css/bootstrap.css">
    <script src="${pageContext.request.contextPath}/public/dist/js/jquery-3.4.1.js"></script>
    <script src="${pageContext.request.contextPath}/public/dist/js/bootstrap.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/public/css/message.css">
</head>
<body class="back">
<h1>我的消息</h1>
<hr>
<button class="button"><span class="glyphicon glyphicon-share-alt"></span><span>返回全部消息</span></button>
<div class="pbody">
    <h4 class="time">${content.getTime()}</h4>
    <p class="content">
        ${content.getMessage()}
    </p>
</div>
</body>
<script>
    $(function () {
        $("button").click(function () {
            window.location.href = "${pageContext.request.contextPath}/disPlaymessage.user";
        })
    })
</script>
</html>
