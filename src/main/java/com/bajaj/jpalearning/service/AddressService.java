package com.bajaj.jpalearning.service;

import com.bajaj.jpalearning.entities.Address;
import com.bajaj.jpalearning.entities.Customer;
import com.bajaj.jpalearning.exception.addressException.AddressNotFoundException;
import com.bajaj.jpalearning.exception.customerException.EntityNotFoundException;
import com.bajaj.jpalearning.repositories.AddressRepository;
import com.bajaj.jpalearning.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AddressRepository addressRepository;

    public List<Address> getAll(Long id){

        Optional<Customer> customer = customerRepository.findById(id);

        if(customer.isPresent()){
           List<Address> address = addressRepository.findByCustomer(customer.get());
           return  address;
        }
        throw new EntityNotFoundException("Address with given ID does not exist");

    }

    public Object create(Long id, Address address){
        Optional<Customer> customer = customerRepository.findById(id);


        if(customer.isPresent()){
            address.setCustomer(customer.get());
            addressRepository.save(address);
            return "address added";
        }
        throw new EntityNotFoundException("customer is not found to update address");
    }
}
