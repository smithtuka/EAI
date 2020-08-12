package edu.miu.service.impl;

import edu.miu.aspect.exception.EmployeeNotFoundException;
import edu.miu.aspect.exception.NoDataFoundException;
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
        return employeeDao.findById(id)
                .orElseThrow( () -> new EmployeeNotFoundException(id) );

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
        List<Employee> employees = employeeDao.findAll();
        if(employees.isEmpty()) throw new NoDataFoundException();
        return employees;
    }
}
