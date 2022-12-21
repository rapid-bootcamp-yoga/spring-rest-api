package com.rapidtect.springrestapi.repository;

import com.rapidtect.springrestapi.entity.SupplierEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepo extends JpaRepository<SupplierEntity, Long> {
}
