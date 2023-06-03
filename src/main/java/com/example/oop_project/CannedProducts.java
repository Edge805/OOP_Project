package com.example.oop_project;

import java.util.Date;

public class CannedProducts extends GeneralGroceries{
    public int amount;

    public CannedProducts(int amount) {
        this.amount = amount;
    }

    public CannedProducts(int price, Vendors vendors, boolean available, Date expireDate, double calories, String name, int amount) {
        super(price, vendors, available, expireDate, calories, name);
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
