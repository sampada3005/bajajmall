package com.bajaj.jpalearning.service;

import com.bajaj.jpalearning.entities.Address;
import com.bajaj.jpalearning.entities.Customer;
import com.bajaj.jpalearning.exception.customerException.CustomerAlreadyExistException;
import com.bajaj.jpalearning.exception.customerException.CustomerDoesNotExistException;
import com.bajaj.jpalearning.exception.customerException.EntityNotFoundException;
import com.bajaj.jpalearning.repositories.AddressRepository;
import com.bajaj.jpalearning.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AddressRepository addressRepository;

    public List<Customer> getAll(){
        return customerRepository.findAll();
    }

    public Customer getItem(Long id){
        Optional<Customer> customer = customerRepository.findById(id);
        if(customer.isPresent()){

            List<Address> addressed = addressRepository.findByCustomer(customer.get());
            customer.get().setAddressed(addressed);
            return customer.get();


        }
        throw new EntityNotFoundException("Customer with given ID does not exist");
    }

    public Customer create(Customer customer){
        if(customerRepository.findByEmailId(customer.getEmailId()).isEmpty()){
            Customer newCustomer = customerRepository.save(customer);
            newCustomer.setPassword(null);
            return newCustomer;
        }
        throw  new CustomerAlreadyExistException("customer with same email id already exist");
    }

    public String delete(Long id){
        if(customerRepository.findById(id).isPresent()){
           customerRepository.deleteById(id);
           return "customer deleted successfully";
        }
        throw new CustomerDoesNotExistException("customer does not exist");
    }

    public Customer update(Long id, Customer customer){
        if(customerRepository.findById(id).isPresent()){
            customerRepository.save(customer);
        }
        throw new CustomerDoesNotExistException("customer does not exist");
    }



}
