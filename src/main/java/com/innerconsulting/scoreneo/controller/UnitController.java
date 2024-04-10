package com.innerconsulting.scoreneo.controller;


import com.innerconsulting.scoreneo.model.Unit;
import com.innerconsulting.scoreneo.services.UnitService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/units")
public class UnitController {
    @Autowired
    private UnitService unitService;


    @PostMapping("/")
    public ResponseEntity<Unit> createUnit(@RequestBody Unit unit) {
        Unit createdUnit = unitService.saveUnit(unit);
        return new ResponseEntity<>(createdUnit,HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Unit> getUnitById(@PathVariable Long id) {
        Unit unit = unitService.findUnitById(id);
        if (unit != null) {
            return new ResponseEntity<>(unit, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/")
    public ResponseEntity<Iterable<Unit>> getAllUnit() {
        Iterable<Unit> unit = unitService.getAllUnit();
        return new ResponseEntity<>(unit, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUnitById(@PathVariable Long id) {
        Unit unit = unitService.findUnitById(id);
        if (unit!= null) {
            unitService.deleteUnitById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
