package com.rapidtect.springrestapi.model;

import com.rapidtect.springrestapi.entity.ShipperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;



@AllArgsConstructor
@Data
@NoArgsConstructor
public class ShipperModel {
    private Long id;
    private String shipperName;
    private String phone;
    public ShipperModel(ShipperEntity entity) {
        BeanUtils.copyProperties(entity, this);
    }
}
