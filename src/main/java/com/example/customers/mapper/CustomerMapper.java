package com.example.customers.mapper;

import com.example.customers.DTO.CustomerDTO;
import com.example.customers.entity.Customers;

public class CustomerMapper {

    public static CustomerDTO toDTO(Customers customer) {
        return new CustomerDTO(
                customer.getClientId(),
                customer.getName(),
                customer.getEmail()
        );
    }

    public static Customers toEntity(CustomerDTO dto) {
        Customers customer = new Customers();
        customer.setClientId(dto.getClientId());
        customer.setName(dto.getName());
        customer.setEmail(dto.getEmail());
        return customer;
    }
}
