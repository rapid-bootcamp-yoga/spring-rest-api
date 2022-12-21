package com.rapidtect.springrestapi.model;

import com.rapidtect.springrestapi.entity.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class ProductModel {
    private Long id;
    private String code;
    private String name;
    private Double price;
    private Integer categoryId;
    private String categoryName;

    public ProductModel(ProductEntity entity){
        /*
        this.id = entity.getId();
        this.code = entity.getCode();
        this.name = entity.getName();
        this.price = entity.getPrice();
        this.categoryId = entity.getCategoryId();*/
        BeanUtils.copyProperties(entity, this);
        if(entity.getCategory() != null) {
            this.categoryName = entity.getCategory().getName();
        }
    }

    public ProductModel(Long id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
