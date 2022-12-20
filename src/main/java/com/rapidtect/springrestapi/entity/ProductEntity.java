package com.rapidtect.springrestapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
@Table( name = "product_tab")
@AllArgsConstructor
public class ProductEntity {
    private Integer id;
    private String name;
    private Double price;
}
