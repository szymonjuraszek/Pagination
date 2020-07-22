package com.szymon.spec;

import com.szymon.model.Customer;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class CustomerWithStatus implements Specification<Customer> {

    private String status;

    public CustomerWithStatus(String status) {
        this.status = status;
    }

    @Override
    public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
        if (status == null) {
            return cb.isTrue(cb.literal(true));
        }
        return cb.equal(root.get("status"), status);
    }
}
