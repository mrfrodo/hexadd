package com.frodo.hexaddd.application.ports.out;

public interface EventPublisherPort {

    void publish(Object event);

}
