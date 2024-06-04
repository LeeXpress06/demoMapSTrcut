package com.mapStruct.demoMapSTrcut;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHAndler {

    @ExceptionHandler(ResourceNotFound.class)
    public ErrorDetails resourceNotFOundException(ResourceNotFound exception , WebRequest webRequest){

        ErrorDetails errorDetails = new ErrorDetails(exception.getMessage()
                ,webRequest.getDescription(false),"user not found", LocalDateTime.now());

        return errorDetails;
    }

}
