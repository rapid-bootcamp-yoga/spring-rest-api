package com.rapidtect.springrestapi.controller;


import com.rapidtect.springrestapi.model.ResponseModel;
import com.rapidtect.springrestapi.model.ShipperModel;
import com.rapidtect.springrestapi.service.ShipperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/shipper")
public class ShipperController {
    private ShipperService service;

    @Autowired
    public ShipperController(ShipperService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Object> get(){
        List<ShipperModel> result = service.getAll();
        return ResponseEntity.ok().body(
                new ResponseModel(200,"SUCCESS", result)
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable("id") Long id){
        Optional<ShipperModel> result = service.getById(id);
        return ResponseEntity.ok().body(
                new ResponseModel(200,"SUCCESS", result)
        );
    }

    @PostMapping()
    public ResponseEntity<Object> saveCategory(@RequestBody ShipperModel request){
        Optional<ShipperModel> result = service.save(request);
        return ResponseEntity.ok().body(
                new ResponseModel(200,"SUCCESS", result)
        );
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Object> updateCategory(@PathVariable("id") Long id, @RequestBody ShipperModel request){
        Optional<ShipperModel> result = service.update(id, request);
        return ResponseEntity.ok().body(
                new ResponseModel(200,"SUCCESS", result)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Long id){
        Optional<ShipperModel> result = service.delete(id);
        return ResponseEntity.ok().body(
                new ResponseModel(200,"SUCCESS", result)
        );
    }
}
