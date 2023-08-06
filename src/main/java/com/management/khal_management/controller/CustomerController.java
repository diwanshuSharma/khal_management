package com.management.khal_management.controller;

import com.management.khal_management.dtos.CustomerDto;
import com.management.khal_management.service.contract.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

        private final ICustomerService ICustomerService;

        @Autowired
        public CustomerController(ICustomerService ICustomerService) {
            this.ICustomerService = ICustomerService;
        }

        @GetMapping
        public List<CustomerDto> getAllCustomers() {
            return ICustomerService.getAllCustomers();
        }

        @GetMapping("/{id}")
        public CustomerDto getCustomerById(@PathVariable Long id) {
            return ICustomerService.getCustomerById(id);
        }

        @PostMapping
        public CustomerDto createCustomer(@RequestBody CustomerDto customerDto) {
            return ICustomerService.createCustomer(customerDto);
        }

        @PutMapping
        public CustomerDto updateCustomer(@RequestBody CustomerDto updateCustomerDto) {
            return ICustomerService.updateCustomer(updateCustomerDto);
        }

        @DeleteMapping("/{id}")
        public CustomerDto deleteCustomer(@PathVariable Long id) {
            CustomerDto deletedCustomerDto = ICustomerService.deleteCustomer(id);
            return deletedCustomerDto;
        }
}
