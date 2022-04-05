package com.regi.SpringSecurityCourse.entity;

import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@AllArgsConstructor
public class SecurityCustomerEntity implements UserDetails {

    private final CustomerEntity customerEntity;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return customerEntity.getRole().getGrantedAuthority();
    }

    @Override
    public String getPassword() {
        return customerEntity.getPwd();
    }

    @Override
    public String getUsername() {
        return customerEntity.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
