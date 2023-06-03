package com.example.oop_project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CheckOutController implements Initializable {
    @FXML
    private Label Check;

    @FXML
    private ToggleGroup Pmethod;

    @FXML
    private AnchorPane Creditpn;

    @FXML
    private TextField CredirCard;

    @FXML
    private Text text;

    @FXML
    private Button CheckoutButton;

    @FXML
    private RadioButton CreditRadio;

    @FXML
    private RadioButton CashRadio;
    public static ShoppingCart shoppingCartFinal;


    @FXML
    void BackButtton(ActionEvent e) throws IOException {
        FXMLLoader fxmlLoader= new FXMLLoader();
        Parent root = fxmlLoader.load(getClass().getResource("User.fxml"));
        Stage stage = (Stage) ((Node)e.getSource ()) .getScene () . getWindow();
        Scene scene = new Scene(root);
        stage.setScene (scene) ;
        stage.show();

    }
    @FXML
    void CreditClicked(ActionEvent e){
        if (CreditRadio.isSelected())
            Creditpn.setVisible(true);
    }

    @FXML
    void CashClicked(ActionEvent e){
        if (CashRadio.isSelected())
            Creditpn.setVisible(false);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Creditpn.setVisible(false);
        Check.setText(shoppingCartFinal.toString());
        System.out.println(shoppingCartFinal.TotalToBePaid());
    }
    public void OnCheckOutClicked(ActionEvent event)
    {
        if (CreditRadio.isSelected())
        {
            Check.setText((new Credit(shoppingCartFinal.TotalToBePaid())).pay());
        }
        else if(CashRadio.isSelected())
        {
            Check.setText((new Cash(shoppingCartFinal.TotalToBePaid())).pay());
        }
    }
}
