package com.mapsTree.account.controller.error;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Object> handleUserAlreadyExists(HttpServletRequest request,DataIntegrityViolationException ex){
        String error = "User Already exists! ";
        return buildResponseEntity(new ErrorResponse(HttpStatus.CONFLICT, error));
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<Object> handMissingUser(HttpServletRequest request, NullPointerException ex){
        String error = "User Does not exist! ";
        return buildResponseEntity(new ErrorResponse(HttpStatus.NOT_FOUND,error));
    }

    private ResponseEntity<Object> buildResponseEntity(ErrorResponse errorResponse){
         return new ResponseEntity<Object>(errorResponse, errorResponse.getStatus());
    }

}
