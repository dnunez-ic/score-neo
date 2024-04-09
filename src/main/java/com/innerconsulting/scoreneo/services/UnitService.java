package com.innerconsulting.scoreneo.services;

import com.innerconsulting.scoreneo.model.Unit;
import com.innerconsulting.scoreneo.repository.UnitRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UnitService {
    @Autowired
    private final UnitRepository unitRepository;

    public UnitService(UnitRepository unitRepository) {
        this.unitRepository = unitRepository;
    }

    public Unit saveUnit(Unit unit) {
        return this.unitRepository.save(unit);
    }
    public Unit findUnitById(Long id) {
        return this.unitRepository.findById(id).orElse(null);
    }

    public Iterable<Unit> findAllUnits() {
        return this.unitRepository.findAll();
    }

    public void deleteUnitById(Long id) {
        this.unitRepository.deleteById(id);
    }
}
