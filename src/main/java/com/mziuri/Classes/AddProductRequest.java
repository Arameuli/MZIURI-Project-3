package com.mziuri.Classes;

public class AddProductRequest {
    private String password;
    private String name;
    private Integer amount;

    public AddProductRequest(String password, String name, Integer amount) {
        this.password = password;
        this.name = name;
        this.amount = amount;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
