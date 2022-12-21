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
    private Integer id;
    private Double quantity;
    private Double price;
    private Double subAmount;

    public PurchaseOrderDetailModel(PurchaseOrderDetailEntity entity) {
        BeanUtils.copyProperties(entity, this);
    }
}
