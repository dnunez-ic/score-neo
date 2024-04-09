package com.innerconsulting.scoreneo.repository;

import com.innerconsulting.scoreneo.model.Zones;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZonesRepository extends Neo4jRepository<Zones, Long> {
}
