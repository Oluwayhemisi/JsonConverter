package com.interswitch.customer.controller;


import com.interswitch.customer.dto.ApiResponse;
import com.interswitch.customer.dto.CustomerDto;
import com.interswitch.customer.dto.UpdateCustomerDto;
import com.interswitch.customer.exception.CustomerException;
import com.interswitch.customer.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping(value = "customers/createCustomer")
    ResponseEntity<Object> createCustomers(@RequestBody CustomerDto customer) throws CustomerException {
        CustomerDto customerDto = customerService.createCustomer(customer);
        ApiResponse apiResponse = ApiResponse.builder()
                .message("Success")
                .data(customerDto)
                .build();
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @GetMapping(value = "customers/{id}")
    public ResponseEntity<Object> getCustomer(@PathVariable("id") String id) throws CustomerException {
        return new ResponseEntity<>(customerService.getCustomerById(id), HttpStatus.OK);
    }

    @PutMapping(value = "customer/{id}")
    public ResponseEntity<Object> updateCustomer(@PathVariable("id") String id,@RequestBody UpdateCustomerDto customer) throws CustomerException {
        UpdateCustomerDto updateCustomerDto = customerService.updateCustomer(id,customer);
        ApiResponse apiResponse = ApiResponse.builder()
                .message("success")
                .data(updateCustomerDto)
                .build();
        return new ResponseEntity<>("Customer is updated successfully", HttpStatus.OK);
    }

    @GetMapping(value = "customers/")
    public ResponseEntity<Object> getAllCustomers() {
        return new ResponseEntity<>(customerService.getAllCustomers(), HttpStatus.OK);
    }

    @DeleteMapping(value = "customers/{id}")
    public ResponseEntity<Object> deleteCustomers(@PathVariable("id")@RequestBody String id) throws CustomerException {
        customerService.delete(id);
        return new ResponseEntity<>("Customer is deleted successfully", HttpStatus.OK);
    }






}
