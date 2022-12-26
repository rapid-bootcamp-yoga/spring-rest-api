package com.rapidtect.springrestapi.service.Impl;

import com.rapidtect.springrestapi.entity.PurchaseOrderDetailEntity;
import com.rapidtect.springrestapi.entity.PurchaseOrderEntity;
import com.rapidtect.springrestapi.model.PurchaseOrderDetailModel;
import com.rapidtect.springrestapi.model.PurchaseOrderModel;
import com.rapidtect.springrestapi.repository.PurchaseOrderDetailRepo;
import com.rapidtect.springrestapi.repository.PurchaseOrderRepo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@ExtendWith(MockitoExtension.class)
class PurchaseOrderServiceImplTest {
    @InjectMocks
    @Autowired
    private PurchaseOrderServiceImpl service;

    private PurchaseOrderRepo poRepo;
    private PurchaseOrderDetailRepo poDetailRepo;

    private List<PurchaseOrderDetailEntity> purchaseOrderDetailEntityList;

    @BeforeEach
    void setUp() {
        log.info("Setup Run  ....");
    }

    @AfterEach
    void tearDown() {
        log.info("Setup Clear ....");
    }

    @Test
    void save() {
        Optional<PurchaseOrderModel> result = this.service.save(null);
        assertEquals(Optional.empty(), result);

        List<PurchaseOrderDetailModel> poDetailsModels = Arrays.asList(
                new PurchaseOrderDetailModel(0L, 01L, 02L, 300.00, 9600.00 ),
                new PurchaseOrderDetailModel(1L, 02L, 02L, 100.00, 39600.00 ),
                new PurchaseOrderDetailModel(2L, 03L, 02L, 200.00, 29600.00 ),
                new PurchaseOrderDetailModel(3L, 04L, 02L, 400.00, 19600.00 )
        );

        // persiapan data request
        PurchaseOrderModel poModel = new PurchaseOrderModel(1L, "2kPoJZ", 20023300L,
                                                            3001L,
                                                            240L, new Date(),
                                                            3500000.00, poDetailsModels);

        PurchaseOrderEntity entity = new PurchaseOrderEntity(poModel);
        List<PurchaseOrderDetailEntity> poDetailEntities = poDetailsModels.stream().map(PurchaseOrderDetailEntity::new)
                                                            .collect(Collectors.toList());
        entity.setPoDetail(poDetailEntities);
    }

    @Test
    void getAll() {
    }

    @Test
    void getById() {
    }


}