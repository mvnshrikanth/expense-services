package com.mvnshrikanth.expenseservices.model;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ErrorResponse {
   private String errorMessage;
   private HttpStatus httpStatus;
   private LocalDateTime localDateTime;
}
