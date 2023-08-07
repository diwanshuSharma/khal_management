package com.management.khal_management.service.contract;

import com.management.khal_management.dtos.customer.CustomerDto;

import java.util.List;

public interface ICustomerService {

    List<CustomerDto> getAllCustomers();
    CustomerDto getCustomerById(Long id);
    CustomerDto createCustomer(CustomerDto customerDto);
    CustomerDto updateCustomer(CustomerDto updatedCustomerDto);
    CustomerDto deleteCustomer(Long id);
}
