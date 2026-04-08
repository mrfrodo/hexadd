package com.frodo.hexaddd.infrastructure.adapters.out.messaging;

import com.frodo.hexaddd.application.ports.out.EventPublisherPort;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class SpringEventPublisher implements EventPublisherPort {

    private final ApplicationEventPublisher publisher;

    public SpringEventPublisher(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    @Override
    public void publish(Object event) {
        Objects.requireNonNull(event, "Event cannot be null");
        publisher.publishEvent(event);
    }

}
