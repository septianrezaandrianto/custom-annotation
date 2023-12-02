package com.rnd.customhandler.controller;

import com.rnd.customhandler.constant.Constant;
import com.rnd.customhandler.model.Product;
import com.rnd.customhandler.model.ProductV2;
import com.rnd.customhandler.model.Response;
import com.rnd.customhandler.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping(value = "/v1/create")
    public ResponseEntity<Response<Object>> createV1(@RequestBody Product product) {
        Response<Object> response = productService.createV1(product);

        if(response.getResponseCode() != Constant.ResponseCode.SUCCESS_CODE) {
            return ResponseEntity.badRequest().body(response);
        }
        return ResponseEntity.ok(response);
    }

    @PostMapping(value = "/v2/create")
    public ResponseEntity<Response<Object>> createV2(@Validated @RequestBody ProductV2 productV2) {
        return ResponseEntity.ok(productService.createV2(productV2));
    }
}
