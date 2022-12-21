package com.rapidtect.springrestapi.repository;

import com.rapidtect.springrestapi.entity.PurchaseOrderDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseOrderDetailRepo extends JpaRepository<PurchaseOrderDetailEntity, Integer> {
}
