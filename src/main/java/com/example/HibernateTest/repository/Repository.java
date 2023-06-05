package com.example.HibernateTest.repository;

import com.example.HibernateTest.entity.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@org.springframework.stereotype.Repository
public class Repository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Person> getPersonsByCity(String city) {
        String sql = "from Person where cityOfLiving = :city";
        return entityManager.createQuery(sql, Person.class).setParameter("city", city).getResultList();
    }
}
