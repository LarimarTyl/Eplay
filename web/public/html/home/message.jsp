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
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link rel="stylesheet" href="../../dist/css/bootstrap.css">
    <script src="../../dist/js/jquery-3.4.1.js"></script>
    <script src="../../dist/js/bootstrap.js"></script>
    <link rel="stylesheet" href="../../css/message.css">
</head>
<body class="back">
<h1>我的消息 <span class="reader">2</span></h1>
<hr>
<table border="1" cellspacing="0" rules="rows" frame="void" width="100%">
    <tr class="message icon">
        <td width="2%" class="mycheck"><input type="checkbox" value="1" id="checkbox1"
                                              name=""
                                              class="hook"
                                              onclick="">
            <label for="checkbox1" class="one"></label>
        </td>
        <td class="hideid">1</td>
        <td width="12%" class="noReader"><span class="reader second">未读</span></td>
        <td width="16%" class="way"><span name="1">[系统消息]</span></span></td>
        <td width="50%">eplay的小姐姐小哥哥都在等着你们哦~</td>
        <td width="20%">2019-7-19</td>
    </tr>
    <tr class="message icon">
        <td width="4%" class="mycheck"><input type="checkbox" value="1" id="checkbox2"
                                              name=""
                                              class="hook"
                                              onclick="">
            <label for="checkbox2" class="one"></label>
        </td>
        <td class="hideid">2</td>
        <td width="10%" class="noReader"><span class="reader second">未读</span></td>
        <td width="16%" class="way"><span name="2">[系统消息]</span></td>
        <td width="50%">杰普发来战帖，叫你们最厉害的上场</td>
        <td width="20%">2019-7-18</td>
    </tr>
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
            $(this).css("backgroundColor", "#fafafa");
        })
        $(".message").mouseout(function () {
            $(this).css("backgroundColor", "white");
        })


        $(".icon>.mycheck").siblings().click(function () {
            // alert($(this).siblings(".hideid").text());
            window.location.href = "messagedisplay.html";
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
                    $(this).parents(".message").remove();
                    // alert($(this).parent().next(".hideid").text()); //ajax去数据库真正删除数据
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
