package com.mvnshrikanth.expenseservices.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ExpensesDto {

	private Long expenseId;
	private String itemName;
	private BigDecimal itemCost;
	private int quantity;
	private String datePurchased;
	private String storeName;
	private String storeLocation;

}
