package edu.miu.service;

import edu.miu.domain.Employee;

import java.util.List;

public interface EmployeeService {
    void save(Employee employee);
    Employee findById(Long id);
    void deleteById(Long id);
    void deleteAll();
    List<Employee> findAll();
}
