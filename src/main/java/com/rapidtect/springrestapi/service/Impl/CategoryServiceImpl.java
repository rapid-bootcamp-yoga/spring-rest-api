package com.rapidtect.springrestapi.service.Impl;

import com.rapidtect.springrestapi.entity.CategoryEntity;
import com.rapidtect.springrestapi.model.CategoryModel;
import com.rapidtect.springrestapi.repository.CategoryRepo;
import com.rapidtect.springrestapi.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepo repo;

    @Autowired
    public CategoryServiceImpl(CategoryRepo repo) {
        this.repo = repo;
    }

    @Override
    public List<CategoryModel> getAll() {
        return this.repo.findAll().stream().map(CategoryModel::new)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<CategoryModel> getById(Integer id) {
        if(id == 0) {
            return Optional.empty();
        }
        Optional<CategoryEntity> result = this.repo.findById(id);
        return result.map(CategoryModel::new);
    }

    @Override
    public Optional<CategoryModel> save(CategoryModel model) {
        if(model == null) {
            return Optional.empty();
        }
        CategoryEntity entity = new CategoryEntity(model);
        try {
            this.repo.save(entity);
            return Optional.of(new CategoryModel(entity));
        }catch (Exception e){
            log.error("Category save is failed, error: {}", e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<CategoryModel> update(Integer id, CategoryModel model) {
        if(id == 0) {
            return Optional.empty();
        }

        CategoryEntity result = this.repo.findById(id).orElse(null);
        if(result == null){
            return Optional.empty();
        }

        // copy property
        BeanUtils.copyProperties(model, result);
        try {
            this.repo.save(result);
            return Optional.of(new CategoryModel(result));
        }catch (Exception e){
            log.error("Category update is failed, error: {}", e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<CategoryModel> delete(Integer id) {
        if(id == 0) {
            return Optional.empty();
        }

        CategoryEntity result = this.repo.findById(id).orElse(null);
        if(result == null){
            return Optional.empty();
        }

        try {
            this.repo.delete(result);
            return Optional.of(new CategoryModel(result));
        }catch (Exception e){
            log.error("Category delete is failed, error: {}", e.getMessage());
            return Optional.empty();
        }
    }
}
