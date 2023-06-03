package com.example.oop_project;

import java.sql.SQLException;
import java.util.Date;

public abstract class Person {
    private String Name;
    private String Password;

    public Person(String name, String password) {
        Name = name;
        Password = password;
    }

    public Person() {

    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }


    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public abstract void SignIn(String Name) throws SQLException;
}

