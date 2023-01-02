package com.mvnshrikanth.expenseservices.repositotry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mvnshrikanth.expenseservices.model.Expenses;

public interface ExpensesRepository extends JpaRepository<Expenses, Long> {
    Expenses findByExpenseId(Long expenseId);
    Long deleteByExpenseId(Long expenseId);
}
