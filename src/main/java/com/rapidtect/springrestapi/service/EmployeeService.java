package com.rapidtect.springrestapi.service;

import com.rapidtect.springrestapi.model.EmployeeModel;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<EmployeeModel> getAll();
    Optional<EmployeeModel> getById(Long id);
    Optional<EmployeeModel> save(EmployeeModel model);
    Optional<EmployeeModel> update(Long id, EmployeeModel model);
    Optional<EmployeeModel> delete(Long id);
}
