package com.frodo.hexaddd.application.ports.in;

import com.frodo.hexaddd.application.commands.CreateCustomerCommand;
import com.frodo.hexaddd.domain.CustomerId;

public interface CreateCustomerUseCasePort {
    CustomerId handle(CreateCustomerCommand command);
}