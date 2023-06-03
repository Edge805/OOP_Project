package com.example.oop_project;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

import static java.lang.Boolean.TRUE;

public class AdminController implements Initializable {

    @FXML
    private Button Add;

    @FXML
    private Button AddGroceries;

    @FXML
    private Pane AddGroceriespn;

    @FXML
    private Button AddVendors;

    @FXML
    private Pane AddVendorspn;

    @FXML
    private ChoiceBox<String> Category;

    @FXML
    private DatePicker EpirationDate;

    @FXML
    private TextField LocationVendor;

    @FXML
    private DatePicker ManfacturingDate;

    @FXML
    private TextField Name;

    @FXML
    private RadioButton OrganicNo;

    @FXML
    private RadioButton OrganicYes;

    @FXML
    private TextField PhoneNumberVendor;

    @FXML
    private TextField Quantity;

    @FXML
    private Button ShowGrocery;

    @FXML
    private Pane ShowGrocerypn;

    @FXML
    private Button ShowRevenue;

    @FXML
    private Pane ShowRevenuepn;

    @FXML
    private Pane ShowRevenuepn1;

    @FXML
    private Button ShowStatistics;

    @FXML
    private Pane ShowStatisticspn;

    @FXML
    private Button ShowUsers;

    @FXML
    private Pane ShowUserspn;

    @FXML
    private Button ShowVendors;

    @FXML
    private Pane ShowVendorspn;

    @FXML
    private TextField Vendor;

    @FXML
    private TextField VendorName;

    @FXML
    private ToggleGroup yesno;

    private String[] category ={"Fruits and Vegetables ","Protein","Canned products","General grocery"};

    @FXML
    private TableView<User> UserTable;
    @FXML
    private TableView<Vendors> VendorTable;
    @FXML
    private TableColumn<User,String> UserName, Email, PhoneNumber, Password, Address;
    @FXML
    private TableColumn<Vendors,String> VendorNameColumn, VendorPhoneColumn, VendorLocationColumn;
    @FXML
    private TableColumn<Vendors,Double> VendorTrustColumn;

    private ObservableList<User> Userlist = FXCollections.observableArrayList() ;
    private ObservableList<Vendors> Vendorlist = FXCollections.observableArrayList() ;

    private Admin admin = Admin.getInstance();
    @FXML
    void handelClicks(ActionEvent event) {
        if (event.getSource()==AddVendors){
            AddVendors.setStyle("1-fx-background-color :#4f0a0a");
            AddVendorspn.toFront();
        }
        if (event.getSource()==AddGroceries){
            AddGroceriespn.toFront();
        }
        if (event.getSource()==ShowGrocery){
            ShowGrocerypn.toFront();
        }
        if (event.getSource()==ShowRevenue){
            ShowRevenuepn.toFront();
        }
        if (event.getSource()==ShowStatistics){
            ShowStatisticspn.toFront();
        }
        if (event.getSource()==ShowUsers){
            ShowUserspn.toFront();
        }
        if (event.getSource()==ShowVendors){
            ShowVendorspn.toFront();
        }
    }
    @FXML
    void AddVendorsClick(ActionEvent event) throws SQLException {
        admin.AddVendors(VendorName.getText(),LocationVendor.getText(),PhoneNumberVendor.getText());
    }
    @FXML
    public void AddGroceries(ActionEvent event) throws SQLException {
        try{
            admin.AddGrocery(VendorName.getText(),LocationVendor.getText(),PhoneNumberVendor.getText(),Date.valueOf(ManfacturingDate.getValue()),Date.valueOf(EpirationDate.getValue()),Integer.valueOf(Quantity.getText()));
        }
        catch(SQLIntegrityConstraintViolationException exception)
        {
            Vendor.setText("");
            Vendor.setPromptText("Enter A Valid Vendor Name.");
        }
        catch(Exception exception1)
        {
            Quantity.setText("");
            Quantity.setPromptText("Enter A Valid Numeric Value.");
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            admin.SignIn("");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        Category.getItems().addAll(category);
        VendorNameColumn.setCellValueFactory(new PropertyValueFactory<Vendors,String>("Name"));
        VendorLocationColumn.setCellValueFactory(new PropertyValueFactory<Vendors,String>("Location"));
        VendorPhoneColumn.setCellValueFactory(new PropertyValueFactory<Vendors,String>("TelephoneNumber"));
        VendorTrustColumn.setCellValueFactory(new PropertyValueFactory<Vendors,Double>("Rating"));
        try {
            Connection con = DatabaseConnection.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from Vendors");
            while (rs.next()) {
                Vendorlist.add(new Vendors(rs.getDouble("rating"),rs.getString("name"), rs.getString("phone_number"), rs.getString("location")));
            }
            VendorTable.setItems(Vendorlist);
        } catch (Exception e) {
            System.out.println(e);
        }
        UserName.setCellValueFactory(new PropertyValueFactory<User,String>("Name"));
        Email.setCellValueFactory(new PropertyValueFactory<User,String>("Email"));
        PhoneNumber.setCellValueFactory(new PropertyValueFactory<User,String>("PhoneNumber"));
        Password.setCellValueFactory(new PropertyValueFactory<User,String>("Password"));
        Address.setCellValueFactory(new PropertyValueFactory<User,String>("Address"));
        try {
            Connection con = DatabaseConnection.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from siteUser");
            while (rs.next()) {
                Userlist.add(new User(rs.getString("username"), rs.getString("email_address"), rs.getString("phone_number"), rs.getString("password"),rs.getString("address")));
            }
            UserTable.setItems(Userlist);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}