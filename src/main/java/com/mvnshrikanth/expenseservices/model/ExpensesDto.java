package com.mvnshrikanth.expenseservices.model;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Data
public class ExpensesDto {

    @NotNull(message = "Please pass an ID")
    private Long expenseId;
    @NotNull(message = "Please pass an Item Name")
    @Size(min = 5, message = "Should be greater than 5")
    private String itemName;
    @NotNull(message = "Please pass the item cost")
    private BigDecimal itemCost;
    @NotNull(message = "Please pass the quantity")
    private int quantity;
    @NotNull(message = "Please pass the date")
    private String datePurchased;
    private String storeName;
    private String storeLocation;

}
