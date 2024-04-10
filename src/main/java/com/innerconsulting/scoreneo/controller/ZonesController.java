package com.innerconsulting.scoreneo.controller;

import com.innerconsulting.scoreneo.model.Zones;
import com.innerconsulting.scoreneo.services.ZonesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/zones")
public class ZonesController {
    @Autowired
    private ZonesService zoneService;


    @PostMapping("/")
    public ResponseEntity<Zones> createZones(@RequestBody Zones zones) {
        Zones createdZones = zoneService.saveZone(zones);
        return new ResponseEntity<>(createdZones,HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Zones> getZonesById(@PathVariable Long id) {
        Zones zones = zoneService.findZoneById(id);

        if (zones != null) {
            return new ResponseEntity<>(zones,HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/")
    public ResponseEntity<Iterable<Zones>> getAllZones() {
        Iterable<Zones> zones = zoneService.findAllZones();
        return new ResponseEntity<>(zones, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteZoneById(@PathVariable Long id) {
        Zones zones= zoneService.findZoneById(id);
        if (zones!= null) {
            zoneService.deleteZoneById(id);

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

