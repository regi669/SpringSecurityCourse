package com.regi.SpringSecurityCourse.repository;

import com.regi.SpringSecurityCourse.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {

    List<CustomerEntity> findByEmail(String email);
}
