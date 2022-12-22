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
    private List<PurchaseOrderDetailModel> details;
}
