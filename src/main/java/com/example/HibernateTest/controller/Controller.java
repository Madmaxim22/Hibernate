package com.example.HibernateTest.controller;

import com.example.HibernateTest.entity.Person;
import com.example.HibernateTest.repository.Repository;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class Controller {

    @Autowired
    private Repository repository;

    @Secured("ROLE_USER")
    @GetMapping("/persons/by-city")
    public List<Person> getlistPersonInCity(@RequestParam String city) {
        return repository.findByCityOfLiving(city);
    }

    @RolesAllowed("ROLE_STAFF")
    @GetMapping("/persons/by-age")
    public List<Person> getlistPersonInAge(@RequestParam int age) {
        return repository.findByAgeLessThanOrderByAge(age);
    }

    @PreAuthorize("hasRole('ROLE_STAFF') or hasRole('ROLE_ADMIN')")
    @GetMapping("/persons/by-name-surname")
    public List<Person> getlistPersonInNameAndSurname(@RequestParam String name, String surname) {
        return repository.findByNameAndSurname(name, surname);
    }

    @PostAuthorize("#name == authentication.principal.username")
    @GetMapping("/persons/by-name")
    public String getlistPersonInName(@RequestParam String name) {
        return "Hello from secured app, " + name;
    }
}
