package com.innerconsulting.scoreneo.repository;

import com.innerconsulting.scoreneo.model.Role;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends Neo4jRepository<Role, Long> {
}
