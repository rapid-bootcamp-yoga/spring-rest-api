package com.rapidtect.springrestapi.service.Impl;

import com.rapidtect.springrestapi.entity.ProductEntity;
import com.rapidtect.springrestapi.model.ProductModel;
import com.rapidtect.springrestapi.repository.ProductRepo;
import com.rapidtect.springrestapi.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {
    private ProductRepo repo;

    @Autowired
    public ProductServiceImpl(ProductRepo repo) {
        this.repo = repo;
    }

    @Override
    public List<ProductModel> getAll() {
        return this.repo.findAll().stream().map(ProductModel::new)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ProductModel> getById(Integer id) {
        if(id == 0) {
            return Optional.empty();
        }
        Optional<ProductEntity> result = this.repo.findById(String.valueOf(id));
        /*
        if(result.isEmpty()){
            return Optional.empty();
        }
        return Optional.of(new ProductModel(result.get()));
         */
        return result.map(ProductModel::new);
    }

    @Override
    public Optional<ProductModel> save(ProductModel model) {
        if(model == null) {
            return Optional.empty();
        }
        ProductEntity entity = new ProductEntity(model);
        try {
            this.repo.save(entity);
            return Optional.of(new ProductModel(entity));
        }catch (Exception e){
            log.error("Product save is failed, error: {}", e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<ProductModel> update(Integer id, ProductModel model) {
        if(id == 0) {
            return Optional.empty();
        }

        ProductEntity result = this.repo.findById(String.valueOf(id)).orElse(null);
        if(result == null){
            return Optional.empty();
        }

        // copy property
        BeanUtils.copyProperties(model, result);
        try {
            this.repo.save(result);
            return Optional.of(new ProductModel(result));
        }catch (Exception e){
            log.error("Product update is failed, error: {}", e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<ProductModel> delete(Integer id) {
        if(id == 0) {
            return Optional.empty();
        }

        ProductEntity result = this.repo.findById(String.valueOf(id)).orElse(null);
        if(result == null){
            return Optional.empty();
        }

        try {
            this.repo.delete(result);
            return Optional.of(new ProductModel(result));
        }catch (Exception e){
            log.error("Product delete is failed, error: {}", e.getMessage());
            return Optional.empty();
        }
    }
}
