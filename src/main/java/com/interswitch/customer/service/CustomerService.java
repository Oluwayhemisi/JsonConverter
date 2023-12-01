package com.interswitch.customer.service;

import com.interswitch.customer.dto.CustomerDto;
import com.interswitch.customer.dto.UpdateCustomerDto;
import com.interswitch.customer.exception.CustomerException;
import com.interswitch.customer.model.Customer;

import java.util.List;

public interface CustomerService {
     CustomerDto createCustomer(CustomerDto customerDto) throws CustomerException;

    Customer getCustomerById(String id) throws CustomerException;

    UpdateCustomerDto updateCustomer(String id, UpdateCustomerDto updateCustomerDto) throws CustomerException;
    List<Customer> getAllCustomers();
    void delete(String id) throws CustomerException;
}
