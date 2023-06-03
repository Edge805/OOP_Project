package com.example.oop_project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.sql.*;

public class HelloController {
    @FXML
    private Label welcomeText;
    private Stage stage;
    private Scene scene;
    @FXML
    private TextField Nametext,Passwordtext;

    private User user = new User();

    @FXML
    protected void SignInButtonClick(ActionEvent e) throws SQLException, IOException {
        Connection connection = DatabaseConnection.getConnection();
        String query = "SELECT COUNT(*) FROM siteUser WHERE username = ? AND password = ? ";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, Nametext.getText());
        statement.setString(2, Passwordtext.getText());
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            int count = resultSet.getInt(1);
            if (count > 0) {
                user.SignIn(Nametext.getText());
                FXMLLoader fxmlLoader= new FXMLLoader();
                Parent root = fxmlLoader.load(getClass().getResource("User.fxml"));
                stage = (Stage) ((Node)e.getSource ()) .getScene () . getWindow();
                scene = new Scene(root);
                stage.setScene (scene) ;
                stage.show();
            } else {
                System.out.println("Username does not exist in the database.");
                Nametext.setText("");
                Passwordtext.setText("");
            }
        }
    }
    @FXML
    protected void SignUpButtonClick1(ActionEvent e) throws IOException {
        FXMLLoader fxmlLoader= new FXMLLoader();
        Parent root = fxmlLoader.load(getClass().getResource("SignUp.fxml"));
        stage = (Stage) ((Node)e.getSource ()) .getScene () . getWindow();
        scene = new Scene(root);
        stage.setScene (scene) ;
        stage.show();
    }
    @FXML
    protected void AdminButtonClick(ActionEvent e) throws IOException {
        FXMLLoader fxmlLoader= new FXMLLoader();
        Parent root = fxmlLoader.load(getClass().getResource("AdminLogin.fxml"));
        stage = (Stage) ((Node)e.getSource ()) .getScene () . getWindow();
        scene = new Scene(root);
        stage.setScene (scene) ;
        stage.show();
    }

}