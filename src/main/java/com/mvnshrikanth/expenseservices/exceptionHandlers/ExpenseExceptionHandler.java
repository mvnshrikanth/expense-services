package com.mvnshrikanth.expenseservices.exceptionhandlers;

import com.mvnshrikanth.expenseservices.exceptions.ExpensesNotFoundException;
import com.mvnshrikanth.expenseservices.model.ErrorResponse;
import com.mvnshrikanth.expenseservices.util.Utils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExpenseExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {ExpensesNotFoundException.class})
    public ResponseEntity<Object> handleExpenseNotFound(ExpensesNotFoundException expensesNotFoundException) {
        return new ResponseEntity<>(new ErrorResponse(expensesNotFoundException.getMessage(), HttpStatus.NOT_FOUND, Utils.today()),
                HttpStatus.NOT_FOUND);
    }
}
