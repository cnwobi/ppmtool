package com.cnwobi.ppmtool.services;

import com.cnwobi.ppmtool.model.Project;
import com.cnwobi.ppmtool.repositories.ProjectRepository;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }


    public Project saveOrUpdateProject(Project project){

        return projectRepository.save(project);
    }
}
