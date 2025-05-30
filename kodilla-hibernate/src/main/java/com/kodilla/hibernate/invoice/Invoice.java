package com.kodilla.hibernate.invoice;

import javax.persistence.Id;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "INVOICES")
public class Invoice {
    @Id
    @GeneratedValue
    private int id;

    @Column(name = "NUMBER")
    private String number;

    @OneToMany(
            targetEntity = Item.class,
            mappedBy = "invoice",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Item> items = new ArrayList<>();

    public Invoice() {}

    public Invoice(String number) {
        this.number = number;
    }

    // Gettery i settery
    public int getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void addItem(Item item) {
        items.add(item);
        item.setInvoice(this);
    }
}
