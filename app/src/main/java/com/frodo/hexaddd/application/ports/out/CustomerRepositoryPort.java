package com.frodo.hexaddd.application.ports.out;

import com.frodo.hexaddd.domain.Customer;
import com.frodo.hexaddd.domain.CustomerId;

import java.util.Optional;

public interface CustomerRepositoryPort {
    void save(Customer customer);
    Optional<Customer> findById(CustomerId id);
}
