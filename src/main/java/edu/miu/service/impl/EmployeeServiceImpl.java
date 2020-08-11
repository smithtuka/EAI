package edu.miu.service.impl;

import edu.miu.dao.EmployeeDao;
import edu.miu.domain.Employee;
import edu.miu.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeDao employeeDao;

    @Override
    public void save(Employee employee) {
        employeeDao.save(employee);
    }


    @Override
    public Employee findById(Long id) {
        return employeeDao.findById(id).get();
    }

    @Override
    public void deleteById(Long id) {
        employeeDao.deleteById(id);
    }

    @Override
    public void deleteAll() {
        employeeDao.deleteAll();
    }

    @Override
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }
}
