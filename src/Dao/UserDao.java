package Dao;

import Entity.User;
import Util.mDatabaseConnection;

import java.sql.*;

public class UserDao {

    public static int add(User u) {
        Connection con = mDatabaseConnection.getConnection();
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

    public static User queryUser(String username) {
        Connection con = mDatabaseConnection.getConnection();
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
