package com.innerconsulting.scoreneo.repository;

import com.innerconsulting.scoreneo.model.Score;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreRepository extends Neo4jRepository<Score, Long> {
}
