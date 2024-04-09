package com.innerconsulting.scoreneo.repository;

import com.innerconsulting.scoreneo.model.Unit;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnitRepository extends Neo4jRepository<Unit, Long> {
}
