package com.example.oop_project;

import java.util.Date;

public class Protein extends GeneralGroceries {
    private boolean isImported;
    private double amount;

    public Protein(int price, Vendors vendors, boolean available, Date expireDate, double calories, String name, boolean isImported, double amount) {
        super(price, vendors, available, expireDate, calories, name);
        this.isImported = isImported;
        this.amount = amount;
    }

    public boolean isImported() {
        return isImported;
    }

    public void setImported(boolean imported) {
        isImported = imported;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
