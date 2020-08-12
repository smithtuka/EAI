package edu.miu.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import edu.miu.validation.EmptyOrSize;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Email;

@Entity
public class Address {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Long id;

    @Column(length = 255)
    @EmptyOrSize(message = "Street {EmptyOrSize}")
    private String street;

    @Column(length = 16)
    @Pattern(regexp="^\\d{5,9}$",message="{Pattern.zipcode}")
    private String zipcode;

    @Column(length = 255)
    @EmptyOrSize(message = "City {EmptyOrSize}")
    private String city;
    @Email
    private String email;

    @OneToOne(mappedBy = "address", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JsonIgnore
    private Employee  employee;

    public Address() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

}
