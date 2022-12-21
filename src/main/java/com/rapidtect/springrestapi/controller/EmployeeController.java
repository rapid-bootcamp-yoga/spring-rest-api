package com.rapidtect.springrestapi.controller;

import com.rapidtect.springrestapi.model.ResponseModel;
import com.rapidtect.springrestapi.model.EmployeeModel;
import com.rapidtect.springrestapi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private EmployeeService service;

    @Autowired
    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Object> get(){
        List<EmployeeModel> result = service.getAll();
        return ResponseEntity.ok().body(
                new ResponseModel(200,"SUCCESS", result)
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable("id") Long id){
        Optional<EmployeeModel> result = service.getById(id);
        return ResponseEntity.ok().body(
                new ResponseModel(200,"SUCCESS", result)
        );
    }

    @PostMapping()
    public ResponseEntity<Object> saveCategory(@RequestBody EmployeeModel request){
        Optional<EmployeeModel> result = service.save(request);
        return ResponseEntity.ok().body(
                new ResponseModel(200,"SUCCESS", result)
        );
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Object> updateCategory(@PathVariable("id") Long id, @RequestBody EmployeeModel request){
        Optional<EmployeeModel> result = service.update(id, request);
        return ResponseEntity.ok().body(
                new ResponseModel(200,"SUCCESS", result)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Long id){
        Optional<EmployeeModel> result = service.delete(id);
        return ResponseEntity.ok().body(
                new ResponseModel(200,"SUCCESS", result)
        );
    }
}
