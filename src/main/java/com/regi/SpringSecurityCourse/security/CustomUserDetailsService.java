package com.regi.SpringSecurityCourse.security;

import com.regi.SpringSecurityCourse.entity.CustomerEntity;
import com.regi.SpringSecurityCourse.entity.SecurityCustomerEntity;
import com.regi.SpringSecurityCourse.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<CustomerEntity> customerEntities = customerRepository.findByEmail(username);
        if (customerEntities.size() == 0) {
            throw new UsernameNotFoundException("User was not found, username provided: " + username);
        }
        return new SecurityCustomerEntity(customerEntities.get(0));
    }
}
