package edu.miu.service.impl;

import edu.miu.dao.ProjectDao;
import edu.miu.domain.Project;
import edu.miu.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectDao projectDao;

    @Override
    public void save(Project project) {
        projectDao.save(project);
    }

    @Override
    public List<Project> findAll() {
        return projectDao.findAll();
    }

    @Override
    public Project findOne(Long id) {
        return projectDao.findById(id).orElse(null);
    }

}
