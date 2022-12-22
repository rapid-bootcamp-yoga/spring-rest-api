package com.rapidtect.springrestapi.model;

import com.rapidtect.springrestapi.entity.CustomerEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerModel {
    private Long id;
    private String fullName;
    private String address;
    private String city;
    private String gender;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateOfBirth;
    private String dateOfPlace;

    public CustomerModel(CustomerEntity entity){
//        this.id = entity.getId();
//        this.fullName = entity.getFullName();
        BeanUtils.copyProperties(entity, this);
    }
}
