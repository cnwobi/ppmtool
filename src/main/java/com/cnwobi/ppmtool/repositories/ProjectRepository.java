package com.cnwobi.ppmtool.repositories;

import com.cnwobi.ppmtool.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;



public interface ProjectRepository extends JpaRepository<Project,Long> {

}
