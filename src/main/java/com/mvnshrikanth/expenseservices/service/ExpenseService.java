package com.mvnshrikanth.expenseservices.service;

import com.mvnshrikanth.expenseservices.dto.ExpensesMapper;
import com.mvnshrikanth.expenseservices.exceptions.ExpensesNotFoundException;
import com.mvnshrikanth.expenseservices.model.Expenses;
import com.mvnshrikanth.expenseservices.model.ExpensesDto;
import com.mvnshrikanth.expenseservices.repositotry.ExpensesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.mvnshrikanth.expenseservices.util.APIConstants.NO_EXPENSE_AVAILABLE_FOR_EXPENSE_ID;

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
            throw new ExpensesNotFoundException(String.format(NO_EXPENSE_AVAILABLE_FOR_EXPENSE_ID, expenseId));
        }
        return ExpensesMapper.expensesToExpensesDto(expensesRepository.findByExpenseId(expenseId));
    }

    public ExpensesDto addExpense(ExpensesDto expensesDto) {
        return ExpensesMapper.expensesToExpensesDto(expensesRepository.save(ExpensesMapper.expensesDtoToExpenses(expensesDto)));
    }

    @Transactional
    public String deleteExpense(Long expenseId) {
        long rowsDeleted = expensesRepository.deleteByExpenseId(expenseId);
        if (rowsDeleted == 0) {
            throw new ExpensesNotFoundException(String.format(NO_EXPENSE_AVAILABLE_FOR_EXPENSE_ID, expenseId));
        }
        return String.format("Expense deleted for Expense ID: %d", expenseId);
    }

    public ExpensesDto updateExpense(ExpensesDto expensesDto) {
        Expenses expense = expensesRepository.findByExpenseId(expensesDto.getExpenseId());
        if (expense == null) {
            throw new ExpensesNotFoundException(String.format(NO_EXPENSE_AVAILABLE_FOR_EXPENSE_ID, expensesDto.getExpenseId()));
        }
        return ExpensesMapper.expensesToExpensesDto(expensesRepository.save(ExpensesMapper.expensesDtoToExpenses(expensesDto)));
    }
}
