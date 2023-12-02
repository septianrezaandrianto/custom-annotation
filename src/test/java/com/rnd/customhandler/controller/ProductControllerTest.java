package com.rnd.customhandler.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.rnd.customhandler.constant.Constant;
import com.rnd.customhandler.model.Product;
import com.rnd.customhandler.model.Response;
import com.rnd.customhandler.service.ProductService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ProductController.class)
public class ProductControllerTest {

    @MockBean
    private ProductService productService;
    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("should return /v1/create success")
    public void createV1_success() throws Exception {
        Product product = new Product("Kecap Botol", "5");

        when(productService.createV1(product))
                .thenReturn(responseMapping(Constant.ResponseCode.SUCCESS_CODE,
                        Constant.ResponseMessage.SUCCESS_MESSAGE, product));

        MockHttpServletResponse result = mockMvc.perform(MockMvcRequestBuilders
                        .post("/product/v1/create")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .characterEncoding("utf-8")
                        .content(new Gson().toJson(product)))
                .andReturn().getResponse();

        assertEquals(Constant.ResponseCode.SUCCESS_CODE, result.getStatus());
    }

    @Test
    @DisplayName("should return /v1/create invalid request")
    public void createV1_invalid_request() throws Exception {
        Product product = new Product("Kecap Botol$", "5");

        when(productService.createV1(product))
                .thenReturn(responseMapping(Constant.ResponseCode.BAD_REQUEST_CODE,
                        Constant.ResponseMessage.INVALID_REQUEST.replace("{value}", "name"), product));

        MockHttpServletResponse result = mockMvc.perform(MockMvcRequestBuilders
                        .post("/product/v1/create")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .characterEncoding("utf-8")
                        .content(new Gson().toJson(product)))
                .andReturn().getResponse();

        assertEquals(Constant.ResponseCode.BAD_REQUEST_CODE, result.getStatus());
    }

    @Test
    @DisplayName("should return /v2/create success")
    public void createV2_success() throws Exception {
        Product product = new Product("Kopi Hitam", "5");

        when(productService.createV1(product))
                .thenReturn(responseMapping(Constant.ResponseCode.SUCCESS_CODE,
                        Constant.ResponseMessage.SUCCESS_MESSAGE, product));

        MockHttpServletResponse result = mockMvc.perform(MockMvcRequestBuilders
                        .post("/product/v2/create")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .characterEncoding("utf-8")
                        .content(new Gson().toJson(product)))
                .andReturn().getResponse();

        assertEquals(Constant.ResponseCode.SUCCESS_CODE, result.getStatus());
    }

    private Response<Object> responseMapping(Integer responseCode, String responseMessage, Object obj) {
        return Response.builder()
                .responseCode(responseCode)
                .responseMessage(responseMessage)
                .data(obj)
                .build();
    }
}
