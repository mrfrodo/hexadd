package com.frodo.hexaddd.domain.events;

import com.frodo.hexaddd.domain.CustomerId;
import java.time.Instant;

public record CustomerCreatedEvent(CustomerId customerId, String name, Instant occurredOn)
        implements DomainEvent {}