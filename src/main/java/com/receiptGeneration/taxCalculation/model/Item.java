package com.receiptGeneration.taxCalculation.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double price;
    private boolean isImported;
    private ItemCategory category;

    // Constructors, getters, and setters
    public Item() {}

    public Item(String name, double price, boolean isImported, ItemCategory category) {
        this.name = name;
        this.price = price;
        this.isImported = isImported;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public boolean isImported() {
        return isImported;
    }

    public ItemCategory getCategory() {
        return category;
    }
}
