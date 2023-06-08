package com.example.HibernateTest.controller;

import com.example.HibernateTest.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    private Repository repository;

    @GetMapping("/products/fetch-product")
    public List<String> getProductName(@RequestParam String name) {
        return repository.getProductName(name);
    }
}
