package com.bajaj.jpalearning;

import com.bajaj.jpalearning.repositories.AddressRepository;
import com.bajaj.jpalearning.repositories.CustomerRepository;
import com.bajaj.jpalearning.repositories.OrdersRepository;
import com.bajaj.jpalearning.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaLearningApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaLearningApplication.class, args);
	}
}
