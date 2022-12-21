package com.rapidtect.springrestapi.entity;


import com.rapidtect.springrestapi.model.PurchaseOrderDetailModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "po_detail_tab")
public class PurchaseOrderDetailEntity {
    @Id
    @TableGenerator(name = "po_detail_id_generator", table = "sequence_tab",
            pkColumnName = "gen_name", valueColumnName = "gen_value",
            pkColumnValue="po_detail_id", initialValue=0, allocationSize=0)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "po_detail_id_generator")
    private Long id;

    @Column(name = "po_id", nullable = false)
    private Long poId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "po_id", insertable = false, updatable = false)
    private PurchaseOrderEntity po;


    @Column(name = "product_id", nullable = false)
    private Long productId;

    @OneToMany(mappedBy = "poDetail")
    private Set<ProductEntity> products = new HashSet<>();

    @Column(name = "quantity", nullable = false)
    private Double quantity;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "sub_amount", nullable = false)
    private Double subAmount;

    public PurchaseOrderDetailEntity(PurchaseOrderDetailModel model) {
        BeanUtils.copyProperties(model, this);
    }
}
