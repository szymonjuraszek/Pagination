package com.szymon.controller;

import com.szymon.model.Customer;
import com.szymon.repository.CustomerRepository;
import com.szymon.spec.CustomerWithFirstName;
import com.szymon.spec.CustomerWithStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepo;

    @GetMapping
    public Page<Customer> findCustomers(
            @RequestParam("firstName") String firstName,
            @RequestParam(required = false) String status,
            Pageable pageable
    ) {

        System.out.println("Przed specyfikacja");
        System.out.println(pageable);
        Specification<Customer> spec = Specification.where(new CustomerWithFirstName(firstName))
                .and(new CustomerWithStatus(status));

        Page<Customer> result = customerRepo.findAll(spec, pageable);

        return result;
    }

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello world";
    }


}
