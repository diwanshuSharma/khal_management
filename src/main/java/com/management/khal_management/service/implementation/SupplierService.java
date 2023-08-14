package com.management.khal_management.service.implementation;

import com.management.khal_management.dtos.supplier.SupplierDto;
import com.management.khal_management.model.SupplierModel;
import com.management.khal_management.repository.ISupplierRepository;
import com.management.khal_management.service.contract.ISupplierService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SupplierService implements ISupplierService {

    private final ISupplierRepository supplierRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public SupplierService(ISupplierRepository supplierRepository, ModelMapper modelMapper) {
        this.supplierRepository = supplierRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<SupplierDto> getAllSuppliers() {
        List<SupplierModel> suppliersFromModel = supplierRepository.findAll();
        List<SupplierDto> supplierDtos = suppliersFromModel.stream()
                .map(supplierModel -> modelMapper.map(supplierModel, SupplierDto.class))
                .collect(Collectors.toList());
        return supplierDtos;
    }

    @Override
    public SupplierDto getSupplierById(Long id) throws ChangeSetPersister.NotFoundException {
        SupplierModel supplierModelFromModel = supplierRepository.findById(id)
                .orElseThrow(() -> new ChangeSetPersister.NotFoundException());
        return modelMapper.map(supplierModelFromModel, SupplierDto.class);
    }

    @Override
    public SupplierDto createSupplier(SupplierDto supplierDto) {
        SupplierModel modelSupplierModel = modelMapper.map(supplierDto, SupplierModel.class);
        SupplierModel addedSupplierModel = supplierRepository.save(modelSupplierModel);
        return modelMapper.map(addedSupplierModel, SupplierDto.class);
    }

    @Override
    public SupplierDto updateSupplier(SupplierDto updatedSupplierDto) {
        SupplierModel supplierModelToUpdate = modelMapper.map(updatedSupplierDto, SupplierModel.class);
        SupplierModel updatedSupplierModel = supplierRepository.save(supplierModelToUpdate);
        return modelMapper.map(updatedSupplierModel, SupplierDto.class);
    }

    @Override
    public SupplierDto deleteSupplier(Long id) throws ChangeSetPersister.NotFoundException {
        SupplierModel supplierModelFromModel = supplierRepository.findById(id)
                .orElseThrow(() -> new ChangeSetPersister.NotFoundException());
        supplierRepository.deleteById(id);
        return modelMapper.map(supplierModelFromModel, SupplierDto.class);
    }
}

