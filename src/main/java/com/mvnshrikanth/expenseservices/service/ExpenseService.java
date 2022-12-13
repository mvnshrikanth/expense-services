package com.mvnshrikanth.expenseservices.service;

import com.mvnshrikanth.expenseservices.dto.ExpensesMapper;
import com.mvnshrikanth.expenseservices.exceptions.ExpensesNotFoundException;
import com.mvnshrikanth.expenseservices.model.Expenses;
import com.mvnshrikanth.expenseservices.model.ExpensesDto;
import com.mvnshrikanth.expenseservices.repositotry.ExpensesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {

    ExpensesRepository expensesRepository;

    @Autowired
    public ExpenseService(ExpensesRepository expensesRepository) {
        this.expensesRepository = expensesRepository;
    }

    public List<ExpensesDto> getAllExpenses() {
        List<Expenses> expensesResult = expensesRepository.findAll();
        if (expensesResult.isEmpty()) {
            throw new ExpensesNotFoundException("No expenses available.");
        }

        return expensesResult.stream().map(ExpensesMapper::expensesToExpensesDto).toList();
    }

    public ExpensesDto getExpense(Long expenseId) {
        Expenses expense = expensesRepository.findByExpenseId(expenseId);
        if (expense == null) {
            throw new ExpensesNotFoundException(String.format("No expense available for expense ID: %d", expenseId));
        }
        return ExpensesMapper.expensesToExpensesDto(expensesRepository.findByExpenseId(expenseId));
    }

    public ExpensesDto addExpense(ExpensesDto expensesDto) {
        return ExpensesMapper.expensesToExpensesDto(expensesRepository.save(ExpensesMapper.expensesDtoToExpenses(expensesDto)));
    }

    public ExpensesDto deleteExpense(Long expenseId) {
        return ExpensesMapper.expensesToExpensesDto(expensesRepository.deleteByExpenseId(expenseId));
    }
}
