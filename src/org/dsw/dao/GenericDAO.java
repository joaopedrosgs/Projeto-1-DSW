package org.dsw.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GenericDAO {
    protected static Connection getConnection() throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC");

            return DriverManager.getConnection("jdbc:sqlite:/home/bortinho/.intellij/db/projeto-1-dsw.sqlite");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}