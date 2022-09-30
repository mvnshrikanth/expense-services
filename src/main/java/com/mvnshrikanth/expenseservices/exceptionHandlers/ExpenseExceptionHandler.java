package com.mvnshrikanth.expenseservices.exceptionHandlers;

import com.mvnshrikanth.expenseservices.exceptions.ExpensesNotFoundException;
import com.mvnshrikanth.expenseservices.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ExpenseExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {ExpensesNotFoundException.class})
    public ResponseEntity<Object> handleExpenseNotFound(ExpensesNotFoundException expensesNotFoundException) {
        return new ResponseEntity<>(new ErrorResponse(expensesNotFoundException.getMessage(), HttpStatus.NOT_FOUND, LocalDateTime.now()),
                HttpStatus.NOT_FOUND);
    }
}
