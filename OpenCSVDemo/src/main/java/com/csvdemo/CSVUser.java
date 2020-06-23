package com.csvdemo;

import com.opencsv.bean.CsvBindByName;

public class CSVUser {
    @CsvBindByName
    private String name;

    @CsvBindByName(column = "email", required = true)
    private String email;

    @CsvBindByName(column = "phone")
    private String phoneNo;

    @CsvBindByName
    private String country;

    CSVUser(String... args) {
        this.name = args[0];
        this.email = args[1];
        this.phoneNo = args[2];
        this.country = args[3];
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return "CSVUser { " +
                "name='" + name + "'" +
                ", email='" + email + "'" +
                ", phone='" + phoneNo + "'" +
                ", country='" + country + "'" +
                " }";
    }
}