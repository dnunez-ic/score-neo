package com.innerconsulting.scoreneo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Node("Score")
public class Score {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private boolean isSearchable;
    @Relationship(type = "HAS_PRODUCT")
    private List<Product> products;
}
