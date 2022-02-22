package com.example.exp3_newworld;

public class TestData {
    private String phoneNum;
    private String faveColor;
    private String mothersMaiden;
    private String password;
    private String name;

    public TestData() {
    }

    public TestData(String pN, String fC, String mM, String pass, String n) {
        phoneNum = pN;
        faveColor = fC;
        mothersMaiden = mM;
        password = pass;
        name = n;
    }

    public String getPassword() {
        return password;
    }

    public String getFaveColor() {
        return faveColor;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMothersMaiden() {
        return mothersMaiden;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public String getName() {
        return name;
    }
}

