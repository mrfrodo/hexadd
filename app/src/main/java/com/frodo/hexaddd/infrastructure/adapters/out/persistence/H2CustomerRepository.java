package com.frodo.hexaddd.infrastructure.adapters.out.persistence;

import com.frodo.hexaddd.application.ports.out.CustomerRepositoryPort;
import com.frodo.hexaddd.domain.Customer;
import com.frodo.hexaddd.domain.CustomerId;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Repository
public class H2CustomerRepository implements CustomerRepositoryPort {

    private final JdbcTemplate jdbc;

    public H2CustomerRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public void save(Customer customer) {
        jdbc.update(
                "INSERT INTO customer (id, name) VALUES (?, ?)",
                customer.customerId().value().toString(),
                customer.name()
        );
    }

    @Override
    public Optional<Customer> findById(CustomerId id) {
        return jdbc.query(
                "SELECT id, name FROM customer WHERE id = ?",
                (rs, rowNum) -> new Customer.Builder()
                        .withName(rs.getString("name"))
                        .withId(CustomerId.from(UUID.fromString(rs.getString("id"))))
                        .build(),
                id.value().toString()
        ).stream().findFirst();
    }
}