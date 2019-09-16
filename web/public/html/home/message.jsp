<%--
  Created by IntelliJ IDEA.
  User: Larimar
  Date: 2019/7/31
  Time: 19:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/public/dist/css/bootstrap.css">
    <script src="${pageContext.request.contextPath}/public/dist/js/jquery-3.4.1.js"></script>
    <script src="${pageContext.request.contextPath}/public/dist/js/bootstrap.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/public/css/message.css">
    <script>
        $(function () {
            var i=${noread};
            if(i==0){
                $(".reader").eq(0).hide();
                $(".second").css("backgroundColor","#ed5565");
            }else {
                $(".reader").css("backgroundColor","#ed5565");
            }
        })
    </script>
</head>
<body class="back">
<h1>我的消息 <span class="reader">
         <c:if test="${noread!=0}" var="flag" scope="session">
             ${noread}
         </c:if>
</span></h1>
<hr>
<table border="1" cellspacing="0" rules="rows" frame="void" width="100%">
    <c:forEach var="message" items="${messages}" varStatus="status">
        <tr class="message icon">
            <td width="2%" class="mycheck"><input type="checkbox" value="1" id="checkbox${status.index}"
                                                  name=""
                                                  class="hook"
                                                  onclick="">
                <label for="checkbox${status.index}" class="one"></label>
            </td>
            <td class="hideid">${message.getId()}</td>
            <td width="12%" class="noReader"><span class="reader second">
                       <c:if test="${message.getStatus()==0}" var="flag" scope="session">
                           未读
                       </c:if>
                     <c:if test="${not flag}" var="flag" scope="session">
                         已读
                     </c:if>
        </span></td>
            <td width="16%" class="way"><span name="1">
            <c:if test="${message.getType()==0}" var="flag" scope="session">
                [系统消息]
            </c:if>
        </span></td>
            <td width="50%">${fn:substring(message.getMessage(),0 ,10)}</td>
            <td width="20%">${message.getTime()}</td>
        </tr>
    </c:forEach>
    <tfoot>
    <tr>
        <td colspan="3" width="30%" class="mycheck"><input type="checkbox" value="1" id="checkboxlast" name=""
                                                           class="">
            <label for="checkboxlast" class="one" id="All"></label><span class="last">全部</span>
            <button id="delete">删除</button>
        </td>
    </tr>
    </tfoot>
</table>
<script>
    $(function () {
        if ($(".message").length == 0) {
            $("tfoot").hide();
        }

        $(".message").mouseover(function () {
            console.log("666");
            $(this).css("backgroundColor", "#fafafa");
        })
        $(".message").mouseout(function () {
            $(this).css("backgroundColor", "white");
        })


        $(".icon>.mycheck").siblings().click(function () {
            window.location.href = "${pageContext.request.contextPath}/messageContent.user?messageId=" + $(this).siblings(".hideid").text();
        })

        // //未读标志和未读数量
        // $(".icon").find(".mycheck").siblings().click(function () {
        //     // console.log($(this).hasClass("noReader"));
        //     if ($(this).hasClass("noReader")) {
        //         if ($(this).find(".second").css("display") == "inline") {
        //             $(this).find(".second").hide();
        //             var i = parseInt($(".reader").eq(0).text());
        //             if (i > 1) {
        //                 $(".reader").eq(0).text(i - 1);
        //             } else {
        //                 $(".reader").eq(0).hide();
        //             }
        //         }
        //     } else {
        //         console.log($(this).siblings(".noReader"));
        //         if ($(this).siblings(".noReader").find(".second").css("display") == "inline") {
        //             $(this).siblings(".noReader").find(".second").hide();
        //             var i = parseInt($(".reader").eq(0).text());
        //             if (i > 1) {
        //                 $(".reader").eq(0).text(i - 1);
        //             } else {
        //                 $(".reader").eq(0).hide();
        //             }
        //         }
        //     }
        // })

//全选
        $("#All").click(function () {
            if ($("#All").prev("#checkboxlast").prop("checked")) {
                console.log("取消全选");
                $(".hook").prop("checked", false);
            } else {
                console.log("全选");
                $(".hook").prop("checked", true);
            }
        })

        //删除选中的信息
        $("#delete").click(function () {
            $(".hook").each(function () {
                if ($(this).prop("checked")) {
                    //ajax真正去数据库删除消息
                    //设置参数
                    var args={
                        "Date":new Date(),
                        "id":$(this).parent().next(".hideid").text()
                    }

                    //设置url
                    var url="${pageContext.request.contextPath}/deleteMessage.user";

                    //post方法
                    $.post(url,args);

                    $(this).parents(".message").remove();

                    var i = parseInt($(".reader").eq(0).text());
                    if (i > 1) {
                        $(".reader").eq(0).text(i - 1);
                    } else {
                        $(".reader").eq(0).hide();
                    }
                }
            })
            if ($(".message").length == 0) {
                $("tfoot").hide();
                $(".reader").eq(0).hide();
            }
        })

    })
</script>
</body>
</html>
