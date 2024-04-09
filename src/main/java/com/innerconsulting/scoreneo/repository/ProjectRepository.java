package com.innerconsulting.scoreneo.repository;

import com.innerconsulting.scoreneo.model.Product;
import com.innerconsulting.scoreneo.model.Project;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends Neo4jRepository<Project, Long> {
}
