package com.aoher.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "CART")
public class Cart1 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private long id;

    @Column(name = "total")
    private double total;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "cart1")
    private Set<Items1> items1;

    public Cart1() {
    }

    public Cart1(double total, String name, Set<Items1> items1) {
        this.total = total;
        this.name = name;
        this.items1 = items1;
    }

    public Cart1(long id, double total, String name, Set<Items1> items1) {
        this(total, name, items1);
        this.id = id;
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

    public Set<Items1> getItems1() {
        return items1;
    }

    public void setItems1(Set<Items1> items1) {
        this.items1 = items1;
    }
}
