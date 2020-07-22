package com.szymon;

import com.szymon.model.Customer;
import com.szymon.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApkaApplication implements CommandLineRunner {

    @Autowired
    private CustomerRepository customerRepository;

    public static void main(String[] args) {
        SpringApplication.run(ApkaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        customerRepository.save(new Customer("Sajmon1", "active1"));
        customerRepository.save(new Customer("Sajmon2", "active2"));
        customerRepository.save(new Customer("Sajmon3", "active3"));
        customerRepository.save(new Customer("Sajmon4", "active4"));
        customerRepository.save(new Customer("Sajmon5", "active5"));
        customerRepository.save(new Customer("Sajmon6", "active6"));
    }
}
