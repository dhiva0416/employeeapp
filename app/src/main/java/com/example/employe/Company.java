package com.example.employe;

public class Company {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public Company(String name) {
        this.name = name;
    }
}
