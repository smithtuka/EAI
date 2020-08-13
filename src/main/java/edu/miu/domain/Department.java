package edu.miu.domain;

import edu.miu.validation.EmptyOrSize;

import javax.persistence.*;
import java.util.List;

@Entity
public class Department {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_id")
    private Long id;

    @Column(nullable = false)
    @EmptyOrSize(message = "Name {EmptyOrSize}")
    private String name;

    @OneToMany( mappedBy = "department")
    private List<Employee> employees;

    @OneToMany(mappedBy = "department")
    private List<Project> projects;

    public Department() {
    }

    public Department(String name) {
        this.name = name;
    }

    public Department(Long id, String name, List<Employee> employees, List<Project> projects) {
        this.id = id;
        this.name = name;
        this.employees = employees;
        this.projects = projects;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

}
