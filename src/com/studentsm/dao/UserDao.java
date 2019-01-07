package com.studentsm.dao;

import com.studentsm.entity.User;
import com.studentsm.util.MyDatabaseConnection;

import java.sql.*;

/**
 * @author WangYu
 */
public class UserDao {
    /**
     * 插入一条用户信息
     * @param u 用户对象
     * @return
     */
    public static int add(User u) {
        Connection con = MyDatabaseConnection.getConnection();
        String sql = "insert into users values(?,?)";
        PreparedStatement pst = null;
        int rows = 0;
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, u.getUsername());
            pst.setString(2, u.getPassword());
            rows = pst.executeUpdate();
            con.close();
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rows;
    }

    /**
     * 查询用户
     * @param username 用户名字段的值
     * @return 返回一个用户对象
     */
    public static User queryUser(String username) {
        Connection con = MyDatabaseConnection.getConnection();
        Statement stmt = null;
        ResultSet rs = null;
        User user = null;
        try {
            stmt = con.createStatement();
            String sql = "select * from users where username='" + username+"'";
            rs = stmt.executeQuery(sql);
            if (rs.first()) {
                user = new User(rs.getString("username"), rs.getString("password"));
            }
            rs.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
