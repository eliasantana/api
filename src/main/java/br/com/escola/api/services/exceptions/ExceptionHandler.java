package br.com.escola.api.services.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(NotFoundException.class)
    public ResponseEntity<StandardError>notFoundExcelption(NotFoundException ex, HttpServletRequest request){
        StandardError error = new StandardError(System.currentTimeMillis(),
                HttpStatus.NOT_FOUND.value(),"ObjectNotFound",ex.getMessage(),request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);

    }

    @org.springframework.web.bind.annotation.ExceptionHandler(org.springframework.web.bind.MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError>methodArgumentNotValidException(
            org.springframework.web.bind.MethodArgumentNotValidException ex, HttpServletRequest request){
            StandardError error = new StandardError(System.currentTimeMillis(),
                    HttpStatus.BAD_REQUEST.value(), "Bad Request", ex.getFieldError().getDefaultMessage(), request.getRequestURI());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<StandardError> constraintViolationException(ConstraintViolationException ex, HttpServletRequest request){
        StandardError error = new StandardError(
            System.currentTimeMillis(),HttpStatus.BAD_REQUEST.value(), "Bad Request",ex.getConstraintViolations().toString(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

}
