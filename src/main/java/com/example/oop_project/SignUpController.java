package com.example.oop_project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SignUpController {
    @FXML
    private TextField UserNameInput, PasswordInput, AddressInput, PhoneInput, EmailInput;
    @FXML
    protected void SignUpButtonClick(ActionEvent e) throws SQLException {
        Connection connection = DatabaseConnection.getConnection();
        String query = "insert into siteuser(username,email_address,phone_number,password,address) values (?,?,?,?,?);";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, UserNameInput.getText());
        preparedStatement.setString(2, EmailInput.getText());
        preparedStatement.setString(3, PhoneInput.getText());
        preparedStatement.setString(4, PasswordInput.getText());
        preparedStatement.setString(5, AddressInput.getText());
        preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();
    }

}
