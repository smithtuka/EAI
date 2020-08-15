package edu.miu.dto;

import edu.miu.domain.Employee;

import java.io.Serializable;


public class RequisitionDTO implements Serializable {

    private String title;

    private String description;

    private Employee employee;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
