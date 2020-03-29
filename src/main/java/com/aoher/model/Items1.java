package com.aoher.model;

import javax.persistence.*;

@Entity
@Table(name = "ITEMS")
public class Items1 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "item_id")
    private String itemId;

    @Column(name = "item_total")
    private double itemTotal;

    @Column(name="quantity")
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "cart_id", nullable = false)
    private Cart1 cart1;

    public Items1() {
    }

    public Items1(String itemId, double itemTotal, int quantity, Cart1 cart1) {
        this.itemId = itemId;
        this.itemTotal = itemTotal;
        this.quantity = quantity;
        this.cart1 = cart1;
    }

    public Items1(long id, String itemId, double itemTotal, int quantity, Cart1 cart1) {
        this(itemId, itemTotal, quantity, cart1);
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public double getItemTotal() {
        return itemTotal;
    }

    public void setItemTotal(double itemTotal) {
        this.itemTotal = itemTotal;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Cart1 getCart1() {
        return cart1;
    }

    public void setCart1(Cart1 cart1) {
        this.cart1 = cart1;
    }
}
