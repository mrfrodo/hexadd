package com.frodo.hexaddd.domain;

import com.frodo.hexaddd.domain.events.CustomerCreatedEvent;
import com.frodo.hexaddd.domain.events.DomainEvent;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Customer {
    private final CustomerId customerId;
    private final String name;
    private final List<Opportunity> opportunities = new ArrayList<>();
    private final List<DomainEvent> domainEvents = new ArrayList<>();

    private Customer(Builder builder) {
        Objects.requireNonNull(builder.name, "Name cannot be null");
        if (builder.name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be blank");
        }
        if (builder.name.strip().length() > 10) {
            throw new IllegalArgumentException("Name cannot exceed 10 characters");
        }
        this.customerId = builder.customerId != null
                ? builder.customerId
                : CustomerId.newId();
        this.name = builder.name.strip();
        this.domainEvents.add(new CustomerCreatedEvent(this.customerId, this.name, Instant.now()));
    }

    public CustomerId customerId() {
        return customerId;
    }

    public String name() {
        return name;
    }

    public List<DomainEvent> domainEvents() {
        return List.copyOf(domainEvents);
    }

    public void clearDomainEvents() {
        domainEvents.clear();
    }

    public static class Builder {
        private CustomerId customerId;
        private String name;

        public Builder withId(CustomerId customerId) {
            this.customerId = customerId;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Customer build() {
            return new Customer(this);
        }
    }
}



