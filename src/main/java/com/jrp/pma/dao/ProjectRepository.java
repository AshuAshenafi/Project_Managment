package com.jrp.pma.dao;

import com.jrp.pma.entities.Project;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Set;

public interface ProjectRepository extends CrudRepository <Project, Long> {
    @Override
    public List<Project> findAll();
}
