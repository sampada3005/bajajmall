package com.bajaj.jpalearning.controllers;

import com.bajaj.jpalearning.entities.Address;
import com.bajaj.jpalearning.pojo.ResponseHandler;
import com.bajaj.jpalearning.service.AddressService;
import com.bajaj.jpalearning.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/addresses")
public class AddressController {

    @Autowired
    AddressService addressService;


    @GetMapping("/{id}")
    public ResponseEntity<Object> getAll(@PathVariable Long id){
        return ResponseHandler.createResponse("found addressed", HttpStatus.OK, addressService.getAll(id));
    }

    @PostMapping("/{id}")
    public ResponseEntity<Object> create(@PathVariable Long id, @RequestBody Address address){
        return ResponseHandler.createResponse("address added", HttpStatus.CREATED, addressService.create(id, address));
    }
}
