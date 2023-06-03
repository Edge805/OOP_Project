package com.example.oop_project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDate;
import java.util.Date;

import static java.lang.Boolean.TRUE;

public class Admin extends Person {
    private static Admin instance;

    private Admin() {
        super();
    }

    private Admin(String name, String ID, String password, Date lastLoginDate) {
        super(name, password);
    }

    public static Admin getInstance() {
        if (instance == null) {
            instance = new Admin();
        }
        return instance;
    }

    public void AddVendors(String Name, String Location, String PhoneNumber) throws SQLException {
        Connection connection = DatabaseConnection.getConnection();
        String query = "insert into VENDORS (NAME , LOCATION ,phone_number) values (?,?,?);";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        preparedStatement.setString(1, Name);
        preparedStatement.setString(2, Location);
        preparedStatement.setString(3, PhoneNumber);
        preparedStatement.executeUpdate();
    }

    public String ShowStatistics() {
        // Implementation
        return null;
    }

    @Override
    public void SignIn(String Name) throws SQLException {
        Connection connection = DatabaseConnection.getConnection();
        String query = "insert into SessionInformation (SessionType , LoginDate) values (?,?);";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        preparedStatement.setString(1, "Admin");;
        preparedStatement.setDate(2, java.sql.Date.valueOf(LocalDate.now()));
        preparedStatement.executeUpdate();
    }

    public void AddGrocery(String Name, String Category, String Vendor, java.sql.Date ManfacturingDate, java.sql.Date EpirationDate, Integer Quantity) throws Exception {
        Connection connection = DatabaseConnection.getConnection();
        String query = "insert into Groceries (NAME , category ,vendor, ManufacturingDate,ExpireDate, Quantity, Organic) values (?,?,?,?,?,?,?);";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try{
            preparedStatement.setString(1, Name);
            preparedStatement.setString(2, Category);
            preparedStatement.setString(3, Vendor);
            preparedStatement.setDate(4, ManfacturingDate);
            preparedStatement.setDate(5,EpirationDate);
            preparedStatement.setInt(6,Quantity );
            preparedStatement.setBoolean(7, TRUE);
            preparedStatement.executeUpdate();
        }
        catch(SQLIntegrityConstraintViolationException exception)
        {
            throw exception;
        }
    }
}
