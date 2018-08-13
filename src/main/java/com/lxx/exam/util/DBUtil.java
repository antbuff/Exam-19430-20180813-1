package com.lxx.exam.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil {
    private static String URL;
    private static String USER_NAME;
    private static String PASSWORD;
    private static Connection conn;

    static {
        try {
            InputStream inputStream = DBUtil.class.getResourceAsStream("database.properties");
            Properties prop = new Properties();
            prop.load(inputStream);
            URL = (String) prop.get("URL");
            USER_NAME = (String) prop.get("USER_NAME");
            PASSWORD = (String) prop.get("PASSWORD");
            String driver = (String) prop.get("DRIVER");
            Class.forName(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        try {
            if(conn == null || conn.isClosed()){
                conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            }
            return conn;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
