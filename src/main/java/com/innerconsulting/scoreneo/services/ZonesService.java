package com.innerconsulting.scoreneo.services;

import com.innerconsulting.scoreneo.model.Zones;
import com.innerconsulting.scoreneo.repository.ZonesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ZonesService {
    @Autowired
    private final ZonesRepository zoneRepository;

    public ZonesService(ZonesRepository zoneRepository) {
        this.zoneRepository = zoneRepository;
    }

    public Zones saveZone(Zones zone) {
        return this.zoneRepository.save(zone);
    }
    public Zones findZoneById(Long id) {
        return this.zoneRepository.findById(id).orElse(null);
    }

    public Iterable<Zones> findAllZones() {
        return this.zoneRepository.findAll();
    }

    public void deleteZoneById(Long id) {
        this.zoneRepository.deleteById(id);
    }
}
