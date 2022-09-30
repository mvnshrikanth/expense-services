package com.mvnshrikanth.expenseservices.repositotry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mvnshrikanth.expenseservices.model.Expenses;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ExpensesRepository extends JpaRepository<Expenses, Long> {

}
