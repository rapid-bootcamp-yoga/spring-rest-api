package com.rapidtect.springrestapi.repository;

import com.rapidtect.springrestapi.entity.PurchaseOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseOrderRepo extends JpaRepository<PurchaseOrderEntity, Long> {
}
