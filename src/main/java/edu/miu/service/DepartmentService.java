package edu.miu.service;

import edu.miu.domain.Department;

import java.util.List;

public interface DepartmentService {

        public Department addDepartment (Department department);
        public List<Department> getAllDepartments();
        public Department getDepartmentById(Long id);
        public void deleteDepartmentById(Long id);
      Department updateDepartment(Department editedDepartment, Long id);
}
