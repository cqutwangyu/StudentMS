package servlet;

import service.UserService;

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
    @Override
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
                default:
        }
    }

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
        if(UserService.ifUserNameNotExist(user)){
            pw.write("用户名不存在");
            return;
        }
        if (UserService.login(user, pasw)) {
            pw.write("登录成功");
        } else {
            pw.write("密码错误");
        }
    }

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
        if (UserService.register(user, pasw)) {
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
