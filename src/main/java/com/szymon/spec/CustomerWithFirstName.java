package com.szymon.spec;

import com.szymon.model.Customer;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class CustomerWithFirstName implements Specification<Customer> {

    private String firstName;

    public CustomerWithFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
        if (firstName == null) {
            return cb.isTrue(cb.literal(true)); // always true = no filtering
        }
        return cb.equal(root.get("firstName"), this.firstName);
    }
}
