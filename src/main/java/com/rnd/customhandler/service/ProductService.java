package com.rnd.customhandler.service;

import com.rnd.customhandler.constant.Constant;
import com.rnd.customhandler.model.Product;
import com.rnd.customhandler.model.ProductV2;
import com.rnd.customhandler.model.Response;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.regex.Pattern;

@Service
public class ProductService {

    public Response<Object> createV1(Product product) {
        String responseMessage = null;
        if (!Pattern.matches(Constant.Regex.ALPHANUMERIC_PATTERN, product.getName())) {
            responseMessage = Constant.ResponseMessage.INVALID_REQUEST.replace("{value}", "name");
        } else if (!Pattern.matches(Constant.Regex.NUMERIC_PATTERN, product.getQuantity())) {
            responseMessage = Constant.ResponseMessage.INVALID_REQUEST.replace("{value}", "quantity");
        }

        if(Objects.nonNull(responseMessage)) {
            return Response.builder()
                    .responseCode(Constant.ResponseCode.BAD_REQUEST_CODE)
                    .responseMessage(responseMessage)
                    .build();
        }

        return Response.builder()
                .responseCode(Constant.ResponseCode.SUCCESS_CODE)
                .responseMessage(Constant.ResponseMessage.SUCCESS_MESSAGE)
                .data(product)
                .build();
    }

    public Response<Object> createV2(ProductV2 productV2) {
        return Response.builder()
                .responseCode(Constant.ResponseCode.SUCCESS_CODE)
                .responseMessage(Constant.ResponseMessage.SUCCESS_MESSAGE)
                .data(productV2)
                .build();
    }
}
