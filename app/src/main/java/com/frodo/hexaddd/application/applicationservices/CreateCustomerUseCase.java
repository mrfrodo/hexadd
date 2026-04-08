package com.frodo.hexaddd.application.applicationservices;

import com.frodo.hexaddd.application.commands.CreateCustomerCommand;
import com.frodo.hexaddd.application.ports.in.CreateCustomerUseCasePort;
import com.frodo.hexaddd.application.ports.out.CustomerRepositoryPort;
import com.frodo.hexaddd.domain.Customer;
import com.frodo.hexaddd.domain.CustomerId;

public class CreateCustomerUseCase implements CreateCustomerUseCasePort {

    private final CustomerRepositoryPort customerRepository;

    public CreateCustomerUseCase(CustomerRepositoryPort customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public CustomerId handle(CreateCustomerCommand command) {
        Customer customer = new Customer.Builder()
                .withName(command.name())
                .build();

        customerRepository.save(customer);

        return customer.customerId();
    }

}
