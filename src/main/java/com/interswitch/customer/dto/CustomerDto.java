package com.interswitch.customer.dto;


import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CustomerDto {
    String customerId;
    String fullName;
    String phoneNumber;
    LocalDate dateJoined;
}
