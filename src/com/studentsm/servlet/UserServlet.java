package com.studentsm.servlet;

import com.studentsm.service.UserService;
import com.studentsm.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author WangYu
 */
@WebServlet(name = "UserServlet",urlPatterns = "/UserServlet")
public class UserServlet extends HttpServlet {

    private final int MIN_USER_NAME=8;
    private final int MIN_USER_PASSWORD=6;
    private static UserService userService=new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String method=request.getParameter("method");
        PrintWriter pw=response.getWriter();
        System.out.println("收到的请求method：" + method);
        // 根据不同的method调用不同的方法
        switch (method)
        {
            case "userRegister":
                userRegister(request, response,pw);
                break;
            case  "userLogin":
                userLogin(request,response,pw);
                break;
                default:
        }
    }

    /**
     * 用户登录
     */
    private void userLogin(HttpServletRequest request, HttpServletResponse response,PrintWriter pw) throws IOException, ServletException {
        String user = request.getParameter("userName");
        String pasw = request.getParameter("userPassword");
        if(user.length()< MIN_USER_NAME){
            pw.write("用户名必须大于8位");
            return;
        }
        if(pasw.length()< MIN_USER_PASSWORD){
            pw.write("密码必须大于6位");
            return;
        }
        if(userService.ifUserNameNotExist(user)){
            pw.write("用户名不存在");
            return;
        }
        if (userService.login(user, pasw)) {
            pw.write("登录成功");
        } else {
            pw.write("密码错误");
        }
    }

    /**
     * 用户注册
     */
    private void userRegister(HttpServletRequest request, HttpServletResponse response,PrintWriter pw) throws IOException {
        String user = request.getParameter("userName");
        String pasw = request.getParameter("userPassword");
        if(user.length()<MIN_USER_NAME){
            pw.write("用户名必须大于8位");
            return;
        }
        if(pasw.length()<MIN_USER_PASSWORD){
            pw.write("密码必须大于6位");
            return;
        }
        if (userService.register(user, pasw)) {
            pw.write("注册成功");
        } else {
            pw.write("用户名已存在");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
