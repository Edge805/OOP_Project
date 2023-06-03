package com.example.oop_project;

import java.util.Date;

public class FruitsAndVegetables extends GeneralGroceries {
    private boolean isOrganic;
    private boolean isFresh;
    private double amount;

    public FruitsAndVegetables(int price, Vendors vendors, boolean available, Date expireDate, double calories, String name, boolean isOrganic, boolean isFresh, double amount) {
        super(price, vendors, available, expireDate, calories, name);
        this.isOrganic = isOrganic;
        this.isFresh = isFresh;
        this.amount = amount;
    }

    public boolean isOrganic() {
        return isOrganic;
    }

    public void setOrganic(boolean organic) {
        isOrganic = organic;
    }

    public boolean isFresh() {
        return isFresh;
    }

    public void setFresh(boolean fresh) {
        isFresh = fresh;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
