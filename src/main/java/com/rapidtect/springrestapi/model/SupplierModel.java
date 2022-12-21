package com.rapidtect.springrestapi.model;

import com.rapidtect.springrestapi.entity.SupplierEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class SupplierModel {
    private Long id;
    private String supplierName;
    private String contactName;
    private String address;
    private String city;
    private String country;
    private String postalCode;
    private String phone;

    public SupplierModel(SupplierEntity entity) {
        BeanUtils.copyProperties(entity, this);
    }
}
