package com.spring.security.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name="users")
public class Users {

    @Id
    @Column(name = "username", unique = true, nullable = false)
    private String username;

    @Column(name="password")
    private String password;

    @Column(name="enabled")
    private boolean enabled;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Authorities> authorities;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private EmployeeDetails ed;

    public Users() {
    }

    public Users(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void setEmployeeDetails(EmployeeDetails ed) {
        this.ed = ed;
        ed.setUser(this);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public List<Authorities> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<Authorities> authorities) {
        this.authorities = authorities;
    }

    public EmployeeDetails getEd() {
        return ed;
    }

    public void setEd(EmployeeDetails ed) {
        this.ed = ed;
    }
}