package com.studentsm.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author WangYu
 */
public class MyDatabaseConnection {

    /**
     * JDBC数据库驱动服务和URL
     */
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/db-studentms?useUnicode=true&characterEncoding=UTF-8&useSSL=false";
    /**
     * 数据库帐号密码
     */
    private static final String USER = "root";
    private static final String PASS = "shenger";

    /**
     * 获取数据库连接对象
     * @return 返回数据库连接对象
     */
    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName(JDBC_DRIVER);

            con = DriverManager.getConnection(DB_URL, USER, PASS);
            if (!con.isClosed()) {
                System.out.println("数据库连接成功！");
            } else {
                System.out.println("数据库连接失败！");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
}
