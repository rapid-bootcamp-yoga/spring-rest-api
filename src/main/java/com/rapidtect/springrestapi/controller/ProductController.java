package com.rapidtect.springrestapi.controller;


import com.rapidtect.springrestapi.model.ProductModel;
import com.rapidtect.springrestapi.model.ResponseModel;
import com.rapidtect.springrestapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

//    @GetMapping
//    public List<ProductModel> get() {
//        return Arrays.asList(
//                new ProductModel(1, "Susu Beruang", 8900.0),
//                new ProductModel(2, "Indomie", 2900.0),
//                new ProductModel(3, "Bakso", 25000.0)
//        );
//    }
    private ProductService service;

    @Autowired
    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Object> get(){
        List<ProductModel> result = service.getAll();
        return ResponseEntity.ok().body(
                new ResponseModel(200,"SUCCESS", result)
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable("id") Long id){
        Optional<ProductModel> result = service.getById(id);
        return ResponseEntity.ok().body(
                new ResponseModel(200,"SUCCESS", result)
        );
    }

    @PostMapping()
    public ResponseEntity<Object> saveProduct(@RequestBody ProductModel request){
        Optional<ProductModel> result = service.save(request);
        return ResponseEntity.ok().body(
                new ResponseModel(200,"SUCCESS", result)
        );
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Object> updateProduct(@PathVariable("id") Long id, @RequestBody ProductModel request){
        Optional<ProductModel> result = service.update(id, request);
        return ResponseEntity.ok().body(
                new ResponseModel(200,"SUCCESS", result)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Long id){
        Optional<ProductModel> result = service.delete(id);
        return ResponseEntity.ok().body(
                new ResponseModel(200,"SUCCESS", result)
        );
    }

}
