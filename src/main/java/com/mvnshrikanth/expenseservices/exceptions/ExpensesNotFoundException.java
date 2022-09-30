package com.mvnshrikanth.expenseservices.exceptions;

public class ExpensesNotFoundException extends RuntimeException {
    public ExpensesNotFoundException(String message) {
        super(message);
    }
}
