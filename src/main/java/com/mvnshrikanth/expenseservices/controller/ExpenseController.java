package com.mvnshrikanth.expenseservices.controller;

import com.mvnshrikanth.expenseservices.dto.ExpensesDto;
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

    @GetMapping(value = "/listallexpenses", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<ExpensesDto>> listAllExpenses() {
        return new ResponseEntity<>(expenseService.listAllExpenses(), HttpStatus.OK);
    }

    @PostMapping(value = "/addexepnse", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ExpensesDto> addExpense(@RequestBody ExpensesDto expensesDto) {
        return new ResponseEntity<>(expenseService.addExpense(expensesDto), HttpStatus.CREATED);
    }

    @PostMapping(value = "/updateexpense", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> updateExpense() {
        return new ResponseEntity<>("Edited", HttpStatus.OK);
    }

    @PostMapping(value = "/deleteexpense", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> deleteExepnse() {
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }


}