package com.interswitch.customer.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "MyCustomers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name = "customerId")
    String customerId;

    @Column(name = "FullName")
    String fullName;

    @Column(name = "phoneNumber")
    String phoneNumber;

    @Column(name = "dateJoined")
    LocalDate dateJoined;
}
