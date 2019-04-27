package com.dsw.p1.dao;

import org.sqlite.SQLiteConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GenericDAO {
    static private Connection s;

    protected static Connection getConnection() {
        if (s == null)
            try {
                SQLiteConfig config = new SQLiteConfig();
                config.setEncoding(SQLiteConfig.Encoding.UTF8);
                Class.forName("org.sqlite.JDBC");
                s = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.home") + "/projeto-1-dsw.sqlite", config.toProperties());
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        return s;
    }
}
