package com.innerconsulting.scoreneo.services;

import com.innerconsulting.scoreneo.model.Project;
import com.innerconsulting.scoreneo.repository.ProjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
    @Autowired
    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public Project saveProject(Project project) {
        return this.projectRepository.save(project);
    }
    public Project findProjectById(Long id) {
        return this.projectRepository.findById(id).orElse(null);
    }

    public Iterable<Project> findAllProjects() {
        return this.projectRepository.findAll();
    }

    public void deleteProjectById(Long id) {
        this.projectRepository.deleteById(id);
    }
}
