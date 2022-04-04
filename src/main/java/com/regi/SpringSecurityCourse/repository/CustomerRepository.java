package com.regi.SpringSecurityCourse.repository;

import com.regi.SpringSecurityCourse.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {

    Optional<CustomerEntity> findCustomerEntityByEmail(String email);
}
