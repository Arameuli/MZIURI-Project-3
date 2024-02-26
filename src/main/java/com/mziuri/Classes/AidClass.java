package com.mziuri.Classes;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class AidClass {
    private String password;
    private ArrayList<Product> arrayList;
    @JsonCreator
    public AidClass(
           @JsonProperty("password") String password,
           @JsonProperty("products") ArrayList<Product> arrayList) {
        this.password = password;
        this.arrayList = arrayList;
    }

    public String getPassword() {
        return password;
    }

    public ArrayList<Product> getArrayList() {
        return arrayList;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setArrayList(ArrayList<Product> arrayList) {
        this.arrayList = arrayList;
    }
}
