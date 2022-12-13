package com.mvnshrikanth.expenseservices.controller;

import com.mvnshrikanth.expenseservices.model.ExpensesDto;
import com.mvnshrikanth.expenseservices.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ExpenseController {

    ExpenseService expenseService;

    @Autowired
    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping(value = "/getallexpenses", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<ExpensesDto>> getAllExpenses() {
        return new ResponseEntity<>(expenseService.getAllExpenses(), HttpStatus.OK);
    }

    @GetMapping(value = "/getexpense/{expenseId}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ExpensesDto> getExpense(@PathVariable Long expenseId) {
        return new ResponseEntity<>(expenseService.getExpense(expenseId), HttpStatus.OK);
    }

    @PostMapping(value = "/addexepnse", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ExpensesDto> addExpense(@RequestBody ExpensesDto expensesDto) {
        return new ResponseEntity<>(expenseService.addExpense(expensesDto), HttpStatus.CREATED);
    }

    @PostMapping(value = "/updateexpense", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> updateExpense() {
        return new ResponseEntity<>("Edited", HttpStatus.OK);
    }

    @PostMapping(value = "/deleteexpense/{expenseId}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ExpensesDto> deleteExpense(@PathVariable Long expenseId) {
        return new ResponseEntity<>(expenseService.deleteExpense(expenseId), HttpStatus.OK);
    }


}
