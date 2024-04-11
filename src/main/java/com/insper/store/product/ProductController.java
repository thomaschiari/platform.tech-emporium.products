package com.insper.store.product;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestHeader;

import io.swagger.annotations.ApiOperation;


@FeignClient(name = "store-product")
public interface ProductController {

    @ApiOperation(value = "Create a new product")
    @PostMapping("/products")
    public ResponseEntity<ProductOut> create(
        @RequestBody(required = true) ProductIn in
    );

    @ApiOperation(value = "Update a product by id")
    @PutMapping("/products/{id}")
    public ResponseEntity<ProductOut> update(
        @PathVariable(required = true) Integer id,
        @RequestBody(required = true) ProductIn in
    );

    @ApiOperation(value = "Get a product by id")
    @GetMapping("/products/{id}")
    public ResponseEntity<ProductOut> read(
        @PathVariable(required = true) Integer id
    );

    @ApiOperation(value = "Get all products")
    @GetMapping("/products")
    ResponseEntity<List<ProductOut>> readAll();

}
