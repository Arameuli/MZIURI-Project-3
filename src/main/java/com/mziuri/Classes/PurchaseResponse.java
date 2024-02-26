package com.mziuri.Classes;

public class PurchaseResponse {
    private String name;
    private Integer remainingAmount;

    public PurchaseResponse(String name, Integer remainingAmount) {
        this.name = name;
        this.remainingAmount = remainingAmount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRemainingAmount() {
        return remainingAmount;
    }

    public void setRemainingAmount(Integer remainingAmount) {
        this.remainingAmount = remainingAmount;
    }
}
