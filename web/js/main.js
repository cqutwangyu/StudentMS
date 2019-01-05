"use strict";
window.onload = function () {
    load();
    selectUp();
}
function closeDialog() {
    //隐藏对话框
    $(".el-dialog__wrapper").hide()
    $(".v-modal").hide()
    //清空输入框
    $("#sno").val(''),
    $("#sname").val(''),
    $("#sdatebirth").val(''),
    $("#ssex").val(''),
    $("#snativeplace").val(''),
    $("#shouseaddress").val(''),
    $("#snation").val('')
}
function selectUp() {

    var i //下拉框的箭头
    var div //下拉框的input的父元素
    var input = $('#search') //下拉框的input
    var dropdown = $(".el-select-dropdown") //下拉框内容的body
    var s = $(".el-select") //下拉框的body
    $("#select-dropdown").click(function () {
        var t = $(this);
        i = t.children('.el-input__suffix').children('.el-input__suffix-inner').children('.el-icon-arrow-up')
        div = i.parent().parent().parent(".el-input")
        // display: none; min-width: 90px; transform-origin: center top 0px; z-index: 2123; position: absolute; top: 65px; left: 28px;"
        // 根据el-select的长宽以及坐标设置下拉框出现的位置
        dropdown.css({
            "min-width": parseInt(s.css("width")) + 'px',
            "top": parseInt(s.css("top")) + s.offset().top + s.height() + 'px',
            "left": parseInt(s.css("left")) + s.offset().left + 'px'
        })

        if (i.hasClass('is-reverse') == false) {
            i.addClass('is-reverse')
            div.addClass('is-focus')
            dropdown.slideDown("slow");
        } else {
            i.removeClass('is-reverse')
            div.removeClass('is-focus')
            dropdown.slideUp("slow");
        }
    });

    $(".el-select-dropdown__list li").click(function () {
        var index = $(this).index()
        $(this).siblings('li').removeClass('selected');
        $(this).addClass('selected')
        $(".el-input--suffix").children(".el-input__inner").val($(this).text())
        i.removeClass('is-reverse')
        div.removeClass('is-focus')
        dropdown.slideUp("slow")
        input.attr('key', $(this).attr('key'))
        if(input.attr('key')=='sdatebirth'){
            $("#search_text").attr("type","date")
        }
    })
    $(".el-select-dropdown__list li").hover(function () {
        $(this).siblings('li').removeClass('hover')
        $(this).addClass('hover')
    })
}
function addStudent() {
    if ($(".el-dialog__wrapper").css("display") == "none") {
        $(".el-dialog__title").text("添加")
        $("#dialog_yes").attr("onclick", "addStudent()")
        $(".el-dialog__wrapper").show()
        $(".v-modal").show()
        return
    }
    $.ajax({
        url: 'StudentServlet', //要请求的url地址
        type: 'POST', //请求方法 GET or POST
        async: true, //是否使用异步请求的方式
        timeout: 5000, //请求超时的时间，以毫秒计
        data: {
            method: 'addStudent',
            sno: $("#sno").val(),
            sname: $("#sname").val(),
            sdatebirth: $("#sdatebirth").val(),
            ssex: $("#ssex").val(),
            snativeplace: $("#snativeplace").val(),
            shouseaddress: $("#shouseaddress").val(),
            snation: $("#snation").val()
        }, //参数，用POST方法时使用，如果用GET方法则直接在url后拼接参数即可
        // dataType:'json', //预期的服务器返回参数类型，如果不是预期类型则会认为请求失败执行error
        beforeSend: function () {

        },//再发送请求前调用的方法
        success: function (msg) {
            if(msg=="添加成功"){
                closeDialog()
            }
            alert(msg)
            clarJsonTable()
            load()
        }, //请求成功时回调方法，data为服务器返回的数据
        error: function () {
            alert("添加失败！")

        }, //请求发生错误时调用方法
        complete: function () {

        } //回调方法 无论success或者error都会执行
    });
}

function deleteStudent(redSno) {
    $.ajax({
        url: 'StudentServlet', //要请求的url地址
        type: 'POST', //请求方法 GET or POST
        async: true, //是否使用异步请求的方式
        timeout: 5000, //请求超时的时间，以毫秒计
        data: {
            method: 'deleteStudent',
            sno: redSno
        }, //参数，用POST方法时使用，如果用GET方法则直接在url后拼接参数即可
        beforeSend: function () {

        },//再发送请求前调用的方法
        success: function (msg) {
            alert(msg)
            clarJsonTable()
            load()
        }, //请求成功时回调方法，data为服务器返回的数据
        error: function () {
            alert("删除失败！")

        }, //请求发生错误时调用方法
        complete: function () {

        } //回调方法 无论success或者error都会执行
    });
}

function updateStudent(redSno) {
    if ($(".el-dialog__wrapper").css("display") == "none") {
        $(".el-dialog__title").text("编辑")
        $("#dialog_yes").attr("onclick", "updateStudent("+redSno+")")
        $(".el-dialog__wrapper").show()
        $(".v-modal").show()
        var row_spans=$("#"+redSno).find("span")
        $("#sno").val(row_spans.eq(0).text()),
        $("#sname").val(row_spans.eq(1).text()),
        $("#sdatebirth").val(row_spans.eq(2).text()),
        $("#ssex").val(row_spans.eq(3).text()),
        $("#snativeplace").val(row_spans.eq(4).text()),
        $("#shouseaddress").val(row_spans.eq(5).text()),
        $("#snation").val(row_spans.eq(6).text())
        return
    }
    $.ajax({
        url: 'StudentServlet', //要请求的url地址
        type: 'POST', //请求方法 GET or POST
        async: true, //是否使用异步请求的方式
        timeout: 5000, //请求超时的时间，以毫秒计
        data: {
            method: 'updateStudent',
            sno_old: redSno,
            sno: $("#sno").val(),
            sname: $("#sname").val(),
            sdatebirth: $("#sdatebirth").val(),
            ssex: $("#ssex").val(),
            snativeplace: $("#snativeplace").val(),
            shouseaddress: $("#shouseaddress").val(),
            snation: $("#snation").val()
        }, //参数，用POST方法时使用，如果用GET方法则直接在url后拼接参数即可
        beforeSend: function () {

        },//再发送请求前调用的方法
        success: function (msg) {
            if(msg=="修改成功"){
                closeDialog()
            }
            alert(msg)
            clarJsonTable()
            load()
            // $(".editForm").css("display", "none")
        }, //请求成功时回调方法，data为服务器返回的数据
        error: function () {
            alert("修改失败")

        }, //请求发生错误时调用方法
        complete: function () {

        } //回调方法 无论success或者error都会执行
    });
}

function searchStudent() {
    $.ajax({
        url: 'StudentServlet', //要请求的url地址
        type: 'POST', //请求方法 GET or POST
        async: true, //是否使用异步请求的方式
        timeout: 5000, //请求超时的时间，以毫秒计
        data: {
            method: "qureyStudent",
            key: $('#search').attr('key'),
            value: $('#search_text').val()
        }, //参数，用POST方法时使用，如果用GET方法则直接在url后拼接参数即可
        dataType: 'json', //预期的服务器返回参数类型
        beforeSend: function () {

        },//再发送请求前调用的方法
        success: function (json) {
            if (json.length > 0) {
                clarJsonTable()
                showStudent(json)
            }
        }, //请求成功时回调方法，data为服务器返回的数据
        error: function (msg) {
            alert(msg.responseText)
        }, //请求发生错误时调用方法
        complete: function () {

        } //回调方法 无论success或者error都会执行
    });

}

function queryStudent(e) {
    $(".editForm").css("display", "inline")
    $.ajax({
        url: 'StudentServlet', //要请求的url地址
        type: 'POST', //请求方法 GET or POST
        async: true, //是否使用异步请求的方式
        timeout: 5000, //请求超时的时间，以毫秒计
        data: {
            method: "qureyStudent",
            key: "sno",
            value: e
        }, //参数，用POST方法时使用，如果用GET方法则直接在url后拼接参数即可
        dataType: 'json', //预期的服务器返回参数类型
        beforeSend: function () {

        },//再发送请求前调用的方法
        success: function (msg) {
            $("#sno_new").val(msg[0]['sno'])
            $("#sno_new").attr("sno_old", msg[0]['sno'])
            $("#sname_new").val(msg[0]['sname'])
            $("#sage_new").val(msg[0]['sage'])
            $("#ssex_new").val(msg[0]['ssex'])
        }, //请求成功时回调方法，data为服务器返回的数据
        error: function () {
            alert("查询失败！")

        }, //请求发生错误时调用方法
        complete: function () {

        } //回调方法 无论success或者error都会执行
    });
}


function load() {
    $.ajax({
        url: 'StudentServlet', //要请求的url地址
        type: 'POST', //请求方法 GET or POST
        async: true, //是否使用异步请求的方式
        timeout: 5000, //请求超时的时间，以毫秒计
        data: {
            method: 'loadStudent'
        }, //参数，用POST方法时使用，如果用GET方法则直接在url后拼接参数即可
        dataType: 'json', //预期的服务器返回参数类型
        beforeSend: function () {

        },//再发送请求前调用的方法
        success: function (json) {
            showStudent(json)
        }, //请求成功时回调方法，data为服务器返回的数据
        error: function () {
            alert("数据库读取失败")
        }, //请求发生错误时调用方法
        complete: function () {

        } //回调方法 无论success或者error都会执行
    });
}
function clarJsonTable() {
    // var element = document.getElementById("jsonTable");
    // element.parentElement.removeChild(element);
    var element = document.getElementById("table_body");
    element.parentElement.removeChild(element);

}
function showStudent(json) {
    // var item = "<table id='jsonTable'><thead><tr><td>学号</td><td>姓名</td><td>年龄</td><td>性别</td><td>操作</td></tr></thead><tbody>";
    // $.each(json, function (i, result) {
    //     item += "<tr><td>" + result['sno'] + "</td><td>" + result['sname'] + "</td><td>" + result['sage'] + "</td><td>" + result['ssex'] + "</td>" +
    //         "<td><input class='jsonButton' type='button' onclick='queryStudent(" + result['sno'] + ")' value='编辑'>" +
    //         "<input class='jsonButton' type='button' onclick='deleteStudent(" + result['sno'] + ")' value='删除'></td></tr>";
    // });
    // item += "</tbody><tfoot><tr><td><a>1</a><a>2</a></td></tr></tfoot>";
    // item += "</table>";
    // $(".json").append(item);

    var item = "<tbody id='table_body'>"
    $.each(json, function (i, result) {
        item += "<tr id='" + result['sno'] + "' class='el-table__row'><td rowspan='1' colspan='1' class='el-table_4_column_26 is-center '><div class='cell'><span>" + result['sno'] + "</span></div></td><td rowspan='1' colspan='1' class='el-table_4_column_27 is-center '><div class='cell'><span>" + result['sname'] + "</span></div></td><td rowspan='1' colspan='1' class='el-table_4_column_28  '><div class='cell'><span class='link-type'>" + result['sdatebirth'] + "</span> </div></td><td rowspan='1' colspan='1' class='el-table_4_column_29 is-center '><div class='cell'><span>" + result['ssex'] + "</span></div></td><td rowspan='1' colspan='1' class='el-table_4_column_30  '><div class='cell'><span class='link-type'>" + result['snativeplace'] + "</span></div></td><td rowspan='1' colspan='1' class='el-table_4_column_31 is-center '><div class='cell'><span class='link-type'>" + result['shouseaddress'] + "</span></div></td><td rowspan='1' colspan='1' class='el-table_4_column_32  status-col'><div class='cell'><span class='el-tag el-tag--info el-tag--medium'>" + result['snation'] + "</span></div></td><td rowspan='1' colspan='1' class='el-table_4_column_33 is-center small-padding fixed-width'><div class='cell'><button type='button' onclick='updateStudent(" + result['sno'] + ")' class='el-button el-button--primary el-button--mini'><span>编辑</span></button><button type='button'  onclick='deleteStudent(" + result['sno'] + ")' class='el-button el-button--danger el-button--mini'><span>删除</span></button></div></td></tr>"
    })
    item += "</tbody>"
    $("#table_body_colgroup").after(item)
}