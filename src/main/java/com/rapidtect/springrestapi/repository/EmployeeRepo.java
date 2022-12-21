package com.rapidtect.springrestapi.repository;

import com.rapidtect.springrestapi.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<EmployeeEntity, Long> {
}
