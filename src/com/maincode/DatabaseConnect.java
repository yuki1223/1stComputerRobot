package com.maincode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by SATOSHI on 2015/10/26.
 */
public class DatabaseConnect {

    private Connection dbConn = null;

    private String className = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; // 数据库驱动名
    private String dbUrl = "jdbc:sqlserver://localhost:1433;databasename=PufferDB"; // 数据库URL
    private String userName = "sa";
    private String userPassword = "1357955";

    public Connection getConnect() {

        // 加载数据库驱动
        try {
            System.out.println("加载数据库驱动...");
            Class.forName(className);
            System.out.println("加载数据库驱动...完成");
        } catch (ClassNotFoundException e) {
            System.out.println("加载数据库驱动...失败");
            e.printStackTrace();
        }

        // 进行数据库连接
        try {
            System.out.println("连接数据库...");
            dbConn = DriverManager.getConnection(dbUrl, userName, userPassword);
            System.out.println("连接数据库...成功");
            return dbConn;
        } catch (Exception e) {
            System.out.println("连接数据库...失败");
            e.printStackTrace();
            return null;
        }
    }

    public void getClose() {
        try {
            if (dbConn != null) {
                dbConn.close();
            }
        } catch (SQLException e) {
            System.out.println("关闭数据库...失败");
            e.printStackTrace();
        }
    }
}
