package com.management.khal_management.service.contract;

import com.management.khal_management.dtos.unit.UnitDto;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;

public interface IUnitService {
    UnitDto createUnit(UnitDto unitDto);
    UnitDto getUnit(Long id) throws ChangeSetPersister.NotFoundException;
    List<UnitDto> getAllUnits();
    UnitDto updateUnit(UnitDto unitDto);
    void deleteUnit(Long id);
}

