package com.management.khal_management.service.implementation;

import com.management.khal_management.dtos.unit.UnitDto;
import com.management.khal_management.model.UnitModel;
import com.management.khal_management.repository.IUnitRepository;
import com.management.khal_management.service.contract.IUnitService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UnitService implements IUnitService {

    private final ModelMapper modelMapper;
    private final IUnitRepository unitRepository;

    @Autowired
    public UnitService(IUnitRepository unitRepository, ModelMapper modelMapper) {
        this.unitRepository = unitRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public UnitDto createUnit(UnitDto unitDto) {
        UnitModel unitModel = modelMapper.map(unitDto, UnitModel.class);
        unitModel = unitRepository.save(unitModel);
        return modelMapper.map(unitModel, UnitDto.class);
    }

    @Override
    public UnitDto getUnit(Long id) throws ChangeSetPersister.NotFoundException {
        UnitModel unitModel = unitRepository.findById(id)
                .orElseThrow(() -> new ChangeSetPersister.NotFoundException());
        return modelMapper.map(unitModel, UnitDto.class);
    }

    @Override
    public List<UnitDto> getAllUnits() {
        List<UnitModel> unitModels = unitRepository.findAll();
        return unitModels.stream()
                .map(unitModel -> modelMapper.map(unitModel, UnitDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public UnitDto updateUnit(UnitDto unitDto) {
        UnitModel unitModel = modelMapper.map(unitDto, UnitModel.class);
        unitModel = unitRepository.save(unitModel);
        return modelMapper.map(unitModel, UnitDto.class);
    }

    @Override
    public void deleteUnit(Long id) {
        unitRepository.deleteById(id);
    }
}

