package com.rapidtect.springrestapi.repository;

import com.rapidtect.springrestapi.entity.ShipperEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShipperRepo extends JpaRepository<ShipperEntity, Long> {
}
