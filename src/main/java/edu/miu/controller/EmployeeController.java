package edu.miu.controller;

import edu.miu.domain.Address;
import edu.miu.domain.Employee;
import edu.miu.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping("")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void save(@RequestBody Employee employee) {
        employeeService.save(employee);
    }
    

    @GetMapping("/{id}")
    public Employee findById(@PathVariable("id") Long employeeId) {
        return employeeService.findById(employeeId);
    }

    @GetMapping("")
    public List<Employee> findAllEmployees() {
        return employeeService.findAll();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("id") Long employeeId) {
        employeeService.deleteById(employeeId);
    }

    @DeleteMapping("")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteAll() {
        employeeService.deleteAll();
    }

}
