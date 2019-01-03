package Dao;

import Entity.Student;
import Util.mDatabaseConnection;
import org.json.JSONArray;
import org.json.JSONObject;

import java.sql.*;

public class StudentDao {

    public static int insert(Student s) {
        Connection con = mDatabaseConnection.getConnection();
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

    public static int updateStudent(Student s, String sno_old) {
        int rows = 0;
        Connection con = mDatabaseConnection.getConnection();
        String sql = "update students set sno=?,sname=?,sage=?,ssex=? where sno=" + sno_old;
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
        Connection con = mDatabaseConnection.getConnection();
        Statement stmt = null;
        ResultSet rs = null;
        JSONArray jsonArray = new JSONArray();
        try {
            stmt = con.createStatement();
            String sql = "select * from students where " + k + "='" + v + "'";
            rs = stmt.executeQuery(sql);
            //json数组
            //得到rs列数
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            //遍历
            jsonArray=rsListToJsonArray(rs,jsonArray, metaData, columnCount);
            rs.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jsonArray;

    }

    public static JSONArray queryStudents() {
        Connection con = mDatabaseConnection.getConnection();
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
            jsonArray=rsListToJsonArray(rs,jsonArray, metaData, columnCount);
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
        Connection con = mDatabaseConnection.getConnection();
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
