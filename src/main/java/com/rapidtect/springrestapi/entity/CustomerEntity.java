package com.rapidtect.springrestapi.entity;

import com.rapidtect.springrestapi.model.CustomerModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customer_tab")
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @Column(name = "customer_name", length = 200, nullable = false)
    private String fullName;
    @Column(name = "customer_address", nullable = false)
    private String address;
    @Column(name = "customer_city", length = 100, nullable = false)
    private String city;
    @Column(name = "customer_gender", length = 50, nullable = false)
    private String gender;
    @Column(name = "customer_dateOfBirth", nullable = false)
    private Date dateOfBirth;
    @Column(name = "customer_dateOfPlace", nullable = false)
    private String dateOfPlace;

    @Column(name = "product_id",nullable = false )
    private int productId;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id", insertable = false, updatable = false)
    private Set<ProductEntity> products = new HashSet<>();

    public CustomerEntity(CustomerModel model) {
    }
}
