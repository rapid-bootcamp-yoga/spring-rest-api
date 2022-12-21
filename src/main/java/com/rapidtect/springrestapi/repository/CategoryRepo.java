package com.rapidtect.springrestapi.repository;

import com.rapidtect.springrestapi.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

public interface CategoryRepo extends JpaRepository<CategoryEntity, Long> {
}
