package com.regi.SpringSecurityCourse.security;


import com.regi.SpringSecurityCourse.entity.CustomerEntity;
import com.regi.SpringSecurityCourse.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class CustomAuthenticationProvider implements AuthenticationProvider {

    private CustomerRepository customerRepository;
    private PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String pwd = authentication.getCredentials().toString();
        CustomerEntity customerEntity = customerRepository.findCustomerEntityByEmail(username).orElseThrow(
                () -> new BadCredentialsException("No user registered with this details!")
        );
        if (passwordEncoder.matches(pwd, customerEntity.getPwd())) {
            return new UsernamePasswordAuthenticationToken(username, pwd, customerEntity.getRole().getGrantedAuthority());
        } else {
            throw new BadCredentialsException("Invalid password!");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
//Jeżeli posiadamy AuthenticationProvider to nasza aplikacja nie wchodzi do CustomUserDetailService