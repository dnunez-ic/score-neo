package com.innerconsulting.scoreneo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Node("Unit")
public class Unit {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private boolean isSearchable;
}
