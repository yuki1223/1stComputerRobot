package com.maincode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by SATOSHI on 2015/10/26.
 */
public class DatabaseConnect {

    private Connection dbConn = null;

    private String className = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; // ���ݿ�������
    private String dbUrl = "jdbc:sqlserver://localhost:1433;databasename=PufferDB"; // ���ݿ�URL
    private String userName = "sa";
    private String userPassword = "1357955";

    public Connection getConnect() {

        // �������ݿ�����
        try {
            System.out.println("�������ݿ�����...");
            Class.forName(className);
            System.out.println("�������ݿ�����...���");
        } catch (ClassNotFoundException e) {
            System.out.println("�������ݿ�����...ʧ��");
            e.printStackTrace();
        }

        // �������ݿ�����
        try {
            System.out.println("�������ݿ�...");
            dbConn = DriverManager.getConnection(dbUrl, userName, userPassword);
            System.out.println("�������ݿ�...�ɹ�");
            return dbConn;
        } catch (Exception e) {
            System.out.println("�������ݿ�...ʧ��");
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
            System.out.println("�ر����ݿ�...ʧ��");
            e.printStackTrace();
        }
    }
}
