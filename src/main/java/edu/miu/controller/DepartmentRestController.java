package edu.miu.controller;

import edu.miu.domain.Department;
import edu.miu.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value="/api/department", produces = MediaType.APPLICATION_JSON_VALUE)
public class DepartmentRestController {
    DepartmentService departmentService;
@Autowired
    public DepartmentRestController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }
    @PostMapping(value = "/addDepartment")
    public Department registerNewStudent(@Valid @RequestBody Department department) {
        return departmentService.addDepartment(department);
    }
    @GetMapping(value = "/departmentList")
    public List<Department> list() {
        return departmentService.getAllDepartments();
    }
    @GetMapping(value = "/get/{studentId}")
    public Department getDepartmentById(@PathVariable Long studentId) {
        return departmentService.getDepartmentById(studentId);
    }
    @DeleteMapping(value = "/delete/{departmentId}")
    public void deleteStudent(@PathVariable Long departmentId) {
        departmentService.deleteDepartmentById(departmentId);
    }
    @PutMapping(value = "/update/{departmentId}")
    public Department updateDepartment(@Valid @RequestBody Department editedDepartment, @PathVariable Long departmentId) {
        return departmentService.updateDepartment(editedDepartment, departmentId);
    }

}
