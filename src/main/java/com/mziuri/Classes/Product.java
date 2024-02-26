package com.mziuri.Classes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name="product")
public class Product {
    @Id
    @Column(name="prod_id")
    private int id;
    @Column(name="prod_name")
    private String name;
    @Column(name="prod_price")
    private float price;
    @Column(name="prod_amount")
    private int amount;

    public Product(){

    }
    public Product(int id, String name, float price, int amount) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
