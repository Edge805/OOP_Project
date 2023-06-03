package com.example.oop_project;

public class Vendors {
    private Double Rating;
    private String name;
    private String TelephoneNumber;

    private String Location;

    public Vendors(Double Rating, String name, String telephoneNumber,String Location) {
        this.Rating = Rating;
        this.name = name;
        this.TelephoneNumber = telephoneNumber;
        this.Location=Location;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public Double getRating() {
        return Rating;
    }

    public void setRating(Double rating) {
        Rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephoneNumber() {
        return TelephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        TelephoneNumber = telephoneNumber;
    }
}
