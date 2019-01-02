package Servlet;

import Service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "UserServlet",urlPatterns = "/UserServlet")
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String method=request.getParameter("method");
        PrintWriter pw=response.getWriter();
        System.out.println(method);
        switch (method)
        {
            case "userRegister":
                userRegister(request, response,pw);
                break;
            case  "userLogin":
                userLogin(request,response,pw);
                break;
        }
    }

    private void userLogin(HttpServletRequest request, HttpServletResponse response,PrintWriter pw) throws IOException, ServletException {
        String user = request.getParameter("userName");
        String pasw = request.getParameter("userPassword");
        if (UserService.login(user, pasw)) {
            pw.write("登录成功");
        } else {
            pw.write("登录失败");
        }
    }

    private void userRegister(HttpServletRequest request, HttpServletResponse response,PrintWriter pw) throws IOException {
        String user = request.getParameter("userName");
        String pasw = request.getParameter("userPassword");
        if (UserService.register(user, pasw)) {
            pw.write("注册成功");
        } else {
            pw.write("注册失败");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
