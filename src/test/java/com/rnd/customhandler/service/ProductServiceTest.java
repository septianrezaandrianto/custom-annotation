package com.rnd.customhandler.service;

import com.rnd.customhandler.constant.Constant;
import com.rnd.customhandler.model.Product;
import com.rnd.customhandler.model.ProductV2;
import com.rnd.customhandler.model.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class ProductServiceTest {

    @InjectMocks
    private ProductService productService;

    @Test
    @DisplayName("should return createV1 success")
    public void createV1_success() {
        Response<Object> result = productService.createV1(new Product("Kecap Botol", "5"));
        assertEquals(Constant.ResponseCode.SUCCESS_CODE, result.getResponseCode());
        assertEquals(Constant.ResponseMessage.SUCCESS_MESSAGE, result.getResponseMessage());
        assertEquals(new Product("Kecap Botol", "5"), result.getData());
    }

    @Test
    @DisplayName("should return createV1 invalid field format name")
    public void createV1_invalid_format_name() {
        Response<Object> result = productService.createV1(new Product("Kecap Botol#$", "5"));
        assertEquals(Constant.ResponseCode.BAD_REQUEST_CODE, result.getResponseCode());
        assertEquals(Constant.ResponseMessage.INVALID_REQUEST.replace("{value}", "name"),
                result.getResponseMessage());
        assertEquals(null, result.getData());
    }

    @Test
    @DisplayName("should return createV1 invalid field format quantity")
    public void createV1_invalid_format_quantity() {
        Response<Object> result = productService.createV1(new Product("Kecap Botol", "%200"));
        assertEquals(Constant.ResponseCode.BAD_REQUEST_CODE, result.getResponseCode());
        assertEquals(Constant.ResponseMessage.INVALID_REQUEST.replace("{value}", "quantity"),
                result.getResponseMessage());
        assertEquals(null, result.getData());
    }


    @Test
    @DisplayName("should return createV2 success")
    public void createV2_success() {
        Response<Object> result = productService.createV2(new ProductV2("Kopi Hitam", "100"));
        assertEquals(Constant.ResponseCode.SUCCESS_CODE, result.getResponseCode());
        assertEquals(Constant.ResponseMessage.SUCCESS_MESSAGE, result.getResponseMessage());
        assertEquals(new ProductV2("Kopi Hitam", "100"), result.getData());
    }

}
