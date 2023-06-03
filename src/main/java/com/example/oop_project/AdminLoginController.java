package com.example.oop_project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminLoginController {
    @FXML
    private Button AdminSigninButton;

    @FXML
    private Label welcomeText;

    @FXML
    private TextField AdminName;

    @FXML
    private PasswordField AdminPassword;




    @FXML
    void SignInButtonClick(ActionEvent event) throws IOException {
        if((AdminName.getText()).compareTo("Admin") == 0 && (AdminPassword.getText()).compareTo("1234") == 0)
        {
            FXMLLoader fxmlLoader= new FXMLLoader();
            Parent root = fxmlLoader.load(getClass().getResource("Admin.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene (scene) ;
            stage.show();
        }
        else{
            AdminName.setText("");
            AdminPassword.setText("");
        }
    }


}
