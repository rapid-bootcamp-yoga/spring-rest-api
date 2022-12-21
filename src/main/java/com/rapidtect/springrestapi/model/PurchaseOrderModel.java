package com.rapidtect.springrestapi.model;

import com.rapidtect.springrestapi.entity.CustomerEntity;
import com.rapidtect.springrestapi.entity.PurchaseOrderEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.Date;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class PurchaseOrderModel {
    private Long id;
    private String poCode;
    private Integer customerId;
    private CustomerEntity customer;
    private Date poDate;
    private Double totalAmount;
    public PurchaseOrderModel(PurchaseOrderEntity entity) {
        BeanUtils.copyProperties(entity, this);
    }
}
