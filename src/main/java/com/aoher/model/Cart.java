package com.aoher.model;

import java.util.Set;

public class Cart {

    private long id;
    private double total;
    private String name;
    private Set<Items> items;

    public Cart() {
    }

    public Cart(long id, double total, String name, Set<Items> items) {
        this.id = id;
        this.total = total;
        this.name = name;
        this.items = items;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Items> getItems() {
        return items;
    }

    public void setItems(Set<Items> items) {
        this.items = items;
    }
}
