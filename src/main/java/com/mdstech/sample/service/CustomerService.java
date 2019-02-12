package com.mdstech.sample.service;

import com.mdstech.sample.domain.Customer;

import java.util.List;

public interface CustomerService {
    Customer save(Customer customer);
    List<Customer> getAll();
    Customer findById(Long id);
    void deleteAll();
    Customer findByFirstName(String firstName);
    List<Customer> findByLastName(String lastName);
}
