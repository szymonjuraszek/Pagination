package com.szymon.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;

    private String status;

    public Customer() {
    }

    public Customer(String firstName, String status) {
        this.firstName = firstName;
        this.status = status;
    }
}
