package com.bajaj.jpalearning.service;

import com.bajaj.jpalearning.entities.Address;
import com.bajaj.jpalearning.entities.Customer;
import com.bajaj.jpalearning.entities.Product;
import com.bajaj.jpalearning.exception.addressException.AddressNotFoundException;
import com.bajaj.jpalearning.exception.customerException.EntityNotFoundException;
import com.bajaj.jpalearning.repositories.CustomerRepository;
import com.bajaj.jpalearning.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProductRepository productRepository;


    public List<Product> getAll(){
        return productRepository.findAll();
    }

    public Product create(Product product){
        return productRepository.save(product);
    }

}

