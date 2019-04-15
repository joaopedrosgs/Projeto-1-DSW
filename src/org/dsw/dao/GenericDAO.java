package org.dsw.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GenericDAO {
    protected static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:sqlite:~/.intellij/db/projeto-1-dsw.sqlite");
    }
}
