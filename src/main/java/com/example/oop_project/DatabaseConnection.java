package com.example.oop_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Implements Singleton Design Pattern
public class DatabaseConnection {
    private static Connection con = null;

    static
    {
        String url = "jdbc:mysql://localhost:3306/project";
        String user = "root";
        String pass = "root";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pass);
        }
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection()
    {
        return con;
    }
}
