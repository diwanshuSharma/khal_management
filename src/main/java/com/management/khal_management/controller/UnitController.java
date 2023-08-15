package com.management.khal_management.controller;

import com.management.khal_management.dtos.unit.UnitDto;
import com.management.khal_management.service.contract.IUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/units")
public class UnitController {

    private final IUnitService unitService;

    @Autowired
    public UnitController(IUnitService unitService) {
        this.unitService = unitService;
    }

    @PostMapping
    public ResponseEntity<UnitDto> createUnit(@RequestBody UnitDto unitDto) {
        UnitDto createdUnit = unitService.createUnit(unitDto);
        return ResponseEntity.ok(createdUnit);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UnitDto> getUnit(@PathVariable Long id) throws ChangeSetPersister.NotFoundException {
        UnitDto unitDto = unitService.getUnit(id);
        return ResponseEntity.ok(unitDto);
    }

    @GetMapping
    public ResponseEntity<List<UnitDto>> getAllUnits() {
        List<UnitDto> units = unitService.getAllUnits();
        return ResponseEntity.ok(units);
    }

    @PutMapping
    public ResponseEntity<UnitDto> updateUnit(@RequestBody UnitDto unitDto) {
        UnitDto updatedUnit = unitService.updateUnit(unitDto);
        return ResponseEntity.ok(updatedUnit);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUnit(@PathVariable Long id) {
        unitService.deleteUnit(id);
        return ResponseEntity.noContent().build();
    }
}

