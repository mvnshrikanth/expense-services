package com.mvnshrikanth.expenseservices.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "expenses")
public class Expenses {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "expense_id")
    private Long expenseId;

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "item_cost")
    private Double itemCost;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "date_purchased")
    private String datePurchased;

    @Column(name = "store_name")
    private String storeName;

    @Column(name = "store_location")
    private String storeLocation;

}
