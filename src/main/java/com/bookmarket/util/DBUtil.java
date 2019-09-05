package com.bookmarket.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil {
    private static Connection conn;

    public static Connection getConnection() {
        if (conn != null) {
            return conn;
        }

        InputStream in = DBUtil.class.getClassLoader().getResourceAsStream("\\db.properties");
        Properties properties = new Properties();
        try {
            properties.load(in);
            String user = properties.getProperty("user");
            String password = properties.getProperty("password");
            String url = properties.getProperty("url");
            conn = DriverManager.getConnection(url, user, password);
        }catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void closeConnection(Connection connection) {
        if (connection == null) {
            return;
        }
        try{
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
