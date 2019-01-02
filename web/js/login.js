"use strict";
window.onload = function () {
    background();
    $(".login_input")[0].focus()//网页打开后自动让用户名输入框获得焦点
}
function inputFocus(e) {
    $(e).parent().siblings(".login_tips").css("color", "#ddd");
}
function inputBlur(e) {
    $(e).parent().siblings(".login_tips").css("color", "#aaa");
}
function inputUp(e) {
    var count=$(e).val().length;
    if(count==0){
        $(e).parent().siblings(".login_tips").css("display","block");
    }else{
        $(e).parent().siblings(".login_tips").css("display","none");
    }
}
function background() {
    $(".background_img").css("opacity", "1");
}
function usesrLogin() {
    console.info("login")
    $.ajax({
        url: 'UserServlet', //要请求的url地址
        type: 'POST', //请求方法 GET or POST
        async: true, //是否使用异步请求的方式
        timeout: 5000, //请求超时的时间，以毫秒计
        data: {
            method: "userLogin",
            userName: $("#userName").val(),
            userPassword: $("#userPassword").val()
        }, //参数，用POST方法时使用，如果用GET方法则直接在url后拼接参数即可
        //dataType:'json', //预期的服务器返回参数类型，如果不是预期类型则会认为请求失败执行error
        beforeSend: function () {

        },//再发送请求前调用的方法
        success: function (msg) {
            if (msg == "登录成功") {
                $(location).attr('href', 'main.html')
            } else {
                alert(msg)
            }
        }, //请求成功时回调方法，data为服务器返回的数据
        error: function () {

        }, //请求发生错误时调用方法
        complete: function () {

        } //回调方法 无论success或者error都会执行
    });
}

function usesrRegister() {
    $.ajax({
        url: 'UserServlet', //要请求的url地址
        type: 'POST', //请求方法 GET or POST
        async: true, //是否使用异步请求的方式
        timeout: 5000, //请求超时的时间，以毫秒计
        data: {
            method: "userRegister",
            userName: $("#userName").val(),
            userPassword: $("#userPassword").val()
        }, //参数，用POST方法时使用，如果用GET方法则直接在url后拼接参数即可
        //dataType:'json', //预期的服务器返回参数类型，如果不是预期类型则会认为请求失败执行error
        beforeSend: function () {

        },//再发送请求前调用的方法
        success: function (msg) {
            alert(msg)
        }, //请求成功时回调方法，data为服务器返回的数据
        error: function () {

        }, //请求发生错误时调用方法
        complete: function () {

        } //回调方法 无论success或者error都会执行
    });
}