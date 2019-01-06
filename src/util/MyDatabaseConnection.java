package util;

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
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/db-studentms?useUnicode=true&characterEncoding=UTF-8&useSSL=false";
    /**
     * 数据库帐号密码
     */
    static final String USER = "root";
    static final String PASS = "shenger";

    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName(JDBC_DRIVER);

            con = DriverManager.getConnection(DB_URL, USER, PASS);
            if (!con.isClosed()) {
                System.out.printf("数据库连接成功！");
            } else {
                System.out.printf("数据库连接失败！");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
}
