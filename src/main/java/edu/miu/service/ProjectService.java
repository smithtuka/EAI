package edu.miu.service;

import edu.miu.domain.Project;

import java.util.List;

public interface ProjectService {
    public void save(Project project);
    public List<Project> findAll();
    public Project findOne(Long id);
    public void deleteById(Long id);
}
