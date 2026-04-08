package com.frodo.hexaddd.application.commands;

import java.util.Objects;

public record CreateCustomerCommand(String name) {

    public CreateCustomerCommand {
        Objects.requireNonNull(name, "Name cannot be null");
        if (name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be blank");
        }
        if (name.strip().length() > 10) {
            throw new IllegalArgumentException("Name cannot exceed 10 characters");
        }
    }
}