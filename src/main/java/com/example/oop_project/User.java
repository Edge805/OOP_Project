package com.example.oop_project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class User extends Person{

    private ShoppingCart myShoppingCart;
    private String PhoneNumber;
    private String Address;
    private String Email;

    public User() {

    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }


    public static boolean SignUp(){
        return false;
    }

    public User(String name, String password, ShoppingCart myShoppingCart) {
        super(name, password);
        this.myShoppingCart = myShoppingCart;
    }

    public User(String name, String Email,String PhoneNumber, String password,String Address) {
        super(name, password);
        this.PhoneNumber=PhoneNumber;
        this.Email=Email;
        this.Address=Address;
    }


    public ShoppingCart getMyShoppingCart() {
        return myShoppingCart;
    }

    public void setMyShoppingCart(ShoppingCart myShoppingCart) {
        this.myShoppingCart = myShoppingCart;
    }


    @Override
    public void SignIn(String UserName) throws SQLException {
        Connection connection = DatabaseConnection.getConnection();
        String query = "insert into SessionInformation (SessionType , LoginDate) values (?,?);";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        preparedStatement.setString(1, UserName);;
        preparedStatement.setDate(2, java.sql.Date.valueOf(LocalDate.now()));
        preparedStatement.executeUpdate();
    }

}
