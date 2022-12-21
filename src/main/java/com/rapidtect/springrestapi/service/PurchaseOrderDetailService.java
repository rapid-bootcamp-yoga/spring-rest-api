package com.rapidtect.springrestapi.service;

import com.rapidtect.springrestapi.model.PurchaseOrderDetailModel;

import java.util.List;
import java.util.Optional;

public interface PurchaseOrderDetailService {
    List<PurchaseOrderDetailModel> getAll();
    Optional<PurchaseOrderDetailModel> getById(Integer id);
    Optional<PurchaseOrderDetailModel> save(PurchaseOrderDetailModel model);
    Optional<PurchaseOrderDetailModel> update(Integer id, PurchaseOrderDetailModel model);
    Optional<PurchaseOrderDetailModel> delete(Integer id);
}
