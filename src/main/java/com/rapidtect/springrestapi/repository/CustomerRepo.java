package com.rapidtect.springrestapi.repository;

import com.rapidtect.springrestapi.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<CustomerEntity, Long> {
}
