package com.bajaj.jpalearning.controllers;

import com.bajaj.jpalearning.entities.Order;
import com.bajaj.jpalearning.pojo.ResponseHandler;
import com.bajaj.jpalearning.service.AddressService;
import com.bajaj.jpalearning.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/orders")
public class OrdersController {

    @Autowired
    OrdersService ordersService;


    @GetMapping("/{id}")
    public ResponseEntity<Object> get(@PathVariable Long id){
        return ResponseHandler.createResponse("order", HttpStatus.OK, ordersService.get(id));
    }

    @PostMapping("/")
    public ResponseEntity<Object> create(@RequestBody Order order){
        return ResponseHandler.createResponse("Order Placed", HttpStatus.CREATED, ordersService.create(order));
    }
}
