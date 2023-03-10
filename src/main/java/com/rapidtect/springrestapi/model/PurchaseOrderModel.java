package com.rapidtect.springrestapi.model;

import com.rapidtect.springrestapi.entity.CustomerEntity;
import com.rapidtect.springrestapi.entity.PurchaseOrderEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class PurchaseOrderModel implements Serializable {
    private Long id;
    private String poCode;
    private Long customerId;
    private Long employeeId;
    private Long shipperId;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date poDate;
    private Double totalAmount;
    private List<PurchaseOrderDetailModel> details = new ArrayList<>();

    public PurchaseOrderModel(Long id, String poCode, Long customerId, Long employeeId, Long shipperId, Date poDate, Double totalAmount) {
        this.id = id;
        this.poCode = poCode;
        this.customerId = customerId;
        this.employeeId = employeeId;
        this.shipperId = shipperId;
        this.poDate = poDate;
        this.totalAmount = totalAmount;
    }

    public PurchaseOrderModel(PurchaseOrderEntity entity) {
        BeanUtils.copyProperties(entity, this);
    }
}
