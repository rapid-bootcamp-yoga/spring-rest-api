package com.rapidtect.springrestapi.model;

import com.rapidtect.springrestapi.entity.PurchaseOrderDetailEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;



@AllArgsConstructor
@Data
@NoArgsConstructor
public class PurchaseOrderDetailModel {
    private Long id;
    private Long poId;
    private Long productId;
    private Double quantity;
    private Double price;

    public PurchaseOrderDetailModel(PurchaseOrderDetailEntity entity) {
        BeanUtils.copyProperties(entity, this);
    }
}
