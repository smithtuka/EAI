package edu.miu.domain;

import javax.persistence.*;

@Entity
public class Address {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "address_id")
    private long id;

    @Column(length = 255)
    private String street;

    @Column(length = 16)
    private String zipcode;

    @Column(length = 255)
    private String city;

    @OneToOne(mappedBy = "address", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Employee  employee;

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
