package com.rapidtect.springrestapi.entity;

import com.rapidtect.springrestapi.model.ProductModel;
import com.rapidtect.springrestapi.model.PurchaseOrderDetailModel;
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
    @TableGenerator(name = "product_id_generator", table = "sequence_tab",
            pkColumnName = "gen_name", valueColumnName = "gen_value",
            pkColumnValue="product_id", initialValue=0, allocationSize=0)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "product_id_generator")
    private Integer id;

    @Column(name = "product_code", length = 20, nullable = false)
    private String code;

    @Column(name = "product_name", length = 100, nullable = false)
    private String name;

    @Column(name = "product_price")
    private Double price;

    @Column(name = "category_id", nullable = false)
    private Integer categoryId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id", insertable = false, updatable = false)
    private CategoryEntity category;

    @Column(name = "supplier_id", nullable = false)
    private Long supplierId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "supplier_id", insertable = false, updatable = false)
    private SupplierEntity supplier;

    @Column(name = "po_detail_id", nullable = false)
    private Integer poDetailId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "po_detail_id", insertable = false, updatable = false)
    private PurchaseOrderDetailEntity purchaseOrderDetail;

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
