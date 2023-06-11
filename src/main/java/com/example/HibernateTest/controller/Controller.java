package com.example.HibernateTest.controller;

import com.example.HibernateTest.entity.Person;
import com.example.HibernateTest.repository.Repository;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@EnableGlobalMethodSecurity(jsr250Enabled = true)
public class Controller {

    @Autowired
    private Repository repository;

    @RolesAllowed("USER")
    @GetMapping("/persons/by-city")
    public List<Person> getlistPersonInCity(@RequestParam String city) {
        return repository.findByCityOfLiving(city);
    }

    @RolesAllowed("STAFF")
    @GetMapping("/persons/by-age")
    public List<Person> getlistPersonInCity(@RequestParam int age) {
        return repository.findByAgeLessThanOrderByAge(age);
    }

    @RolesAllowed("ADMIN")
    @GetMapping("/persons/by-name-surname")
    public List<Person> getlistPersonInCity(@RequestParam String name, String surname) {
        return repository.findByNameAndSurname(name, surname);
    }
}
