package com.example.employe;

public class Employee {
    private  String id;
    private String name;
    private String email;
    private String phone;
    private String company;
    private String website;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    private String address;


    public Employee(String id, String name, String email, String phone, String company_name, String website, String address){
        this.id = id;
        this.name = name;
        this.email = email;
//        this.address = address;
        this.phone = phone;
        this.company =company_name;
        this.website = website;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}
