package com.mvnshrikanth.expenseservices.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
@Entity
@Table(name = "expenses")
public class Expenses {

	@Id
	@Column(name = "expense_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long expenseId;

	@Column(name = "item_name")
	private String itemName;
	
	@Column(name="item_cost")
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
