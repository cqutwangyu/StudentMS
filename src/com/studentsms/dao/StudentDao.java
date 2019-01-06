package com.studentsms.dao;

import com.studentsms.entity.Student;
import com.studentsms.util.MyDatabaseConnection;
import org.json.JSONArray;
import org.json.JSONObject;

import java.sql.*;

/**
 * @author WangYu
 */
public class StudentDao {

    public static void initDateStudentDB(){
        Connection con = MyDatabaseConnection.getConnection();
        try {
            Statement stms=con.createStatement();
            stms.addBatch("INSERT INTO `students` VALUES ('100001', '王浩', '1998-05-02', '男', '重庆', '地址地址地址', '汉族');");
            stms.addBatch("INSERT INTO `students` VALUES ('100002', '张洋', '1999-12-01', '女', '四川', '地址地址地址', '汉族');");
            stms.addBatch("INSERT INTO `students` VALUES ('100003', '李航', '1996-01-21', '男', '北京', '地址地址地址', '汉族');");
            stms.addBatch("INSERT INTO `students` VALUES ('100004', '吴辉', '1997-03-01', '男', '上海', '地址地址地址', '汉族');");
            stms.addBatch("INSERT INTO `students` VALUES ('100005', '常鑫', '1996-01-06', '男', '西安', '地址地址地址', '汉族');");
            stms.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static int insert(Student s) {
        Connection con = MyDatabaseConnection.getConnection();
        String sql = "insert into students values(?,?,?,?,?,?,?)";
        int rows = 0;
        PreparedStatement pst = null;
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, s.getSno());
            pst.setString(2, s.getSname());
            pst.setString(3, s.getSdatebirth());
            pst.setString(4, s.getSsex());
            pst.setString(5, s.getSnativeplace());
            pst.setString(6, s.getShouseaddress());
            pst.setString(7, s.getSnation());
            rows = pst.executeUpdate();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rows;
    }

    public static int updateStudent(Student s, String snoOld) {
        int rows = 0;
        Connection con = MyDatabaseConnection.getConnection();
        String sql = "update students set sno=?,sname=?,sdatebirth=?,ssex=? ,snativeplace=? ,shouseaddress=? ,snation=? where sno=" + snoOld;
        PreparedStatement pst = null;
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, s.getSno());
            pst.setString(2, s.getSname());
            pst.setString(3, s.getSdatebirth());
            pst.setString(4, s.getSsex());
            pst.setString(5, s.getSnativeplace());
            pst.setString(6, s.getShouseaddress());
            pst.setString(7, s.getSnation());
            rows = pst.executeUpdate();
            System.out.println(pst.toString());
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rows;
    }

    public static JSONArray queryStudents(String k, String v) {
        Connection con = MyDatabaseConnection.getConnection();
        Statement stmt = null;
        ResultSet rs = null;
        JSONArray jsonArray = new JSONArray();
        try {
            stmt = con.createStatement();
            String sql = "select * from students where " + k + " like '%" + v + "%'";
            rs = stmt.executeQuery(sql);
            //json数组
            //得到rs列数
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            //遍历
            jsonArray = rsListToJsonArray(rs, jsonArray, metaData, columnCount);
            rs.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jsonArray;

    }

    public static JSONArray queryStudents() {
        Connection con = MyDatabaseConnection.getConnection();
        Statement stmt = null;
        ResultSet rs = null;
        JSONArray jsonArray = new JSONArray();
        try {
            stmt = con.createStatement();
            String sql = "select * from students order by sno";
            rs = stmt.executeQuery(sql);
            //json数组
            //得到rs列数
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            //遍历
            jsonArray = rsListToJsonArray(rs, jsonArray, metaData, columnCount);
            rs.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jsonArray;

    }

    private static JSONArray rsListToJsonArray(ResultSet rs, JSONArray jsonArray, ResultSetMetaData metaData, int columnCount) throws SQLException {
        while (rs.next()) {
            JSONObject jsonObject = new JSONObject();
            for (int i = 1; i <= columnCount; i++) {
                String key = metaData.getColumnLabel(i);
                String value = rs.getString(key);
                jsonObject.put(key, value);
            }
            jsonArray.put(jsonObject);
        }
        return jsonArray;
    }

    public static int deleteStudent(String sno) {
        int rows = 0;
        Connection con = MyDatabaseConnection.getConnection();
        Statement stmt = null;

        try {
            stmt = con.createStatement();
            String sql = "delete from students where sno=" + sno;
            rows = stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rows;
    }
}
