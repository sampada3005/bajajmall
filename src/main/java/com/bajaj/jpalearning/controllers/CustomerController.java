package com.bajaj.jpalearning.controllers;

import com.bajaj.jpalearning.entities.Customer;
import com.bajaj.jpalearning.pojo.ErrorBean;
import com.bajaj.jpalearning.pojo.ResponseHandler;
import com.bajaj.jpalearning.repositories.CustomerRepository;
import com.bajaj.jpalearning.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController
{
    @Autowired
    CustomerService customerService;

    @GetMapping("/")
    public ResponseEntity<Object> getAll(){
        return ResponseHandler.createResponse("Found Customers",HttpStatus.OK, customerService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCustomer(@PathVariable Long id){

        Customer customer = customerService.getItem(id);
        return ResponseHandler.createResponse("customer available",HttpStatus.OK, customer);

    }

    @PostMapping("/")
    public ResponseEntity<Object> create (@RequestBody Customer customer){

        Object response = customerService.create(customer);
        return ResponseHandler.createResponse("customer created successfully",HttpStatus.CREATED, response);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCustomer(@PathVariable Long id){

        String deletedResponse =  customerService.delete(id);
        return ResponseHandler.createResponse("customer deleted successfully", HttpStatus.OK, deletedResponse);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@RequestBody Customer customer, @PathVariable Long id){
        Object response = customerService.update(id, customer);
        return ResponseHandler.createResponse("customer updated", HttpStatus.CREATED, response);
    }
}
