package edu.miu.controller;

import edu.miu.domain.Employee;
import edu.miu.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping("")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void save(@Valid @RequestBody Employee employee) {
        employeeService.save(employee);
    }


    @CrossOrigin
    @GetMapping("/{id}")
    public Employee findById(@Valid @PathVariable("id") Long employeeId) {
        return employeeService.findById(employeeId);
    }

    @CrossOrigin
    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Employee> findAllEmployees() {
        return employeeService.findAll();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteById(@Valid @PathVariable("id") Long employeeId) {
        employeeService.deleteById(employeeId);
    }

    @DeleteMapping("")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteAll() {
        employeeService.deleteAll();
    }

}
