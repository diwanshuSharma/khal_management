package com.management.khal_management.service.implementation;

import com.management.khal_management.dtos.customer.CustomerDto;
import com.management.khal_management.model.CustomerModel;
import com.management.khal_management.repository.ICustomerRepository;
import com.management.khal_management.service.contract.ICustomerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    private final ICustomerRepository customerRepository;
    private final ModelMapper modelMapper;

    public CustomerService(ICustomerRepository customerRepository, ModelMapper modelMapper) {
        this.customerRepository = customerRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<CustomerDto> getAllCustomers() {
        List<CustomerModel> customersFromModel = customerRepository.findAll();
        List<CustomerDto> customerDtos = modelMapper.map(customersFromModel, new TypeToken<List<CustomerDto>>(){}.getType());
        return customerDtos;
    }

    @Override
    public CustomerDto getCustomerById(Long id) {
        CustomerModel customerModelFromModel = customerRepository.findById(id).get();
        CustomerDto customerDto = modelMapper.map(customerModelFromModel, CustomerDto.class);
        return customerDto;
    }

    @Override
    public CustomerDto createCustomer(CustomerDto customerDto) {
        CustomerModel modelCustomerModel = modelMapper.map(customerDto, CustomerModel.class);
        CustomerModel addedCustomerModel = customerRepository.save(modelCustomerModel);
        CustomerDto addedCustomerDtoDto = modelMapper.map(addedCustomerModel, CustomerDto.class);
        return addedCustomerDtoDto;
    }

    @Override
    public CustomerDto updateCustomer(CustomerDto updateCustomerDto) {
        CustomerModel customerModelToUpdate = modelMapper.map(updateCustomerDto, CustomerModel.class);
        CustomerModel updatedCustomerModel = customerRepository.save(customerModelToUpdate);
        CustomerDto customerDto = modelMapper.map(updatedCustomerModel, CustomerDto.class);
        return customerDto;
    }

    @Override
    public CustomerDto deleteCustomer(Long id) {
        CustomerModel customerModelFromModel = customerRepository.findById(id).get();
        customerRepository.deleteById(id);
        CustomerDto deletedCustomerDto = modelMapper.map(customerModelFromModel, CustomerDto.class);
        return deletedCustomerDto;
    }
}
