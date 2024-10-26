package com.cn.cnpayment.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import java.util.List;

/**
 * Modify the code to add one-to-one mapping between Payment and Payment Details.
 * Use Proper Annotations.
 * Add required getters and setters.
 */
@Entity
@Table(name="orders")
public class Orders {

    //add proper annotations for mapping a property as id, column etc.
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
    private int id;

	@Column
    private String name;

	@Column
    private String category;

	@Column
    private Integer quantity;

	@Column
    private Integer amount;

    //add proper annotation for establishing many-to-many relationship with Payment.
    @ManyToMany(fetch =  FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(
            name = "order_details",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "payment_id"))
    List<Payment> payments;


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    public Orders(String name, String category, Integer quantity, Integer amount) {

        this.name = name;
        this.category = category;
        this.quantity = quantity;
        this.amount = amount;
    }

    public Orders() {
    }

}
