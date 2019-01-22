package com.wangyu.studentms.servlet;

import com.wangyu.studentms.service.StudentService;
import com.wangyu.studentms.service.impl.StudentServiceImpl;
import com.wangyu.studentms.util.DataTypeUtils;
import org.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 * @author WangYu
 */
@WebServlet(name = "StudentServlet", urlPatterns = "/StudentServlet")
public class StudentServlet extends HttpServlet {
    // 学生的学号长度限制
    private final int MIN_STUDENT_SNO_LENGTH = 6;
    private static StudentService studentService = new StudentServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String method = request.getParameter("method");
        PrintWriter pw = response.getWriter();
        System.out.println("收到的请求method：" + method);
        // 根据不同的method调用不同的方法
        switch (method) {
            case "addStudent":
                addStudent(request, response, pw);
                break;
            case "deleteStudent":
                deleteStudent(request, response, pw);
                break;
            case "updateStudent":
                updateStudent(request, response, pw);
                break;
            case "qureyStudent":
                qureyStudent(request, response, pw);
                break;
            case "loadStudent":
                loadStudent(request, response, pw);
                break;
            default:

        }

    }

    /**
     * 插入一条学生信息
     */
    private void addStudent(HttpServletRequest request, HttpServletResponse response, PrintWriter pw) {
        String sno = request.getParameter("sno");
        String sname = request.getParameter("sname");
        String sdatebirth = request.getParameter("sdatebirth");
        String ssex = request.getParameter("ssex");
        String snativeplace = request.getParameter("snativeplace");
        String shouseaddress = request.getParameter("shouseaddress");
        String snation = request.getParameter("snation");
        if (sno.length() == MIN_STUDENT_SNO_LENGTH) {
            pw.write("学号必须为6位");
            return;
        }
        if (studentService.isExist(sno)) {
            pw.write("学号已存在");
            return;
        }
        boolean result = studentService.addStudent(sno, sname, sdatebirth, ssex, snativeplace, shouseaddress, snation);
        if (result) {
            pw.write("添加成功");
        } else {
            pw.write("添加失败");
        }
    }

    /**
     * 删除学号为sno的学生信息
     */
    private void deleteStudent(HttpServletRequest request, HttpServletResponse response, PrintWriter pw) {
        String sno = request.getParameter("sno");
        boolean result = studentService.deleteStudent(sno);
        if (result) {
            pw.write("删除成功");
        } else {
            pw.write("删除失败");
        }
    }

    /**
     * 修改学号为snoOld的学生信息
     */
    private void updateStudent(HttpServletRequest request, HttpServletResponse response, PrintWriter pw) {
        String sno = request.getParameter("sno");
        String snoOld = request.getParameter("sno_old");
        String sname = request.getParameter("sname");
        String sdatebirth = request.getParameter("sdatebirth");
        String ssex = request.getParameter("ssex");
        String snativeplace = request.getParameter("snativeplace");
        String shouseaddress = request.getParameter("shouseaddress");
        String snation = request.getParameter("snation");
        if (!DataTypeUtils.isNum(sno)) {
            pw.write("学号必须为数字");
            return;
        }
        if (sno.length() < MIN_STUDENT_SNO_LENGTH) {
            pw.write("学号必须为6位");
            return;
        }
        boolean result = studentService.updateStudent(sno, sname, sdatebirth, ssex, snativeplace, shouseaddress, snation, snoOld);
        if (result) {
            pw.write("修改成功");
        } else {
            pw.write("修改失败");
        }
    }

    /**
     * 查询key字段的值包含value的学生信息
     */
    private void qureyStudent(HttpServletRequest request, HttpServletResponse response, PrintWriter pw) throws UnsupportedEncodingException {
        String key = request.getParameter("key");
        String value = request.getParameter("value");
        if (key == null || key.length() < 1) {
            pw.write("请选择索引字段");
            return;
        }
        if (value == null || value.length() < 1) {
            pw.write("请输入搜索内容");
            return;
        }
        System.out.println(333);
        JSONArray jsonArray = studentService.queryStudent(key, value);
        pw.write(jsonArray.toString());
    }

    /**
     * 读取数据库中所有学生信息
     */
    private void loadStudent(HttpServletRequest request, HttpServletResponse response, PrintWriter pw) {
        JSONArray jsonArray = studentService.queryStudents();
        if (jsonArray.length() < 1) {
            studentService.initDB();
        }
        pw.write(jsonArray.toString());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
