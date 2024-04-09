package com.innerconsulting.scoreneo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.neo4j.config.EnableNeo4jAuditing;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

@SpringBootApplication
@EnableNeo4jAuditing
//@EnableNeo4jRepositories(basePackages = {"com.innerconsulting.scoreneo.repository"})
public class ScoreNeoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScoreNeoApplication.class, args);
	}

}
