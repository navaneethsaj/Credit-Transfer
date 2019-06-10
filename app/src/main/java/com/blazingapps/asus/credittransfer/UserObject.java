package com.blazingapps.asus.credittransfer;

public class UserObject {
    String name;
    String email;
    Integer credit;

    public UserObject(String name, String email, Integer credit) {
        this.name = name;
        this.email = email;
        this.credit = credit;
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

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }
}
