package com.mvnshrikanth.expenseservices.service;

import com.mvnshrikanth.expenseservices.dto.ExpensesDto;
import com.mvnshrikanth.expenseservices.dto.mapper.ExpensesMapper;
import com.mvnshrikanth.expenseservices.exceptions.ExpensesNotFoundException;
import com.mvnshrikanth.expenseservices.model.Expenses;
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

    public List<ExpensesDto> listAllExpenses() {
        List<Expenses> expensesResult = expensesRepository.findAll();
        if (expensesResult.isEmpty()) {
            throw new ExpensesNotFoundException("No expenses available.");
        }

        return expensesResult.stream().map(ExpensesMapper::expensesToExpensesDto).toList();
    }

    public ExpensesDto addExpense(ExpensesDto expensesDto) {
        return ExpensesMapper.expensesToExpensesDto(expensesRepository.save(ExpensesMapper.expensesDtoToExpenses(expensesDto)));
    }

}
