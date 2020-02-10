package xyz.ph.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlConnection {
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection connection= null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://62.234.148.80:3306/student?useSSL=false&serverTimezone=GMT","root","123123ph");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
