package com.interswitch.customer.repository;

import com.interswitch.customer.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findCustomerByCustomerId(String id);
    Optional<Customer> findByPhoneNumber(String phoneNumber);
}
