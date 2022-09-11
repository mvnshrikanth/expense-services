package com.mvnshrikanth.expenseservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mvnshrikanth.expenseservices.dto.ExpensesDto;
import com.mvnshrikanth.expenseservices.service.ExpenseService;

@RestController
@RequestMapping("/api")
public class ExpenseController {
	
	ExpenseService expenseService;

	@Autowired
	public ExpenseController(ExpenseService expenseService) {
		this.expenseService=expenseService;
	}

	@GetMapping(value = "/listallexpenses",produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<ExpensesDto>> listAllExpenses() {
		return new ResponseEntity<>(expenseService.listAllExpenses(), HttpStatus.OK);
	}

}
