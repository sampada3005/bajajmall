package com.bajaj.jpalearning.service;

import com.bajaj.jpalearning.entities.Address;
import com.bajaj.jpalearning.entities.Customer;
import com.bajaj.jpalearning.entities.Order;
import com.bajaj.jpalearning.entities.Product;
import com.bajaj.jpalearning.exception.customerException.EntityNotFoundException;
import com.bajaj.jpalearning.repositories.AddressRepository;
import com.bajaj.jpalearning.repositories.CustomerRepository;
import com.bajaj.jpalearning.repositories.OrdersRepository;
import com.bajaj.jpalearning.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrdersService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private ProductRepository productRepository;

    public Order create(Order order){
        Optional<Product> product = productRepository.findById(order.getProduct().getId());
        Optional<Customer> customer = customerRepository.findById(order.getCustomer().getId());

        if(product.isPresent() && customer.isPresent() && order.getQuantity() > 0){
            return ordersRepository.save(order);
        }
        throw new EntityNotFoundException("product or customer does not exist");
    }

    public List<Order> get(Long id){

        Optional<Customer> customer = customerRepository.findById(id);

        if(customer.isPresent()){
            List<Order> orders = ordersRepository.findByCustomer(customer.get());
            return orders;
        }
        throw new EntityNotFoundException("order does not exist");

    }

}
