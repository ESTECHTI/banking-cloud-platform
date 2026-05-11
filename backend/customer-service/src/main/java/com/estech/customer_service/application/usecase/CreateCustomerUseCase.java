package com.estech.customer_service.application.usecase;

import com.estech.customer_service.domain.model.Customer;
import com.estech.customer_service.domain.repository.CustomerRepository;

public class CreateCustomerUseCase {

  private final CustomerRepository customerRepository;

  public CreateCustomerUseCase(CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }

  public Customer execute(String name, String email) {
    if (customerRepository.existsByEmail(email)) {
      throw new IllegalArgumentException("Email already exists");
    }

    var customer = new Customer(name, email);

    return customerRepository.save(customer);
  }

}
