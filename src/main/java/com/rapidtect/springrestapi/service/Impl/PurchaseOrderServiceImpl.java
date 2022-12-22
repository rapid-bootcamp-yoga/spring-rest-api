package com.rapidtect.springrestapi.service.Impl;

import com.rapidtect.springrestapi.entity.PurchaseOrderEntity;
import com.rapidtect.springrestapi.entity.ShipperEntity;
import com.rapidtect.springrestapi.model.ProductModel;
import com.rapidtect.springrestapi.model.PurchaseOrderModel;
import com.rapidtect.springrestapi.model.ShipperModel;
import com.rapidtect.springrestapi.repository.PurchaseOrderDetailRepo;
import com.rapidtect.springrestapi.repository.PurchaseOrderRepo;
import com.rapidtect.springrestapi.service.PurchaseOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

    private PurchaseOrderRepo poRepo;
    private PurchaseOrderDetailRepo poDetailRepo;

    @Autowired
    public PurchaseOrderServiceImpl(PurchaseOrderRepo poRepo, PurchaseOrderDetailRepo poDetailRepo) {
        this.poRepo = poRepo;
        this.poDetailRepo = poDetailRepo;
    }

    @Override
    public List<PurchaseOrderModel> getAll() {
        return null;
    }

    @Override
    public Optional<PurchaseOrderModel> getById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<PurchaseOrderModel> save(PurchaseOrderModel model) {
        if(model == null || model.getDetails().isEmpty()) {
            return Optional.empty();
        }

        PurchaseOrderEntity entity = new PurchaseOrderEntity(model);
        entity.addDetailList(model.getDetails());

        try{
            poRepo.save(entity);
            return Optional.of(model);
        }catch (Exception e){
            log.error("Purchase Order save is failed, error: {}", e.getMessage());
            return Optional.empty();
        }
    }
}
