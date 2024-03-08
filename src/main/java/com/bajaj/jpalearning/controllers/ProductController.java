package com.bajaj.jpalearning.controllers;

import com.bajaj.jpalearning.entities.Product;
import com.bajaj.jpalearning.pojo.ResponseHandler;
import com.bajaj.jpalearning.service.AddressService;
import com.bajaj.jpalearning.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

        @Autowired
        ProductService productService;


        @GetMapping("/")
        public ResponseEntity<Object> getAll(){
                return ResponseHandler.createResponse("Found Products",HttpStatus.OK, productService.getAll());
        }

        @PostMapping("/")
        public ResponseEntity<Object> create(@RequestBody Product product){
                Product newProduct = productService.create(product);
                return ResponseHandler.createResponse("product added",HttpStatus.CREATED, newProduct);
        }


}
