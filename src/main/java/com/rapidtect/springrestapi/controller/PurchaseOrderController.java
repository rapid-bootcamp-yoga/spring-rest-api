package com.rapidtect.springrestapi.controller;

import com.rapidtect.springrestapi.model.PurchaseOrderModel;
import com.rapidtect.springrestapi.model.ResponseModel;
import com.rapidtect.springrestapi.service.PurchaseOrderService;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/po")
public class PurchaseOrderController {
    private PurchaseOrderService purchaseOrderService;

    @Autowired
    public PurchaseOrderController(PurchaseOrderService purchaseOrderService) {
        this.purchaseOrderService = purchaseOrderService;
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> save(@RequestBody PurchaseOrderModel request){
        return ResponseEntity.ok().body(
               new ResponseModel(200, "Sukses", purchaseOrderService.save(request))
        );
    }

}
