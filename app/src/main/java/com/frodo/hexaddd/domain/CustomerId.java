package com.frodo.hexaddd.domain;

import java.util.Objects;
import java.util.UUID;

public record CustomerId(UUID value) {

    private static final UUID ZERO_UUID = new UUID(0L, 0L);

    public CustomerId {
        Objects.requireNonNull(value, "CustomerId cannot be null");
        if (value.equals(ZERO_UUID)) {
            throw new IllegalArgumentException("CustomerId cannot be all zeros");
        }
    }

    // Static factory method to generate a new CustomerId
    public static CustomerId newId() {
        return new CustomerId(UUID.randomUUID());
    }

    // Optional: factory from existing UUID
    public static CustomerId from(UUID uuid) {
        return new CustomerId(uuid);
    }
}
