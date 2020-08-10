package edu.miu.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Authentication")
public class UserCredentials {
    @Id
    @Column(name = "user", nullable = false, unique = true, length = 127)
    String userName;

    @Column(nullable = false)
    String password;

    @Transient
    String verifyPassword;

    Boolean enabled;

    @OneToOne(mappedBy="userCredentials", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Employee employee;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable ( name="Credential_Authority", joinColumns={@JoinColumn(name="credential_id")},
            inverseJoinColumns={ @JoinColumn(name="authority_id", unique=true)} )
    List<Authority> authority = new ArrayList<Authority>();

    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getVerifyPassword() {
        return verifyPassword;
    }
    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
    }
    public Boolean getEnabled() {
        return enabled;
    }
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
    public Employee getUser() {
        return employee;
    }
    public void setUser(Employee employee) {
        this.employee = employee;
    }
    public List<Authority> getAuthority() {
        return authority;
    }
    public void setAuthority(List<Authority> authority) {
        this.authority = authority;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
