package com.bajaj.jpalearning.repositories;

import com.bajaj.jpalearning.entities.Address;
import com.bajaj.jpalearning.entities.Customer;
import com.bajaj.jpalearning.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {


}
