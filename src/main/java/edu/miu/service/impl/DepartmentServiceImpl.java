package edu.miu.service.impl;

import edu.miu.dao.DepartmentDao;
import edu.miu.domain.Department;
import edu.miu.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DepartmentServiceImpl implements DepartmentService {

    DepartmentDao departmentDao;
@Autowired
    public DepartmentServiceImpl(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    @Override
    public Department addDepartment(Department department) {
        return departmentDao.save(department);
    }

    @Override
    public List<Department> getAllDepartments() {
        return (List<Department>) departmentDao.findAll();
    }

    @Override
    public Department getDepartmentById(Long id) {
        return departmentDao.findById(id).orElse(null);
    }

    @Override
    public void deleteDepartmentById(Long id) {
        departmentDao.deleteById(id);

    }

    @Override
    public Department updateDepartment(Department editedDepartment, Long id) {
        return departmentDao.findById(id)
                .map(department -> {
                    department.setName(editedDepartment.getName());
                    return departmentDao.save(department);
                }).orElseGet(() -> {
                    return departmentDao.save(editedDepartment);
                });
    }
}
