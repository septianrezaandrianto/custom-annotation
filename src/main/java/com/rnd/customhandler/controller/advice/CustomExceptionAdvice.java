package com.rnd.customhandler.controller.advice;

import com.rnd.customhandler.exception.BadRequestException;
import com.rnd.customhandler.model.Response;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionAdvice {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BadRequestException.class)
    public Response<Object> badRequestHandler(BadRequestException ex) {
        return Response.builder()
                .responseCode(ex.getResponseCode())
                .responseMessage(ex.getResponseMessage())
                .build();
    }


}
