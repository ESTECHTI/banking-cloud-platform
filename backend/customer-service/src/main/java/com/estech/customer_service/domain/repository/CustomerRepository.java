package com.estech.customer_service.domain.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.estech.customer_service.domain.model.Customer;

public interface CustomerRepository {

  Customer save(Customer customer);

  Optional<Customer> findById(UUID id);

  Optional<Customer> findByEmail(String email);

  List<Customer> findAll();

  void deleteById(UUID id);

  boolean existsByEmail(String email);

}
