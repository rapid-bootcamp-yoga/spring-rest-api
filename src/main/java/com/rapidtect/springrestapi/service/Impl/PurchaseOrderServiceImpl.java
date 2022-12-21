package com.rapidtect.springrestapi.service.Impl;

import com.rapidtect.springrestapi.entity.PurchaseOrderEntity;
import com.rapidtect.springrestapi.model.PurchaseOrderModel;
import com.rapidtect.springrestapi.repository.PurchaseOrderRepo;
import com.rapidtect.springrestapi.service.PurchaseOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService {
    private PurchaseOrderRepo repo;

    @Autowired
    public PurchaseOrderServiceImpl(PurchaseOrderRepo repo) {
        this.repo = repo;
    }

    @Override
    public List<PurchaseOrderModel> getAll() {
        return this.repo.findAll().stream().map(PurchaseOrderModel::new)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<PurchaseOrderModel> getById(Long id) {
        if(id == 0) {
            return Optional.empty();
        }
        Optional<PurchaseOrderEntity> result = this.repo.findById(id);
        return result.map(PurchaseOrderModel::new);
    }

    @Override
    public Optional<PurchaseOrderModel> save(PurchaseOrderModel model) {
        if(model == null) {
            return Optional.empty();
        }
        PurchaseOrderEntity entity = new PurchaseOrderEntity(model);
        try {
            this.repo.save(entity);
            return Optional.of(new PurchaseOrderModel(entity));
        }catch (Exception e){
            log.error("Product save is failed, error: {}", e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<PurchaseOrderModel> update(Long id, PurchaseOrderModel model) {
        if(id == 0) {
            return Optional.empty();
        }

        PurchaseOrderEntity result = this.repo.findById(id).orElse(null);
        if(result == null){
            return Optional.empty();
        }

        // copy property
        BeanUtils.copyProperties(model, result);
        try {
            this.repo.save(result);
            return Optional.of(new PurchaseOrderModel(result));
        }catch (Exception e){
            log.error("Product update is failed, error: {}", e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<PurchaseOrderModel> delete(Long id) {
        if(id == 0) {
            return Optional.empty();
        }

        PurchaseOrderEntity result = this.repo.findById(id).orElse(null);
        if(result == null){
            return Optional.empty();
        }

        try {
            this.repo.delete(result);
            return Optional.of(new PurchaseOrderModel(result));
        }catch (Exception e){
            log.error("Product delete is failed, error: {}", e.getMessage());
            return Optional.empty();
        }
    }
}
