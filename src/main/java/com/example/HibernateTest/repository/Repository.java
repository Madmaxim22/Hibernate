package com.example.HibernateTest.repository;

import com.example.HibernateTest.entity.Person;
import com.example.HibernateTest.entity.PersonId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<Person, PersonId> {
    List<Person> findByCityOfLiving(String city);

    List<Person> findByAgeLessThanOrderByAge(int age);

    List<Person> findByNameAndSurname(String name, String surname);
}
