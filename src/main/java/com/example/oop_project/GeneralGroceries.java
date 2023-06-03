package com.example.oop_project;

import java.util.Date;

public class GeneralGroceries {
    private double price;
    private Vendors vendors;
    private boolean available;
    private Date ExpireDate;
    private String name;

    private int quantity;

    public GeneralGroceries() {
    }

    public GeneralGroceries(int price, Vendors vendors, boolean available, Date expireDate, double calories, String name) {
        this.price = price;
        this.vendors = vendors;
        this.available = available;
        ExpireDate = expireDate;
        this.name = name;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public GeneralGroceries(String Name, Double Price, int Quantity) {
        this.name=Name;
        this.price=Price;
        this.quantity=Quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Vendors getVendors() {
        return vendors;
    }

    public void setVendors(Vendors vendors) {
        this.vendors = vendors;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public Date getExpireDate() {
        return ExpireDate;
    }

    public void setExpireDate(Date expireDate) {
        ExpireDate = expireDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
