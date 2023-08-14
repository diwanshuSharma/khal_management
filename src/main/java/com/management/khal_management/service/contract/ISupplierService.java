package com.management.khal_management.service.contract;

import com.management.khal_management.dtos.supplier.SupplierDto;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;

public interface ISupplierService {
    List<SupplierDto> getAllSuppliers();
    SupplierDto getSupplierById(Long id) throws ChangeSetPersister.NotFoundException;
    SupplierDto createSupplier(SupplierDto supplierDto);
    SupplierDto updateSupplier(SupplierDto updatedSupplierDto);
    SupplierDto deleteSupplier(Long id) throws ChangeSetPersister.NotFoundException;
}

