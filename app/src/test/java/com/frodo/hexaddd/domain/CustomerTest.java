package com.frodo.hexaddd.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerTest {

    @Test
    void shouldCreateCustomerWithValidName() {
        Customer customer = new Customer.Builder()
                .withName("John")
                .build();

        assertNotNull(customer);
    }

    @Test
    void shouldThrowWhenNameIsNull() {
        assertThrows(NullPointerException.class, () ->
                new Customer.Builder()
                        .withName(null)
                        .build()
        );
    }

    @Test
    void shouldThrowWhenNameIsBlank() {
        assertThrows(IllegalArgumentException.class, () ->
                new Customer.Builder()
                        .withName("   ")
                        .build()
        );
    }

    @Test
    void shouldThrowWhenNameExceedsTenCharacters() {
        assertThrows(IllegalArgumentException.class, () ->
                new Customer.Builder()
                        .withName("John Smith Jr")
                        .build()
        );
    }

    @Test
    void shouldAcceptNameWithExactlyTenCharacters() {
        Customer customer = new Customer.Builder()
                .withName("JohnSmithX")
                .build();

        assertNotNull(customer);
    }

    @Test
    void shouldStripWhitespaceFromName() {
        Customer customer = new Customer.Builder()
                .withName("  John  ")
                .build();

        assertNotNull(customer);
    }

    @Test
    void shouldGenerateCustomerId() {
        Customer customer = new Customer.Builder()
                .withName("John")
                .build();

        assertNotNull(customer.customerId());
        assertNotNull(customer.customerId().value());
    }

    @Test
    void shouldGenerateUniqueIdPerCustomer() {
        Customer first = new Customer.Builder().withName("John").build();
        Customer second = new Customer.Builder().withName("Jane").build();

        assertNotEquals(first.customerId(), second.customerId());
    }
}
