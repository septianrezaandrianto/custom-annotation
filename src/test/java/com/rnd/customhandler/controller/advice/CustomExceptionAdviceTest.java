package com.rnd.customhandler.controller.advice;

import com.rnd.customhandler.constant.Constant;
import com.rnd.customhandler.exception.BadRequestException;
import com.rnd.customhandler.model.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.*;
public class CustomExceptionAdviceTest {

    private final CustomExceptionAdvice customExceptionAdvice = new CustomExceptionAdvice();

    @Test
    @DisplayName("should return testBadRequestHandler success")
    void testBadRequestHandler() {
        BadRequestException exception = BadRequestException.builder()
                .responseCode(Constant.ResponseCode.BAD_REQUEST_CODE)
                .responseMessage(Constant.ResponseMessage.INVALID_REQUEST)
                .build();

        Response<Object> response = customExceptionAdvice.badRequestHandler(exception);
        assertEquals(HttpStatus.BAD_REQUEST.value(), response.getResponseCode());
        assertEquals(Constant.ResponseMessage.INVALID_REQUEST, response.getResponseMessage());
    }
}
