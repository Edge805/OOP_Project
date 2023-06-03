package com.example.oop_project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class UserController implements Initializable {
    @FXML
    private Button Bayza;

    @FXML
    private Pane Bayzapn;

    @FXML
    private Pane Cardpn;

    @FXML
    private Button CarrotAdd;

    @FXML
    private Spinner<Integer> CarrotQ;

    @FXML
    private Button ChickenAdd;

    @FXML
    private Spinner<Integer> ChickenQ;

    @FXML
    private Button CornAdd;

    @FXML
    private Spinner<Integer> CornQ;

    @FXML
    private Button FishAdd;

    @FXML
    private Spinner<Integer> FishQ;


    @FXML
    private Button Market;

    @FXML
    private Pane Marketpn;

    @FXML
    private Button MeatAdd;

    @FXML
    private Spinner<Integer> MeatQ;

    @FXML
    private Button PaperAdd;

    @FXML
    private Spinner<Integer> PeperQ;

    @FXML
    private Pane Sarafnypn;

    @FXML
    private Button Sarfny;

    @FXML
    private Button ShoppingCart;

    @FXML
    private Button ShrimpAdd;

    @FXML
    private Spinner<Integer> ShrimpQ;

    @FXML
    private Button TomatoAdd;

    @FXML
    private Spinner<Integer> TomatoQ;

    @FXML
    private TextArea SarafnyInput;

    @FXML
    private Label SarafnyOutput;

    @FXML
    private Button SarafnyOk;

    @FXML
    private Button BackButton;


    ShoppingCart shoppingCart = new ShoppingCart();
    ArrayList<Spinner<Integer>> OurSpinners = new ArrayList<Spinner<Integer>>();
    @FXML
    void hadelClicks(ActionEvent event) {
        if (event.getSource()==Market){
            Market.setStyle("1-fx-background-color :#4f0a0a");
            Marketpn.toFront();
        }
        if (event.getSource()==ShoppingCart){
            Cardpn.toFront();
        }
        if (event.getSource()==Sarfny){
            Sarafnypn.toFront();
        }
        if (event.getSource()==Bayza){
            Bayzapn.toFront();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        SpinnerValueFactory<Integer> valueFactory1= new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10);
        valueFactory1.setValue(0);
        TomatoQ.setValueFactory(valueFactory1);

        SpinnerValueFactory<Integer> valueFactory2= new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10);
        valueFactory2.setValue(0);
        PeperQ.setValueFactory(valueFactory2);

        SpinnerValueFactory<Integer> valueFactory3= new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10);
        valueFactory3.setValue(0);
        CornQ.setValueFactory(valueFactory3);
        SpinnerValueFactory<Integer> valueFactory4= new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10);
        valueFactory4.setValue(0);
        CarrotQ.setValueFactory(valueFactory4);
        SpinnerValueFactory<Integer> valueFactory8= new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10);
        valueFactory8.setValue(0);
        ShrimpQ.setValueFactory(valueFactory8);
        SpinnerValueFactory<Integer> valueFactory9= new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10);
        valueFactory9.setValue(0);
        ChickenQ.setValueFactory(valueFactory9);
        SpinnerValueFactory<Integer> valueFactory10= new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10);
        valueFactory10.setValue(0);
        FishQ.setValueFactory(valueFactory10);
        SpinnerValueFactory<Integer> valueFactory11= new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10);
        valueFactory11.setValue(0);
        MeatQ.setValueFactory(valueFactory11);
    }

    public void OnCheckOut(ActionEvent event) throws IOException {
        OurSpinners.add(TomatoQ);
        OurSpinners.add(PeperQ);
        OurSpinners.add(CornQ);
        OurSpinners.add(CarrotQ);
        OurSpinners.add(ShrimpQ);
        OurSpinners.add(ChickenQ);
        OurSpinners.add(FishQ);
        OurSpinners.add(MeatQ);
        for (Spinner<Integer> spinner :OurSpinners) {
            if(spinner == TomatoQ && spinner.getValue() != 0 )
            {
                shoppingCart.AddToCart(new GeneralGroceries("Tomato", 10.0,spinner.getValue()));
            }
            else if (spinner == PeperQ && spinner.getValue() != 0) {
                shoppingCart.AddToCart(new GeneralGroceries("Peper", 10.0,spinner.getValue()));
            }
            else if (spinner == CornQ && spinner.getValue() != 0)
            {
                shoppingCart.AddToCart(new GeneralGroceries("Corn", 10.0,spinner.getValue()));
            }
            else if (spinner == ShrimpQ && spinner.getValue() != 0)
            {
                shoppingCart.AddToCart(new GeneralGroceries("Shrimp", 5.0,spinner.getValue()));
            }
            else if (spinner == ChickenQ && spinner.getValue() != 0) {
                shoppingCart.AddToCart(new GeneralGroceries("Chicken", 6.0,spinner.getValue()));
            }
            else if (spinner == CarrotQ && spinner.getValue() != 0) {
                shoppingCart.AddToCart(new GeneralGroceries("Carrot", 6.0,spinner.getValue()));
            }
            else if (spinner == FishQ && spinner.getValue() != 0) {
                shoppingCart.AddToCart(new GeneralGroceries("Fish", 6.0,spinner.getValue()));
            }
            else if (spinner == MeatQ && spinner.getValue() != 0) {
                shoppingCart.AddToCart(new GeneralGroceries("Meat", 3.0,spinner.getValue()));
            }
            CheckOutController.shoppingCartFinal = shoppingCart ;
        }

        FXMLLoader fxmlLoader= new FXMLLoader();
        Parent root = fxmlLoader.load(getClass().getResource("CheckOut.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void BackButtton(ActionEvent e) throws IOException {
        FXMLLoader fxmlLoader= new FXMLLoader();
        Parent root = fxmlLoader.load(getClass().getResource("hello-view.fxml"));
        Stage stage = (Stage) ((Node)e.getSource ()) .getScene () . getWindow();
        Scene scene = new Scene(root);
        stage.setScene (scene) ;
        stage.show();
    }

    public void OnSarafnyOkay(ActionEvent event){
        Sarfny sarfny = new Sarfny();
        try{
            sarfny.generateResponse("Hello GPT Can you please suggest a recipe using the following ingredients ?"+SarafnyInput.getText());
        }
        catch(IOException exception){
            SarafnyOutput.setText("We are sorry the system is currently out of service stay tuned");
        }

    }
}

