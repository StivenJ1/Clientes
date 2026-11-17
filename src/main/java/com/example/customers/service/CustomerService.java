package com.example.customers.service;

import com.example.customers.DTO.CustomerDTO;
import com.example.customers.mapper.CustomerMapper;
import com.example.customers.repository.CustomersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CustomerService {

    private final CustomersRepository customersRepository;


    public List<CustomerDTO> getCustomers() {
        return customersRepository.findAll().stream()
                .map(CustomerMapper::toDTO)
                .toList();
    }

    public com.example.customers.DTO.CustomerDTO createCustomer(CustomerDTO customerDTO){
        var customer = CustomerMapper.toEntity(customerDTO);
        return CustomerMapper.toDTO(customersRepository.save(customer));
    }

}
