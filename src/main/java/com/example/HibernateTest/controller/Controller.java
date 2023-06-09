package com.example.HibernateTest.controller;

import com.example.HibernateTest.entity.Person;
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

    @GetMapping("/persons/by-city")
    public List<Person> getlistPersonInCity(@RequestParam String city) {
        return repository.findByCityOfLiving(city);
    }

    @GetMapping("/persons/by-age")
    public List<Person> getlistPersonInCity(@RequestParam int age) {
        return repository.findByAgeLessThanOrderByAge(age);
    }

    @GetMapping("/persons/by-name-surname")
    public List<Person> getlistPersonInCity(@RequestParam String name, String surname) {
        return repository.findByNameAndSurname(name, surname);
    }
}
