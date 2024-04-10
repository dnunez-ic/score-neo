package com.innerconsulting.scoreneo.services;

import com.innerconsulting.scoreneo.model.Score;
import com.innerconsulting.scoreneo.model.Unit;
import com.innerconsulting.scoreneo.repository.ScoreRepository;
import com.innerconsulting.scoreneo.repository.UnitRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UnitService {
    @Autowired
    private final UnitRepository unitRepository;

    public UnitService(UnitRepository unitRepository) {

        this.unitRepository = unitRepository;
    }

    public List<Unit> getAllUnit(){
        return unitRepository.findAll();
    }

    public Unit saveUnit( Unit unit){
        return unitRepository.save(unit);
    }

    public Unit updateUnit(Unit unit){
        Optional<Unit> unitFromDB=unitRepository.findById(unit.getId());
        if(unitFromDB.isPresent()){

            Unit unitFromDBVal = unitFromDB.get();

            unitFromDBVal.setName(unit.getName());
            unitFromDBVal.setSearchable(unit.isSearchable());

            unitRepository.save(unitFromDBVal);
        }else {
            return null;
        }
        return unit;
    }


    public Unit findUnitById(Long id) {

        return this.unitRepository.findById(id).orElse(null);
    }


    public void deleteUnitById(Long id) {

        this.unitRepository.deleteById(id);
    }
}
