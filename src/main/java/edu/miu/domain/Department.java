package edu.miu.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Department {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_id")
    private long id;

    @Column(nullable = false)
    private String name;

    @OneToMany( mappedBy = "department")
    private List<Employee> employees;

    @OneToMany(mappedBy = "department")
    private List<Project> projects;

    public Long getId() {
        return id;
    }

    public void setId(long id) {
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
