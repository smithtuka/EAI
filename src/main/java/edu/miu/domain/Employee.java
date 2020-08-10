package edu.miu.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private long id;

    @Column(nullable = false)
    private String firstName;

    @Column(name = "is_admin", nullable = false)
    private boolean admin = false;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(nullable = false)
    private Integer age = 0;

    @Column(name = "hire_date", nullable = false)
    private LocalDate hireDate;

    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToOne(fetch=FetchType.LAZY,  cascade = CascadeType.ALL)
    @JoinColumn(name="user_credentials_id")
    private UserCredentials userCredentials;

    @OneToMany(mappedBy = "employee")
    private List<Requisition> requisitions;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;

//    @ManyToOne(fetch = FetchType.LAZY, cascade={CascadeType.ALL})
//    @JoinColumn(name="manager")
//    private Employee manager;
//
//    @OneToMany(mappedBy="manager")
//    private Set<Employee> subordinates = new HashSet<Employee>();

    @OneToMany(mappedBy = "employee")
    private Set<Project> projects = new HashSet<Project>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Requisition> getRequisitions() {
        return requisitions;
    }

    public void setRequisitions(List<Requisition> requisitions) {
        this.requisitions = requisitions;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

//    public Employee getManager() {
//        return manager;
//    }
//
//    public void setManager(Employee manager) {
//        this.manager = manager;
//    }
//
//    public Set<Employee> getSubordinates() {
//        return subordinates;
//    }
//
//    public void setSubordinates(Set<Employee> subordinates) {
//        this.subordinates = subordinates;
//    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public UserCredentials getUserCredentials() {
        return userCredentials;
    }

    public void setUserCredentials(UserCredentials userCredentials) {
        this.userCredentials = userCredentials;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }


}
