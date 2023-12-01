package com.interswitch.customer.service;

import com.interswitch.customer.dto.CustomerDto;
import com.interswitch.customer.dto.UpdateCustomerDto;
import com.interswitch.customer.exception.CustomerException;
import com.interswitch.customer.model.Customer;
import com.interswitch.customer.repository.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class CustomerServiceImpl implements  CustomerService{
    private final CustomerRepository customerRepository;


    private final ModelMapper modelMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository, ModelMapper modelMapper) {
        this.customerRepository = customerRepository;
        this.modelMapper = modelMapper;
    }


    public CustomerDto createCustomer(CustomerDto customerDto) throws CustomerException {
        if(customerRepository.findCustomerByCustomerId(customerDto.getCustomerId()).isPresent()){
            throw new CustomerException("Customer Id Exist",404);
        }
        if(customerRepository.findByPhoneNumber(customerDto.getPhoneNumber()).isPresent()){
            throw new CustomerException("Customer Number exist", 404);
        }
        Customer customer = new Customer();
        customer.setCustomerId(generateCustomerId());
        customer.setFullName(customerDto.getFullName());
        customer.setPhoneNumber(customerDto.getPhoneNumber());
        customer.setDateJoined(LocalDate.now());
        Customer customer1 = customerRepository.save(customer);
        return modelMapper.map(customer1,CustomerDto.class);

    }
    public Customer getCustomerById(String id) throws CustomerException {
        Customer customer = customerRepository.findCustomerByCustomerId(id).orElseThrow(()-> new CustomerException("Customer Id Does Not Exist",404));
            return customer;
    }


    public UpdateCustomerDto updateCustomer(String id, UpdateCustomerDto updateCustomerDto) throws CustomerException {
        Customer customer = customerRepository.findCustomerByCustomerId(id).orElseThrow(()-> new CustomerException("Customer Id Does Not Exist",404));
        Customer savedCustomer = modelMapper.map(updateCustomerDto,Customer.class);
        customer.setFullName(updateCustomerDto.getFullName());
        customer.setPhoneNumber(updateCustomerDto.getPhoneNumber());
        customer.setDateJoined(customer.getDateJoined());
        customerRepository.save(customer);
       return modelMapper.map(savedCustomer,UpdateCustomerDto.class);



    }
    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();

    }

    @Override
    public void delete(String id) throws CustomerException {
        Customer customer = customerRepository.findCustomerByCustomerId(id).orElseThrow(()-> new CustomerException("Customer Id Does Not Exist",404));
            customerRepository.delete(customer);

    }

    private String generateCustomerId(){
        int number = customerRepository.findAll().size();
        String id = String.format("%02d",number+1);
        return "Cust"+id;

    }




}
