package com.bajaj.jpalearning.repositories;

import com.bajaj.jpalearning.entities.Customer;
import com.bajaj.jpalearning.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersRepository extends JpaRepository<Order, Long> {

    public List<Order> findByCustomer(Customer customer);

}
