package com.thomblweed.userservice.exception;

import java.util.Date;
import com.thomblweed.userservice.user.BadRequestException;
import com.thomblweed.userservice.user.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class ThomblweedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {

        ExceptionResponse exceptionResponse =
                new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));

        return new ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<Object> handleUserNotFoundException(
            UserNotFoundException userNotFoundException, WebRequest request) {

        ExceptionResponse userNotFoundExceptionResponse = new ExceptionResponse(new Date(),
                userNotFoundException.getMessage(), request.getDescription(false));

        return new ResponseEntity(userNotFoundExceptionResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestException.class)
    public final ResponseEntity<Object> handleBadRequestException(
            BadRequestException badRequestException, WebRequest request) {

        ExceptionResponse badRequestExceptionResponse = new ExceptionResponse(new Date(),
                badRequestException.getMessage(), request.getDescription(false));

        return new ResponseEntity(badRequestExceptionResponse, HttpStatus.BAD_REQUEST);
    }

    
}
