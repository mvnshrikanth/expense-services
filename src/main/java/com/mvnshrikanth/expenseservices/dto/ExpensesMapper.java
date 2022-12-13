package com.mvnshrikanth.expenseservices.dto;

import com.mvnshrikanth.expenseservices.model.Expenses;
import com.mvnshrikanth.expenseservices.model.ExpensesDto;

import java.math.BigDecimal;

public class ExpensesMapper {

	private ExpensesMapper() {
		throw new IllegalStateException("Mapper Utility class");
	}

	public static ExpensesDto expensesToExpensesDto(Expenses expenses) {
		ExpensesDto expensesDto = new ExpensesDto();
		expensesDto.setExpenseId(expenses.getExpenseId());
		expensesDto.setItemName(expenses.getItemName());
		expensesDto.setDatePurchased(expenses.getDatePurchased());
		expensesDto.setQuantity(expenses.getQuantity());
		expensesDto.setStoreLocation(expenses.getStoreLocation());
		expensesDto.setStoreName(expenses.getStoreName());
		expensesDto.setItemCost(BigDecimal.valueOf(expenses.getItemCost()));
		return expensesDto;
	}

	public static Expenses expensesDtoToExpenses(ExpensesDto expensesDto) {
		Expenses expenses = new Expenses();
		expenses.setDatePurchased(expensesDto.getDatePurchased());
		expenses.setItemCost(expensesDto.getItemCost().doubleValue());
		expenses.setItemName(expensesDto.getItemName());
		expenses.setQuantity(expensesDto.getQuantity());
		expenses.setStoreLocation(expensesDto.getStoreLocation());
		expenses.setStoreName(expensesDto.getStoreName());
		expenses.setExpenseId(expensesDto.getExpenseId());
		return expenses;
	}

}
