package com.rapidtect.springrestapi.entity;

import com.rapidtect.springrestapi.model.ProductModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table( name = "product_tab")
@AllArgsConstructor
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "product_code", length = 20, nullable = false)
    private String code;

    @Column(name = "product_name", length = 100, nullable = false)
    private String name;

    @Column(name = "product_price")
    private Double price;

    @Column(name = "category_id", nullable = false)
    private int categoryId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id", insertable = false, updatable = false)
    private CategoryEntity category;

    @ManyToMany(mappedBy = "products", fetch = FetchType.LAZY)
    private Set<CustomerEntity> customers = new HashSet<>();

    public ProductEntity(ProductModel model) {
        BeanUtils.copyProperties(model, this);

        /*
        this.code = model.getCode();
        this.name = model.getName();
        this.price = model.getPrice();
        this.categoryId = model.getCategoryId();
         */
    }
}
