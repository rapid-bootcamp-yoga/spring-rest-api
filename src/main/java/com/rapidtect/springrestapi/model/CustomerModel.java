package com.rapidtect.springrestapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerModel {
    private int id;
    private String fullName;
    private String address;
    private String city;
    private String gender;
    private Date dateOfBirth;
    private String dateOfPlace;
}
