package com.rapidtect.springrestapi.controller;


import com.rapidtect.springrestapi.model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @GetMapping
    public List<Product> get() {
        return Arrays.asList(
                new Product(1, "Susu Beruang", 8900.0),
                new Product(2, "Indomie", 2900.0),
                new Product(3, "Bakso", 25000.0)
        );
    }

}
